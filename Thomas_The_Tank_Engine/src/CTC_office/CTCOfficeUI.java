package CTC_office;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import Interface.CTCandTrackControllerInterface;
import Interface.Switches;
import Interface.TrackCircuit;
import Overall_Sys.TimeClass;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * This class is used as the CTC office's UI
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class CTCOfficeUI {

	private JFrame frame;
	private JTable table;
	private JTable table2;
	private JTable table3;
	private MainLineTableModel Line=null;
	private SwitchesModel switchs=null;
	private BrokenRailsModel BTracks=null;
	private TimeClass timer = TimeClass.getInstance(false);
	private AllTrains Train;
	private AllTrackBlock Blocks;
	private TrainScheduleFileParser TSparser = new TrainScheduleFileParser(true);
	private TrackModelFileParser TMparser= new TrackModelFileParser(true);
    private CTC_Office temp;
    private CTCMapUI map;
    private VerifyManualMode mode = new VerifyManualMode();
    private Switches switchinterface = Switches.getInstance(false);
    private TrackCircuit circuit;
    private CTCandTrackControllerInterface CTCTCint = CTCandTrackControllerInterface.getInstance(false);
	/**
	 * 
	 * Create the application.
	 */
	public CTCOfficeUI(AllTrains Train, AllTrackBlock Blocks, CTC_Office CTC,TrackCircuit circuit, CTCMapUI map ) {
		this.Train = Train;
		this.Blocks = Blocks;
		this.temp= CTC;
		this.circuit = circuit;
		this.map =map;
		
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1188, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Manual Mode?");
		tglbtnNewToggleButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
			        mode.updateManualMode(true);
			      } else if(e.getStateChange()==ItemEvent.DESELECTED){
			    	  mode.updateManualMode(false);
			    	  for(int i=0;i<Train.getRedTrain().size();i++){
			    		  Train.setUserSetDest(false, Train.getRedTrain().get(i).getID(), "Red");
			    	  }
			    	  for(int i=0;i<Train.getGreenTrain().size();i++){
			    		  Train.setUserSetDest(false, Train.getGreenTrain().get(i).getID(), "Green");
			    	  }
			      }
			}
		});
			
		tglbtnNewToggleButton.setBounds(12, 12, 207, 55);
		tglbtnNewToggleButton.setToolTipText("Controls \nSelected Manual Mode \nNot Selected Autoamatic Mode");
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnxMode = new JToggleButton("10x Mode");
		tglbtnxMode.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 if(e.getStateChange()==ItemEvent.SELECTED){
				        temp.updateMult(1);
				      } else if(e.getStateChange()==ItemEvent.DESELECTED){
				    	  temp.updateMult(0);
				      }
			}
		});
		tglbtnxMode.setBounds(974, 12, 193, 55);
		tglbtnxMode.setToolTipText("Speed \nSelected 10x normal speed \nNot Selected 1x normal speed");
		frame.getContentPane().add(tglbtnxMode);
		
		JButton btnNewButton = new JButton("<html>Import</br> Train Schedule</html>");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);

			      if (returnVal == JFileChooser.APPROVE_OPTION) {
			          File file = fc.getSelectedFile();
			          Train=TSparser.Parser(Train, file.getPath(), Blocks, map);
			          temp.updateTrain(Train);		
			          if(file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Red_Line_Schedule.csv")){
			          List <Trains>  alltrains = new ArrayList <Trains>();
			          alltrains.addAll(Train.getRedTrain());
			          alltrains.addAll(Train.getGreenTrain());
                      Line.updateTrainList(alltrains);
			  		  Trains newtrain = Train.getRedTrain().get(Train.getRedTrain().size()-1);
			  		  
			  		  circuit.makeNewTrain( newtrain.getID(), newtrain.getBlockGrade(), 0, newtrain.getSpeed(), newtrain.getAuthority(), "Red", newtrain.getBlockNum(), false);
			  		 CTCTCint.makeNewTrain(newtrain.getID(), newtrain.getBlockSpeedLim(), newtrain.getTrainSchedule().get(0).getStation(), false, 7);
			  		  } else if (file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Green_Line_Schedule.csv")){
			  			List <Trains>  alltrains = new ArrayList <Trains>();
				          alltrains.addAll(Train.getRedTrain());
				          alltrains.addAll(Train.getGreenTrain());
				          Line.updateTrainList(alltrains);
			  		Trains newtrain = Train.getGreenTrain().get(Train.getGreenTrain().size()-1);
			  		  circuit.makeNewTrain( newtrain.getID(), newtrain.getBlockGrade(), 0, newtrain.getSpeed(), newtrain.getAuthority(), "Green", newtrain.getBlockNum(), false);
			  		CTCTCint.makeNewTrain(newtrain.getID(), newtrain.getBlockSpeedLim(), newtrain.getTrainSchedule().get(0).getStation(), false, 2);
			  		  }
				  	  Line.fireTableDataChanged();
			      }
			}
		});
		btnNewButton.setBounds(231, 12, 189, 55);
		frame.getContentPane().add(btnNewButton);
		JButton btnBrakeRail = new JButton("Brake Rail");
		btnBrakeRail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Line1 = JOptionPane.showInputDialog(btnBrakeRail, "Which Line?");
				String BlockNumber = JOptionPane.showInputDialog(btnBrakeRail, "Which Block Number");
			 if((Line1.equalsIgnoreCase("Red") || Line1.equalsIgnoreCase("Green"))&& (Integer.parseInt(BlockNumber)<152 && Integer.parseInt(BlockNumber)>0)){
				Blocks.setBroken(true, Integer.parseInt(BlockNumber), Line1);
				BTracks.updateBlocks(Blocks);
				BTracks.fireTableDataChanged();
				}
			}
		});
		btnBrakeRail.setBounds(486, 12, 218, 55);
		frame.getContentPane().add(btnBrakeRail);
		frame.setVisible(true);
		JButton btnNewButton_1 = new JButton("<html>Import</br> Track Layout</html>");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);

			      if (returnVal == JFileChooser.APPROVE_OPTION) {
			          File file = fc.getSelectedFile();
			          
			          Blocks=TMparser.Parser(file.getPath(), Blocks);
			          temp.updateTrack(Blocks);			       
			          if(file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Red_Track_Layout.csv")){
			        	  Blocks=switchinterface.updateBlocks(Blocks, "Red");
			        	  switchs.updateBlocks(Blocks);
					  		 
					  		  } else if (file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Green_Track_Layout.csv")){
					  			Blocks=switchinterface.updateBlocks(Blocks, "Green");
					  			switchs.updateBlocks(Blocks);
					  		  }
			          switchs.fireTableDataChanged();
			      }
			}
		});
		btnNewButton_1.setBounds(758, 12, 191, 55);
		frame.getContentPane().add(btnNewButton_1);
		List <Trains>  alltrains = new ArrayList <Trains>();
        alltrains.addAll(Train.getRedTrain());
        alltrains.addAll(Train.getGreenTrain());
		Line = new MainLineTableModel(alltrains);
		table = new JTable();
		table.setModel(Line);
		table.setBounds(31, 105, 354, 32);
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		      if(mode.verify()){
		      if (e.getClickCount() == 2) {
		        JTable target = (JTable)e.getSource();
		        int row = target.getSelectedRow();
		        int column = target.getSelectedColumn();
		        if(column== 3){
		        String speed = JOptionPane.showInputDialog(table, "Set new Speed (mph)");
		        int id = (int) table.getValueAt(row, 2);
		        SetAdvisedSpeed advisedspeed = new SetAdvisedSpeed();
		        Train = advisedspeed.setSpeed(Train, id, Integer.parseInt(speed), mode);
		        
		        }
		        if(column== 5){
		          String authority= JOptionPane.showInputDialog(table, "Set new Authority (ft)");
		          int id = (int) table.getValueAt(row, 2);
		          SetTrainAuthority advisedauthority = new SetTrainAuthority();
		          advisedauthority.setAuthority(Train, id, Integer.parseInt(authority), mode);

		          }
		        if(column== 4){
		          String block = JOptionPane.showInputDialog(table, "Set destination block");
		          SetDestination dest = new SetDestination();
		          int id = (int) table.getValueAt(row, 2);
		          String tline = (String) table.getValueAt(row, 1);
		          int BlockNum =0;
		          try{
		        	  BlockNum = Integer.parseInt(block);
		          } catch(Exception t){
		        	  BlockNum = Blocks.getBlockNum(block, tline );
		          }
		          dest.setManualDestination(id, BlockNum, mode, Train, Blocks);
		          }
		        if(column== 7){
		          String retire= JOptionPane.showInputDialog(table, "Retire Train (true/false)?");
		          table.setValueAt(Boolean.parseBoolean(retire), row, column);
		          }
		        // do some action if appropriate column
		      }
		    }
		    }
		  });
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 94, 1162, 159);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
		
		switchs = new SwitchesModel(Blocks);
		table2 = new JTable(switchs);
		table2.setBounds(31, 105, 354, 32);
		table2.setFocusable(false);
		table2.setAutoscrolls(false);
		table2.setCellSelectionEnabled(false);
		table2.setColumnSelectionAllowed(false);
		table2.setRowSelectionAllowed(false);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);	
		scrollPane2.setBounds(15, 265, 1152, 299);
		frame.getContentPane().add(scrollPane2);
		
		BTracks = new BrokenRailsModel(Blocks);
		table3 = new JTable(BTracks);
		table3.setBounds(31, 105, 354, 32);
		table3.setFocusable(false);
		table3.setAutoscrolls(false);
		table3.setCellSelectionEnabled(false);
		table3.setColumnSelectionAllowed(false);
		table3.setRowSelectionAllowed(false);
		table3.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (e.getClickCount() == 2) {
		    		JTable target = (JTable)e.getSource();
			        int row = target.getSelectedRow();
			        int column = target.getSelectedColumn();
			        if(column== 3){
				          String CloseRail= JOptionPane.showInputDialog(table3, "Close Rail (true/false)?");
				          String blockline = (String) table3.getValueAt(row, 0);
				          int blocknum = (int) table3.getValueAt(row, 1);
				          if(Boolean.parseBoolean(CloseRail)){
				          Blocks.setClosed(Boolean.parseBoolean(CloseRail), blocknum, blockline);
				          Blocks.setClosedTime(timer.getTime(), blocknum, blockline);
				          BTracks.updateBlocks(Blocks);
				  		  BTracks.fireTableDataChanged();
				          }
				          
			        }
		    	}
		    }});
		JScrollPane scrollPane3 = new JScrollPane(table3);
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);	
		scrollPane3.setBounds(22, 576, 1152, 178);
		frame.getContentPane().add(scrollPane3);
		
	}
	/**
	 * Updates the track model table
	 * @param Blocks
	 */
	public void updateSwitchTable(AllTrackBlock Blocks){
		this.Blocks =Blocks;
		switchs.updateBlocks(Blocks);
		switchs.fireTableDataChanged();
	}
	/**
	 * Updates the train's table
	 * @param Train AllTrains object
	 */
	public void updateTrains(AllTrains Train){
		List <Trains>  alltrains = new ArrayList <Trains>();
        alltrains.addAll(Train.getRedTrain());
        alltrains.addAll(Train.getGreenTrain());
		Line.updateTrainList(alltrains);
		Line.fireTableDataChanged();
	}
	/**
	 * Updates the broken rail's table
	 * @param Blocks AllTrackBlock object
	 */
	public void updateBrokenRails(AllTrackBlock Blocks){
		this.Blocks =Blocks;
		BTracks.updateBlocks(Blocks);
		BTracks.fireTableDataChanged();
		}
	/**
	 * Sends back the CTC's mode
	 * @return this.mode.verify()
	 */
	public boolean getMode(){
		return this.mode.verify();
	}
	/**
	 * Sends back the updated block object
	 * @return Blocks
	 */
	public AllTrackBlock getupdatedBlocks(){
		return Blocks;
	}
}
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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CTCOfficeUI {

	private JFrame frame;
	private JTable table;
	private JTable table2;
	private MainLineTableModel Line=null;
	private SwitchesModel switchs=null;
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
		frame.setBounds(100, 100, 1173, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Manual Mode?");
		tglbtnNewToggleButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
			        mode.updateManualMode(true);
			      } else if(e.getStateChange()==ItemEvent.DESELECTED){
			    	  mode.updateManualMode(false);
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
			  		  
			  		  circuit.makeNewTrain( newtrain.getID(), newtrain.getBlockGrade(), 0, newtrain.getSpeed(), newtrain.getAuthority(), "Red", newtrain.getBlockNum());
			  		 CTCTCint.makeNewTrain(newtrain.getID(), newtrain.getBlockSpeedLim(), newtrain.getTrainSchedule().get(0).getStation(), false, 7);
			  		  } else if (file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Green_Line_Schedule.csv")){
			  			List <Trains>  alltrains = new ArrayList <Trains>();
				          alltrains.addAll(Train.getRedTrain());
				          alltrains.addAll(Train.getGreenTrain());
				          Line.updateTrainList(alltrains);
			  		Trains newtrain = Train.getGreenTrain().get(Train.getGreenTrain().size()-1);
			  		  circuit.makeNewTrain( newtrain.getID(), newtrain.getBlockGrade(), 0, newtrain.getSpeed(), newtrain.getAuthority(), "Green", newtrain.getBlockNum());
			  		CTCTCint.makeNewTrain(newtrain.getID(), newtrain.getBlockSpeedLim(), newtrain.getTrainSchedule().get(0).getStation(), false, 2);
			  		  }
				  	  Line.fireTableDataChanged();
			      }
			}
		});
		btnNewButton.setBounds(231, 12, 189, 55);
		frame.getContentPane().add(btnNewButton);
		
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
			          SwitchesModel switchs =null;
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
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 127, 1134, 159);
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
		scrollPane2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);	
		scrollPane2.setBounds(12, 302, 1134, 323);
		frame.getContentPane().add(scrollPane2);
		
		JButton btnBrakeRail = new JButton("Brake Rail");
		btnBrakeRail.setBounds(486, 12, 218, 55);
		frame.getContentPane().add(btnBrakeRail);
		frame.setVisible(true);
		
	}
	public void updateSwitchTable(AllTrackBlock Blocks){
		this.Blocks =Blocks;
		switchs.updateBlocks(Blocks);
		switchs.fireTableDataChanged();
	}
	public void updateTrains(AllTrains Train){
		List <Trains>  alltrains = new ArrayList <Trains>();
        alltrains.addAll(Train.getRedTrain());
        alltrains.addAll(Train.getGreenTrain());
		Line.updateTrainList(alltrains);
		Line.fireTableDataChanged();
	}
}

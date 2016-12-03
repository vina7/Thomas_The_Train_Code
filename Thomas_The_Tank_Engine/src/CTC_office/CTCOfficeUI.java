package CTC_office;

import java.awt.EventQueue;
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
	private JTable table3;
	private JTable table4;
	private AllTrains Train;
	private AllTrackBlock Blocks;
	private TrainScheduleFileParser TSparser = new TrainScheduleFileParser(true);
	private TrackModelFileParser TMparser= new TrackModelFileParser(true);
    private CTC_Office temp;

    private VerifyManualMode mode = new VerifyManualMode();
    private Switches switchinterface = Switches.getInstance(false);
    private TrackCircuit circuit;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllTrains temp = AllTrains.getInstance(false);
					AllTrackBlock temp2 = AllTrackBlock.getInstance(false);
					CTC_Office temp3 = new CTC_Office();
					CTCOfficeUI window = new CTCOfficeUI(temp, temp2, temp3);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public CTCOfficeUI(AllTrains Train, AllTrackBlock Blocks, CTC_Office CTC,TrackCircuit circuit ) {
		this.Train = Train;
		this.Blocks = Blocks;
		this.temp= CTC;
		this.circuit = circuit;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1181, 541);
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
		tglbtnxMode.setBounds(806, 12, 193, 55);
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
			          Train=TSparser.Parser(Train, file.getPath(), Blocks);
			          temp.updateTrain(Train);		  	
			          if(file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Red_Line_Schedule.csv")){
			  		MainLineTableModel Line = new MainLineTableModel(Train.getRedTrain());
			  		  Trains newtrain = Train.getRedTrain().get(Train.getRedTrain().size()-1);
			  		  System.out.println(newtrain.getID());
			  		  circuit.makeNewTrain( newtrain.getID(), newtrain.getBlockGrade(), 0, newtrain.getSpeed(), newtrain.getAuthority(), "Red", newtrain.getBlockNum());
			  		  table.setModel(Line);
			  		SwingUtilities.updateComponentTreeUI(table);
			  		  } else if (file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Green_Line_Schedule.csv")){
			  		MainLineTableModel Line2 = new MainLineTableModel(Train.getGreenTrain());
			  		Trains newtrain = Train.getGreenTrain().get(Train.getGreenTrain().size()-1);
			  		System.out.println("P"+newtrain.getBlockNum());
			  		  circuit.makeNewTrain( newtrain.getID(), newtrain.getBlockGrade(), 0, newtrain.getSpeed(), newtrain.getAuthority(), "Green", newtrain.getBlockNum());
			  		  table2.setModel(Line2);
			  		SwingUtilities.updateComponentTreeUI(table2);
			  		  }
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
			          if(file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Red_Track_Layout.csv")){
			        	  Blocks=switchinterface.updateBlocks(Blocks, "Red");
			        	  SwitchesModel redswitch = new SwitchesModel(Blocks.getRedTrack(),switchinterface.getRedswitchlocations());
					  		  table4.setModel(redswitch);
					  		  table4.updateUI(); 
					  		  } else if (file.getPath().equals("/home/van/workspace5/Thomas_The_Tank_Engine/Green_Track_Layout.csv")){
					  			Blocks=switchinterface.updateBlocks(Blocks, "Green");
					  			SwitchesModel greenswitch = new SwitchesModel(Blocks.getGreenTrack(), switchinterface.getGreenswitchlocations());
					  		  table3.setModel(greenswitch);
					  		  table3.updateUI();
					  		  }
			      }
			}
		});
		btnNewButton_1.setBounds(603, 12, 191, 55);
		frame.getContentPane().add(btnNewButton_1);
		
		MainLineTableModel Line = new MainLineTableModel(Train.getRedTrain());
		table = new JTable();
		table.setModel(Line);
		table.setBackground(Color.RED);
		table.setBounds(12, 330, 624, 173);
		table.setSize(624, 173);
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		      if(mode.verify() ){
		      if (e.getClickCount() == 2) {
		        JTable target = (JTable)e.getSource();
		        int row = target.getSelectedRow();
		        int column = target.getSelectedColumn();
		        if(column== 2){
		        String speed = JOptionPane.showInputDialog(table, "Set new Speed (mph)");
		        table.setValueAt(Integer.parseInt(speed), row, column);
		        }
		        if(column== 4){
		          String authority= JOptionPane.showInputDialog(table, "Set new Authority (ft)");
		          table.setValueAt(Integer.parseInt(authority), row, column);
		          }
		        if(column== 3){
		          String block = JOptionPane.showInputDialog(table, "Set destination block");
		          table.setValueAt(Integer.parseInt(block), row, column);
		          }
		        if(column== 6){
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
		scrollPane.setBounds(12, 330, 624, 173);
		frame.getContentPane().add(scrollPane);
		
		MainLineTableModel Line2 = new MainLineTableModel(Train.getGreenTrain());
		table2 = new JTable();
		table2.setModel(Line2);
		table2.setBackground(Color.GREEN);
		table2.setBounds(31, 105, 354, 32);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane2.setBounds(12, 127, 624, 149);
		frame.getContentPane().add(scrollPane2);
		frame.setVisible(true);
		
		SwitchesModel greenswitch = new SwitchesModel(Blocks.getGreenTrack(), switchinterface.getGreenswitchlocations());
		table3 = new JTable(greenswitch);
		table3.setBackground(Color.GREEN);
		table3.setBounds(31, 105, 354, 32);
		table3.setFocusable(false);
		table3.setCellSelectionEnabled(false);
		table3.setColumnSelectionAllowed(false);
		table3.setRowSelectionAllowed(false);
		JScrollPane scrollPane3 = new JScrollPane(table3);
		scrollPane3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane3.setBounds(668, 330, 264, 173);
		frame.getContentPane().add(scrollPane3);
		frame.setVisible(true);
		
		SwitchesModel redswitch = new SwitchesModel(Blocks.getRedTrack(),switchinterface.getRedswitchlocations() );
		table4 = new JTable(redswitch);
		table4.setBackground(Color.RED);
		table4.setBounds(31, 105, 354, 32);
		table4.setFocusable(false);
		table4.setCellSelectionEnabled(false);
		table4.setColumnSelectionAllowed(false);
		table4.setRowSelectionAllowed(false);
		JScrollPane scrollPane4 = new JScrollPane(table4);
		scrollPane4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);	
		scrollPane4.setBounds(668, 127, 264, 149);
		frame.getContentPane().add(scrollPane4);
		frame.setVisible(true);
		
	}
	public void updateRedSwitchTable(AllTrackBlock Blocks){
		this.Blocks =Blocks;
		SwitchesModel redswitch = new SwitchesModel(this.Blocks.getRedTrack(),this.switchinterface.getRedswitchlocations());
		table4.setModel(redswitch);
		table4.updateUI();
	}
	public void updateGreenSwitchTable(AllTrackBlock Blocks){
		this.Blocks =Blocks;
		SwitchesModel greenswitch = new SwitchesModel(this.Blocks.getGreenTrack(), this.switchinterface.getGreenswitchlocations());
		table3.setModel(greenswitch);
		table3.updateUI();
	}
	public void updateRedTrains(AllTrains Train){
		  MainLineTableModel Line = new MainLineTableModel(Train.getRedTrain());
		  table.setModel(Line);
		  System.out.println(Train.getRedTrain().size());
	}
	public void updateGreenTrains(AllTrains Train){
		  MainLineTableModel Line2 = new MainLineTableModel(Train.getGreenTrain());
		  System.out.println(Train.getGreenTrain().size());
		  table2.setModel(Line2);
	}
}

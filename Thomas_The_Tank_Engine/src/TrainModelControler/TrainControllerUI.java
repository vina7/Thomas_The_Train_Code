package TrainModelControler;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JRadioButton;

import java.awt.TextArea;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.event.ChangeListener;


import javax.swing.event.ChangeEvent;
import javax.swing.JSeparator;

import java.util.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.text.DecimalFormat;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public class TrainControllerUI {

	public JFrame frame;
	
	private final double	MPS_TO_MPH = 2.23694;			//Conversion ratio for meters per second to miles per hour
	private final double	METERS_TO_MILES = 0.000621371;	//Conversion ratio for meters to miles
	
	private final DecimalFormat	formatter = new DecimalFormat("0.00");
	
	private final ButtonGroup controlModes = new ButtonGroup();
	private final JSlider velocitySlider = new JSlider();
	private final JComboBox<Integer> trainSelectBox = new JComboBox<Integer>();
	private final JButton eBrakeButton = new JButton("Emergency Brake");
	private final JButton brakeButton = new JButton("Service Brake");
	JButton leftDoorButton = new JButton("Left Doors");
	JButton rightDoorButton = new JButton("Right Doors");
	private final JRadioButton manRadio = new JRadioButton("Manual");
	private final JRadioButton autoRadio = new JRadioButton("Automatic");
	
	private JTextField setpointVelocityField;
	private JTextField leftDoorStatusField;
	private JTextField rightDoorStatusField;
	private JTextField AnnouncmentsField;
	private JTextField brakeStatusField;
	private JTextField eBrakeStatusField;
	private JTextField authorityField;
	
	
	

	
	private TrainController wrapper;
	private Controller controller = null;
	private JTextField powerCommandField;
	private JTextField failuresField;
	private JTextField blkSpdLimTextField;
	private JTextField currSpdField;


	
	/**
	 * Create the application.
	 * @param trainController 
	 */
	public TrainControllerUI(TrainController trainController) {
		wrapper = trainController;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.getContentPane().setForeground(SystemColor.info);
		frame.setTitle("Train Controller");
		frame.setBounds(100, 100, 929, 481);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setForeground(SystemColor.windowBorder);
		mainPanel.setBackground(SystemColor.controlHighlight);
		mainPanel.setBounds(0, 0, 923, 448);
		frame.getContentPane().add(mainPanel);
		autoRadio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		autoRadio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(autoRadio.isSelected()) {
					switchMode(1);
				}
			}
		});
		controlModes.add(autoRadio);
		autoRadio.setSelected(true);
		autoRadio.setBackground(SystemColor.controlHighlight);
		autoRadio.setBounds(715, 9, 103, 31);
		mainPanel.add(autoRadio);
		manRadio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		manRadio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(manRadio.isSelected()) {
					switchMode(2);
				}
			}
		});
		controlModes.add(manRadio);
		manRadio.setBackground(SystemColor.controlHighlight);
		manRadio.setBounds(822, 9, 83, 31);
		mainPanel.add(manRadio);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		for(int i = 0; i <= 4; i++) {
			labelTable.put( Integer.valueOf(i * 1000 ), new JLabel(Integer.toString(i * 10)));
		}
		
		JLabel announcementsLbl = new JLabel("Announcements:");
		announcementsLbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		announcementsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		announcementsLbl.setBounds(12, 406, 166, 31);
		mainPanel.add(announcementsLbl);
		
		trainSelectBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
			          Integer trainID = (Integer) arg0.getItem();
			          switchTrain(trainID);
			    }
			}
		});
		trainSelectBox.setBounds(96, 13, 140, 25);
		mainPanel.add(trainSelectBox);
		
		JSeparator topSep = new JSeparator();
		topSep.setForeground(Color.BLACK);
		topSep.setBackground(SystemColor.textInactiveText);
		topSep.setBounds(12, 49, 893, 2);
		mainPanel.add(topSep);
		
		JLabel trainNumberLbl = new JLabel("Train ID:");
		trainNumberLbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		trainNumberLbl.setBounds(12, 13, 72, 22);
		mainPanel.add(trainNumberLbl);
		
		AnnouncmentsField = new JTextField();
		AnnouncmentsField.setHorizontalAlignment(SwingConstants.CENTER);
		AnnouncmentsField.setBackground(SystemColor.controlHighlight);
		AnnouncmentsField.setEditable(false);
		AnnouncmentsField.setColumns(10);
		AnnouncmentsField.setBounds(173, 406, 471, 31);
		mainPanel.add(AnnouncmentsField);
		
		JPanel doorsPanel = new JPanel();
		doorsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		doorsPanel.setBackground(SystemColor.controlHighlight);
		doorsPanel.setBounds(656, 64, 252, 126);
		mainPanel.add(doorsPanel);
		doorsPanel.setLayout(null);
		
		rightDoorButton.setEnabled(false);
		rightDoorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		rightDoorButton.setBounds(13, 38, 109, 33);
		doorsPanel.add(rightDoorButton);
		
		JLabel DoorsLbl = new JLabel("Doors");
		DoorsLbl.setBounds(92, 0, 67, 20);
		doorsPanel.add(DoorsLbl);
		DoorsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		DoorsLbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		rightDoorStatusField = new JTextField();
		rightDoorStatusField.setHorizontalAlignment(SwingConstants.CENTER);
		rightDoorStatusField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rightDoorStatusField.setBackground(SystemColor.controlHighlight);
		rightDoorStatusField.setBounds(134, 38, 106, 31);
		doorsPanel.add(rightDoorStatusField);
		rightDoorStatusField.setEditable(false);
		rightDoorStatusField.setColumns(10);
		
		leftDoorButton.setEnabled(false);
		leftDoorButton.setBounds(13, 76, 109, 33);
		doorsPanel.add(leftDoorButton);
		
		leftDoorStatusField = new JTextField();
		leftDoorStatusField.setHorizontalAlignment(SwingConstants.CENTER);
		leftDoorStatusField.setBackground(SystemColor.controlHighlight);
		leftDoorStatusField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		leftDoorStatusField.setBounds(134, 76, 106, 31);
		doorsPanel.add(leftDoorStatusField);
		leftDoorStatusField.setEditable(false);
		leftDoorStatusField.setColumns(10);
		
		JPanel brakesPanel = new JPanel();
		brakesPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		brakesPanel.setBackground(SystemColor.controlHighlight);
		brakesPanel.setBounds(656, 203, 252, 126);
		mainPanel.add(brakesPanel);
		brakesPanel.setLayout(null);
		
		JLabel lblBrakes = new JLabel("Brakes");
		lblBrakes.setBounds(93, 1, 66, 20);
		brakesPanel.add(lblBrakes);
		lblBrakes.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrakes.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		brakeStatusField = new JTextField();
		brakeStatusField.setHorizontalAlignment(SwingConstants.CENTER);
		brakeStatusField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		brakeStatusField.setBackground(SystemColor.controlHighlight);
		brakeStatusField.setBounds(165, 71, 75, 34);
		brakesPanel.add(brakeStatusField);
		brakeStatusField.setEditable(false);
		brakeStatusField.setColumns(10);
		
		eBrakeStatusField = new JTextField();
		eBrakeStatusField.setHorizontalAlignment(SwingConstants.CENTER);
		eBrakeStatusField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		eBrakeStatusField.setBackground(SystemColor.controlHighlight);
		eBrakeStatusField.setBounds(166, 34, 74, 33);
		brakesPanel.add(eBrakeStatusField);
		eBrakeStatusField.setEditable(false);
		eBrakeStatusField.setColumns(10);
		eBrakeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				switchEmergencyBrakeStatus();
			}
		});
		eBrakeButton.setBounds(12, 34, 142, 35);
		brakesPanel.add(eBrakeButton);
		brakeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchServiceBrakeStatus();
			}
		});
		
		
		brakeButton.setBounds(12, 72, 142, 35);
		brakesPanel.add(brakeButton);
		
		JPanel failuresPanel = new JPanel();
		failuresPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		failuresPanel.setBackground(SystemColor.controlHighlight);
		failuresPanel.setBounds(656, 342, 252, 95);
		mainPanel.add(failuresPanel);
		failuresPanel.setLayout(null);
		
		failuresField = new JTextField();
		failuresField.setHorizontalAlignment(SwingConstants.CENTER);
		failuresField.setEditable(false);
		failuresField.setBounds(12, 42, 228, 26);
		failuresField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		failuresField.setBackground(SystemColor.controlHighlight);
		failuresPanel.add(failuresField);
		failuresField.setColumns(10);
		
		JLabel lblFailures = new JLabel("Failures");
		lblFailures.setBounds(47, 3, 157, 26);
		failuresPanel.add(lblFailures);
		lblFailures.setHorizontalAlignment(SwingConstants.CENTER);
		lblFailures.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JPanel pwrCmdPanel = new JPanel();
		pwrCmdPanel.setBackground(SystemColor.controlHighlight);
		pwrCmdPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pwrCmdPanel.setBounds(334, 82, 149, 84);
		mainPanel.add(pwrCmdPanel);
		pwrCmdPanel.setLayout(null);
		
		JLabel lblPowerCommand = new JLabel("Power Command");
		lblPowerCommand.setBounds(7, 6, 135, 22);
		pwrCmdPanel.add(lblPowerCommand);
		lblPowerCommand.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		powerCommandField = new JTextField();
		powerCommandField.setHorizontalAlignment(SwingConstants.CENTER);
		powerCommandField.setBounds(7, 33, 135, 28);
		powerCommandField.setBackground(SystemColor.controlHighlight);
		powerCommandField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pwrCmdPanel.add(powerCommandField);
		powerCommandField.setEditable(false);
		powerCommandField.setColumns(10);
		
		JPanel authorityPanel = new JPanel();
		authorityPanel.setBackground(SystemColor.controlHighlight);
		authorityPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		authorityPanel.setBounds(495, 82, 149, 84);
		mainPanel.add(authorityPanel);
		authorityPanel.setLayout(null);
		
		JLabel authorityLbl = new JLabel("Authority");
		authorityLbl.setBounds(36, 6, 76, 22);
		authorityPanel.add(authorityLbl);
		authorityLbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		authorityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		authorityField = new JTextField();
		authorityField.setHorizontalAlignment(SwingConstants.CENTER);
		authorityField.setBounds(7, 33, 135, 28);
		authorityField.setBackground(SystemColor.controlHighlight);
		authorityField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		authorityPanel.add(authorityField);
		authorityField.setEditable(false);
		authorityField.setColumns(10);
		
		JPanel setSpeedpanel = new JPanel();
		setSpeedpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setSpeedpanel.setBackground(SystemColor.controlHighlight);
		setSpeedpanel.setBounds(84, 203, 477, 148);
		mainPanel.add(setSpeedpanel);
		setSpeedpanel.setLayout(null);
		velocitySlider.setBounds(12, 83, 453, 52);
		setSpeedpanel.add(velocitySlider);
		velocitySlider.setEnabled(false);
		
		velocitySlider.setValue(0);
		velocitySlider.setPaintTicks(true);
		velocitySlider.setMinorTickSpacing(100);
		velocitySlider.setMaximum(4350);
		velocitySlider.setMajorTickSpacing(1000);
		velocitySlider.setBackground(SystemColor.controlHighlight);
		velocitySlider.setLabelTable( labelTable );
		velocitySlider.setPaintLabels(true);
		
		setpointVelocityField = new JTextField();
		setpointVelocityField.setHorizontalAlignment(SwingConstants.CENTER);
		setpointVelocityField.setBackground(SystemColor.controlHighlight);
		setpointVelocityField.setEditable(false);
		setpointVelocityField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		setpointVelocityField.setBounds(188, 48, 101, 28);
		setSpeedpanel.add(setpointVelocityField);
		setpointVelocityField.setColumns(10);
		
		JLabel setpointVelocityLbl = new JLabel("Target Speed");
		setpointVelocityLbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		setpointVelocityLbl.setBounds(183, 13, 111, 22);
		setSpeedpanel.add(setpointVelocityLbl);
		setpointVelocityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Operating Modes:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(567, 13, 140, 22);
		mainPanel.add(lblNewLabel);
		
		JPanel currSpdPanel = new JPanel();
		currSpdPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		currSpdPanel.setBounds(173, 82, 149, 84);
		mainPanel.add(currSpdPanel);
		currSpdPanel.setBackground(SystemColor.controlHighlight);
		currSpdPanel.setLayout(null);
		
		JLabel lblCurrSpeed = new JLabel("Current Speed");
		lblCurrSpeed.setBounds(18, 6, 112, 22);
		lblCurrSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrSpeed.setFont(new Font("Times New Roman", Font.BOLD, 18));
		currSpdPanel.add(lblCurrSpeed);
		
		currSpdField = new JTextField();
		currSpdField.setHorizontalAlignment(SwingConstants.CENTER);
		currSpdField.setBounds(7, 33, 135, 28);
		currSpdField.setBackground(SystemColor.controlHighlight);
		currSpdField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		currSpdField.setEditable(false);
		currSpdField.setColumns(10);
		currSpdPanel.add(currSpdField);
		
		JPanel blkSpdLimPanel = new JPanel();
		blkSpdLimPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		blkSpdLimPanel.setBounds(12, 82, 149, 84);
		mainPanel.add(blkSpdLimPanel);
		blkSpdLimPanel.setBackground(SystemColor.controlHighlight);
		blkSpdLimPanel.setLayout(null);
		
		JLabel lblBlockSpeedLimit = new JLabel("Block Speed Limit");
		lblBlockSpeedLimit.setBounds(3, 6, 144, 22);
		lblBlockSpeedLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlockSpeedLimit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		blkSpdLimPanel.add(lblBlockSpeedLimit);
		
		blkSpdLimTextField = new JTextField();
		blkSpdLimTextField.setHorizontalAlignment(SwingConstants.CENTER);
		blkSpdLimTextField.setBounds(7, 33, 135, 28);
		blkSpdLimTextField.setBackground(SystemColor.controlHighlight);
		blkSpdLimTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		blkSpdLimTextField.setEditable(false);
		blkSpdLimTextField.setColumns(10);
		blkSpdLimPanel.add(blkSpdLimTextField);
		velocitySlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setTargetVelocity(velocitySlider.getValue() / 100);
            }
        });}
	
	public void addTrain(int trainID) {
		trainSelectBox.addItem(new Integer(trainID));
	}
	
	public void setTargetVelocity(double newVelocity) {
		
		//prevent driver from going above setpoint
		if((controller.getBlockSpeedLimit() * MPS_TO_MPH) < newVelocity) {
			newVelocity = controller.getBlockSpeedLimit() * MPS_TO_MPH;
		}
		
		setpointVelocityField.setText(formatter.format(newVelocity));
		
		controller.setTrainsitVelocity(newVelocity / MPS_TO_MPH);
	}
	
	public void switchServiceBrakeStatus() {
		if(brakeStatusField.getText().equals("Disengaged")) {
			controller.stopTrain(true);
			brakeStatusField.setText("Engaged");
		}
		else {
			controller.releaseServiceBrakes(true);
			brakeStatusField.setText("Disengaged");
		}
	}
	
	public void switchEmergencyBrakeStatus() {
		if(eBrakeStatusField.getText().equals("Disengaged")) {
			controller.emergencyStop(true);
			eBrakeStatusField.setText("Engaged");
		}
		else {
			controller.releaseEmergencyBrakes(true);
			eBrakeStatusField.setText("Disengaged");
		}
	}
	
	private void updateSetpointVelocity(double newSetpointVelocity) {
		setpointVelocityField.setText(formatter.format(newSetpointVelocity) +" mph");
	}
	
	private void updateVelocityFeedback(double newVelocityFeedback) {
		currSpdField.setText(formatter.format(newVelocityFeedback * MPS_TO_MPH)+" mph");
	}
	
	private void updateAuthority() {
		authorityField.setText(formatter.format(controller.getAuthority())+" ft");
	}
	
	private void updateblockSpeedLimit() {
		blkSpdLimTextField.setText(formatter.format(controller.getBlockSpeedLimit())+" mph");
	}
	
	private void updatePowerCommand(double newPowerCommand) {
		powerCommandField.setText(formatter.format(newPowerCommand)+" W");
	}
	
	private void updateStation(String station) {
		AnnouncmentsField.setText("Approaching " + station);
	}
	
	private void updateTransponder() {
    controller.transponder();
	}
	
	public void update() {
		if(controller != null) {
			updateAuthority();
			updateblockSpeedLimit();
			updateSetpointVelocity(controller.getSetSpeedLimit() * MPS_TO_MPH);
			updateVelocityFeedback(controller.getVelocityFeedback() );
			updatePowerCommand(controller.getPowerCommand());
			updateStation(controller.getStation());
			updateTransponder();
			checkBrakes();
			checkDoors();
		}
	}
	
	
	
	public void checkBrakes() {
		if(controller.getsbrake()) {
			
			brakeStatusField.setText("Engaged");
		}
		
		else {
			
			brakeStatusField.setText("Disengaged");
		}
		
		if(controller.getebrake()) {
			
			eBrakeStatusField.setText("Engaged");
		}
		
		else {
			
			eBrakeStatusField.setText("Disengaged");
		}
	}
	
	public void checkDoors() {
		
		if(controller.leftDoorStatus) {
		
			leftDoorStatusField.setText("Open");
		}
		
		else {
			leftDoorStatusField.setText("Closed");
		}
		
		if(controller.rightDoorStatus) {
		
			rightDoorStatusField.setText("Open");
		}
		else {
			
			rightDoorStatusField.setText("Closed");
		}
	}
	
	public void switchTrain(int trainID) {
		controller = wrapper.getTrainController(trainID);
		update();
	}
	
	public void switchMode(int modeID) {
		if(controller != null) {
			controller.setMode(modeID);
		}
		
		//auto
		if(modeID == 1) {
			velocitySlider.setEnabled(false);
			brakeButton.setEnabled(false);
			rightDoorButton.setEnabled(false);
			leftDoorButton.setEnabled(false);
			
		}
		else {
			velocitySlider.setEnabled(true);
			brakeButton.setEnabled(true);
			rightDoorButton.setEnabled(true);
			leftDoorButton.setEnabled(true);
			
		}
}
	
}

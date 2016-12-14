package TrainModel;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.event.ChangeListener;

import TrainController.Controller;
import TrainController.TrainController;

import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSpinner;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TrainModelUI {

	JFrame frmTrainmodelmodule;
	
	//Constants
	private JTextField txtLength;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField txtEmptyMass;
	private JTextField txtEBrakeDecel;
	private JTextField txtSBrakeDecel;
	private JTextField txtAccelLim;
	private JTextField txtMaxEnginePwr;
	private JTextField txtMaxSpeed;
	
	private JTextField txtEnginePower;
	private JTextField textLeftDoorStat;
	private JTextField textRightDoorStat;
	private JTextField txtEBrkStat;
	private JTextField txtSBrkStat;
	private JTextField txtSetSpd;
	private JTextField txtAuthority;
	private JTextField txtBockSpdLim;
	private JTextField txtCurrSpd;
	private JTextField txtAccel;
	private JTextField txtGrade;
	private final JComboBox<Integer> trainSelectBox = new JComboBox<Integer>();
	
	private Train train;
	private TrainModel trainModel;
	private int displayTrain;
	
	
	public void setTrain(Train train){
		this.train = train;
		this.displayTrain = train.getID();
	}

	/**
	 * Create the application.
	 * @param train 
	 */
	public TrainModelUI(TrainModel trainModel) {
		this.trainModel = trainModel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrainmodelmodule = new JFrame();
		frmTrainmodelmodule.setTitle("TrainModelModule");
		frmTrainmodelmodule.setBounds(100, 100, 1161, 579);
		frmTrainmodelmodule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrainmodelmodule.getContentPane().setLayout(null);
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JPanel failureModesPanel = new JPanel();
		failureModesPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		failureModesPanel.setBounds(12, 23, 219, 347);
		frmTrainmodelmodule.getContentPane().add(failureModesPanel);
		failureModesPanel.setLayout(null);
		
		JLabel lblFailModes = new JLabel("Failure Modes");
		lblFailModes.setBounds(30, 0, 164, 48);
		failureModesPanel.add(lblFailModes);
		lblFailModes.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFailModes.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton engineFailureButton = new JButton("Engine Failure");
		engineFailureButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		engineFailureButton.setBounds(30, 61, 164, 54);
		failureModesPanel.add(engineFailureButton);
		engineFailureButton.setForeground(Color.BLACK);
		
		JButton brakeFailureButton = new JButton("Brake Failure");
		brakeFailureButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		brakeFailureButton.setBounds(30, 130, 164, 54);
		failureModesPanel.add(brakeFailureButton);
		
		JButton signalPickupFailureButton = new JButton("Signal Pickup Failure");
		signalPickupFailureButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		signalPickupFailureButton.setBounds(30, 208, 164, 54);
		failureModesPanel.add(signalPickupFailureButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		resetButton.setBounds(30, 289, 164, 45);
		failureModesPanel.add(resetButton);
		
		engineFailureButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				
				brakeFailureButton.setEnabled(false);
				signalPickupFailureButton.setEnabled(false);
				train.activateEngineFailure();
			}
		});
		
		brakeFailureButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				engineFailureButton.setEnabled(false);
				signalPickupFailureButton.setEnabled(false);
				train.activateBrakeFailure();
			}
		});
		
		signalPickupFailureButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				brakeFailureButton.setEnabled(false);
				engineFailureButton.setEnabled(false);
				train.activateSignalPickupFailure();
			}
		});
		
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				brakeFailureButton.setEnabled(true);
				engineFailureButton.setEnabled(true);
				signalPickupFailureButton.setEnabled(true);
				train.deactivateEngineFailure();
				train.deactivateBrakeFailure();
				train.deactivateSignalPickupFailure();
			}
		});
		
		JPanel enginePwrPanel = new JPanel();
		enginePwrPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		enginePwrPanel.setBounds(506, 23, 144, 70);
		frmTrainmodelmodule.getContentPane().add(enginePwrPanel);
		enginePwrPanel.setLayout(null);
		
		JLabel lblEnginePwr = new JLabel("Engine Power");
		lblEnginePwr.setBounds(19, 0, 106, 22);
		enginePwrPanel.add(lblEnginePwr);
		lblEnginePwr.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnginePwr.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtEnginePower = new JTextField();
		txtEnginePower.setBounds(6, 28, 131, 28);
		enginePwrPanel.add(txtEnginePower);
		txtEnginePower.setEditable(false);
		txtEnginePower.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnginePower.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtEnginePower.setColumns(10);
		
		JPanel brkInputPanel = new JPanel();
		brkInputPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		brkInputPanel.setBounds(243, 23, 251, 347);
		frmTrainmodelmodule.getContentPane().add(brkInputPanel);
		brkInputPanel.setLayout(null);
		
		JLabel lblBrkInputs = new JLabel("Brake Inputs");
		lblBrkInputs.setBounds(71, 13, 101, 22);
		brkInputPanel.add(lblBrkInputs);
		lblBrkInputs.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBrkInputs.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton tglbtnServiceBrake = new JButton("Service Brake");
		tglbtnServiceBrake.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		tglbtnServiceBrake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent o) {
				switchServiceBrakeStatus();
			}
		});
		tglbtnServiceBrake.setSelected(false);
		tglbtnServiceBrake.setBounds(12, 213, 228, 121);
		brkInputPanel.add(tglbtnServiceBrake);
		
		JButton tglbtnEmergencyBrake = new JButton("Passenger Emergency Brake");
		tglbtnEmergencyBrake.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		tglbtnEmergencyBrake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent y) {
			switchEmergencyBrakeStatus();
			}
		});
		tglbtnEmergencyBrake.setSelected(false);
		tglbtnEmergencyBrake.setBounds(12, 56, 228, 121);
		brkInputPanel.add(tglbtnEmergencyBrake);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Fixed values on the gui
		JLabel lblLength = new JLabel("Length:");
		lblLength.setHorizontalAlignment(SwingConstants.LEFT);
		lblLength.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblLength.setBounds(47, 398, 60, 22);
		frmTrainmodelmodule.getContentPane().add(lblLength);
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWidth.setBounds(54, 430, 53, 22);
		frmTrainmodelmodule.getContentPane().add(lblWidth);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHeight.setBounds(50, 462, 57, 22);
		frmTrainmodelmodule.getContentPane().add(lblHeight);
		
		JLabel lblEmptyMass = new JLabel("Empty Mass:");
		lblEmptyMass.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmptyMass.setBounds(6, 493, 101, 22);
		frmTrainmodelmodule.getContentPane().add(lblEmptyMass);
		
		JLabel lblEmergencyBrakeDeceleration = new JLabel("Emergency Brake Deceleration Limit:");
		lblEmergencyBrakeDeceleration.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmergencyBrakeDeceleration.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmergencyBrakeDeceleration.setBounds(285, 394, 291, 22);
		frmTrainmodelmodule.getContentPane().add(lblEmergencyBrakeDeceleration);
		
		JLabel lblServiceBrakeAcceleration = new JLabel("Service Brake Deceleration Limit:");
		lblServiceBrakeAcceleration.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblServiceBrakeAcceleration.setBounds(315, 429, 261, 22);
		frmTrainmodelmodule.getContentPane().add(lblServiceBrakeAcceleration);
		
		JLabel lblAccelerationLimit = new JLabel("Acceleration Limit:");
		lblAccelerationLimit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAccelerationLimit.setBounds(426, 462, 150, 22);
		frmTrainmodelmodule.getContentPane().add(lblAccelerationLimit);
		
		JLabel lblMaxEnginePower = new JLabel("Max Engine Power:");
		lblMaxEnginePower.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaxEnginePower.setBounds(771, 394, 151, 22);
		frmTrainmodelmodule.getContentPane().add(lblMaxEnginePower);
		
		JLabel lblMaxSpeed = new JLabel("Max Speed:");
		lblMaxSpeed.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxSpeed.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMaxSpeed.setBounds(831, 428, 91, 22);
		frmTrainmodelmodule.getContentPane().add(lblMaxSpeed);
		
		txtLength = new JTextField();
		txtLength.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtLength.setText("105.64 ft");
		txtLength.setEditable(false);
		txtLength.setBounds(115, 397, 116, 22);
		frmTrainmodelmodule.getContentPane().add(txtLength);
		txtLength.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtWidth.setText("8.69 ft");
		txtWidth.setEditable(false);
		txtWidth.setColumns(10);
		txtWidth.setBounds(115, 431, 116, 22);
		frmTrainmodelmodule.getContentPane().add(txtWidth);
		
		txtHeight = new JTextField();
		txtHeight.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtHeight.setText("11.22 ft");
		txtHeight.setEditable(false);
		txtHeight.setColumns(10);
		txtHeight.setBounds(115, 463, 116, 22);
		frmTrainmodelmodule.getContentPane().add(txtHeight);
		
		txtEmptyMass = new JTextField();
		txtEmptyMass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtEmptyMass.setText("90169.07 lbs");
		txtEmptyMass.setEditable(false);
		txtEmptyMass.setColumns(10);
		txtEmptyMass.setBounds(115, 494, 116, 22);
		frmTrainmodelmodule.getContentPane().add(txtEmptyMass);
		
		txtEBrakeDecel = new JTextField();
		txtEBrakeDecel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtEBrakeDecel.setText("- 8.96 (ft)/(s^2)");
		txtEBrakeDecel.setEditable(false);
		txtEBrakeDecel.setColumns(10);
		txtEBrakeDecel.setBounds(584, 397, 127, 22);
		frmTrainmodelmodule.getContentPane().add(txtEBrakeDecel);
		
		txtSBrakeDecel = new JTextField();
		txtSBrakeDecel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSBrakeDecel.setText("- 3.94 (ft)/(s^2)");
		txtSBrakeDecel.setEditable(false);
		txtSBrakeDecel.setColumns(10);
		txtSBrakeDecel.setBounds(584, 431, 127, 22);
		frmTrainmodelmodule.getContentPane().add(txtSBrakeDecel);
		
		txtAccelLim = new JTextField();
		txtAccelLim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtAccelLim.setText("1.64 (ft)/(s^2)");
		txtAccelLim.setEditable(false);
		txtAccelLim.setColumns(10);
		txtAccelLim.setBounds(584, 463, 127, 22);
		frmTrainmodelmodule.getContentPane().add(txtAccelLim);
		
		txtMaxEnginePwr = new JTextField();
		txtMaxEnginePwr.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaxEnginePwr.setText("120000 W");
		txtMaxEnginePwr.setEditable(false);
		txtMaxEnginePwr.setColumns(10);
		txtMaxEnginePwr.setBounds(927, 396, 116, 22);
		frmTrainmodelmodule.getContentPane().add(txtMaxEnginePwr);
		
		txtMaxSpeed = new JTextField();
		txtMaxSpeed.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaxSpeed.setText("43.50 mph");
		txtMaxSpeed.setEditable(false);
		txtMaxSpeed.setColumns(10);
		txtMaxSpeed.setBounds(927, 430, 116, 22);
		frmTrainmodelmodule.getContentPane().add(txtMaxSpeed);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel doorPanel = new JPanel();
		doorPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		doorPanel.setBounds(506, 252, 272, 118);
		frmTrainmodelmodule.getContentPane().add(doorPanel);
		doorPanel.setLayout(null);
		
		JLabel lblLeftDoorsStatus = new JLabel("Left Doors Status:");
		lblLeftDoorsStatus.setBounds(23, 44, 142, 22);
		doorPanel.add(lblLeftDoorsStatus);
		lblLeftDoorsStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblRightDoorsStatus = new JLabel("Right Doors Status:");
		lblRightDoorsStatus.setBounds(12, 70, 153, 22);
		doorPanel.add(lblRightDoorsStatus);
		lblRightDoorsStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblRightDoorsStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_5 = new JLabel("Doors");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(112, 13, 56, 16);
		doorPanel.add(lblNewLabel_5);
		
		textLeftDoorStat = new JTextField();
		textLeftDoorStat.setHorizontalAlignment(SwingConstants.CENTER);
		textLeftDoorStat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textLeftDoorStat.setEditable(false);
		textLeftDoorStat.setColumns(10);
		textLeftDoorStat.setBounds(176, 45, 84, 22);
		doorPanel.add(textLeftDoorStat);
		
		textRightDoorStat = new JTextField();
		textRightDoorStat.setHorizontalAlignment(SwingConstants.CENTER);
		textRightDoorStat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textRightDoorStat.setEditable(false);
		textRightDoorStat.setColumns(10);
		textRightDoorStat.setBounds(176, 71, 84, 22);
		doorPanel.add(textRightDoorStat);
		
		JPanel brakePanel = new JPanel();
		brakePanel.setLayout(null);
		brakePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		brakePanel.setBounds(790, 252, 338, 118);
		frmTrainmodelmodule.getContentPane().add(brakePanel);
		
		JLabel lblEmergencyBrakeStatus = new JLabel("Emergency Brake Status:");
		lblEmergencyBrakeStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmergencyBrakeStatus.setBounds(12, 44, 194, 22);
		brakePanel.add(lblEmergencyBrakeStatus);
		
		JLabel lblServiceBrakeStatus = new JLabel("Service Brake Status:");
		lblServiceBrakeStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblServiceBrakeStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblServiceBrakeStatus.setBounds(42, 76, 164, 22);
		brakePanel.add(lblServiceBrakeStatus);
		
		JLabel lblBrakes = new JLabel("Brakes");
		lblBrakes.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBrakes.setBounds(159, 13, 56, 16);
		brakePanel.add(lblBrakes);
		trainSelectBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		trainSelectBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
			          Integer trainID = (Integer) arg0.getItem();
			          switchTrain(trainID);
			    }
			}
		});
		
		trainSelectBox.setBounds(1060, 23, 58, 20);
		frmTrainmodelmodule.getContentPane().add(trainSelectBox);
		
		txtEBrkStat = new JTextField();
		txtEBrkStat.setHorizontalAlignment(SwingConstants.CENTER);
		txtEBrkStat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtEBrkStat.setEditable(false);
		txtEBrkStat.setColumns(10);
		txtEBrkStat.setBounds(209, 45, 116, 22);
		brakePanel.add(txtEBrkStat);
		
		txtSBrkStat = new JTextField();
		txtSBrkStat.setHorizontalAlignment(SwingConstants.CENTER);
		txtSBrkStat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtSBrkStat.setEditable(false);
		txtSBrkStat.setColumns(10);
		txtSBrkStat.setBounds(209, 77, 116, 22);
		brakePanel.add(txtSBrkStat);
		
		JPanel setSpdPanel = new JPanel();
		setSpdPanel.setLayout(null);
		setSpdPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setSpdPanel.setBounds(662, 23, 144, 70);
		frmTrainmodelmodule.getContentPane().add(setSpdPanel);
		
		JLabel lblSetSpd = new JLabel("Target Speed");
		lblSetSpd.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetSpd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSetSpd.setBounds(19, 0, 106, 22);
		setSpdPanel.add(lblSetSpd);
		
		txtSetSpd = new JTextField();
		txtSetSpd.setHorizontalAlignment(SwingConstants.CENTER);
		txtSetSpd.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSetSpd.setEditable(false);
		txtSetSpd.setColumns(10);
		txtSetSpd.setBounds(6, 28, 131, 28);
		setSpdPanel.add(txtSetSpd);
		
		JPanel Authoritypanel = new JPanel();
		Authoritypanel.setLayout(null);
		Authoritypanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Authoritypanel.setBounds(818, 23, 144, 70);
		frmTrainmodelmodule.getContentPane().add(Authoritypanel);
		
		JLabel lblAuthority = new JLabel("Authority");
		lblAuthority.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthority.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAuthority.setBounds(19, 0, 106, 22);
		Authoritypanel.add(lblAuthority);
		
		txtAuthority = new JTextField();
		txtAuthority.setHorizontalAlignment(SwingConstants.CENTER);
		txtAuthority.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtAuthority.setEditable(false);
		txtAuthority.setColumns(10);
		txtAuthority.setBounds(6, 28, 131, 28);
		Authoritypanel.add(txtAuthority);
		
		JPanel blkSpdLimPanel = new JPanel();
		blkSpdLimPanel.setLayout(null);
		blkSpdLimPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		blkSpdLimPanel.setBounds(506, 135, 144, 70);
		frmTrainmodelmodule.getContentPane().add(blkSpdLimPanel);
		
		JLabel lblBlockSpeedLimit = new JLabel("Block Speed Limit");
		lblBlockSpeedLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlockSpeedLimit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBlockSpeedLimit.setBounds(6, 0, 131, 22);
		blkSpdLimPanel.add(lblBlockSpeedLimit);
		
		txtBockSpdLim = new JTextField();
		txtBockSpdLim.setHorizontalAlignment(SwingConstants.CENTER);
		txtBockSpdLim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtBockSpdLim.setEditable(false);
		txtBockSpdLim.setColumns(10);
		txtBockSpdLim.setBounds(6, 28, 131, 28);
		blkSpdLimPanel.add(txtBockSpdLim);
		
		JPanel currSpeedPanel = new JPanel();
		currSpeedPanel.setLayout(null);
		currSpeedPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		currSpeedPanel.setBounds(662, 135, 144, 70);
		frmTrainmodelmodule.getContentPane().add(currSpeedPanel);
		
		JLabel lblCurrSpd = new JLabel("Current Speed");
		lblCurrSpd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrSpd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCurrSpd.setBounds(6, 0, 131, 22);
		currSpeedPanel.add(lblCurrSpd);
		
		txtCurrSpd = new JTextField();
		txtCurrSpd.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurrSpd.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtCurrSpd.setEditable(false);
		txtCurrSpd.setColumns(10);
		txtCurrSpd.setBounds(6, 28, 131, 28);
		currSpeedPanel.add(txtCurrSpd);
		
		JPanel accelPanel = new JPanel();
		accelPanel.setLayout(null);
		accelPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		accelPanel.setBounds(818, 135, 144, 70);
		frmTrainmodelmodule.getContentPane().add(accelPanel);
		
		JLabel lblAcceleration = new JLabel("Acceleration");
		lblAcceleration.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcceleration.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAcceleration.setBounds(19, 0, 106, 22);
		accelPanel.add(lblAcceleration);
		
		txtAccel = new JTextField();
		txtAccel.setHorizontalAlignment(SwingConstants.CENTER);
		txtAccel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtAccel.setEditable(false);
		txtAccel.setColumns(10);
		txtAccel.setBounds(6, 28, 131, 28);
		accelPanel.add(txtAccel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_5.setBounds(974, 135, 144, 70);
		frmTrainmodelmodule.getContentPane().add(panel_5);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblGrade.setBounds(19, 0, 106, 22);
		panel_5.add(lblGrade);
		
		txtGrade = new JTextField();
		txtGrade.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrade.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtGrade.setEditable(false);
		txtGrade.setColumns(10);
		txtGrade.setBounds(6, 28, 131, 28);
		panel_5.add(txtGrade);
		
		JLabel lblTrainId = new JLabel("Train ID:");
		lblTrainId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTrainId.setBounds(985, 22, 74, 20);
		frmTrainmodelmodule.getContentPane().add(lblTrainId);
		
	}
	public void addTrain(int trainID) {
		trainSelectBox.addItem(new Integer(trainID));
	}
	
	public int getCurrTrain(){
		return displayTrain;
	}
	public void switchTrain(int trainID) {
		train = trainModel.getTrain(trainID);
		setTrain(train);
	}
	
	//Display
	public void setBlkSpdLimit(String blcspdlim)
	{
		txtBockSpdLim.setText(blcspdlim + " mph");
	}
	
	public void setGrade(String Grade)
	{
		txtGrade.setText(Grade);
	}
	public void setAcceleration(String accel){
		txtAccel.setText(accel + " (ft)/(s^2)");
	}
	public void setSpeed(String speed){
		txtSetSpd.setText(speed + " mph");
	}
	public void setCurrSpeed(String currspeed){
		txtCurrSpd.setText(currspeed + " mph");
	}
	public void setAuthority(String auth){
		txtAuthority.setText(auth + " ft");
	}
	
	public void setEnginePower(String power){
		txtEnginePower.setText(power + " W");
	}
	
	public void checkBrakes() {
		System.out.println(""+train.isServiceBrakeActive());
		if(!train.isBrakeFailureActive())
		{
		if(train.isServiceBrakeActive()) {
			txtSBrkStat.setText("Engaged");
		}
		else {
			txtSBrkStat.setText("Disengaged");
		}
		}
		else{
			txtSBrkStat.setText("Disengaged");
			train.deactivateServiceBrake();
		}
		
		if(train.isEmergencyBrakeActive()) {
			txtEBrkStat.setText("Engaged");
		}
		else {
			txtEBrkStat.setText("Disengaged");
		}
	}

	
	public void switchServiceBrakeStatus() {
		
		
		if(txtSBrkStat.getText().equals("Disengaged")) {
			train.activateServiceBrake();
		}
		else {
			train.deactivateServiceBrake();
		}
		}
	
		
		
	
	
	public void switchEmergencyBrakeStatus() {
		if(txtEBrkStat.getText().equals("Disengaged")) {
			train.activateEmergencyBrake();
		}
		else {
			train.deactivateEmergencyBrake();
		}
	}
		public void setLeftDoors(boolean left){
		if(left)
			textLeftDoorStat.setText("Open");
		else
			textLeftDoorStat.setText("Closed");
	}
	
	public void setRightDoors(boolean right){
		if(right)
			textRightDoorStat.setText("Open");
		else
			textRightDoorStat.setText("Closed");
	}
}

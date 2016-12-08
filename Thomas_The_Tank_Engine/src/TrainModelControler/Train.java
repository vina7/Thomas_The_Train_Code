package TrainModel;
import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.util.*;

import TrainController.Controller;


public class Train {

	DecimalFormat SigFig = new DecimalFormat("0.00");

	//Attributes
	private TrainModelUI ui;
	private TrainModel trainModel;
	//private Controller trainController;

	//Constants used for conversion
	private static final double METRIC_VEL_CONV = 3.6;	// Used to convert from km/h --> m/s 
	private static final double METER_TO_FEET = 3.28084; 
	private static final double METRIC_TO_US = 1.10231131;
	private static final double KM_TO_MI = 0.621371;

	//Train Characteristics
	private static final double TRAIN_MAX_VELOCITY = 19.444;	//19.44m/s --> 70.0 km/h
	private static final double TRAIN_MAX_ACCELERATION = 0.5;	//m/s^2
	private static final double SERVICE_BRAKE_DECELERATION = -1.2;	//m/s^2
	private static final double EMERGENCY_BRAKE_DECELERATION = -2.73;	//m/s^2
	private static final double TRAIN_EMPTY_MASS = 40900.0;	//40900 kg --> 40.9 tons;
		
	//Track Model Inputs
	private double setSpeed;
	private double authority;
	private double grade;
	private double blockSpeedLimit;
	
	//Train Movement Stuff
	private double enginePower;
	private double trainForce; 
	private double acceleration;
	private double currentSpeed;
	private double displacement;   

	//Train Features
	private int 	trainID;
	private boolean serviceBrake;
	private boolean emergencyBrake;
	private boolean leftDoors;
	private boolean rightDoors;

	//Failures
	private boolean brakeFailure; 
	private boolean signalPickupFailure;
	private boolean engineFailure;

	private String stationName; 

	public Train(int trainID){
		//initializing variables
		this.trainID = trainID;

		
		acceleration = 0.0;
		currentSpeed = 0.0; 
	}

	public void setUI(TrainModelUI ui){
		this.ui = ui;
	}
	public TrainModelUI getUI(){
		return ui;
	}
	public void updateTrain(){
		calculateTrainForce();
		calculateAcceleration();
		calculateCurrentSpeed();
		calculateDisplacment();
		if(ui.getCurrTrain() == trainID)
			setDisplay();
		
		System.out.println("Train ID: " + trainID);
		System.out.println("Train Force: "+trainForce+" N");
		System.out.println("Train Accel: "+acceleration+" m/s^2");
		System.out.println("Train Velocity: "+currentSpeed+" m/s");
System.out.println();
	}
	
	public void setDisplay(){
		
		//Display
		ui.setBlkSpdLimit(SigFig.format(blockSpeedLimit*METRIC_VEL_CONV*KM_TO_MI));
		ui.setGrade(SigFig.format(grade));
		ui.setAcceleration(SigFig.format(acceleration*METER_TO_FEET));
		ui.setSpeed(SigFig.format(setSpeed*METRIC_VEL_CONV*KM_TO_MI));
		ui.setCurrSpeed(SigFig.format(currentSpeed*METRIC_VEL_CONV*KM_TO_MI));
		ui.setAuthority(SigFig.format(authority));
		ui.setEnginePower(SigFig.format(enginePower));
		//ui.switchEmergencyBrakeStatus();
		//ui.switchServiceBrakeStatus();
		ui.checkBrakes();
		ui.setLeftDoors(leftDoors);
		ui.setRightDoors(rightDoors);
	}

//public void setTrainController(Controller controller) {
	//	trainController = controller;
	//}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public int getID(){
		return trainID;
	}

	/*
	 * The following methods are used to calculate the trains movement
	*/
	public void calculateTrainForce() {
		double gravity = 9.8;
		double rollingCoefficient = .001;

		double gravitationalForce; 
		double frictionalForce; 
		double engineForce;
		if (serviceBrake){
			if (currentSpeed == 0.0){
				trainForce = 0.0;
			}
			else{
				trainForce = SERVICE_BRAKE_DECELERATION*TRAIN_EMPTY_MASS;
			}
		}
		else if (emergencyBrake){
			if (currentSpeed == 0.0){	
				trainForce = 0.0;
			}
			else{		
				trainForce = EMERGENCY_BRAKE_DECELERATION*TRAIN_EMPTY_MASS;
			}
		}
		else{
			if (enginePower/(currentSpeed) > 120000){
				engineForce = 120000; //N
			}
			else {
				engineForce = enginePower/((currentSpeed)); //N
			}
			frictionalForce = rollingCoefficient * (TRAIN_EMPTY_MASS* gravity * Math.cos(Math.atan(grade/100))); //N
			gravitationalForce = TRAIN_EMPTY_MASS * gravity * Math.sin(Math.atan(grade/100)); //N
			trainForce = engineForce - frictionalForce - gravitationalForce; //N
		}
	}

	public void calculateAcceleration(){
		acceleration = trainForce/(TRAIN_EMPTY_MASS);
		if (acceleration > TRAIN_MAX_ACCELERATION){
				acceleration = TRAIN_MAX_ACCELERATION;
		}
		if (acceleration < 0.0 & currentSpeed == 0.0){
				acceleration = 0.0;
		}
	}

	public void calculateCurrentSpeed(){
		currentSpeed += acceleration;
		if (currentSpeed < 0.0){
				currentSpeed = 0.0;
		}
	}

	public void calculateDisplacment(){
		displacement = currentSpeed;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * The following methods are used to set the failure modes on the train
	*/
	public void activateBrakeFailure(){
		brakeFailure = true;
	}
	
	public void deactivateBrakeFailure(){
		brakeFailure = false;
	}
	
	public boolean isBrakeFailureActive()
	{
		return brakeFailure;
	}
	public void activateEngineFailure(){
		engineFailure = true;
	}
	
	public void deactivateEngineFailure(){
		engineFailure = false;
	}
	
	public void activateSignalPickupFailure(){
		signalPickupFailure = true;
	}
	
	public void deactivateSignalPickupFailure(){
		signalPickupFailure = false;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * The following methods are used to set the emergency and service brakes on the train
	*/
	public void activateEmergencyBrake(){
		emergencyBrake = true;
	}

	public void deactivateEmergencyBrake(){
		emergencyBrake = false;
	}
	
	public boolean isEmergencyBrakeActive(){
		return emergencyBrake;
	}

	public void activateServiceBrake(){
		if (brakeFailure){
			serviceBrake = false;
		}
		else{
			serviceBrake = true;
		}
	}

	public void deactivateServiceBrake(){
		serviceBrake = false;
	}

	public boolean isServiceBrakeActive(){
		return serviceBrake;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * The following methods are used to set the right and left doors on the train
	*/
	public void openLeftDoors(){
		leftDoors = true;
	}
	
	public void closeLeftDoors(){
		leftDoors = false;
	}

	public void openRightDoors(){
		rightDoors = true;
	}
	
	public void closeRightDoors(){
		rightDoors = false;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setBlockSpeedLimit(double blockSpeedLimit){	
		if (signalPickupFailure){
			this.blockSpeedLimit = 0;	
		}
		else{
			this.blockSpeedLimit = blockSpeedLimit;	
		}
	}

	public double getBlockSpeedLimit(){
		return blockSpeedLimit;
	}

	public void setSpeed(int setSpeed){
		if (signalPickupFailure){	
			this.setSpeed = 0;
		}
		else{
			this.setSpeed = setSpeed;
		}
	}
	
	public void setStationInfro(String stationName, String side)
	{
		this.stationName = stationName;
	}

	public void setAuthority(double authority){
		if (signalPickupFailure){
			this.authority = 0;
		}
		else {
			this.authority = authority;
		}
	}
	
	public double getAuthority(){
		return authority;
	}
	
	public void setGrade(double grade){	
		this.grade = grade;
}
	
	public double getSetSpeed(){
		return setSpeed;
	}
	
	public double getCurrentSpeed(){
		return currentSpeed;
	}

	public double getDisplacement(){
		return displacement;
	}

	public double setEnginePower(double powerCommand){
		if (engineFailure){
			enginePower = 0;
		}
		else {
			if(powerCommand < 0.0) {
				activateServiceBrake();
			} 
			if (emergencyBrake || serviceBrake){
				enginePower = 0;
			}
			else {
				enginePower = powerCommand;;	
			}
		}
		return enginePower;
	}
	
	}











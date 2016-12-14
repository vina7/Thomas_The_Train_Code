package TrainModel;
import java.text.DecimalFormat;
import TrainController.Controller;
import Interface.CTCandTrackControllerInterface;
import Interface.TrackCircuit;



public class Train {

	DecimalFormat SigFig = new DecimalFormat("0.00");
	private TrackCircuit circuit = TrackCircuit.getInstance(false);
	private CTCandTrackControllerInterface CTCinterface = CTCandTrackControllerInterface.getInstance(false);

	//Attributes
	private TrainModelUI ui;
	private Controller trainController;

	//Constants used for conversion
	private static final double METRIC_VEL_CONV = 3.6;	// Used to convert from km/h --> m/s 
	private static final double METER_TO_FEET = 3.28084; 
	private static final double METRIC_TO_US = 1.10231131;
	private static final double KM_TO_MI = 0.621371;

	//Constants used in calculations
	private static final double TRAIN_MAX_ACCELERATION = 0.5;	//m/s^2
	private static final double SERVICE_BRAKE_DECELERATION = -1.2;	//m/s^2
	private static final double EMERGENCY_BRAKE_DECELERATION = -2.73;	//m/s^2
	private static final double TRAIN_EMPTY_MASS = 40900.0;	//40900 kg --> 40.9 tons;
		
	//Track Model Inputs
	private double CTCAdvisedSpeed;
	private double authority;
	private double grade;
	private double blockSpeedLimit;
	private String station;
	private boolean transponder;
	private boolean direction;
	
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
		calculateDisplacement();
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
		ui.setBlkSpdLimit(SigFig.format(blockSpeedLimit));
		ui.setGrade(SigFig.format(grade));
		ui.setAcceleration(SigFig.format(acceleration*METER_TO_FEET));
		ui.setSpeed(SigFig.format(trainController.getSetSpeedLimit()*METRIC_VEL_CONV*KM_TO_MI));
		ui.setCurrSpeed(SigFig.format(currentSpeed*METRIC_VEL_CONV*KM_TO_MI));
		ui.setAuthority(SigFig.format(authority));
		ui.setEnginePower(SigFig.format(enginePower));
		ui.checkBrakes();
		ui.setLeftDoors(leftDoors);
		ui.setRightDoors(rightDoors);
	}

public void setTrainController(Controller controller) {
		trainController = controller;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public int getID(){
		return trainID;
	}

	/*
	 * The following methods are used to calculate the trains movement
	*/
	
	/**
	 * The following method is used to set the engine power on the train.
	 */
	public double setEnginePower(double powerCommand){
		if (engineFailure){
			enginePower = 0;
		}
		else {
			
			if (emergencyBrake || serviceBrake){
				enginePower = 0;
			}
			
			else {
				enginePower = powerCommand;;	
			}
		}
		
		return enginePower;
	}
	
	/**
	 * The following method is used to calculate the trains force
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

	/**
	 * The following method is used to calculate the acceleration
	 */
	public void calculateAcceleration(){
		if (trainForce > 0 || trainForce < 0){

		acceleration = trainForce/(TRAIN_EMPTY_MASS);
		
		}
		
		if (acceleration > TRAIN_MAX_ACCELERATION){
		
			acceleration = TRAIN_MAX_ACCELERATION;
		}
		
		if (acceleration < 0.0 & currentSpeed == 0.0 ){
				acceleration = 0.0;
		}
	}

	/**
	 * The following method is used to calculate the current speed
	 */
	public void calculateCurrentSpeed(){
		
		currentSpeed += acceleration;
		
		if (currentSpeed < 0.0){
		
			currentSpeed = 0.0;
		}
	}

	/**
	 * The following method is used to calculate the displacement
	 */
	public void calculateDisplacement(){
		displacement = currentSpeed;
		circuit.addDisplacement(displacement, trainID);
	}
	
	/*
	 * The following methods are used to set the failure modes on the train
	*/
	
	/**
	 * The following method is used to activate a brake failure
	 */
	public void activateBrakeFailure(){
		
		brakeFailure = true;
	}
	
	/**
	 * The following methods is used to deactivate the brake failure
	 */
	public void deactivateBrakeFailure(){
	
		brakeFailure = false;
	}
	
	/**
	 * The following method is used to check if the brake failure has been activated
	 */
	public boolean isBrakeFailureActive(){
		
		return brakeFailure;
	}
	
	/**
	 * The following method is used to activate the engine failure
	 */
	public void activateEngineFailure(){
		
		engineFailure = true;
	}
	
	/**
	 * The following method is used to deactivate the engine failure
	 */
	public void deactivateEngineFailure(){
		
		engineFailure = false;
	}
	
	/**
	 * The following method is used to activate a signal pickup failure
	 */
	public void activateSignalPickupFailure(){
	
		signalPickupFailure = true;
	}
	
	/**
	 * The following method is used to deactivate the signal pickup failure
	 */
	public void deactivateSignalPickupFailure(){
		
		signalPickupFailure = false;
	}

	/*
	 * The following methods are used to set the emergency and service brakes on the train
	 */

	/**
	 * The following method is used to activate the trains emergency brakes
	 */
	public void activateEmergencyBrake(){

		emergencyBrake = true;
	}

	/**
	 * The following method is used to deactivate the trains emergency brakes
	 */
	public void deactivateEmergencyBrake(){

		emergencyBrake = false;
	}

	/**
	 * The following method is used to check if the emergency brake is be used on the train
	 */
	public boolean isEmergencyBrakeActive(){

		return emergencyBrake;
	}

	/**
	 * The following method is used to activate the trains service brakes. It also checks to see if the
	 * brake failure mode has been activated. If it finds the brake failure mode has been activated, it
	 * sets the service brake to off. This will prevent it from being activated which is what happens in
	 * real life.
	 */
	public void activateServiceBrake(){

		if (brakeFailure){

			serviceBrake = false;
		}

		else{

			serviceBrake = true;
		}
	}

	/**
	 * The following method is used to deactivate the trains service brakes
	 */
	public void deactivateServiceBrake(){

		serviceBrake = false;
	}

	/**
	 * The following method is used to check if the service brake has been activated
	 */
	public boolean isServiceBrakeActive(){

		return serviceBrake;
	}

	/*
	 * The following methods are used to set the right and left doors on the train
	 */

	/**
	 * The following method is used to open the doors on the left side of the train
	 */
	public void openLeftDoors(){

		leftDoors = true;
	}

	/**
	 * The following method is used to close the doors on the left side of the train
	 */
	public void closeLeftDoors(){

		leftDoors = false;
	}

	/**
	 * The following method is used to open the doors on the right side of the train
	 */
	public void openRightDoors(){

		rightDoors = true;
	}

	/**
	 * The following method is used to close the doors on the right side of the train
	 */
	public void closeRightDoors(){

		rightDoors = false;
	}

	/*
	 * The following methods are used to receive and pass data given by the CTC office / Track Model.
	 * They are also used to send data to the train controller class
	 */

	/**
	 * The following method is used to get the blockSpeedLimit from the track circuit
	 */
	public void setBlockSpeedLimit(double blockSpeedLimit){	

		if (signalPickupFailure){

			this.blockSpeedLimit = 0;	
		}

		else{

			this.blockSpeedLimit = blockSpeedLimit;	
		}
	}

	/**
	 * The following method is used to get the blockSpeedLimit
	 */
	public double getBlockSpeedLimit(){

		return blockSpeedLimit;
	}

	/**
	 * The following method sets the CTC advised speed by getting the data from the trackCircuit interface
	 */
	public void setCTCAdvisedSpeed(double CTCAdvisedSpeed){

		if (signalPickupFailure){	

			this.CTCAdvisedSpeed = 0;
		}

		else{

			this.CTCAdvisedSpeed = CTCAdvisedSpeed;
		}
	}

	/**
	 * The following method is used to get the advised speed given by the ctc office
	 */
	public double getCTCAdvisedSpeed(){

		return this.CTCAdvisedSpeed;
	}

	/**
	 * The following method is used to get the authority set by the track circuit interface.
	 * If a signal pickup failure is initiated the authority is set to 0
	 */
	public void setAuthority(double authority){

		if (signalPickupFailure){

			this.authority = 0;
		}

		else {

			this.authority = authority;
		}
	}

	/**
	 * The following method is used to get the authority
	 */
	public double getAuthority(){

		return authority;
	}

	/**
	 * The following method is used to get the grade from the track circuit interface
	 */
	public void setGrade(double grade){	

		this.grade = grade;
	}

	/**
	 * The following method is used to get the current speed
	 */
	public double getCurrentSpeed(){

		return currentSpeed;
	}
	
	public void setStation(String station){
		
		this.station = station;
	}
	
public String getStation(){
		
		return station;
	}

public void setTransponder(boolean transponder){
	
	this.transponder = transponder;
}

public boolean getTransponder(){
	
	return transponder;
}

public void setDirection(boolean direction){
	
	this.direction = direction;
}

public boolean getDirection(){
	
	return direction;
}

	/*
	 * The following methods are used to send information to the ctc office / track model
	 */

	/**
	 * The following methods are used to get the displacement
	 */
	public double getDisplacement(){

		return displacement;
	}		
}












package TrainModelControler;

import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("unused")
public class Controller {
		
	private final double	MPS_TO_MPH = 2.23694;		//Conversion ratio for meters per second to miles per hour
	
	//TRAIN INFO
	private	int			ID;
	private	int			mode;							//0 for automatic, 1 for manual
	
	//POWER CONTROL
	private	double		setSpeedLimit;
	private double transitSpeed;
	private	double		currentSpeed;
	private	double		blockSpeedLimit;
	private double		powerCommand;
	
	//BRAKING
	private	boolean		brakeStatus;					//true = on
	private	boolean		eBrakeStatus ;					//true = on
	private	boolean		manualBrake;					//true = manual braking
	private	boolean		manualEBrake;					//true = manual e-braking
	
	//SUBSYSTEMS
	public	boolean		leftDoorStatus;					//true = open
	public	boolean		rightDoorStatus;				//true = open
	
	//STATION INFO
	private	String		stationName;
	private	String		stationSide;					//"left" or "right"
	
	//ASSOCIATED CLASSES
	private	Train			model;
	private	TrainControllerUI	ui;
	private	VitalControl		vc;	
	

	
	public Controller(int newID, Train newTrainModel, TrainControllerUI newUI) {
		ID = newID;
		
		model = newTrainModel;
		model.setTrainController(this);
		ui = newUI;
		vc = new VitalControl(this);
		mode = 2;
	}
	
	public int getID() {
		return this.ID;
	}
	public void setTrainsitVelocity(double i)
	{
		transitSpeed= i;
	}
	
	public double getSetSpeedLimit() {
		System.out.println(mode);
		if (mode == 1)
	{
		if (model.getCTCAdvisedSpeed() > model.getBlockSpeedLimit())
	{
		setSpeedLimit = model.getBlockSpeedLimit();
	}
	else
	{
		setSpeedLimit = model.getCTCAdvisedSpeed();
	}
	}
	else if (mode == 2){
		setSpeedLimit = transitSpeed;
		
			
		}
	vc.setTargetVelocity(setSpeedLimit);
	return setSpeedLimit;
	}
	
	public double getBlockSpeedLimit() {
		return model.getBlockSpeedLimit();
	}
	
	public double getVelocityFeedback() {
		return model.getCurrentSpeed();
	}
	
	
	
	public double getPowerCommand() {
		return powerCommand;
	}
	
	//Switch between auto and manual modes
	public void setMode(int newMode) {
		mode = newMode;
		return;
	}
	
	
	
	
	
	
	
	//Get station info from the beacon and activate station approach mode
	public void setStationInfo(String newStationName, String newStationSide) {
		if(!stationName.equals(newStationName)) {
			stationName = newStationName;
			stationSide = newStationSide;
		}
		return;
	}
	
	
	
	//Call for vital power control only if the brakes aren't set and the train has authority
		private void controlPower() {
		//	if(!brakeStatus && !eBrakeStatus ) {	
			vc.vitalPower(model.getCurrentSpeed(), model.getCurrentSpeed(), model.getCurrentSpeed());
			//}
		}
		
		//Send the model its power command
		public void sendPower(double power) {
			powerCommand = power;
			model.setEnginePower(power);
			return;
	}
	
		public void tick() {		
			controlPower();
			return;
	}
	
	
	//===================
	//		BRAKING
	//===================
	
	public void stopTrain(boolean manual) {
		if(manual) {
			manualBrake = true;
		}
		sendPower(0);
		vc.resetPower();
		model.activateServiceBrake();
		brakeStatus = model.isServiceBrakeActive();
		return;
	}
	
	public void emergencyStop(boolean manual) {
		if(manual) {
			manualEBrake = true;
		}
		sendPower(0);
		vc.resetPower();
		model.activateEmergencyBrake();
		eBrakeStatus = model.isEmergencyBrakeActive();
		return;
	}
	
	public void releaseServiceBrakes(boolean manual) {
		if(manualBrake) {
			if(manual && brakeStatus) {
				model.deactivateServiceBrake();
				brakeStatus = model.isServiceBrakeActive();
				manualBrake = false;
			}
		}
		else if(brakeStatus) {
			model.deactivateServiceBrake();
			brakeStatus = model.isServiceBrakeActive();
		}
		return;
	}
		
	public void releaseEmergencyBrakes(boolean manual) {
		if(manualEBrake) {
			if(manual && eBrakeStatus) {
				model.deactivateEmergencyBrake();
				eBrakeStatus = model.isEmergencyBrakeActive();
				manualEBrake = false;
			}
		}
		else if(eBrakeStatus) {
			model.deactivateEmergencyBrake();
			eBrakeStatus = model.isEmergencyBrakeActive();
		}
		return;
	}
	
	public double getAuthority()
	{
		return model.getAuthority();
	}
	

	
	//===================
	//SUBSYSTEM CONTROL
	//===================
	public String getStation()
	{
		return model.getStation();
	}
	
	public void transponder()
	{
		if (model.getTransponder())
			{
			stopTrain(false);
			}
		if (currentSpeed ==0)
		{
			controlDoors();
		}
	}
	
	public void openLeftDoors()
	{
		leftDoorStatus = true;
		model.openLeftDoors();
	}
	
	public void closeLeftDoors()
	{
		leftDoorStatus = false;
		model.closeLeftDoors();
	}
	
	public void openRightDoors()
	{
		rightDoorStatus = true;
		model.openRightDoors();
	}
	
	public void closeRightDoors()
	{
		rightDoorStatus = true;
		model.closeRightDoors();
	}
	
	
	public void controlDoors() {
		if (mode == 2)
		{
		if (model.getDirection())
			{
				if(model.getCurrentSpeed() == 0) {
						model.openRightDoors();
						rightDoorStatus = true;
					}
				else
				{
					model.closeRightDoors();
					rightDoorStatus = false;
				}
			}
			else{
				if(model.getCurrentSpeed() ==0){
					
				model.openLeftDoors();
				leftDoorStatus = true;
				}
				else
				{
					model.closeLeftDoors();
					leftDoorStatus = false;
				}
			
			}
		}
	}
	
	
	public boolean getebrake()
	{
		return model.isEmergencyBrakeActive();
	}
	
	public boolean getsbrake()
	{
		return model.isServiceBrakeActive();
	}
	
	
	
	//Check if doors are open
	public boolean checkDoors() {
		return leftDoorStatus || rightDoorStatus;
	}
	
	
	
	
}

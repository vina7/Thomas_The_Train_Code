package TrainModelControler;

import java.util.concurrent.TimeUnit;

public class Train {

	private int setSpeed;
	
	//possible failures that could occur on the train.
	private boolean brakeFailure; //service brake fails. Prevents it from being engaged.
	private boolean signalPickupFailure; //Train can't pickup signals from track circuit. authority = 0 and setSpeed = 0
	private boolean engineFailure; //train engine fails. enginePower is set to 0.
	
	private double enginePower; //the power of the engine. cannot exceed 120 kW.
	double engineForce; //force exerted on the train by the engine.
	private double grade; //slope of the hill train is traveling on.
	double gravitationalForce; // force exerted on the train by gravity. This can be positive, negative, or non-existent depending on the grade.
	double rollingCoefficient = .001; //used in friction calculation.
	double frictionalForce; //force exerted on the train by friction. Increases as grade increases.
	private double trainForce; //net force exerted by train.
	
	
	private double displacement;  
	
	//Variables used in calculating net force and acceleration 
	private double trainMass = 40900; 
	double gravity = 9.8; 

	//Variables used in calculating acceleration
    private int blockSpeedLimit;
    private double currentSpeed;
	private boolean serviceBrake;
	private boolean emergencyBrake;
	private double previousCurrentSpeed;
	private double T=1; //sample period
	private double acceleration; 


	public Train() {
	}

	public void calculateTrainForce() {

		//Checks to make sure the force of the engine does not exceed the its maximum. If it does it sets it to maximum.
		if (enginePower/(currentSpeed) > 120000){

			engineForce = 120000; //N
		}
		else {
			engineForce = enginePower/((currentSpeed)); //N
		}

			frictionalForce = rollingCoefficient * (trainMass* gravity * Math.cos(Math.atan(grade/100))); //N
			gravitationalForce = trainMass * gravity * Math.sin(Math.atan(grade/100)); //N
			trainForce = engineForce - frictionalForce - gravitationalForce; //N
		
		//System.out.println("The net force exerted by the train is: "+trainForce);
	}

	public void calculateAcceleration(){

		//if emergency brake is active the following acceleration value will be used to calculate the speed.
		if (emergencyBrake){
			
			acceleration = -2.73; // m/s^2
		}
		//if service brake is active the following acceleration value will be used to calculate the speed.
		else if (serviceBrake){
			
			acceleration = -1.2; // m/s^2
		}
		//otherwise
		else {
			
			acceleration = trainForce/trainMass;
		}
		//System.out.println("The acceleration of the train is: "+acceleration);
	}
	
	public void calculateCurrentSpeed(){
		
		//takes previous current speed and adds acceleration * a sample period of time to get current speed.
		currentSpeed = previousCurrentSpeed + acceleration*T;
		previousCurrentSpeed = currentSpeed;
		//System.out.println("The current speed of the train is: "+currentSpeed);
	}
	
	public void calculateDisplacmnet(){
		
	displacement = currentSpeed * T;
	//System.out.println("The displacement of the train durign the time period of "+T+"seconds is: "+displacement);
	}
	
	public void setBlockSpeedLimit(int blockSpeedLimit)
	{
		this.blockSpeedLimit = blockSpeedLimit;
	}
	
	public int getBlockSpeedLimit(int blockSpeedLimit)
	{
		return blockSpeedLimit;
	}
	
	public void setSetSpeed(int setSpeed){
		
		this.setSpeed = setSpeed;
	}
	
	public int getSetSpeed(){
		
		return setSpeed;
	}
	
	public double getCurrentSpeed(){
		
		return currentSpeed;
	}
	
	public double getDisplacement(){
		
		return displacement;
	}
	
	public void setEnginePower(double enginePower) {
		
if (engineFailure){
			
			enginePower = 0;
		}
		else {
			this.enginePower = enginePower;	
		}
	}
	
	public double getEnginePower()
	{
		
		return enginePower;
	}
	

	private void calculateTrainSpeed() {
		// TODO Auto-generated method stub
		
	}	
	}


public class Train {

	private Brake serviceBrake;
	private Brake emergencyBrake;
	private Door leftSideDoors = new Door();
	private Door rightSideDoors = new Door();
    private Movement trainMovement = new Movement();
    private boolean brakeFailure;
   private boolean engineFailure;
    private boolean signalPickupFailure;
    private double grade;
    private double enginePower;
    private int currentSpeed;
    private double authority;
    private int blockSpeedlimit;
    private int setSpeed;
    private String approchingStation;
    private int trainID;
    
    /**
     * Initialize a stationary, full train with one car.
     */
    
    public Train(int trainID) {
    	serviceBrake = new Brake(1.2);
    	emergencyBrake = new Brake(2.73);
    	leftSideDoors = new Door();
    	rightSideDoors = new Door();
    	trainMovement = new Movement();
    	brakeFailure = false;
    	signalPickupFailure = false;
    	engineFailure = false;
    	this.trainID = trainID;
    }
 
  

    public void setEngineFailure(boolean fail) {
        engineFailure = fail;
    }

    public void setSignalPickupFailure(boolean fail) {
        signalPickupFailure = fail;
        setSpeed = 0;
        authority = 0;
    }

    public void setBrakeFailure(boolean fail) {

    	brakeFailure = fail;
    	serviceBrake.setBrakeStatus("fail");
    }
    
    public void setEnginePower(int enginePower) {
    	if (engineFailure)
        {
    	this.enginePower=0;
        }
        else
        {
        	this.enginePower=enginePower;
        }
    }
    
    public int getBlockSpeedLimit() {
        return blockSpeedlimit;
    }

    public double getAuthority() {
        return authority;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean setServiceBrakeStatus(boolean brakeStatus) {
  boolean fail;
    	if (brakeFailure)
    	{
    	fail = true; 
    	}
    	else
    	{
    		{
    	    	if (brakeStatus)
    	    	{
    	    		serviceBrake.setBrakeStatus("engaged");
    	    	}
    	    	else
    	    	{
    	    		serviceBrake.setBrakeStatus("Disengaged");
    	    	}
    	    	fail= false;
    	    	}
    }
    	return fail;
    
    }
    
    public String getServiceBrakeStatus() {
        return serviceBrake.getBrakeStatus();
    }

    public boolean setEmergencyBrakeStatus(boolean brakeStatus) {
    	if (brakeStatus)
    	{
    	emergencyBrake.setBrakeStatus("Engaged");
    	}
    	else
    	{
    		emergencyBrake.setBrakeStatus("Disengaged");
    	}
    	return true;
    }
    
    
    public String getEmergencyBrakeStatus() {
        return emergencyBrake.getBrakeStatus();
    }

    public boolean setLeftSideDoorsStatus(boolean doorStatus) {
    	if (doorStatus)
    	{
    	leftSideDoors.setDoorStatus("Open");
    	}
    	else
    	{
    		leftSideDoors.setDoorStatus("Close");
    	}
    	return true;
    }
    
    public String getLeftSideDoorsStatus() {
        return leftSideDoors.getDoorStatus();
    }
    
    public boolean setRightSideDoorsStatus(boolean doorStatus) {
    	if (doorStatus)
    	{
    	rightSideDoors.setDoorStatus("Open");
    	}
    	else
    	{
    		rightSideDoors.setDoorStatus("Close");
    	}
    	return true;
    }
    
    
    public String getRightSideDoorsStatus() {
        return rightSideDoors.getDoorStatus();
    }
}


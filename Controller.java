

public class Controller {
	//private final double PASS_WEIGHT = 68.0389; //150lbs
	//private final double TRAIN_WEIGHT = 37103.86; //40.9tons
	private final double MAX_POWER = 120000;

	private static boolean initialized = false;
	private Train trainInstance;
	private TrainControllerGui g;
	private double speed_limit = 0;
	private double authority = 0;

	private double prev_power = 0;
	private double prev_integral = 0;
	private double prev_error = 0;
	private double dt = 1;
	private int kp = -24000;
	private int ki = 1;

	public TrainController(Train trainInstance) {
		if(!initialized)
		{
			g = new TrainControllerGui();
			g.main(null);
			initialized = true;
		}

		this.trainInstance = trainInstance;
		g.addTrainController(this);
	}

	public double update(double set_speed, double authority, int clock)
	{
		this.dt = clock / 1000; //change from miliseconds to seconds
		this.speed_limit = set_speed;
		this.authority = authority;

		double current_speed = this.getSpeed();
		double stop_distance = current_speed*current_speed/(2*BRAKE_SPEED);
		if(stop_distance >= authority - 5)
		{
			this.setServiceBrake(true);
			prev_power = 0;
			return 0;
		}

		double error = current_speed - set_speed;

		double integral;
		if(prev_power < MAX_POWER)
			integral = prev_integral + dt/2 * (error + prev_error);
		else
			integral = prev_integral;


		double power = kp*error + ki*integral;
        double power1 = kp*error + ki*integral;
        
        if(power1 != power)
        {
            return 0;
        }
        
		prev_error = error;
		prev_integral = integral;
		prev_power = power;

		if(power > MAX_POWER)
			power = MAX_POWER;

		if(power <= 0)
		{
			power = 0;
			train.setServiceBrake(true);
		}
		else
		{
			train.setServiceBrake(false);
		}

		//System.out.println("Speed: " + current_speed + ", Acceleration: " + a + ", Power: " + power);
		return power;
	}

	public int getID()
	{
		return this.train.getID();
	}

	public boolean getLeftDoorStatus() {
		return !this.train.hasDoorsOpen();
	}

	public void setLeftDoor(boolean closed) {
		this.train.setDoorsOpen(!closed);
	}
	
	public boolean getRightDoorStatus() {
		return !this.train.hasDoorsOpen();
	}

	public void setRightDoor(boolean closed) {
		this.train.setDoorsOpen(!closed);


		public void setServiceBrakeStatus(boolean on) {
			this.train.setServiceBrake(on);
		}
	public void setServiceBrake(boolean on) {
		this.train.setServiceBrake(on);
	}

	public boolean getEmergencyBrakeStatus() {
		return this.train.isEmergencyBrakePulled();
	}

	public void setEmergencyBrake(boolean on) {
		this.train.setEmergencyBrake(on);
	}

	public void setSetSpeed(double speed) {
		this.speed_limit = speed;
	}

	public double getSetSpeedLimit() {
		return this.speed_limit;
	}

	public double getCurrentSpeed() {
		return this.train.getCurrentSpeed();
	}

	public double getAuthority() {
	    return this.authority;
	}

public String getStation()
return this.trainInstance.getStation;

	public void detectTrainEngineFailure(boolean failure) {
		this.train.setEngineFailure(failure);
	}

	public void detectSignalPickupFailure(boolean failure) {
		this.train.setSignalPickupFailure(failure);
	}

	public void detectBrakeFailure(boolean failure) {
		this.train.setBrakeFailure(failure);
	}

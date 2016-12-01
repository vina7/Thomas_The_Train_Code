
public class Movement implements Runnable {

	private Thread t;

	/* variables used to calculate net force exerted by the train*/
	private final double loadedWeight = 56700; /* kg*/
	private final double gravity = 9.8; /* m/s^2*/
	private final double staticFriction = .74;
	private final double kineticFriction = .57;
	private double gravitationalForce;
	private double frictionalForce;
	private double grade=.5;
	private double engineForce;
	private double enginePower=120000;

	/* variables used to calculate acceleration and deceleration if brake is pressed */
	private double deceleration;
	private double acceleration;
	private double trainForce;

	/* variables used to calculate current speed*/
	private double previousCurrentSpeed;
	private double currentSpeed;
	private double time=1;

	/* variables used to calculate displacement, time is also used here*/
	private double displacment;

	public Movement() {}

	public void setEnginePower(double enginePower)
	{
		this.enginePower = enginePower;
	}

	public void setGrade(double grade)
	{
		this.grade = grade;
	}

	public void setDecleration(double deceleration)
	{
		this.deceleration = deceleration;
	}
	public double getDisplacment()
	{
	return	displacment;
	}
	public double getTrainForce()
	{
	return	trainForce;
	}
	public double getCurrentSpeed()
	{
	return	currentSpeed;
	}
	public double getAcceleration()
	{
	return	acceleration;
	}

	public double calculateForce() {

		if (grade > 0){

			if (currentSpeed == 0){

				engineForce = 120000;
				frictionalForce = staticFriction*(loadedWeight * Math.cos(Math.atan(grade/100)));
				gravitationalForce = loadedWeight * Math.sin(Math.atan(grade/100));
				trainForce = engineForce - frictionalForce - gravitationalForce;
			}
			else if (currentSpeed > 0)
			{
				engineForce = enginePower/((currentSpeed));
				frictionalForce = kineticFriction*(loadedWeight * Math.cos(Math.atan(grade/100)));
				gravitationalForce = loadedWeight * Math.sin(Math.atan(grade/100));
				trainForce = engineForce - frictionalForce - gravitationalForce;
			}
			else
			{
				trainForce = 0;
			}
		}
		else if (grade < 0)
		{
			if (currentSpeed == 0)
			{
				trainForce =  .5*56700;
			}
			else if (currentSpeed > 0)
			{
				engineForce = enginePower/currentSpeed;
				frictionalForce = kineticFriction*(loadedWeight * Math.cos(Math.atan(grade/100)));
				gravitationalForce = loadedWeight * Math.sin(Math.atan(grade/100));
				trainForce = engineForce - frictionalForce + gravitationalForce;
			}
			else
			{
				trainForce = 0;
			}
		}
		else
		{
			if (currentSpeed == 0)
			{
				engineForce = 120000;
				frictionalForce = staticFriction*(loadedWeight);
				trainForce = engineForce - frictionalForce;
			}
			else if (currentSpeed > 0)
			{
				engineForce = enginePower/currentSpeed;
				frictionalForce = kineticFriction*(loadedWeight);
				trainForce = engineForce - frictionalForce;
			}
			else
			{
				trainForce = 0;
			}
		}
		return trainForce;
	}
	
	public void calculateAcceleration()
	{
		if (deceleration < 0){
			
			acceleration = deceleration;
		}

		else{
			
			acceleration = trainForce/(loadedWeight/gravity);
		}
	}
	
	public void calculateCurrentSpeed()
	{
		if (currentSpeed >= 0){
			
			currentSpeed = previousCurrentSpeed + acceleration*time;
			previousCurrentSpeed= currentSpeed;
		}
		else{
			
			currentSpeed=0;
			acceleration=0;
		}
	}
	public void calculateDisplacment()
	{
		displacment = currentSpeed*time;
	}

	public void run() {

	
			try {
				while (true)
				{
					calculateForce();
					calculateAcceleration();
					calculateCurrentSpeed();
					calculateDisplacment();
					System.out.println(engineForce);
					System.out.println(frictionalForce);
					System.out.println(gravitationalForce);
					System.out.println(trainForce);
					System.out.println(acceleration);
					System.out.println("");
				Thread.sleep(1000);
			}} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		

	

	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}




}


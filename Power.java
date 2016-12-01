
public class Power implements Runnable {

	private Thread t;
	private final double MAX_POWER = 120000;


	private double previousPower;
	private double integral;
	private double previousIntegral;
	private double previousError;
	private double error;
	private double dt = 1;
	private int currentSpeed=0;
	private int setSpeed=70;
	private int kp = -1714;
	private double ki = .00053;

	
	
	public void powerCalculator()
	{
		error = currentSpeed - setSpeed;
		if (previousPower < MAX_POWER)
	{
		integral = previousIntegral + dt/2 * (error + previousError);		
	}
	else
	{
			integral = previousIntegral;

	}


	double power = kp*error + ki*integral;


    
    
	previousError = error;
	previousIntegral = integral;
	previousPower = power;
	}


	
	public void run() {
		int i=0;
		while (i<10)
		{
			powerCalculator();
			System.out.println(previousPower);
			currentSpeed=currentSpeed+2;
			i++;
		} 

	}

	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}




}




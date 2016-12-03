
public class trainController {

	
	private final double maxpower = 120000;


	private double previousPower;
	private double uk;
	private double ukPrevious;
	private double ekPrevious;
	private double ek;
	private double T = 1;
	private double currentSpeed;
	private double setSpeed=19.44;
	private double powerCommand;
	private int kp = -1715;
	private double ki = -22.8808;
	

	public void setCurrentSpeed(double c)
	{
		currentSpeed=c;
	}
	
	public double getpower()
	{
		return powerCommand;
	}
	public void powerCalculator()
	{
		ek = currentSpeed - setSpeed;
		if (powerCommand < maxpower)
	{
		uk = ukPrevious+(T/2)*(ek+ekPrevious);
			}
	else
		uk = ukPrevious;
	{

	


	powerCommand = kp*ek + ki*uk;


    
    
	ekPrevious = ek;
	ukPrevious = uk;
	
	}


	
	System.out.println("The power command is: "+powerCommand);
	}
}




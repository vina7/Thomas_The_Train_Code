
public class Brake {

	private String brakeStatus;
	private double deceleration;
	
	public Brake(double deceleration)
	{
		brakeStatus = "Disengaged";
		this.deceleration = deceleration;
	}
	
	public void setBrakeStatus(String brakeStatus)
	{
			this.brakeStatus = brakeStatus;
	}
	
	
	public String getBrakeStatus()
	{
		return brakeStatus;
	}

	public double getBrakeDecel()
	{
		return deceleration;
	}
}


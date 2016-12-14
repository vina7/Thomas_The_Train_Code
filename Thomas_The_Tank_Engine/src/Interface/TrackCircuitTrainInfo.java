package Interface;

/**
 * The CTC, Train Module, Track Controller train object
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class TrackCircuitTrainInfo {
	private int ID;
	private boolean verifiedS;
	private boolean verifiedA;
	private double Grade;
	private double Displacement;
	private double displayDisplacement = 0;
	private int Speed;
	private int Authority;
	private String Line;
	private int CurBlock;
	private boolean reversedirection;

	/**
	 * Constructor
	 * 
	 * @param ID
	 *            Train's id
	 * @param Grade
	 *            Trains's grade
	 * @param Displacement
	 *            train's displacement
	 * @param Speed
	 *            train's speed
	 * @param Authority
	 *            train's authority
	 * @param Line
	 *            train's line
	 * @param CurBlock
	 *            train's current block
	 * @param reversedirection
	 *            train's direction
	 */
	public TrackCircuitTrainInfo(int ID, double Grade, double Displacement, int Speed, int Authority, String Line,
			int CurBlock, boolean reversedirection) {
		this.ID = ID;
		this.Grade = Grade;
		this.Displacement = Displacement;
		this.Speed = Speed;
		this.Authority = Authority;
		this.Line = Line;
		this.CurBlock = CurBlock;
		this.reversedirection = reversedirection;
	}

	/**
	 * Sets a train's current block
	 * 
	 * @param CurBlock
	 *            train's current block
	 */
	public void setCurBlock(int CurBlock) {
		this.CurBlock = CurBlock;
	}

	/**
	 * Returns the train's current block
	 * 
	 * @return CurBlock
	 */
	public int getCurBlock() {
		return CurBlock;
	}

	/**
	 * Returns a train's line
	 * 
	 * @return getLine
	 */
	public String getLine() {
		return Line;
	}

	/**
	 * Returns train's id
	 * 
	 * @return ID train's id
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets a train's grade
	 * 
	 * @param Grade
	 *            train's grade
	 */
	public void setGrade(double Grade) {
		this.Grade = Grade;
	}

	/**
	 * Returns the train's grade
	 * 
	 * @return Grade
	 */
	public double getGrade() {
		return Grade;
	}

	/**
	 * Adds to the train's displacement
	 * 
	 * @param Displacement
	 *            train's displacement
	 */
	public void addDisplacement(double Displacement) {
		this.displayDisplacement = Displacement;
		this.Displacement = this.Displacement + (Displacement * 3.3);
		System.out.println("DFssdf"+Displacement);
	}

	/**
	 * Gets the train's overall displacement since this function was called
	 * 
	 * @return DisplayDisplacement
	 */
	public double getDisplayDisplacement() {
		return displayDisplacement;
	}

	/**
	 * Gets the train's displacement
	 * 
	 * @return Displacement
	 */
	public double getDisplacement() {
		return Displacement;
	}

	/**
	 * Resets the train's displacement
	 */
	public void resetDisplacement() {
		Displacement = 0;
	}

	/**
	 * Sets the train's speed
	 * 
	 * @param Speed
	 *            train's speed
	 */
	public void setSpeed(int Speed) {
		this.Speed = Speed;
		verifiedS = false;
	}

	/**
	 * Gets the train's speed to verify
	 * 
	 * @return Speed
	 */
	public int getSpeedVerify() {
		return Speed;
	}

	/**
	 * Sets the train's verified speed
	 * 
	 * @param Speed
	 *            train's speed
	 */
	public void setVerifiedSpeed(int Speed) {
		this.Speed = Speed;
		verifiedS = true;
	}

	/**
	 * Gets the direction of the train
	 * 
	 * @return reversedirection
	 */
	public boolean getDirection() {
		return reversedirection;
	}

	/**
	 * Sets the direction the train is going in
	 * 
	 * @param reversedirection
	 *            the train's direction
	 */
	public void setDirection(boolean reversedirection) {
		this.reversedirection = reversedirection;
	}

	/**
	 * Gets the train's verified speed
	 */
	public int getSpeed() {
		if (verifiedS == true) {
			return Speed;
		}
		return -1;
	}

	/**
	 * Sets the train's authority
	 * 
	 * @param Authority
	 *            train's authority
	 */
	public void setAuthority(int Authority) {
		this.Authority = Authority;
		verifiedA = false;
	}

	/**
	 * Gets the train's authority to verify
	 * 
	 * @return this.Authority
	 */
	public int getAuthorityVerify() {
		return this.Authority;
	}

	/**
	 * Sets the train's verified authority
	 * 
	 * @param Authority
	 *            train's authority
	 */
	public void setVerifiedAuthority(int Authority) {
		this.Authority = Authority;
		verifiedA = true;
	}

	/**
	 * Gets the train's verified authority
	 * 
	 * @return Authority
	 */
	public int getAuthority() {
		if (verifiedA == true) {
			return Authority;
		}
		return -1;
	}
}

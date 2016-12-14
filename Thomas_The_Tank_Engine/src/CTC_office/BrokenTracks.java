package CTC_office;

/**
 * Stores the information of the broken rails.
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class BrokenTracks {
	private String Line;
	private int BlockNum;
	private int TimeToFixRail;
	private boolean Closed;
	private int ClosedTime;
	private boolean Broken;

	/**
	 * Constructor
	 * 
	 * @param Line
	 *            Track's line
	 * @param BlockNum
	 *            Track's block number
	 * @param TimeToFixRail
	 *            Time to fix the rail
	 * @param Closed
	 *            If the block is closed or not
	 * @param ClosedTime
	 *            The time the block was closed
	 * @param Broken
	 *            If the block is broken
	 */
	public BrokenTracks(String Line, int BlockNum, int TimeToFixRail, boolean Closed, int ClosedTime, boolean Broken) {
		this.Line = Line;
		this.BlockNum = BlockNum;
		this.TimeToFixRail = TimeToFixRail;
		this.Closed = Closed;
		this.ClosedTime = ClosedTime;
		this.Broken = Broken;
	}

	/**
	 * Sets the block closed
	 * 
	 * @param Closed
	 */
	public void setClosed(boolean Closed) {
		this.Closed = Closed;
	}

	/**
	 * Sets the time the block was closed
	 * 
	 * @param ClosedTime
	 */
	public void setClosedTime(int ClosedTime) {
		this.ClosedTime = ClosedTime;
	}

	/**
	 * Gets the track's line
	 * 
	 * @return Line
	 */
	public String getLine() {
		return Line;
	}

	/**
	 * Gets the block's number
	 * 
	 * @return BlockNum
	 */
	public int getBlockNum() {
		return BlockNum;
	}

	/**
	 * Gets the time to fix a rail
	 * 
	 * @return TimeToFixRail
	 */
	public int getTimeToFixRail() {
		return TimeToFixRail;
	}

	/**
	 * Gets the whether the rail was closed
	 * 
	 * @return Closed
	 */
	public boolean getClosed() {
		return Closed;
	}

	/**
	 * Gets the time the rail was closed
	 * 
	 * @return ClosedTime
	 */
	public int getClosedTime() {
		return ClosedTime;
	}

	/**
	 * Gets whether the rail is broken
	 * 
	 * @return Broken
	 */
	public boolean getBroken() {
		return Broken;
	}
}

package Interface;

/**
 * The CTC and Track Controller train objects
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class CTC_TC_Trains {
	private int ID;
	private int BlockSpeedLim;
	private String NextStation;
	private boolean transponder;
	private int Destination;

	/**
	 * Constructor
	 * 
	 * @param ID
	 *            Train's ID
	 * @param BlockSpeedLim
	 *            Train's Block Speed Limit
	 * @param NextStation
	 *            Train's Next Station
	 * @param transponder
	 *            If the train has hit a transponder
	 * @param Destination
	 *            Train's destination
	 */
	public CTC_TC_Trains(int ID, int BlockSpeedLim, String NextStation, boolean transponder, int Destination) {
		this.ID = ID;
		this.BlockSpeedLim = BlockSpeedLim;
		this.NextStation = NextStation;
		this.transponder = transponder;
		this.Destination = Destination;
	}

	/**
	 * Returns the Train's ID
	 * 
	 * @return ID Train ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the train's Block Speed Limit
	 * 
	 * @param BlockSpeedLim
	 *            The Block Speed Limit to set the train to
	 */
	public void setBlockSpeedLim(int BlockSpeedLim) {
		this.BlockSpeedLim = BlockSpeedLim;
	}

	/**
	 * Gets the train's Block Speed Limit
	 * 
	 * @return BlockSpeedLim The train's Block Speed Limit
	 */
	public int getBlockSpeedLim() {
		return BlockSpeedLim;
	}

	/**
	 * Set's the train's next station
	 * 
	 * @param NextStation
	 *            Next Station to set to
	 */
	public void setNextStation(String NextStation) {
		this.NextStation = NextStation;
	}

	/**
	 * Get's the train's next station
	 * 
	 * @return NextStation The train's Next Station
	 */
	public String getNextStation() {
		return NextStation;
	}

	/**
	 * Set's the train's next destination
	 * 
	 * @param BlockNum
	 *            Next Block to set to
	 */
	public void setNextDestination(int BlockNum) {
		this.Destination = BlockNum;
	}

	/**
	 * Get's the train's next destination
	 * 
	 * @return Destination The train's destination
	 */
	public int getNextDestination() {
		return Destination;
	}

	/**
	 * Set's whether the train has past the transponder
	 * 
	 * @param transponder
	 *            The value to set the transponder value to
	 */
	public void setTransponder(boolean transponder) {
		this.transponder = transponder;
	}

	/**
	 * Get's the whether the train has past the transponder
	 * 
	 * @return temp The transponder value
	 */
	public boolean getTransponder() {
		boolean temp = this.transponder;
		this.transponder = false;
		return temp;
	}

}

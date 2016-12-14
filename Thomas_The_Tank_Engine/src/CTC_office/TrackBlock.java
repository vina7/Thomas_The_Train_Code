package CTC_office;

/**
 * Stores the information of the system's track block
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class TrackBlock {
	String Line;
	String Section;
	int BlockNum;
	int BlockLen;
	double BlockGrade;
	double SpeedLimit;
	String Infrastructure;
	double Elevation;
	double CumElevation;
	String SwitchBlock;
	String ArrowDirection;
	String SwitchPosition;
	boolean Closed;
	int ClosedTime;
	boolean Broken;
	String RailroadCross;
	int TimeToFixRail;

	/**
	 * Constructor
	 * 
	 * @param Line
	 *            block's line
	 * @param Section
	 *            block's section
	 * @param BlockNum
	 *            block's block number
	 * @param BlockLen
	 *            block's length
	 * @param BlockGrade
	 *            block's grade
	 * @param SpeedLimit
	 *            block's speed limit
	 * @param Infrastructure
	 *            block's infrastructure
	 * @param Elevation
	 *            block's elevation
	 * @param CumElevation
	 *            block's cumulative elevation
	 * @param SwitchBlock
	 *            if the block is a switch block
	 * @param ArrowDirection
	 *            block's arrow direction
	 * @param SwitchPosition
	 *            block's switch position
	 * @param Closed
	 *            if the block is closed
	 * @param ClosedTime
	 *            time block was closed
	 * @param Broken
	 *            if the block is broken
	 * @param RailroadCross
	 *            if the block is a railroad crossing
	 * @param TimeToFixRail
	 *            time to fix the block
	 */
	public TrackBlock(String Line, String Section, int BlockNum, int BlockLen, double BlockGrade, double SpeedLimit,
			String Infrastructure, double Elevation, double CumElevation, String SwitchBlock, String ArrowDirection,
			String SwitchPosition, boolean Closed, int ClosedTime, boolean Broken, String RailroadCross,
			int TimeToFixRail) {
		this.Line = Line;
		this.Section = Section;
		this.BlockNum = BlockNum;
		this.BlockLen = BlockLen;
		this.BlockGrade = BlockGrade;
		this.SpeedLimit = SpeedLimit;
		this.Infrastructure = Infrastructure;
		this.Elevation = Elevation;
		this.CumElevation = CumElevation;
		this.SwitchBlock = SwitchBlock;
		this.ArrowDirection = ArrowDirection;
		this.SwitchPosition = SwitchPosition;
		this.Closed = Closed;
		this.ClosedTime = ClosedTime;
		this.Broken = Broken;
		this.RailroadCross = RailroadCross;
		this.TimeToFixRail = TimeToFixRail;
	}

	/**
	 * Gets the line
	 * 
	 * @return Line
	 */
	public String getLine() {
		return Line;
	}

	/**
	 * Gets the block's section
	 * 
	 * @return block's section
	 */
	public String getSection() {
		return Section;
	}

	/**
	 * Gets the station's block number
	 * 
	 * @return Block number
	 */
	public int getBlockNum() {
		return BlockNum;
	}

	/**
	 * Gets the block's length
	 * 
	 * @return block length
	 */
	public int getBlockLen() {
		return BlockLen;
	}

	/**
	 * Get the block's grade
	 * 
	 * @return block grade
	 */
	public double getBlockGrade() {
		return BlockGrade;
	}

	/**
	 * Get the train's Speed Limit
	 * 
	 * @return speed limit
	 */
	public double getSpeedLimit() {
		return SpeedLimit;
	}

	/**
	 * Gets the block's infrastructure
	 * 
	 * @return Infrastructure
	 */
	public String getInfrastructure() {
		return Infrastructure;
	}

	/**
	 * Gets the block elevation
	 * 
	 * @return elevation
	 */
	public double getElevation() {
		return Elevation;
	}

	/**
	 * Gets the cumulative elevation
	 * 
	 * @return cumulative elevation
	 */
	public double getCumElevation() {
		return CumElevation;
	}

	/**
	 * Gets the block switch block
	 * 
	 * @return switch blocks
	 */
	public String getSwitchBlock() {
		return SwitchBlock;
	}

	/**
	 * Get the block's arrow direction
	 * 
	 * @return arrow direction
	 */
	public String getArrowDirection() {
		return ArrowDirection;
	}

	/**
	 * Gets the block switch position
	 * 
	 * @return switch position
	 */
	public String getSwitchPosition() {
		return SwitchPosition;
	}

	/**
	 * Gets whether the block is closed
	 * 
	 * @return Closed
	 */
	public boolean getClosed() {
		return Closed;
	}

	/**
	 * gets the time the block was closed
	 * 
	 * @return closed time
	 */
	public int getClosedTime() {
		return ClosedTime;
	}

	/**
	 * Gets whether the block is broken
	 * 
	 * @return broken
	 */
	public boolean getBroken() {
		return Broken;
	}

	/**
	 * Gets whether the block is a railroad crossing
	 * 
	 * @return Railroadcroess
	 */
	public String getRailroadCross() {
		return RailroadCross;
	}

	/**
	 * gets time to fix a broken rail
	 * 
	 * @return time to fix broken rails
	 */
	public int getTimeToFixRail() {
		return TimeToFixRail;
	}

	/**
	 * Sets the track's line
	 * 
	 * @param Line
	 */
	public void setLine(String Line) {
		this.Line = Line;
	}

	/**
	 * Sets the track's section
	 * 
	 * @param Section
	 */
	public void setSection(String Section) {
		this.Section = Section;
	}

	/**
	 * sets the block's number
	 * 
	 * @param BlockNum
	 */
	public void setBlockNum(int BlockNum) {
		this.BlockNum = BlockNum;
	}

	/**
	 * sets the block length
	 * 
	 * @param BlockLen
	 */
	public void setBlockLen(int BlockLen) {
		this.BlockLen = BlockLen;
	}

	/**
	 * sets the block grade
	 * 
	 * @param BlockGrade
	 */
	public void setBlockGrade(double BlockGrade) {
		this.BlockGrade = BlockGrade;
	}

	/**
	 * sets the blocks speed limit
	 * 
	 * @param SpeedLimit
	 */
	public void setSpeedLimit(double SpeedLimit) {
		this.SpeedLimit = SpeedLimit;
	}

	/**
	 * Sets the block's infrastructure
	 * 
	 * @param Infrastructure
	 */
	public void setInfrastructure(String Infrastructure) {
		this.Infrastructure = Infrastructure;
	}

	/**
	 * sets the block's elevation
	 * 
	 * @param Elevation
	 */
	public void setElevation(double Elevation) {
		this.Elevation = Elevation;
	}

	/**
	 * sets the block's cumulative elevation
	 * 
	 * @param CumElevation
	 */
	public void setCumElevation(double CumElevation) {
		this.CumElevation = CumElevation;
	}

	/**
	 * sets the switch block
	 * 
	 * @param SwitchBlock
	 */
	public void setSwitchBlock(String SwitchBlock) {
		this.SwitchBlock = SwitchBlock;
	}

	/**
	 * sets the block's arrow direction
	 * 
	 * @param ArrowDirection
	 */
	public void setArrowDirection(String ArrowDirection) {
		this.ArrowDirection = ArrowDirection;
	}

	/**
	 * Sets the blocks switch position
	 * 
	 * @param SwitchPosition
	 *            block's switch position
	 */
	public void setSwitchPosition(String SwitchPosition) {
		this.SwitchPosition = SwitchPosition;
	}

	/**
	 * Sets if the track is closed
	 * 
	 * @param Closed
	 *            if track is closed
	 */
	public void setClosed(boolean Closed) {
		this.Closed = Closed;
	}

	/**
	 * Sets the block's closed time
	 * 
	 * @param ClosedTime
	 *            block's closed time
	 */
	public void setClosedTime(int ClosedTime) {
		this.ClosedTime = ClosedTime;
	}

	/**
	 * Set is the block is broken
	 * 
	 * @param Broken
	 *            if the block is broken
	 */
	public void setBroken(boolean Broken) {
		this.Broken = Broken;
	}

	/**
	 * Sets the track railroad crossing locations
	 * 
	 * @param RailroadCross
	 */
	public void setRailroadCross(String RailroadCross) {
		this.RailroadCross = RailroadCross;
	}

	/**
	 * Sets time to fix broken rails
	 * 
	 * @param TimeToFixRail
	 *            block's time to fix
	 */
	public void setTimeToFixRail(int TimeToFixRail) {
		this.TimeToFixRail = TimeToFixRail;
	}
}

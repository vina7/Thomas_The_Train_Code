package CTC_office;
import java.awt.Color;
import java.util.List;

/**
 * The system's train
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class Trains {
	private Color color;
	private int ID;
	private int Speed;
	private int Authority;
	private String Direction;
	private String PrevSection;
	private String Section;
	private int BlockNum;
	private int BlockLen;
	private double BlockGrade;
	private int BlockSpeedLim;
	private double Elevation;
	private boolean Retire;
	private String Station;
	private String Status;
	private int DestBlock;
	private List <ScheduleInfo> TrainSchedule;
	private boolean UserSetSpeed;
	private boolean UserSetDest;
	private boolean UserSetAuth;
	private int DisplaySpeed;
	private int StationNum;
	/**
	   * Constructor 
	   * @param color Train's color
	   * @param ID Train's ID
	   * @param Speed Train's speed
	   * @param Authority Train's authority
	   * @param Direction Train's direction
	   * @param PrevSection Train's previous section
	   * @param Section Train's section
	   * @param BlockNum Train's block number
	   * @param BlockLen Train's block length
	   * @param BlockGrade Train's block grade
	   * @param BlockSpeedLim Train's block speed limit
	   * @param Elevation Train's elevation
	   * @param Retire Train's retire status
	   * @param Status Train's status
	   * @param Station Train's section
	   * @param DestBlock Train's destination block
	   * @param TrainSchedule Train's schedule
	   * @param UserSetSpeed User set the speed
	   * @param UserSetDest User set the destination 
	   * @param DisplaySpeed Train's display speed
	   * @param StationNum Train's station number
	   */
	public Trains(Color color, int ID, int Speed, int Authority,String Direction,String PrevSection, String Section, 
			int BlockNum, int BlockLen, double BlockGrade,int BlockSpeedLim, double Elevation, 
			boolean Retire, String Status, String Station, int DestBlock, List <ScheduleInfo> TrainSchedule, 
			boolean UserSetSpeed, boolean UserSetDest, int DisplaySpeed, int StationNum){
		this.color= color;
		this.ID=ID;
		this.Status = Status;
		this.Speed =Speed;
		this.Authority=Authority;
		this.Direction= Direction;
		this.Section=Section;
		this.PrevSection = PrevSection;
		this.BlockNum =BlockNum;
		this.BlockLen = BlockLen;
		this.BlockGrade = BlockGrade;
		this.BlockSpeedLim = BlockSpeedLim;
		this.Elevation = Elevation;
		this.Retire =Retire;
		this.Station = Station;
		this.DestBlock = DestBlock;
		this.TrainSchedule = TrainSchedule;
		this.UserSetSpeed = UserSetSpeed;
		this.UserSetDest = UserSetDest;
		this.DisplaySpeed = DisplaySpeed;
		this.StationNum = StationNum;
	}
	  /**
	   * Gets trains color
	   * @return Color
	   */
	public Color getColor(){
       return color;
	}
	/**
	 * Gets train's id
	 * @return ID
	 */
	public int getID(){
		return ID;
	}
	  /**
	   * Get Train's status
	   * @return Status
	   */
	public String getStatus(){
		return Status;
	}
	/**
	 * Gets the train's display speed
	 * @return Display Speed
	 */
	public int getDisplaySpeed(){
		return DisplaySpeed;
	}
	/**
	 * Gets train's speed
	 * @return Speed
	 */
	public int getSpeed(){
		return Speed;
	}
	/**
	 * Gets the train's authority 
	 * @return Authority 
	 */
	public int getAuthority(){
		return Authority;
	}
	/**
	 * Get the train's direction 
	 * @return direction
	 */
	public String getDirection(){
		return Direction;
	}
	/**
	 * Get train's previous section
	 * @return previous section
	 */
	public String getPrevSection(){
		return PrevSection;
	}
	/**
	 * Gets train's section
	 * @return section
	 */
	public String getSection(){
		return Section;
	}
	/**
	 * Gets the train's block number
	 * @return train's block number
	 */
	public int getBlockNum(){
		return BlockNum;
	}
	/**
	 * Gets the train current block's length
	 * @return Block Length
	 */
	public int getBlockLen(){
		return BlockLen;
	}
	/**
	 * Gets the train's block grade
	 * @return block grade
	 */
	public double getBlockGrade(){
		return BlockGrade;
	}
	/**
	 * Gets the blocks speed limit
	 * @return Speed Limit
	 */
	public int getBlockSpeedLim(){
		return BlockSpeedLim;
	}
	/**
	 * Gets train's elevation
	 * @return Elevation
	 */
	public double getElevation(){
		return Elevation;
	}
	/**
	 * Get train's retired status 
	 * @return retire
	 */
	public boolean getRetire(){
		return Retire;
	}
	/**
	 * Gets the train's station
	 * @return Station
	 */
	public String getStation(){
		return Station;
	}
	/**
	 * Get train's station number 
	 * @return station number 
	 */
	public int getStationNum(){
		return StationNum;
	}
	/**
	 * Sets the train's status
	 * @param Status Train's status 
	 * @param Line Train's line
	 */
	public void setStatus(String Status){
		this.Status= Status;
	}
	/**
	 * Get the train's destination block  
	 * @return destination block
	 */
	public int getDestBlock(){
		return DestBlock;
	}
	/**
	 * Gets the train schedule
	 * @return Train schedule
	 */
	public List <ScheduleInfo> getTrainSchedule(){
		return TrainSchedule;
	}
	/**
	 * Get if the user set the speed
	 * @return User set speed
	 */
	public boolean getUserSetSpeed(){
		return UserSetSpeed;
	}
	/**
	 * Get if the user set the authority 
	 * @return User set Authority 
	 */
	public boolean getUserSetAth(){
		return UserSetAuth;
	}
	/**
	 * Get if the user set the destination 
	 * @return User set destination
	 */
	public boolean getUserSetDest(){
		return UserSetDest;
	}
	/**
	 * Set the train's speed
	 * @param Speed Train's speed
	 */
	public void setSpeed(int Speed){
		this.Speed= Speed;
	}
	/**
	 * Set the display speed
	 * @param DisplaySpeed Train's display speed
	 */
	public void setDisplaySpeed(int DisplaySpeed){
		this.DisplaySpeed= DisplaySpeed;
	}
	/**
	 * Set the train's authority
	 * @param Authority Train's authority
	 */
	public void setAuthority(int Authority){
		this.Authority=Authority;
	}
	/**
	 * Set the train's direction
	 * @param Direction Train's direction
	 */
	public void setDirection(String Direction){
		this.Direction=Direction;
	}
	/**
	 * Set train's previous section
	 * @param PrevSection Train's previous section
	 */
	public void setPrevSection(String PrevSection){
		this.PrevSection=PrevSection;
	}
	/**
	 * Set the train section 
	 * @param Section Train's section
	 */
	public void setSection(String Section){
		this.Section=Section;
	}
	/**
	 * Set the train's block number
	 * @param BlockNum Train's block number
	 */
	public void setBlockNum(int BlockNum){
		this.BlockNum = BlockNum;
	}
	/**
	 * Set the train's block length
	 * @param BlockLen Train's block length
	 */
	public void setBlockLen(int BlockLen){
		this.BlockLen= BlockLen;
	}
	/**
	 * Set the train's block grade
	 * @param BlockGrade Train's block grade
	 */
	public void setBlockGrade(double BlockGrade){
		this.BlockGrade= BlockGrade;
	}
	/**
	 * Set the train's block speed limit
	 * @param BlockSpeedLim Train's block speed limit
	 */
	public void setBlockSpeedLim(int BlockSpeedLim){
		this.BlockSpeedLim= BlockSpeedLim;
	}
	/**
	 * Set the train's elevation
	 * @param Elevation Train's elevation
	 */
	public void setElevation(double Elevation){
		this.Elevation = Elevation;
	}
	/**
	 * Set if the train is retired 
	 * @param Retire Train's retire status
	 */
	public void setRetire(boolean Retire){
		this.Retire= Retire;
	}
	/**
	 * Set the train's station
	 * @param Station Train's station
	 */
	public void setStation(String Station){
		this.Station= Station;
	}
	 /**
     * Sets the train's station number
     * @param StationNum Train's station number
     */
	public void setStationNum(int StationNum){
		this.StationNum = StationNum;
	}
	/**
	 * Sets the train's destination block 
	 * @param DestBlock Train's destination block
	 */
	public void setDestBlock(int DestBlock){
		this.DestBlock = DestBlock;
	}
	/**
	 * Sets the train's schedule
	 * @param TrainSchedule train's schedule
	 */
	public void setTrainSchedule(List <ScheduleInfo> TrainSchedule){
		this.TrainSchedule= TrainSchedule;
	}
	/**
	 * Sets if the user set the speed
	 * @param UserSetSpeed Train's UserSetSpeed
	 */
	public void setUserSetSpeed(boolean UserSetSpeed){
		this.UserSetSpeed= UserSetSpeed;
	}
	/**
	 * Sets if the user set the authority 
	 * @param UserSetAuth Train's UseSetAuth
	 */
	public void setUserSetAth(boolean UserSetAuth){
		this.UserSetAuth=UserSetAuth;
	}
	/**
	 * Sets if the user set the train's destination
	 * @param UserSetDest train's UserSetDest
	 */
	public void setUserSetDest(boolean UserSetDest){
		this.UserSetDest= UserSetDest;
	}
}

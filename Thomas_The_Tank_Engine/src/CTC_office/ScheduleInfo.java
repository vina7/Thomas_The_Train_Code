package CTC_office;

/**
 * Stores the schedule's information
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class ScheduleInfo {
  String Line;
  String Station;
  double Time;
  int BlockNum;
  /**
   * Constructor
   * @param Line track line
   * @param Station Station
   * @param Time Time at station
   * @param BlockNum Station's block number 
   */
  public ScheduleInfo(String Line, String Station,double Time, int BlockNum){
	  this.Line= Line;
	  this.Station =Station;
	  this.Time = Time;
	  this.BlockNum = BlockNum;
  }
  /**
   * get the schedule's line
   * @return Line
   */
  public String getLine(){
	  return Line;
  }
  /**
   * Get the scheduled station
   * @return Station
   */
  public String getStation(){
	  return Station;
  }
  /**
   * Get the scheduled block number
   * @return block number
   */
  public int getBlockNum(){
	  return BlockNum;
  }
  /**
   * Get the scheduled time at the station
   * @return Time
   */
  public double Time(){
	  return Time;
  }
  /**
   * Set the scheduled station
   * @param Station 
   */
  public void setStation(String Station){
	  this.Station = Station;
  }
  /**
   * Set the schedule's line
   * @param Line
   */
  public void setLine(String Line){
	  this.Line =Line;
  }
  /**
   * set the scheduled time at the station
   * @param Time
   */
  public void setTime(double Time){
	  this.Time= Time;
  }
}

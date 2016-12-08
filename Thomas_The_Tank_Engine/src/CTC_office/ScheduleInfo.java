package CTC_office;

public class ScheduleInfo {
  String Line;
  String Station;
  double Time;
  int BlockNum;
  public ScheduleInfo(String Line, String Station,double Time, int BlockNum){
	  this.Line= Line;
	  this.Station =Station;
	  this.Time = Time;
	  this.BlockNum = BlockNum;
  }
  public String getLine(){
	  return Line;
  }
  public String getStation(){
	  return Station;
  }
  public int getBlockNum(){
	  return BlockNum;
  }
  public double Time(){
	  return Time;
  }
  public void setStation(String Station){
	  this.Station = Station;
  }
  public void setLine(String Line){
	  this.Line =Line;
  }
  public void setTime(double Time){
	  this.Time= Time;
  }
}

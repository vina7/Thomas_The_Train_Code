package CTC_Office_Track_Model;

import java.awt.Color;
import java.util.List;

public class TrainInfo {
  
  private Color color;
  private int ID;
  private int Speed;
  private int Authority;
  private String Direction;
  private String Section;
  private int BlockNum;
  private int BlockLen;
  private double BlockGrade;
  private int BlockSpeedLim;
  private double Elevation;
  private boolean Retire;
  private String LastStation;
  private String Status;
  private int DestBlock = 0;
  private List<ScheduleInfo> TrainSchedule;
  
  
  public TrainInfo( Color color, int ID, int Speed, int Authority, String Direction,
      String Section, int BlockNum, int BlockLen, double BlockGrade,
      int BlockSpeedLim, double Elevation, boolean Retire, String Status, String LastStation, List<ScheduleInfo> TrainSchedule){
// add block destination 
    this.color=color;
    this.ID= ID;
    this.Speed=Speed;
    this.Authority=Authority;
    this.Direction = Direction;
    this.Section=Section;
    this.BlockNum=BlockNum;
    this.BlockLen=BlockLen;
    this.BlockGrade=BlockGrade;
    this.BlockSpeedLim=BlockSpeedLim;
    this.Elevation=Elevation;
    this.Retire = Retire;
    this.Status = Status;
    this.LastStation = LastStation; //last past station not last visited
    this.TrainSchedule = TrainSchedule;
  }
  public List<ScheduleInfo> getSchedule(){
    return TrainSchedule;
  }
  public void setSchedule(List<ScheduleInfo> TrainSchedule){
    this.TrainSchedule = TrainSchedule;
  }
  public Color getColor(){
    return color;
  }
  public int getId(){
    return ID;
  }
  public int getDestBlock(){
    return DestBlock;
  }
  public void setDestBlock(int DestBlock){
    this.DestBlock = DestBlock; 
  }
  public void setSpeed(int Speed){
    this.Speed =Speed;
  }
  public int getSpeed(){
    return Speed;
  }
  public void setAuthority(int Authority){
    this.Authority =Authority;
  }
  public int getAuthority(){
    return Authority;
  }
  public void setDirection(String Direction){
    this.Direction =Direction;
  }
  public String getDirection(){
    return Direction;
  }
  public void setSection(String Section){
    this.Section =Section;
  }
  public String getSection(){
    return Section;
  }
  public void setBlockNum(int BlockNum){
    this.BlockNum = BlockNum;
  }
  public int getBlockNum(){
    return BlockNum;
  }
  public void setBlockLen(int BlockLen){
    this.BlockLen =BlockLen;
  }
  public int getBlockLen(){
    return BlockLen;
  }
  public void setBlockGrade(double BlockGrade){
    this.BlockGrade =BlockGrade;
  }
  public double getBlockGrade(){
    return BlockGrade;
  }

  public void setBlockSpeedLim(int BlockSpeedLim){
    this.BlockSpeedLim =BlockSpeedLim;
  }
  public int getBlockSpeedLim(){
    return BlockSpeedLim;
  }
  public void setElevation(double Elevation){
    this.Elevation =Elevation;
  }
  public double getElevation(){
    return Elevation;
  }
  public void setRetire(boolean Retire){
    this.Retire = Retire;
  }
  public boolean getRetire(){
    return Retire;
  }
  public void setStatus(String Status){
    this.Status =Status;
  }
  public String getStatus(){
    return Status;
  }
  public void setLastStation(String LastStation){
    this.LastStation =LastStation;
  }
  public String getLastStation(){
    return LastStation;
  }
}

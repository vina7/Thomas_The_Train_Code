package CTC_office;

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
  public TrackBlock(String Line,String Section, int BlockNum, int BlockLen, double BlockGrade,
		  double SpeedLimit, String Infrastructure, double Elevation, double CumElevation, String SwitchBlock,
		  String ArrowDirection, String SwitchPosition, boolean Closed, int ClosedTime, boolean Broken, String RailroadCross,
		  int TimeToFixRail){
	  this.Line=Line;
	  this.Section=Section;
	  this.BlockNum=BlockNum;
	  this.BlockLen=BlockLen;
	  this.BlockGrade=BlockGrade;
	  this.SpeedLimit=SpeedLimit;
	  this.Infrastructure=Infrastructure;
	  this.Elevation=Elevation;
	  this.CumElevation=CumElevation;
	  this.SwitchBlock=SwitchBlock;
	  this.ArrowDirection=ArrowDirection;
	  this.SwitchPosition=SwitchPosition;
	  this.Closed=Closed;
	  this.ClosedTime=ClosedTime;
	  this.Broken=Broken;
	  this.RailroadCross=RailroadCross;
	  this.TimeToFixRail=TimeToFixRail;
  }
  public String getLine(){
	  return Line;
  }
  public String getSection(){
	  return Section;
  }
  public int getBlockNum(){
	  return BlockNum;
  }
  public int getBlockLen(){
	  return BlockLen;
  }
  public double getBlockGrade(){
	  return BlockGrade;
  }
  public double getSpeedLimit(){
	  return SpeedLimit;
  }
  public String getInfrastructure(){
	  return Infrastructure;
  }
  public double getElevation(){
	  return Elevation;
  }
  public double getCumElevation(){
	  return CumElevation;
  }
  public String getSwitchBlock(){
	  return SwitchBlock;
  }
  public String getArrowDirection(){
	  return ArrowDirection;
  }
  public String getSwitchPosition(){
	  return SwitchPosition;
  }
  public boolean getClosed(){
	  return Closed;
  }
  public int getClosedTime(){
	  return ClosedTime;
  }
  public boolean getBroken(){
	  return Broken;
  }
  public String getRailroadCross(){
	  return RailroadCross;
  }
  public int getTimeToFixRail(){
	  return TimeToFixRail;
  }
  public void setLine( String Line){
	  this.Line=Line;
  }
  public void setSection(String Section){
	  this.Section=Section;
  }
  public void setBlockNum(int BlockNum){
	  this.BlockNum=BlockNum;
  }
  public void setBlockLen(int BlockLen){
	  this.BlockLen=BlockLen;
  }
  public  void  setBlockGrade(double BlockGrade){
	  this.BlockGrade=BlockGrade;
  }
  public  void  setSpeedLimit( double SpeedLimit){
	  this.SpeedLimit=SpeedLimit;
  }
  public  void  setInfrastructure(String Infrastructure){
	 this.Infrastructure=Infrastructure;
  }
  public  void  setElevation(double Elevation){
	   this.Elevation=Elevation;
  }
  public  void  setCumElevation(double CumElevation){
	  this.CumElevation=CumElevation;
  }
  public  void  setSwitchBlock(String SwitchBlock){
	  this.SwitchBlock=SwitchBlock;
  }
  public  void setArrowDirection(String ArrowDirection){
	 this.ArrowDirection=ArrowDirection;
  }
  public  void  setSwitchPosition( String SwitchPosition){
	  this.SwitchPosition=SwitchPosition;
  }
  public  void  setClosed(boolean Closed){
	   this.Closed= Closed;
  }
  public void  setClosedTime(int ClosedTime){
	   this.ClosedTime=ClosedTime;
  }
  public void setBroken(boolean Broken){
	   this.Broken=Broken;
  }
  public  void  setRailroadCross(String RailroadCross){
	   this.RailroadCross=RailroadCross;
  }
  public  void  setTimeToFixRail(int TimeToFixRail){
	  this.TimeToFixRail=TimeToFixRail;
  }
}

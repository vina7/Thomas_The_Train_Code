package Interface;

public class TrackCircuitTrainInfo {
  private int ID;
  private boolean verifiedS;
  private boolean verifiedA;
  private double Grade;
  private double Displacement;
  private int Speed;
  private int Authority;
  private String Line;
  private int CurBlock;
  public TrackCircuitTrainInfo(int ID, double Grade, double Displacement, int Speed, int Authority, String Line, int CurBlock){
	  this.ID= ID;
	  this.Grade= Grade;
	  this.Displacement=Displacement;
	  this.Speed = Speed;
	  this.Authority = Authority;
	  this.Line = Line;
	  this.CurBlock = CurBlock;
  }
  public void setCurBlock(int CurBlock){
		this.CurBlock = CurBlock;
	  }
	  public int getCurBlock(){
		  return CurBlock;
	  }
  public String getLine(){
	  return Line;
  }
  public int getID(){
	  return ID;
  }
  public void setGrade(double Grade){
	  this.Grade = Grade;
  }
  public double getGrade(){
	  return Grade;
  }
  public void addDisplacement(double Displacement){
	  this.Displacement = this.Displacement +Displacement;
  }
  public double getDisplacement(){
	  return Displacement;
  }
  public void resetDisplacement(){
	  Displacement =0;
  }
  public void setSpeed(int Speed){
	  this.Speed =Speed;
	  verifiedS =false;
  }
  public int getSpeedVerify(){
	  return Speed;
  }
  public void setVerifiedSpeed(int Speed){
	  this.Speed =Speed;
	  verifiedS = true;
  }
  public int getSpeed(){
	  if (verifiedS == true){
		return Speed;  
	  } 
	  return -1;
  }
  public void setAuthority(int Authority){
	  this.Authority =Authority;
	  verifiedA =false;
  }
  public int getAuthorityVerify(){
	  return Authority;
  }
  public void setVerifiedAuthority(int Authority){
	  this.Authority =Authority;
	  verifiedA = true;
  }
  public int getAuthority(){
	  if (verifiedA == true){
		return Authority;  
	  } 
	  return -1;
  }
}

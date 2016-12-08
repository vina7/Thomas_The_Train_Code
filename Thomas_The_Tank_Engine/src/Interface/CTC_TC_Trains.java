package Interface;

public class CTC_TC_Trains {
  private int ID;
  private int BlockSpeedLim;
  private String NextStation;
  private boolean transponder;
  private int Destination;
  public CTC_TC_Trains(int ID, int BlockSpeedLim, String NextStation, boolean transponder, int Destination){
	  this.ID = ID;
	  this.BlockSpeedLim= BlockSpeedLim;
	  this.NextStation=NextStation;
	  this.transponder= transponder;
	  this.Destination= Destination;
  }
  public int getID(){
	  return ID;
  }
  public void setBlockSpeedLim(int BlockSpeedLim){
	  this.BlockSpeedLim= BlockSpeedLim;
  }
  public int getBlockSpeedLim(){
	  return BlockSpeedLim;
  }
  public void setNextStation(String NextStation){
	  this.NextStation= NextStation;
  }
  public String getNextStation(){
	  return NextStation;
  }
  public void setNextDestination(int BlockNum){
	  this.Destination= BlockNum;
  }
  public int getNextDestination(){
	  return Destination;
  }
  public void setTransponder(boolean transponder){
	  this.transponder = transponder;
  }
  public boolean getTransponder(){
	  boolean temp = this.transponder;
	  this.transponder =false;
	  return temp;
  }
  
}

package Interface;

public class CTC_TC_Trains {
  private int ID;
  private int BlockSpeedLim;
  private String NextStation;
  private boolean transponder;
  public CTC_TC_Trains(int ID, int BlockSpeedLim, String NextStation, boolean transponder){
	  this.ID = ID;
	  this.BlockSpeedLim= BlockSpeedLim;
	  this.NextStation=NextStation;
	  this.transponder= transponder;
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
  public void setTransponder(boolean transponder){
	  this.transponder = transponder;
  }
  public boolean getTransponder(){
	  boolean temp = transponder;
	  transponder =false;
	  return temp;
  }
  
}

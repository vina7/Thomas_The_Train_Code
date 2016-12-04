package CTC_office;

public class VerifyManualMode {
  boolean ManualMode;
  public VerifyManualMode(){
	  ManualMode =false;
  }
  public void updateManualMode(boolean ManualMode){
	  this.ManualMode = ManualMode;
  }
  public boolean verify(){
	  return ManualMode;
  }
}

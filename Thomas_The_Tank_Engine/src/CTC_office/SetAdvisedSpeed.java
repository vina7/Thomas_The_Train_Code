package CTC_office;

public class SetAdvisedSpeed {
  public SetAdvisedSpeed(){
	  
  }
  public AllTrains setSpeed(AllTrains train,int ID, int Speed, VerifyManualMode mode){
	  if(mode.verify()){
		  train.setSpeed(Speed, ID, train.getTrainSchedule(ID).get(0).getLine());
	  }
	  return train;
  }
}

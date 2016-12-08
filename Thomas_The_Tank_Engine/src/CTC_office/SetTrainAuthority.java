package CTC_office;

public class SetTrainAuthority {
	 public SetTrainAuthority (){
		  
	  }
	  public AllTrains setAuthority(AllTrains train,int ID, int Authority , VerifyManualMode mode){
		  if(mode.verify()){
			  train.setAuthority(Authority, ID, train.getTrainSchedule(ID).get(0).getLine());
			  train.setUserSetAth(true, ID, train.getTrainSchedule(ID).get(0).getLine());
		  }
		  return train;
	  }
}

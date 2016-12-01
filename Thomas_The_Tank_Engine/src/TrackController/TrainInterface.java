package TrackController;

import java.util.ArrayList;


public class TrainInterface {
	
	ArrayList<TrainMessage> messages;
	
	public TrainInterface(){
		messages = new ArrayList<TrainMessage>();
	}

	

	private static TrainInterface instance =null;	

	public static TrainInterface getInstance(){
		  if(instance == null){
			  instance= new TrainInterface();
		  }
		  return instance;
	 }
	
	
	public void addTrainMessage(int id, String nextstation, boolean transponder){
		messages.add(new TrainMessage(id, nextstation, transponder));
	}
	
	
}

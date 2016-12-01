package TrackController;

public class TrainMessage {
	
	int trainID;
	String nextStation;
	boolean transponder;
	
	public TrainMessage(int trainIDin, String nextStationin, boolean transponderin){
		trainID = trainIDin;
		nextStation = nextStationin;
		transponder = transponderin;
	}
	

}

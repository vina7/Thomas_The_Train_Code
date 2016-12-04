package Interface;

import java.util.ArrayList;

public class CTCandTrackControllerInterface {
	private static CTCandTrackControllerInterface instance =null;
	boolean DebugMode;
	ArrayList <CTC_TC_Trains>  activetrains;
	protected CTCandTrackControllerInterface(boolean DebugMode){
		  activetrains =new ArrayList<CTC_TC_Trains>();
		  this.DebugMode=DebugMode;
	  }
	public static CTCandTrackControllerInterface getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new CTCandTrackControllerInterface(DebugMode);
		  }
		  return instance;
	  }
	public void makeNewTrain(int ID, int BlockSpeedLim, String NextStation, boolean transponder, int Destination){
		CTC_TC_Trains newtrain = new CTC_TC_Trains(ID, BlockSpeedLim, NextStation, transponder, Destination);
		activetrains.add(newtrain);
		System.out.println("gother");
	}
	public void setBlockSpeedLim(int ID,int BlockSpeedLim){
		  CTC_TC_Trains temp = activetrains.get(ID);
	       	temp.setBlockSpeedLim(BlockSpeedLim);
	  }
	  public int getBlockSpeedLim(int ID){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  return temp.getBlockSpeedLim();
	  }
	  public void setNextDestination(int ID, int BlockNum){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  temp.setNextDestination(BlockNum);
	  }
	  public int getNextDestination(int ID){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  return temp.getNextDestination();
	  }
	  public void setNextStation(int ID, String NextStation){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  temp.setNextStation(NextStation);
	  }
	  public String getNextStation(int ID){
		  System.out.println(activetrains.size());
		  CTC_TC_Trains temp = activetrains.get(ID);
		  
		  return temp.getNextStation();
	  }
	  public void setTransponder(int ID, boolean transponder){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  temp.setTransponder(transponder);
	  }
	  public boolean getTransponder(int ID){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  return temp.getTransponder();
	  }
}

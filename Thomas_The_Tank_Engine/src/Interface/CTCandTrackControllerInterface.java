package Interface;

import java.util.ArrayList;
/**
 * The CTC and Track Controller Interface
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class CTCandTrackControllerInterface {
	private static CTCandTrackControllerInterface instance =null;
	boolean DebugMode;
	ArrayList <CTC_TC_Trains>  activetrains;
	/**
	 * Constructor
	 * @param DebugMode Used to debug the system
	 */
	protected CTCandTrackControllerInterface(boolean DebugMode){
		  activetrains =new ArrayList<CTC_TC_Trains>();
		  this.DebugMode=DebugMode;
	  }
	/**
	 * Creates a singleton of the class
	 * @param DebugMode Used to debug the system
	 * @return Instance Returns the instance of the class
	 */
	public static CTCandTrackControllerInterface getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new CTCandTrackControllerInterface(DebugMode);
		  }
		  return instance;
	  }
	/**
	 * Adds a new train object to activetrains list
	 * @param ID Train's ID
	 * @param BlockSpeedLim Train's Block Speed Limit
	 * @param NextStation Train's Next Station
	 * @param transponder Whether the train past the transponder
	 * @param Destination Train's destination
	 */
	public void makeNewTrain(int ID, int BlockSpeedLim, String NextStation, boolean transponder, int Destination){
		CTC_TC_Trains newtrain = new CTC_TC_Trains(ID, BlockSpeedLim, NextStation, transponder, Destination);
		activetrains.add(newtrain);
	}
	/**
	 * Sets the train's Block Speed Limit
	 * @param ID Train's ID
	 * @param BlockSpeedLim Train's Block Speed Limit
	 */
	public void setBlockSpeedLim(int ID,int BlockSpeedLim){
		  CTC_TC_Trains temp = activetrains.get(ID);
	       	temp.setBlockSpeedLim(BlockSpeedLim);
	  }
	 /**
	  * Gets the train's Block Speed Limit
	  * @param ID
	  * @return BlockSpeedLim The train's Block Speed Limit
	  */
	  public int getBlockSpeedLim(int ID){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  return temp.getBlockSpeedLim();
	  }
	  /**
	   * Set's the train's next destination
	   * @param ID Train's ID
	   * @param BlockNum Next Block to set to
	   */
	  public void setNextDestination(int ID, int BlockNum){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  temp.setNextDestination(BlockNum);
	  }
	  /**
	   * Get's the train's next destination
	   * @param ID Train's ID
	   * @return Destination The train's destination
	   */
	  public int getNextDestination(int ID){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  return temp.getNextDestination();
	  }
	  /**
	   * Set's the train's next station
	   * @param ID Train's ID
	   * @param NextStation Next Station to set to
	   */
	  public void setNextStation(int ID, String NextStation){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  temp.setNextStation(NextStation);
	  }
	  /**
	   * Get's the train's next station
	   * @param ID Train's ID
	   * @return NextStation The train's Next Station 
	   */
	  public String getNextStation(int ID){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  
		  return temp.getNextStation();
	  }
	  /**
	   * Set's whether the train has past the transponder
	   * @param ID Train's ID
	   * @param transponder The value to set the transponder value to 
	   */
	  public void setTransponder(int ID, boolean transponder){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  temp.setTransponder(transponder);
	  }
	  /**
	   * Get's the whether the train has past the transponder
	   * @param ID Train's ID
	   * @return temp The transponder value
	   */
	  public boolean getTransponder(int ID){
		  CTC_TC_Trains temp = activetrains.get(ID);
		  return temp.getTransponder();
	  }
}

package Interface;

import java.util.ArrayList;

/**
 * The CTC, Train Module, Track Controller Interface
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class TrackCircuit {
	private static TrackCircuit instance =null;
	boolean DebugMode;
	ArrayList <TrackCircuitTrainInfo>  activetrains;
	/**
	 * Constructor
	 * @param DebugMode Used to debug the system
	 */
	protected TrackCircuit(boolean DebugMode){
		  activetrains =new ArrayList<TrackCircuitTrainInfo>();
		  this.DebugMode=DebugMode;
	  }
	/**
	 * Creates a singleton of the class
	 * @param DebugMode Used to debug the system
	 * @return Instance Returns the instance of the class
	 */
	public static TrackCircuit getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new TrackCircuit(DebugMode);
		  }
		  return instance;
	  }
	/**
	 * Makes a new train to add to the interface
	 * @param ID Train's id
	 * @param Grade Trains's grade 
	 * @param Displacement train's displacement
	 * @param Speed train's speed
	 * @param Authority train's authority 
	 * @param Line train's line
	 * @param CurBlock train's current block
	 * @param reversedirection train's direction
	 */
	public void makeNewTrain(int ID, double Grade, double Displacement, int Speed, int Authority, String Line, int CurBlock, boolean reversedirection){
		TrackCircuitTrainInfo newtrain = new TrackCircuitTrainInfo(ID,Grade, Displacement, Speed, Authority, Line, CurBlock, reversedirection);
		activetrains.add(newtrain);
	}
	/**
	 * Sets a train's current block
	 * @param CurBlock train's current block 
	 * @param ID train's id
	 */
	public void setCurBlock(int CurBlock, int ID){
		TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setCurBlock(CurBlock);
	  }
	/**
	 * Returns the train's current block
	 * @param ID train's id
	 * @return temp.getCurBlock()
	 */
	  public int getCurBlock(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getCurBlock();
	  }
	  /**
	   * Returns the trains that are in the interface
	   * @return
	   */
	public ArrayList <TrackCircuitTrainInfo> getActiveTrains(){
		return activetrains;
	}
	/**
	 * Returns a train's line
	 * @param ID train's id
	 * @return temp.getLine();
	 */
	public String getLine(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getLine();
	  }
	/**
	 * Sets a train's grade
	 * @param Grade train's grade 
	 * @param ID train's id
	 */
	public void setGrade(double Grade, int ID){
		TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setGrade(Grade);  
	  }
	/**
	 * Returns the train's grade
	 * @param ID train's id
	 * @return temp.getGrade();
	 */
	  public double getGrade(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getGrade();
	  }
	  /**
	   * Sets the direction the train is going in
	   * @param reversedirection the train's direction
	   * @param ID the train's id
	   */
	  public void setDirection(boolean reversedirection,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setDirection(reversedirection);
	  }
	  /**
	   * Gets the direction of the train
	   * @param ID the train's id
	   * @return temp.getDirection()
	   */
	  public boolean getDirection(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getDirection();
	  }
	  /**
	   * Adds to the train's displacement
	   * @param Displacement train's displacement
	   * @param ID train's id
	   */
	  public void addDisplacement(double Displacement,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.addDisplacement(Displacement);
	  }
	  /**
	   * Gets the train's overall displacement since this function was called
	   * @param ID train's id
	   * @return temp.getDisplayDisplacement()
	   */
	  public double getDisplayDisplacement(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getDisplayDisplacement();
	  }
	  /**
	   * Gets the train's displacement
	   * @param ID train's id
	   * @return temp.getDisplayDisplacement()
	   */
	  public double getDisplacement(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getDisplacement();
	  }
	  /**
	   * Sets the train's speed
	   * @param Speed train's speed
	   * @param ID train's id
	   */
	  public void setSpeed(int Speed,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setSpeed(Speed);
	  }
	  /**
	   * Gets the train's speed to verify
	   * @param ID train's id
	   * @return temp.getSpeedVerify()
	   */
	  public int getSpeedVerify(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getSpeedVerify();
	  }
	  /**
	   * Sets the train's verified speed
	   * @param Speed train's speed
	   * @param ID train's id
	   */
	  public void setVerifiedSpeed(int Speed,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setVerifiedSpeed(Speed);
	  }
	  /**
	   * Gets the train's verified speed
	   * @param ID train's id
	   */
	  public int getSpeed(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getSpeed();
	  }
	  /**
	   * Sets the train's authority
	   * @param Authority train's authority
	   * @param ID train's id
	   */
	  public void setAuthority(int Authority,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setAuthority(Authority);
	  }
	  /**
	   * Gets the train's authority to verify
	   * @param ID train's id
	   * @return temp.getAuthorityVerify()
	   */
	  public int getAuthorityVerify(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getAuthorityVerify();
	  }
	  /**
	   * Sets the train's verified authority
	   * @param Authority train's authority
	   * @param ID train's id
	   */
	  public void setVerifiedAuthority(int Authority,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setVerifiedAuthority(Authority);
	  }
	  /**
	   * Gets the train's verified authority 
	   * @param ID train's id
	   * @return temp.getAuthority()
	   */
	  public int getAuthority(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getAuthority();
	  }
	
}

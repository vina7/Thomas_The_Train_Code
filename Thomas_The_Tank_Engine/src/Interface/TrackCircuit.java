package Interface;

import java.util.ArrayList;

public class TrackCircuit {
	private static TrackCircuit instance =null;
	boolean DebugMode;
	ArrayList <TrackCircuitTrainInfo>  activetrains;
	protected TrackCircuit(boolean DebugMode){
		  activetrains =new ArrayList<TrackCircuitTrainInfo>();
		  this.DebugMode=DebugMode;
	  }
	public static TrackCircuit getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new TrackCircuit(DebugMode);
		  }
		  return instance;
	  }
	public void makeNewTrain(int ID, double Grade, double Displacement, int Speed, int Authority, String Line, int CurBlock){
		TrackCircuitTrainInfo newtrain = new TrackCircuitTrainInfo(ID,Grade, Displacement, Speed, Authority, Line, CurBlock);
		activetrains.add(newtrain);
	}
	public void setCurBlock(int CurBlock, int ID){
		TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setCurBlock(CurBlock);
	  }
	  public int getCurBlock(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getCurBlock();
	  }
	public ArrayList <TrackCircuitTrainInfo> getActiveTrains(){
		return activetrains;
	}
	public String getLine(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getLine();
	  }
	public void setGrade(double Grade, int ID){
		TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setGrade(Grade);  
	  }
	  public double getGrade(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getGrade();
	  }
	  public void addDisplacement(double Displacement,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.addDisplacement(Displacement);
	  }
	  public double getDisplayDisplacement(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getDisplayDisplacement();
	  }
	  public double getDisplacement(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getDisplacement();
	  }
	  public void setSpeed(int Speed,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setSpeed(Speed);
	  }
	  public int getSpeedVerify(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getSpeedVerify();
	  }
	  public void setVerifiedSpeed(int Speed,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setVerifiedSpeed(Speed);
	  }
	  public int getSpeed(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getSpeed();
	  }
	  public void setAuthority(int Authority,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setAuthority(Authority);
	  }
	  public int getAuthorityVerify(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getAuthority();
	  }
	  public void setVerifiedAuthority(int Authority,int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  temp.setVerifiedAuthority(Authority);
	  }
	  public int getAuthority(int ID){
		  TrackCircuitTrainInfo temp = activetrains.get(ID);
		  return temp.getAuthority();
	  }
	
}

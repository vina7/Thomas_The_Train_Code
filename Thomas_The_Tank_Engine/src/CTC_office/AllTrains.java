package CTC_office;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class AllTrains {
  private static AllTrains instance =null;
  ArrayList <Trains> GreenTrain;
  ArrayList <Trains> RedTrain;
  boolean DebugMode;
  protected AllTrains(){
	  this.GreenTrain = new ArrayList <Trains>();
	  this.RedTrain = new ArrayList <Trains>();
  }
  public ArrayList <Trains> getGreenTrain(){
	  return GreenTrain;
  }
  public ArrayList <Trains> getRedTrain(){
	  return RedTrain;
  }
  public static AllTrains getInstance(){
	  if(instance == null){
		  instance= new AllTrains();
	  }
	  return instance;
  }
  public void addTrain(Color color, int ID, int Speed, int Authority,String Direction, String Section, 
			int BlockNum, int BlockLen, double BlockGrade,int BlockSpeedLim, double Elevation, 
			boolean Retire, String Status, String LastStation, int DestBlock, List <ScheduleInfo> TrainSchedule, 
			boolean UserSetSpeed, boolean UserSetDest){
	       if(TrainSchedule.get(0).getLine()=="Green"){
	    	   Trains newTrain =new Trains(color, ID, Speed, Authority, Direction,  Section, 
	    				BlockNum,  BlockLen,  BlockGrade, BlockSpeedLim, Elevation, 
	    				 Retire,  Status,  LastStation,  DestBlock, TrainSchedule, 
	    				UserSetSpeed,  UserSetDest);
	    	   GreenTrain.add(newTrain);
	    	   
	       } else if (TrainSchedule.get(0).getLine()=="Red"){
	    	   Trains newTrain =new Trains(color, ID, Speed, Authority, Direction,  Section, 
	    				BlockNum,  BlockLen,  BlockGrade, BlockSpeedLim, Elevation, 
	    				 Retire,  Status,  LastStation,  DestBlock, TrainSchedule, 
	    				UserSetSpeed,  UserSetDest);
	    	   RedTrain.add(newTrain);
	       }
	  
  }
  public Color getColor(int ID, String Line){
	  Trains temp;
	  if (Line =="Green"){
		  for(int i =0; i<GreenTrain.size(); i++){
			  temp = GreenTrain.get(i);
			  if(temp.getID()==ID){
				  return temp.getColor();
			  }
		  }
	  } else if(Line=="Red"){
		  for(int i =0; i<RedTrain.size(); i++){
			  temp = RedTrain.get(i);
			  if(temp.getID()==ID){
				  return temp.getColor();
			  }
		  }
	  }
	  return null;
      
	}
	public String getStatus(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getStatus();
				  }
			  }
		  } else {
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getStatus();
				  }
			  }
		  }
		  return null;
		
	}
	public int getSpeed(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getSpeed();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getSpeed();
				  }
			  }
		  }
		return -1;
	}
	public int getAuthority(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getAuthority();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getAuthority();
				  }
			  }
		  }
		return -1;
	}
	public String getDirection(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getDirection();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getDirection();
				  }
			  }
		  }
		
		return null;
	}
	public String getSection(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getSection();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getSection();
				  }
			  }
		  }
		  return null;
	}
	public int getBlockNum(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getBlockNum();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getBlockNum();
				  }
			  }
		  }
		  return -1;
	}
	public int getBlockLen(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getBlockLen();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getBlockLen();
				  }
			  }
		  }
		  return -1;
	}
	public double getBlockGrade(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getBlockGrade();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getBlockGrade();
				  }
			  }
		  }
		return -1;
	}
	public int getBlockSpeedLim(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getBlockSpeedLim();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getBlockSpeedLim();
				  }
			  }
		  }
		return -1;
	}
	public double getElevation(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getElevation();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getElevation();
				  }
			  }
		  }
		return -1;
	}
	public boolean getRetire(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getRetire();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getRetire();
				  }
			  }
		  }
		return true;
	}
	public String getLastStation(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getLastStation();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getLastStation();
				  }
			  }
		  }
		return null;
	}
	public void setStatus(String Status, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setStatus(Status);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setStatus(Status);
				  }
			  }
		  }
	}
	public int getDestBlock(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getDestBlock();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getDestBlock();
				  }
			  }
		  }
		return -1;
	}
	public List <ScheduleInfo> getTrainSchedule(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getTrainSchedule();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getTrainSchedule();
				  }
			  }
		  }
		return null;
	}
	public boolean getUserSetSpeed(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getUserSetSpeed();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getUserSetSpeed();
				  }
			  }
		  }
		return false;
	}
	public boolean getUserSetDest(int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getUserSetDest();
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  return temp.getUserSetDest();
				  }
			  }
		  }
		return false;
	}
	public void setSpeed(int Speed, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setSpeed(Speed);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setSpeed(Speed);
				  }
			  }
		  }
	}
	public void setAuthority(int Authority, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setAuthority(Authority);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setAuthority(Authority);
				  }
			  }
		  }
	}
	public void setDirection(String Direction, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setDirection(Direction);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setDirection(Direction);
				  }
			  }
		  }
	}
	public void setSection(String Section, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setSection(Section);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setSection(Section);
				  }
			  }
		  }
	}
	public void setBlockNum(int BlockNum, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setBlockNum(BlockNum);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setBlockNum(BlockNum);
				  }
			  }
		  }
	}
	public void setBlockLen(int BlockLen, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setBlockLen(BlockLen);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setBlockLen(BlockLen);
				  }
			  }
		  }
	}
	public void setBlockGrade(double BlockGrade, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setBlockGrade(BlockGrade);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setBlockGrade(BlockGrade);
				  }
			  }
		  }
	}
	public void setBlockSpeedLim(int BlockSpeedLim, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setBlockSpeedLim(BlockSpeedLim);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setBlockSpeedLim(BlockSpeedLim);
				  }
			  }
		  }
	}
	public void setElevation(double Elevation, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setElevation(Elevation);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setElevation(Elevation);
				  }
			  }
		  }
	}
	public void setRetire(boolean Retire, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setRetire(Retire);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setRetire(Retire);
				  }
			  }
		  }
	}
	public void setLastStation(String LastStation, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setLastStation(LastStation);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setLastStation(LastStation);
				  }
			  }
		  }
	}
	public void setDestBlock(int DestBlock, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setDestBlock(DestBlock);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setDestBlock(DestBlock);
				  }
			  }
		  }
	}
	public void setTrainSchedule(List <ScheduleInfo> TrainSchedule, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setTrainSchedule(TrainSchedule);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setTrainSchedule(TrainSchedule);
				  }
			  }
		  }
	}
	public void setUserSetSpeed(boolean UserSetSpeed, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setUserSetSpeed(UserSetSpeed);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setUserSetSpeed(UserSetSpeed);
				  }
			  }
		  }
	}
	public void setUserSetDest(boolean UserSetDest, int ID, String Line){
		Trains temp;
		  if (Line =="Green"){
			  for(int i =0; i<GreenTrain.size(); i++){
				  temp = GreenTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setUserSetDest(UserSetDest);
				  }
			  }
		  } else if(Line=="Red"){
			  for(int i =0; i<RedTrain.size(); i++){
				  temp = RedTrain.get(i);
				  if(temp.getID()==ID){
					  temp.setUserSetDest(UserSetDest);
				  }
			  }
		  }
	}
}

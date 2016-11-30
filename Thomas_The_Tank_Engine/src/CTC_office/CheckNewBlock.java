package CTC_office;

import java.util.ArrayList;

import Interface.TrackCircuit;

public class CheckNewBlock {
  public CheckNewBlock(){
	  
  }
  public AllTrains  check(TrackCircuit circuit,int ID, AllTrains train, AllTrackBlock Blocks){
	  if(circuit.getDisplacement(ID)>= train.getBlockLen(ID, train.getTrainSchedule(ID).get(0).getLine())){
		  ArrayList <TrackBlock> Track = null;
		  if (train.getTrainSchedule(ID).get(0).getLine()=="Green"){
		    Track = Blocks.getGreenTrack();
		  } else if (train.getTrainSchedule(ID).get(0).getLine()=="Red"){
			  Track = Blocks.getRedTrack();
		  }
		  for(int i=0; i<Track.size(); i++){
			  if(Track.get(i).getBlockNum()==train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())){
				  if(Track.get(i).getInfrastructure().equals("SWITCH")){
					  for(int p=0; p<Track.size(); p++){
						  if (Track.get(p).getSwitchBlock().equals(Track.get(i).getSwitchBlock()) && Track.get(p).getSection().equals(Track.get(i).getSwitchPosition())){
							  train.setBlockNum(Track.get(p).getBlockNum(), ID, train.getTrainSchedule(ID).get(0).getLine());
							  train.setBlockGrade(Track.get(p).getBlockGrade(), ID, train.getTrainSchedule(ID).get(0).getLine());
							  train.setBlockLen(Track.get(p).getBlockLen(), ID, train.getTrainSchedule(ID).get(0).getLine());
							  train.setElevation(Track.get(p).getElevation(), ID, train.getTrainSchedule(ID).get(0).getLine());
							  train.setSection(Track.get(p).getSection(), ID, train.getTrainSchedule(ID).get(0).getLine());
							  train.setBlockSpeedLim((int)Track.get(p).getSpeedLimit(), ID, train.getTrainSchedule(ID).get(0).getLine());
							  train.setDirection(Track.get(p).getArrowDirection(), ID, train.getTrainSchedule(ID).get(p).getLine());
							  train.setSpeed((int) (Track.get(p).getSpeedLimit()/1.61), ID, train.getTrainSchedule(ID).get(0).getLine());
							  train.setAuthority((int) ((((((Track.get(p).getSpeedLimit())*.27)/1.2)/3600)*Track.get(p).getSpeedLimit())*3280.84), ID, train.getTrainSchedule(ID).get(0).getLine());
							  break;
						  }
					  }
					  break;
				  } else {
					int t= i+1;
					if(t>=Track.size()){
						train.setBlockNum(Track.get(0).getBlockNum(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setBlockGrade(Track.get(0).getBlockGrade(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setBlockLen(Track.get(0).getBlockLen(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setElevation(Track.get(0).getElevation(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setSection(Track.get(0).getSection(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setBlockSpeedLim((int)Track.get(0).getSpeedLimit(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setDirection(Track.get(0).getArrowDirection(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setSpeed((int) (Track.get(0).getSpeedLimit()/1.61), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setAuthority((int) ((((((Track.get(0).getSpeedLimit())*.27)/1.2)/3600)*Track.get(0).getSpeedLimit())*3280.84), ID, train.getTrainSchedule(ID).get(0).getLine());
					} else {
						train.setBlockNum(Track.get(t).getBlockNum(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setBlockGrade(Track.get(t).getBlockGrade(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setBlockLen(Track.get(t).getBlockLen(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setElevation(Track.get(t).getElevation(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setSection(Track.get(t).getSection(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setBlockSpeedLim((int)Track.get(t).getSpeedLimit(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setDirection(Track.get(t).getArrowDirection(), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setSpeed((int) (Track.get(t).getSpeedLimit()/1.61), ID, train.getTrainSchedule(ID).get(0).getLine());
						  train.setAuthority((int) ((((((Track.get(t).getSpeedLimit())*.27)/1.2)/3600)*Track.get(t).getSpeedLimit())*3280.84), ID, train.getTrainSchedule(ID).get(0).getLine());
					}
					break;
				  }
					  
			  }
		  }
	  }
	  return train;
  }
}

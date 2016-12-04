package CTC_office;

import java.util.ArrayList;

import Interface.Route;
import Interface.TrackCircuit;

public class CheckNewBlock {
  public CheckNewBlock(){
	  
  }
  public AllTrains  check(TrackCircuit circuit,int ID, AllTrains train, AllTrackBlock Blocks, CTCMapUI map){
	  Route ourroute = new Route();
	  if(circuit.getDisplacement(ID)>= train.getBlockLen(ID, train.getTrainSchedule(ID).get(0).getLine())){
		  ArrayList <TrackBlock> Track = null;
		  if (train.getTrainSchedule(ID).get(0).getLine().equals("Green")){

		    Track = Blocks.getGreenTrack();
		    int curEntry = ourroute.getGreenEntryBlock(train.getPrevSection(ID, "Green"),train.getSection(ID, "Green") );
		    int curExit = ourroute.getGreenExitBlock(train.getPrevSection(ID, "Green"),train.getSection(ID, "Green") );
		    boolean direction = ourroute.getGreendirect(train.getPrevSection(ID, "Green"),train.getSection(ID, "Green") );
		    String NextSection = ourroute.getNextGreen(train.getPrevSection(ID, "Green"),train.getSection(ID, "Green") );
		    if(train.getBlockNum(ID, "Green") == curExit ){	    
		    	train.setBlockNum(ourroute.getGreenEntryBlock(train.getSection(ID, "Green"), NextSection), ID, "Green");
		    	train.setPrevSection(train.getSection(ID, "Green"), ID, "Green");
		    	train.setSection(NextSection, ID, "Green");
		    	map.updateColor(train.getSection(ID, "Green"),train.getPrevSection(ID, "Green"), "Green", train.getColor(ID,"Green"));
		    	
		    } else {
		    	if(direction){
	
		    		train.setBlockNum(train.getBlockNum(ID, "Green")-1, ID, "Green");
		    	} else {
		
		    		train.setBlockNum(train.getBlockNum(ID, "Green")+1, ID, "Green");
		    	}
		    }
		    
		  } else if (train.getTrainSchedule(ID).get(0).getLine().equals("Red")){
			  Track = Blocks.getRedTrack();
			    int curEntry = ourroute.getRedEntryBlock(train.getPrevSection(ID, "Red"),train.getSection(ID, "Red") );
			    int curExit = ourroute.getRedExitBlock(train.getPrevSection(ID, "Red"),train.getSection(ID, "Red") );
			    boolean direction = ourroute.getReddirect(train.getPrevSection(ID, "Red"),train.getSection(ID, "Red") );
			    String NextSection = ourroute.getNextRed(train.getPrevSection(ID, "Red"),train.getSection(ID, "Red") );
			    if(train.getBlockNum(ID, "Red") == curExit ){
			    	train.setBlockNum(ourroute.getRedEntryBlock(train.getSection(ID, "Red"), NextSection), ID, "Red");
			    	train.setPrevSection(train.getSection(ID, "Red"), ID, "Red");
					train.setSection(NextSection, ID, "Red");
			    	map.updateColor(train.getSection(ID, "Red"),train.getPrevSection(ID, "Red"), "Red", train.getColor(ID,"Red"));
			    } else {
			    	if(direction){
			    		train.setBlockNum(train.getBlockNum(ID, "Red")-1, ID, "Red");
			    	} else {
			    		train.setBlockNum(train.getBlockNum(ID, "Red")+1, ID, "Red");
			    	}
			    }
		  }
		  
		  train.setBlockGrade(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())-1).getBlockGrade(), ID, train.getTrainSchedule(ID).get(0).getLine());
		  train.setBlockLen(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())-1).getBlockLen(), ID, train.getTrainSchedule(ID).get(0).getLine());
		  train.setElevation(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())-1).getElevation(), ID, train.getTrainSchedule(ID).get(0).getLine());
		  train.setSection(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())-1).getSection(), ID, train.getTrainSchedule(ID).get(0).getLine());
		  train.setBlockSpeedLim((int)Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())-1).getSpeedLimit(), ID, train.getTrainSchedule(ID).get(0).getLine());
		  train.setDirection(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())-1).getArrowDirection(), ID, train.getTrainSchedule(ID).get(0).getLine());
		  train.setSpeed((int) (Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())-1).getSpeedLimit()), ID, train.getTrainSchedule(ID).get(0).getLine());
		  train.setAuthority((int) (((Math.pow((Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())-1).getSpeedLimit())*.447,2))/(2*1.2))*3.3), ID, train.getTrainSchedule(ID).get(0).getLine());
		  
	  }
	  return train;
  }
}

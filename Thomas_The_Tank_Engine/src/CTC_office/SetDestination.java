package CTC_office;

/**
 * This class is used to set a train's destination 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

import java.util.List;

import Interface.CTC_TC_Trains;
import Interface.CTCandTrackControllerInterface;

public class SetDestination {
	/**
	 * Constructor
	 */
     public SetDestination(){
    	 
     }
     /**
      * Sets the train's dispatcher set destination 
      * @param ID Train's id
      * @param BlockNum Train's block number 
      * @param mode VerifyManualMode object
      * @param train AllTrains object
      * @param Blocks AllTrains object
      * @return train AllTrains object
      */
     public AllTrains setManualDestination(int ID, int BlockNum, VerifyManualMode mode, AllTrains train, AllTrackBlock Blocks){
    	 if(mode.verify()){
    		 train.setDestBlock(BlockNum, ID, train.getTrainSchedule(ID).get(0).getLine());

             if(!((Blocks.getInfrastructure(BlockNum, train.getTrainSchedule(ID).get(0).getLine()).equalsIgnoreCase(" ")) ||
            		 (Blocks.getInfrastructure(BlockNum, train.getTrainSchedule(ID).get(0).getLine()).equalsIgnoreCase("SWITCH")) || 
            		 (Blocks.getInfrastructure(BlockNum, train.getTrainSchedule(ID).get(0).getLine()).equalsIgnoreCase("RAILWAY CROSSING")) ||
            		 (Blocks.getInfrastructure(BlockNum, train.getTrainSchedule(ID).get(0).getLine()).equalsIgnoreCase("UNDERGROUND")))){
            	 train.setStation(Blocks.getInfrastructure(BlockNum, train.getTrainSchedule(ID).get(0).getLine()), ID,train.getTrainSchedule(ID).get(0).getLine() );
            	 List <ScheduleInfo> stations =train.getTrainSchedule(ID);
            	 for(int y =0; y<stations.size(); y++){
            		 if(stations.get(y).getStation().equalsIgnoreCase(Blocks.getInfrastructure(BlockNum, train.getTrainSchedule(ID).get(0).getLine()))){
            			train.setStationNum(y, ID, train.getTrainSchedule(ID).get(0).getLine());
            		 }
            	 }
             }
             
    		 train.setUserSetDest(true, ID,train.getTrainSchedule(ID).get(0).getLine());
    	 }
    	 return train;
     }
     /**
      * Sets the train's destination automatically
      * @param ID train's id
      * @param BlockNum train's block number
      * @param train AllTrains object
      * @param Blocks AllTrackBlock object
      * @param reversedirection train's direction
      * @param TCinterface CTCandTrackControllerInterface object
      * @return train AllTrains object
      */
     private AllTrains setAutomaticDestination(int ID, int BlockNum, AllTrains train, AllTrackBlock Blocks, boolean reversedirection, CTCandTrackControllerInterface TCinterface){
    	 List <ScheduleInfo> stations =train.getTrainSchedule(ID);
        		 if(stations.get(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())).getBlockNum()== BlockNum){
        			 TCinterface.setTransponder(ID, true);
        			 if(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1<stations.size()){
        			 train.setDestBlock(stations.get(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1).getBlockNum(), ID, train.getTrainSchedule(ID).get(0).getLine());
        			 train.setStation(stations.get(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1).getStation(), ID,train.getTrainSchedule(ID).get(0).getLine() );
        			 train.setStationNum(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1, ID, train.getTrainSchedule(ID).get(0).getLine());
        		    } else if (train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1>=stations.size()){
        		    	 train.setDestBlock(stations.get(0).getBlockNum(), ID, train.getTrainSchedule(ID).get(0).getLine());
            			 train.setStation(stations.get(0).getStation(), ID,train.getTrainSchedule(ID).get(0).getLine() );
            			 train.setStationNum(0, ID, train.getTrainSchedule(ID).get(0).getLine());
        		    }
        			 train.setUserSetDest(false, ID,train.getTrainSchedule(ID).get(0).getLine());
        			 return train;
        		 } else {
        			 train.setDestBlock(stations.get(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())).getBlockNum(), ID, train.getTrainSchedule(ID).get(0).getLine());
        		 }
    	 return train;
     }
     /**
      * checks if the train past its current set destination 
      * @param ID train's id
      * @param train  AllTrains object
      * @param Blocks AllTrackBlock object
      * @param reversedirection train's direction 
      * @param TCinterface CTCandTrackControllerInterface object
      * @return train  AllTrains object
      */
     public AllTrains checkPastDestionation(int ID, AllTrains train, AllTrackBlock Blocks, boolean reversedirection, CTCandTrackControllerInterface TCinterface){
    	 if(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())== train.getDestBlock(ID, train.getTrainSchedule(ID).get(0).getLine()) ){
    		 train=setAutomaticDestination(ID, train.getDestBlock(ID, train.getTrainSchedule(ID).get(0).getLine()), train, Blocks,reversedirection,TCinterface);   	 
    	 }
    	 return train;
     }
}

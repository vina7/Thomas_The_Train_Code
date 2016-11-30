package CTC_office;

import java.util.List;

public class SetDestination {
     public SetDestination(){
    	 
     }
     public AllTrains setManualDestination(int ID, int BlockNum, VerifyManualMode mode, AllTrains train){
    	 if(mode.verify()){
    		 train.setDestBlock(BlockNum, ID, train.getTrainSchedule(ID).get(0).getLine());
    		 train.setUserSetDest(true, ID,train.getTrainSchedule(ID).get(0).getLine());
    	 }
    	 return train;
     }
     private AllTrains setAutomaticDestination(int ID, int BlockNum, AllTrains train, AllTrackBlock Blocks){
    	 List <ScheduleInfo> stations =train.getTrainSchedule(ID);
    	 for (int i=0; i<stations.size(); i++){
    		 if(Blocks.getBlockNum(stations.get(i))== BlockNum){
    			 train.setDestBlock(Blocks.getBlockNum(stations.get(i+1)), ID, train.getTrainSchedule(ID).get(0).getLine());
    			 train.setUserSetDest(false, ID,train.getTrainSchedule(ID).get(0).getLine());
    		 }
    	 }
    	 return train;
     }
     public AllTrains checkPastDestionation(int ID, AllTrains train, AllTrackBlock Blocks){
    	 if(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())== train.getDestBlock(ID, train.getTrainSchedule(ID).get(0).getLine()) ){
    		 train=setAutomaticDestination(ID, train.getDestBlock(ID, train.getTrainSchedule(ID).get(0).getLine()), train, Blocks);
    	 }
    	 return train;
     }
}

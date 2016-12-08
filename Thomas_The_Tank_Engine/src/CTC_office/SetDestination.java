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
     private AllTrains setAutomaticDestination(int ID, int BlockNum, AllTrains train, AllTrackBlock Blocks, boolean reversedirection){
    	 List <ScheduleInfo> stations =train.getTrainSchedule(ID);
        		 if(stations.get(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())).getBlockNum()== BlockNum){
        			 if(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1<stations.size()){
        			 train.setDestBlock(stations.get(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1).getBlockNum(), ID, train.getTrainSchedule(ID).get(0).getLine());
        			 train.setStation(stations.get(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1).getStation(), ID,train.getTrainSchedule(ID).get(0).getLine() );
        			 train.setStationNum(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1, ID, train.getTrainSchedule(ID).get(0).getLine());
        		    } else if (train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine())+1>=stations.size()){
        		    	 train.setDestBlock(stations.get(0).getBlockNum(), ID, train.getTrainSchedule(ID).get(0).getLine());
            			 train.setStation(stations.get(0).getStation(), ID,train.getTrainSchedule(ID).get(0).getLine() );
            			 train.setStationNum(0, ID, train.getTrainSchedule(ID).get(0).getLine());
        		    }
        			 System.out.println(train.getDestBlock(ID, train.getTrainSchedule(ID).get(0).getLine()));
            		 System.out.println(train.getStationNum(ID, train.getTrainSchedule(ID).get(0).getLine()));
        			 train.setUserSetDest(false, ID,train.getTrainSchedule(ID).get(0).getLine());
        			 return train;
        		 }
    	 return train;
     }
     public AllTrains checkPastDestionation(int ID, AllTrains train, AllTrackBlock Blocks, boolean reversedirection){
    	 System.out.println(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()));
    	 if(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine())== train.getDestBlock(ID, train.getTrainSchedule(ID).get(0).getLine()) ){
    		 train=setAutomaticDestination(ID, train.getDestBlock(ID, train.getTrainSchedule(ID).get(0).getLine()), train, Blocks,reversedirection );
    	 }
    	 return train;
     }
}

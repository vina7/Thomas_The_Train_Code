package Interface;

import java.util.ArrayList;

import CTC_office.AllTrackBlock;
import CTC_office.TrackBlock;

public class RailwayCrossings {
		ArrayList <Integer> Greencrossinglocations;
		ArrayList <Integer> Redcrossinglocations;
		AllTrackBlock Blocks;
		private static RailwayCrossings instance =null;
		boolean DebugMode;
		protected RailwayCrossings (boolean DebugMode){
			Greencrossinglocations =new ArrayList <Integer> ();
			Redcrossinglocations = new ArrayList <Integer> ();
			this.DebugMode=DebugMode;
		  }
		public static RailwayCrossings getInstance(boolean DebugMode){
			  if(instance == null){
				  instance= new RailwayCrossings(DebugMode);
			  }
			  return instance;
		  }
		public void updateBlocks(AllTrackBlock Blocks, String Line){
			this.Blocks = Blocks;
			updateCrossingLocations(Line);
		}
		private void updateCrossingLocations(String Line){
			if(Line.equals("Green")){
			ArrayList <TrackBlock> GreenTrack = Blocks.getGreenTrack();
			for(int i=0; i<GreenTrack.size(); i++){
				if(GreenTrack.get(i).getInfrastructure().equals("RAILWAY CROSSING")){
					Greencrossinglocations.add(GreenTrack.get(i).getBlockNum());
				} 
				}
				
			}
			if(Line.equals("Red")){
				ArrayList <TrackBlock> RedTrack = Blocks.getRedTrack();
				for(int i=0; i<RedTrack.size(); i++){
					if(RedTrack.get(i).getInfrastructure().equals("RAILWAY CROSSING")){
						Redcrossinglocations.add(RedTrack.get(i).getBlockNum());
					} 
					}
					
				}
		}
		
		public ArrayList <Integer> getGreencrossinglocations(){
			return Greencrossinglocations;
		}
		public ArrayList <Integer> getRedcrossinglocations(){
			return Redcrossinglocations;
		}
		public void setCrossingPosition(String RailroadCross, int BlockNum,String Line){
			Blocks.setRailroadCross(RailroadCross, BlockNum, Line);
		}
		public AllTrackBlock getupdatedBlock(){
			return Blocks;
		}
	
}

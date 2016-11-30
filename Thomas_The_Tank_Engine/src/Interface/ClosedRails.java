package Interface;

import java.util.ArrayList;

import CTC_office.AllTrackBlock;
import CTC_office.TrackBlock;
import Overall_Sys.TimeClass;

public class ClosedRails {
	ArrayList <Integer> Greenclosedrailslocations;
	ArrayList <Integer> Redclosedrailslocations;
	AllTrackBlock Blocks;
	private static ClosedRails instance =null;
	boolean DebugMode;
	protected ClosedRails (boolean DebugMode){
		Greenclosedrailslocations =new ArrayList <Integer> ();
		Redclosedrailslocations = new ArrayList <Integer> ();
		this.DebugMode=DebugMode;
	  }
	public static ClosedRails getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new ClosedRails(DebugMode);
		  }
		  return instance;
	  }
	public ArrayList <Integer> getGreenclosedrailslocations(){
		return Greenclosedrailslocations;
	}
	public ArrayList <Integer> getRedclosedrailslocations(){
		return Redclosedrailslocations;
	}
	public void updateBlocks(AllTrackBlock Blocks, String Line){
		this.Blocks = Blocks;
		updateClosedLocations(Line);
	}
	public void updateClosedLocations(String Line){
		if(Line.equals("Green")){
			ArrayList <TrackBlock> GreenTrack = Blocks.getGreenTrack();
			for(int i =0; i<GreenTrack.size(); i++ ){
				if(GreenTrack.get(i).getClosed()){
					Greenclosedrailslocations.add(GreenTrack.get(i).getBlockNum());
				}
			}
		} else if (Line.equals("Red")){
			ArrayList <TrackBlock> RedTrack = Blocks.getRedTrack();
			for(int i =0; i<RedTrack.size(); i++ ){
				if(RedTrack.get(i).getClosed()){
					Redclosedrailslocations.add(RedTrack.get(i).getBlockNum());
				}
			}
		}
	}
	public AllTrackBlock openTracks(TimeClass timer){
		ArrayList <TrackBlock> GreenTrack = Blocks.getGreenTrack();
		for(int i =0; i<GreenTrack.size(); i++ ){
			if(GreenTrack.get(i).getClosed()){
				if((timer.getTime()-GreenTrack.get(i).getClosedTime())>= GreenTrack.get(i).getTimeToFixRail()){
					Blocks.setClosed(false,GreenTrack.get(i).getBlockNum(),"Green");
					Greenclosedrailslocations.remove(GreenTrack.get(i).getBlockNum());
				}
			}
		}
		ArrayList <TrackBlock> RedTrack = Blocks.getRedTrack();
		for(int i =0; i<RedTrack.size(); i++ ){
			if(RedTrack.get(i).getClosed()){
				if((timer.getTime()-RedTrack.get(i).getClosedTime())>= RedTrack.get(i).getTimeToFixRail()){
					Blocks.setClosed(false,GreenTrack.get(i).getBlockNum(),"Red");
					Redclosedrailslocations.remove(RedTrack.get(i).getBlockNum());
				}
			}
		}
		return Blocks;
	}
}

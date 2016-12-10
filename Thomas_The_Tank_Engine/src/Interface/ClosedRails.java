package Interface;

import java.util.ArrayList;

import CTC_office.AllTrackBlock;
import CTC_office.TrackBlock;
import Overall_Sys.TimeClass;
/**
 * This class is a singleton so the data can be used across modules. Used as the interface between the CTC 
 * and Track Controller for which blocks are broken and closed. 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class ClosedRails {
	ArrayList <Integer> Greenclosedrailslocations;
	ArrayList <Integer> Redclosedrailslocations;
	AllTrackBlock Blocks;
	private static ClosedRails instance =null;
	boolean DebugMode;
	/**
	 * Constructor
	 * @param DebugMode Used as a way to debug the system
	 */
	protected ClosedRails (boolean DebugMode){
		Greenclosedrailslocations =new ArrayList <Integer> ();
		Redclosedrailslocations = new ArrayList <Integer> ();
		this.DebugMode=DebugMode;
	  }
	/**
	 * Creates a singleton of the class
	 * @param DebugMode Value used for debugging
	 * @return instance The Class' instance
	 */
	public static ClosedRails getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new ClosedRails(DebugMode);
		  }
		  return instance;
	  }
	/**
	 * Sends back the list of closed rail locations on the green line
	 * @return Greenclosedrailslocations ArrayList of BlockNum
	 */
	public ArrayList <Integer> getGreenclosedrailslocations(){
		return Greenclosedrailslocations;
	}
	/**
	 * Sends back the list of closed rail locations on the red line
	 * @return Redclosedrailslocations ArrayList of BlockNum
	 */
	public ArrayList <Integer> getRedclosedrailslocations(){
		return Redclosedrailslocations;
	}
	/**
	 * Updates the Block object stored in the class. Then add sets certain broken blocks to closed
	 * @param Blocks Stores all of the system's block information 
	 * @param Line Tells which line the closed block is in
	 */
	public void updateBlocks(AllTrackBlock Blocks, String Line){
		this.Blocks = Blocks;
		updateClosedLocations(Line);
	}
	/**
	 * Update the array list to which blocks are closed 
	 * @param Line Tells which line the closed block is in
	 */
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
	/**
	 * Opens Closed rails if the time to fix the rails has past
	 * @param timer TimeClass object
	 * @return Blocks Stores all of the system's block information 
	 */
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

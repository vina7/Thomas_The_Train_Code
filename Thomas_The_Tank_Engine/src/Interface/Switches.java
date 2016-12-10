package Interface;

import java.util.ArrayList;

import CTC_office.AllTrackBlock;
import CTC_office.TrackBlock;
/**
 * The CTC and Track Controller Switch Interface
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class Switches {
	ArrayList <Integer> Greenswitchlocations;
	ArrayList <Integer>Redswitchlocations;
	ArrayList <Integer []> Greenswitchoptions;
	ArrayList <Integer []> Redswitchoptions;
	AllTrackBlock Blocks;
	private static Switches instance =null;
	boolean DebugMode;
	/**
	 * Constructor
	 * @param DebugMode Used to debug the system
	 */
	protected Switches(boolean DebugMode){
		Greenswitchlocations =new ArrayList <Integer> ();
		Redswitchlocations = new ArrayList <Integer> ();
		Greenswitchoptions= new ArrayList <Integer[]> ();
		Redswitchoptions= new ArrayList <Integer[]> ();
		Blocks = AllTrackBlock.getInstance(false);
		this.DebugMode=DebugMode;
	  }
	/**
	 * Creates a singleton of the class
	 * @param DebugMode Used to debug the system
	 * @return Instance Returns the instance of the class
	 */
	public static Switches getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new Switches(DebugMode);
		  }
		  return instance;
	  }
	/**
	 * Updates the blocks that the switches are located on 
	 * @param Blocks The Track Block object
	 * @param Line The block's line
	 */
	public AllTrackBlock updateBlocks(AllTrackBlock Blocks, String Line){
		this.Blocks = Blocks;
		updateSwitchLocations(Line);
		setInitialSwitchPositions(Line);
		return this.Blocks;
	}
	/**
	 * Updates the switch locations
	 * @param Line The switch's line
	 */
	private void updateSwitchLocations(String Line){
		if(Line.equals("Green")){
			Integer [] startarray = {0,0};
			Greenswitchoptions.add(startarray);
			Greenswitchoptions.add(startarray);
			Greenswitchoptions.add(startarray);
			Greenswitchoptions.add(startarray);
			Greenswitchoptions.add(startarray);
			Greenswitchoptions.add(startarray);
			Greenswitchlocations.add(0);
			Greenswitchlocations.add(0);
			Greenswitchlocations.add(0);
			Greenswitchlocations.add(0);
			Greenswitchlocations.add(0);
			Greenswitchlocations.add(0);
		ArrayList <TrackBlock> GreenTrack = Blocks.getGreenTrack();
		for(int i=0; i<GreenTrack.size(); i++){
			if(!GreenTrack.get(i).getSwitchBlock().equals(" ")){
			String[] temp=GreenTrack.get(i).getSwitchBlock().split("\\s+");
			if(GreenTrack.get(i).getInfrastructure().equals("SWITCH")){
				Greenswitchlocations.set(Integer.parseInt(temp[1]),GreenTrack.get(i).getBlockNum());
			} else{
				if(Greenswitchoptions.get(Integer.parseInt(temp[1]))[0]==0){
					Integer [] temparray = {GreenTrack.get(i).getBlockNum(), -1};
					Greenswitchoptions.set(Integer.parseInt(temp[1]),temparray);
				}else {
					Integer [] temparray = Greenswitchoptions.get(Integer.parseInt(temp[1]));
					temparray[1]= GreenTrack.get(i).getBlockNum();
					Greenswitchoptions.set(Integer.parseInt(temp[1]),temparray);
				}
				
			}
			}
			
		}
		}
		if(Line.equals("Red")){
			Integer [] startarray = {0,0};
			Redswitchoptions.add(startarray);
			Redswitchoptions.add(startarray);
			Redswitchoptions.add(startarray);
			Redswitchoptions.add(startarray);
			Redswitchoptions.add(startarray);
			Redswitchoptions.add(startarray);
			Redswitchoptions.add(startarray);
			Redswitchlocations.add(0);
			Redswitchlocations.add(0);
			Redswitchlocations.add(0);
			Redswitchlocations.add(0);
			Redswitchlocations.add(0);
			Redswitchlocations.add(0);
			Redswitchlocations.add(0);
		ArrayList <TrackBlock> RedTrack = Blocks.getRedTrack();
		for(int i=0; i<RedTrack.size(); i++){
			if(!RedTrack.get(i).getSwitchBlock().equals(" ")){
			String[] temp=RedTrack.get(i).getSwitchBlock().split("\\s+");
			if(RedTrack.get(i).getInfrastructure().equals("SWITCH")){
				Redswitchlocations.set(Integer.parseInt(temp[1])-6,RedTrack.get(i).getBlockNum());
			} else{
				if(Redswitchoptions.get(Integer.parseInt(temp[1])-6)[0]==0){
					Integer [] temparray = {RedTrack.get(i).getBlockNum(), -1};
					Redswitchoptions.set(Integer.parseInt(temp[1])-6,temparray);
				}else {
					Integer [] temparray = Redswitchoptions.get(Integer.parseInt(temp[1])-6);
					temparray[1]= RedTrack.get(i).getBlockNum();
					Redswitchoptions.set(Integer.parseInt(temp[1])-6,temparray);
				}
				
			}
			}
			
		}
		}
	}
	/**
	 * Sets the original switch positions of the line
	 * @param Line The switch's line
	 */
	private void setInitialSwitchPositions(String Line){
	  	if(Line.equals("Green")){
	  		for(int i =0; i<Greenswitchlocations.size(); i++){
	  		Integer blocknum =  Greenswitchlocations.get(i);
	  		Blocks.setSwitchPosition(Blocks.getSection(Greenswitchoptions.get(i)[0] ,Line), blocknum, Line);
	  		}
	  		
	  	} else if (Line.equals("Red")){
	  		for(int i =0; i<Redswitchlocations.size(); i++){
		  		Integer blocknum =  Redswitchlocations.get(i);
		  		Blocks.setSwitchPosition(Blocks.getSection(Redswitchoptions.get(i)[0] ,Line), blocknum, Line);
		  		}
	  	}
	}
	/**
	 * Gets the Green switch location array list
	 * @return Greenswitchlocations array list
	 */
	public ArrayList <Integer> getGreenswitchlocations(){
		return Greenswitchlocations;
	}
	/**
	 * Gets the Red switch location array list
	 * @return Redswitchlocations array list
	 */
	public ArrayList <Integer> getRedswitchlocations(){
		return Redswitchlocations;
	}
	/**
	 * Gets the Green switch position options array list
	 * @return Greenswitchoptions array list
	 */
	public ArrayList <Integer []> getGreenswitchoptions(){
		return Greenswitchoptions;
	}
	/**
	 * Gets the Red switch position options array list
	 * @return Redswitchoptions array list
	 */
	public ArrayList <Integer []> getRedswitchoptions(){
		return Redswitchoptions;
	}
	/**
	 * Sets a switch's position 
	 * @param SwitchPosition Chosen position
	 * @param BlockNum Switch's Block number
	 * @param Line Switch's Line
	 */ 
	public void setSwitchPosition(String SwitchPosition, int BlockNum,String Line){
		Blocks.setSwitchPosition(SwitchPosition, BlockNum, Line);
	}
	/**
	 * Gets the updated block object 
	 * @return Blocks Block object
	 */
	public AllTrackBlock getupdatedBlock(){
		return Blocks;
	}
}

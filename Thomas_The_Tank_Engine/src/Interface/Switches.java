package Interface;

import java.util.ArrayList;

import CTC_office.AllTrackBlock;
import CTC_office.TrackBlock;

public class Switches {
	ArrayList <Integer> Greenswitchlocations;
	ArrayList <Integer>Redswitchlocations;
	ArrayList <Integer []> Greenswitchoptions;
	ArrayList <Integer []> Redswitchoptions;
	AllTrackBlock Blocks;
	private static Switches instance =null;
	boolean DebugMode;
	protected Switches(boolean DebugMode){
		Greenswitchlocations =new ArrayList <Integer> ();
		Redswitchlocations = new ArrayList <Integer> ();
		Greenswitchoptions= new ArrayList <Integer[]> ();
		Redswitchoptions= new ArrayList <Integer[]> ();
		this.DebugMode=DebugMode;
	  }
	public static Switches getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new Switches(DebugMode);
		  }
		  return instance;
	  }
	public AllTrackBlock updateBlocks(AllTrackBlock Blocks, String Line){
		this.Blocks = Blocks;
		updateSwitchLocations(Line);
		setInitialSwitchPositions(Line);
		return this.Blocks;
	}
	private void updateSwitchLocations(String Line){
		if(Line.equals("Green")){
		ArrayList <TrackBlock> GreenTrack = Blocks.getGreenTrack();
		for(int i=0; i<GreenTrack.size(); i++){
			if(!GreenTrack.get(i).getSwitchBlock().equals(" ")){
			String[] temp=GreenTrack.get(i).getSwitchBlock().split(" ");
			if(GreenTrack.get(i).getInfrastructure().equals("SWITCH")){
				Greenswitchlocations.add(Integer.parseInt(temp[1]),GreenTrack.get(i).getBlockNum());
			} else{
				if(Greenswitchoptions.get(Integer.parseInt(temp[1]))==null){
					Integer [] temparray = {GreenTrack.get(i).getBlockNum(), -1};
					Greenswitchoptions.add(Integer.parseInt(temp[1]),temparray);
				}else {
					Integer [] temparray = Greenswitchoptions.get(Integer.parseInt(temp[1]));
					temparray[1]= GreenTrack.get(i).getBlockNum();
					Greenswitchoptions.remove(Integer.parseInt(temp[1]));
					Greenswitchoptions.add(Integer.parseInt(temp[1]),temparray);
				}
				
			}
			}
			
		}
		}
		if(Line.equals("Red")){
		ArrayList <TrackBlock> RedTrack = Blocks.getRedTrack();
		for(int i=0; i<RedTrack.size(); i++){
			if(!RedTrack.get(i).getSwitchBlock().equals(" ")){
			String[] temp=RedTrack.get(i).getSwitchBlock().split(" ");
			if(RedTrack.get(i).getInfrastructure().equals("SWITCH")){
				Redswitchlocations.add(Integer.parseInt(temp[1]),RedTrack.get(i).getBlockNum());
			} else{
				if(Redswitchoptions.get(Integer.parseInt(temp[1]))==null){
					Integer [] temparray = {RedTrack.get(i).getBlockNum(), -1};
					Redswitchoptions.add(Integer.parseInt(temp[1]),temparray);
				}else {
					Integer [] temparray = Redswitchoptions.get(Integer.parseInt(temp[1]));
					temparray[1]= RedTrack.get(i).getBlockNum();
					Redswitchoptions.remove(Integer.parseInt(temp[1]));
					Redswitchoptions.add(Integer.parseInt(temp[1]),temparray);
				}
				
			}
			}
			
		}
		}
	}
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
	public ArrayList <Integer> getGreenswitchlocations(){
		return Greenswitchlocations;
	}
	public ArrayList <Integer> getRedswitchlocations(){
		return Redswitchlocations;
	}
	public ArrayList <Integer []> getGreenswitchoptions(){
		return Greenswitchoptions;
	}
	public ArrayList <Integer []> getRedswitchoptions(){
		return Redswitchoptions;
	}
	public void setSwitchPosition(String SwitchPosition, int BlockNum,String Line){
		Blocks.setSwitchPosition(SwitchPosition, BlockNum, Line);
	}
	public AllTrackBlock getupdatedBlock(){
		return Blocks;
	}
}

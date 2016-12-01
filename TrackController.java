package Track_Controller;

import java.util.ArrayList;
import java.util.Scanner;

import CTC_office.AllTrackBlock;
import CTC_office.AllTrains;
import CTC_office.Trains;
import Interface.CTCandTrackControllerInterface;
import Interface.Switches;
import Interface.TrackCircuit;
import Interface.TrackCircuitTrainInfo;
import Overall_Sys.TimeClass;

/*Track Controller. The system will be controlled by 4 TCs, each controlling a quadrant of the track. */
public class TrackController {


	/* TrackController's Main Method */
	public static void main(String[] args){
	
		
		TimeClass time = TimeClass.getInstance(false);
		int currentTime = -1;

		/* Holds all calculations off so they only happen every second */ 
		while(true){
			if(currentTime != time.getTime()){
				currentTime = time.getTime();  

				verifyAllTrainSpeeds();
				
				verifyAllTrainAuthorities();
				
				moveAllNeededSwitches();
				
				updateTrainInterface();

			}
		}
		
		
	}
	
	public static void updateTrainInterface(){
		
		TrackCircuit trackCircuit = TrackCircuit.getInstance(false);
		ArrayList <TrackCircuitTrainInfo> activetrains = trackCircuit.getActiveTrains();
		
		int id;
		String nextStation;
		boolean transponder;
		
		CTCandTrackControllerInterface CTC_TC_Interface = CTCandTrackControllerInterface.getInstance(false);
		for (int i = 0; i<activetrains.size();i++){
			id = (activetrains.get(i)).getID();
			nextStation = CTC_TC_Interface.getNextStation(id);
			transponder = CTC_TC_Interface.getTransponder(id);
			
			
			
			
		}

		
	}
	
	public static void moveAllNeededSwitches(){
		String line;
		int id;
		int currBlockNum;
		String currSection = null; //needs adding to trains.java
		String prevSection = null; //needs adding to trains.java
		int switchSource = 0;
		Integer[] switchDestinations = null;
		String nextSection;
		
		AllTrackBlock allTrackBlock = AllTrackBlock.getInstance(false);

		double switchArrayIndex; 
		
		AllTrains allTrains = AllTrains.getInstance(false);
		
		Route route = new Route();

		
		TrackCircuit trackCircuit = TrackCircuit.getInstance(false);
		ArrayList <TrackCircuitTrainInfo> activetrains = trackCircuit.getActiveTrains();
		
		Switches switches = Switches.getInstance(false);
		
		ArrayList <Integer> greenSwitchLocationBlockNums = switches.getGreenswitchlocations();
		ArrayList <Integer[]> greenSwitchOptions = switches.getGreenswitchoptions();
		
		ArrayList <Integer> greenSwitchDestinationBlockNums = new ArrayList<Integer>();
		for(int m = 0; m<greenSwitchOptions.size(); m++){
			greenSwitchDestinationBlockNums.add((greenSwitchOptions.get(m))[0]);
			greenSwitchDestinationBlockNums.add((greenSwitchOptions.get(m))[1]);
		}
		
		ArrayList <Integer> redSwitchLocationBlockNums = switches.getRedswitchlocations();
		ArrayList <Integer[]> redSwitchOptions = switches.getRedswitchoptions();
		
		ArrayList <Integer> redSwitchDestinationBlockNums = new ArrayList<Integer>();
		for(int m = 0; m<redSwitchOptions.size(); m++){
			redSwitchDestinationBlockNums.add((redSwitchOptions.get(m))[0]);
			redSwitchDestinationBlockNums.add((redSwitchOptions.get(m))[1]);
		}
		
		//For all active trains, 
		for(int i=0;i<activetrains.size();i++){
			
			line = (activetrains.get(i)).getLine();
			id = (activetrains.get(i)).getID();
			currBlockNum = allTrains.getBlockNum(id, line); //block number where train is 
			currSection = allTrackBlock.getSection(currBlockNum, line);
			// GET PREV SECTION
			

			if(greenSwitchLocationBlockNums.contains(currBlockNum)||redSwitchLocationBlockNums.contains(currBlockNum)){ //if current block is source 
				
				
				if(line.equals("Green")){
					switchSource = currBlockNum;
					switchArrayIndex = greenSwitchLocationBlockNums.indexOf(currBlockNum);
					switchDestinations = greenSwitchOptions.get((int)switchArrayIndex);
					
					nextSection = route.getNextGreen(prevSection.toLowerCase(), currSection.toLowerCase());
					
					switches.setSwitchPosition(nextSection, switchSource, line);

					

					
				}
				else if (line.equalsIgnoreCase("Red")){
					switchSource = currBlockNum;
					switchArrayIndex = redSwitchLocationBlockNums.indexOf(currBlockNum);
					switchDestinations = redSwitchOptions.get((int)switchArrayIndex);
					
					nextSection = route.getNextRed(prevSection.toLowerCase(), currSection.toLowerCase());
					
					switches.setSwitchPosition(nextSection, switchSource, line);


				}
								
			}
			
			if(greenSwitchDestinationBlockNums.contains(currBlockNum)||redSwitchDestinationBlockNums.contains(currBlockNum)){ //if current block is destination
				
				
				if(line.equals("Green")){
					switchArrayIndex = greenSwitchDestinationBlockNums.indexOf(currBlockNum);
					switchArrayIndex = Math.ceil((switchArrayIndex/2));
					switchDestinations = greenSwitchOptions.get((int)switchArrayIndex);
					switchSource = greenSwitchLocationBlockNums.get((int)switchArrayIndex);
					
					nextSection = route.getNextGreen(prevSection.toLowerCase(), currSection.toLowerCase());
					
					switches.setSwitchPosition(currSection, switchSource, line);



					
				}
				else if (line.equalsIgnoreCase("Red")){
					switchArrayIndex = redSwitchDestinationBlockNums.indexOf(currBlockNum);
					switchArrayIndex = Math.ceil((switchArrayIndex/2));
					switchDestinations = redSwitchOptions.get((int)switchArrayIndex);
					switchSource = redSwitchLocationBlockNums.get((int)switchArrayIndex);
					
					nextSection = route.getNextRed(prevSection.toLowerCase(), currSection.toLowerCase());
					
					switches.setSwitchPosition(currSection, switchSource, line);


				}
				
			}
	
		} //end for
		
	}
	
	
	/*
	
	
	public static void moveAllNeededSwitchesBackup(){
		
		String line;
		int id;
		int blockNum;
		
		int switchArrayIndex;
		Integer[] switchOptions;
		
		

		
		AllTrains allTrains = AllTrains.getInstance(false);
		TrackCircuit trackCircuit = TrackCircuit.getInstance(false);
		ArrayList <TrackCircuitTrainInfo> activetrains = trackCircuit.getActiveTrains();
		Switches switches = Switches.getInstance(false);
		
		ArrayList <Integer> greenSwitchLocationBlockNums = switches.getGreenswitchlocations();
		ArrayList <Integer[]> greenSwitchOptions = switches.getGreenswitchoptions();

		ArrayList <Integer> redSwitchLocationBlockNums = switches.getRedswitchlocations();
		ArrayList <Integer[]> redSwitchOptions = switches.getRedswitchoptions();

		
		//For all active trains, 
		for(int i=0;i<activetrains.size();i++){
			
			line = (activetrains.get(i)).getLine();
			id = (activetrains.get(i)).getID();
			blockNum = allTrains.getBlockNum(id, line); //block number where train is 

			if(greenSwitchLocationBlockNums.contains(blockNum)||redSwitchLocationBlockNums.contains(blockNum)){ //if the train is at a switch
				
				if(line.equals("Green")){
					switchArrayIndex = greenSwitchLocationBlockNums.indexOf(blockNum);
					switchOptions = greenSwitchOptions.get(switchArrayIndex);
					
					
				}
				else if (line.equalsIgnoreCase("Red")){
					switchArrayIndex = redSwitchLocationBlockNums.indexOf(blockNum);
					switchOptions = redSwitchOptions.get(switchArrayIndex);
				}
				
				
			
			
			}
				
		}
		
		
	}
	
	
	*/ 
	
	public static void verifyAllTrainSpeeds(){
		
		String line;
		int id;
		int speed;
		int speedLim;
		
		AllTrains allTrains = AllTrains.getInstance(false);
		
		TrackCircuit trackCircuit = TrackCircuit.getInstance(false);
		ArrayList <TrackCircuitTrainInfo> activetrains = trackCircuit.getActiveTrains();
		
		
		//For all active trains, /
		for(int i=0;i<activetrains.size();i++){
			
			line = (activetrains.get(i)).getLine();
			id = (activetrains.get(i)).getID();
			
			speed = allTrains.getSpeed(id, line);
						
			speedLim = allTrains.getBlockSpeedLim(id, line);
			
			if(speed > speedLim){
				(activetrains.get(i)).setVerifiedSpeed(speedLim);
			}
				
		}
		
		
		
		
	}
	
	
	public static void verifyAllTrainAuthorities(){
		
		
		String line;
		int id;
		int authority;
		int authorityDecrement;
		int blockNum;
		int blockNumIncrement;
		int blockLen;
		boolean badAuthority = false;
		ArrayList<Integer> authorizedBlocks = new ArrayList<Integer>();
		
		AllTrains allTrains = AllTrains.getInstance(false);
		AllTrackBlock allTrackBlock = AllTrackBlock.getInstance(false);
		
		TrackCircuit trackCircuit = TrackCircuit.getInstance(false);
		ArrayList <TrackCircuitTrainInfo> activetrains = trackCircuit.getActiveTrains();
		
		
		
		
		
		/*For all active trains, */
		for(int i=0;i<activetrains.size();i++){
			
			line = (activetrains.get(i)).getLine(); 
			id = (activetrains.get(i)).getID(); //train id
			authority = allTrains.getAuthority(id,line); //train authority by distance
			authorityDecrement = authority;
			blockNum = allTrains.getBlockNum(id, line); //block number where train is 
			blockNumIncrement = blockNum;
					
			while(authorityDecrement > 0){
				
				blockLen = allTrackBlock.getBlockLen(blockNumIncrement, line); //get current block's length
								
				authorizedBlocks.add(blockNum); //add current authorized block to list of authorized blocks. If a duplicate, 2 trains have been authorized for the same block. Current train's authority is dangerous. 
				
				for(int j = 0; j<(authorizedBlocks.size()-1); j++){
					if(authorizedBlocks.get(j) == authorizedBlocks.get(authorizedBlocks.size())){ //a block is added to "authorized" in duplicate
						badAuthority = true;
					}
				}
				
				authorityDecrement = authorityDecrement - blockLen; //subtract current block length from authority, this block is authorized

				blockNumIncrement = blockNumIncrement++; //TO CHECK THE NEXT BLOCK. WILL NOT WORK IF THE NEXT BLOCK IS AFTER A SWITCH!
				
			}
			
			if(badAuthority == true){ //fix the authority
				trackCircuit.setAuthority((allTrackBlock.getBlockLen(blockNum, line)), id); //If another train is authorized where you are trying to send this one, decrease this train's authority to the block it is in. 
			}
			
			badAuthority = false;

			

				
		}
	}
	
	
	

}
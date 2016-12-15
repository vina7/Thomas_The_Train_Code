import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

/*Track Controller. The system will be controlled by 4 TCs, each controlling a quadrant of the track. */
public class TrackController {

	public int tcID; 						    	//The ID of this track controller. (1, 2, 3, 4)
	public Block trackBlocks[];						//Array of Track Blocks controlled by this TC.
	public Switch switchesInQuadrant[];	            //List of all switches in quadrant.
	public ArrayList<Train> trainsInQuadrant;		//List of all trains in quadrant
	public Block enterBlock;						//Block where trains enter quadrant
	public Block exitBlock;							//Block where trains leave quadrant
	

	
	/* Track Controller Constructor */
	public TrackController(int initID, Block initBlocks[], Switch initSwitches[], ArrayList<Train> initTrains, Block initEnter, Block initExit)
	{
		tcID = initID;
		trackBlocks = initBlocks;
		switchesInQuadrant = initSwitches;
		trainsInQuadrant = initTrains;
		enterBlock = initEnter;
		exitBlock = initExit;
		
		
	}
	
	public void testPLC(){
		
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("TEST CASE");

			scanner.nextLine();

			Train demoTrain = new Train(2,trackBlocks[0],1,20,trackBlocks[15]);
			
			demoTrain.printInfo();

			
			for(int i = 0; i<15; i++){
				
				System.out.println("Press enter to continue.");
				scanner.nextLine();
				
				demoTrain.moveTrain(trackBlocks[i], trackBlocks[i+1], 1, 20);
				demoTrain.printInfo();
				trackBlocks[i].printInfo();
				trackBlocks[i+1].printInfo();
				trackBlocks[i+2].printInfo();		
				
				
			}	
		

	}
	

}
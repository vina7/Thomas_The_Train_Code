import java.util.ArrayList;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;


public class Init {
	
	
	TrackController region1;
	TrackController region2;
	TrackController region3;
	TrackController region4;

	public static void main(String[] args){
		
		// Create an instance of the AddPLC GUI. 
		GUI addPLC = new GUI();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI addPLC = new GUI();
					addPLC.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		initTC();

	}

	public static void initTC(){
		
		/* Initialization of 4 quadrants */
		ArrayList<TrackController> plcList = new ArrayList<TrackController>();

		/* Quadrant 1:
		 * Red line sections: A B C D E F U
		 * Blocks 1-20, 77 + entry, exit blocks
		 * */
		int initID1 = 1;
		Block initBlocks1[] = new Block[100];		
		Switch initSwitches1[] = new Switch[100];
		ArrayList<Train> initTrains1 = new ArrayList<Train>();
		Block initEnter1 = null;
		Block initExit1 = null;	
		TrackController region1 = new TrackController(initID1,initBlocks1,initSwitches1,initTrains1,initEnter1,initExit1);
		
		/* Quadrant 2:
		 * Red line sections: G H I J K L N M O P Q R S T
		 * Blocks 21-76 + entry, exit blocks
		 * */
		int initID2 = 2;
		Block initBlocks2[] = new Block[100];
		Switch initSwitches2[] = new Switch[100];
		ArrayList<Train> initTrains2 = new ArrayList<Train>();
		Block initEnter2 = null;
		Block initExit2 = null;	
		TrackController region2 = new TrackController(initID2,initBlocks2,initSwitches2,initTrains2,initEnter2,initExit2);
		
		/* Quadrant 3:
		 * Green line sections: A B C D E F
		 * */
		int initID3 = 3;
		Block initBlocks3[] = new Block[100];

		for(int i = 0; i<28; i++){
			initBlocks3[i] = new Block((i+1),initID3,null,null,false,null);
		}
		initBlocks3[1].setStation(true);
		initBlocks3[8].setStation(true);
		
		initSwitches2[0] = new Switch(12,13,1);
		
		initBlocks3[0].setSwitchDestination(initSwitches2[0]);
		initBlocks3[12].setSwitchDestination(initSwitches2[0]);
		initBlocks3[11].setSwitchSource(initSwitches2[0]);

		Crossing initCrossing = new Crossing(19);
		initBlocks3[18].setCrossing(initCrossing);

		Switch initSwitches3[] = new Switch[100];
		ArrayList<Train> initTrains3 = new ArrayList<Train>();
		Block initEnter3 = null;
		Block initExit3 = null;	
		TrackController region3 = new TrackController(initID3,initBlocks3,initSwitches3,initTrains3,initEnter3,initExit3);
		region3.testPLC();
		
		/* Quadrant 4:
		 * Green line sections: G H I J K L M N O P Q R S T U V W X Y Z
		 * */
		int initID4 = 4;
		Block initBlocks4[] = new Block[100];
		Switch initSwitches4[] = new Switch[100];
		ArrayList<Train> initTrains4 = new ArrayList<Train>();
		Block initEnter4 = null;
		Block initExit4 = null;	
		TrackController region4 = new TrackController(initID4,initBlocks4,initSwitches4,initTrains4,initEnter4,initExit4);
		 
	
			
	}

}
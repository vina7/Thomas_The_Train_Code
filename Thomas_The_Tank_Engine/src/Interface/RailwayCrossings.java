package Interface;

import java.util.ArrayList;

import CTC_office.AllTrackBlock;
import CTC_office.TrackBlock;

/**
 * The CTC and Track Controller Railroad Interface
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class RailwayCrossings {
	ArrayList<Integer> Greencrossinglocations;
	ArrayList<Integer> Redcrossinglocations;
	AllTrackBlock Blocks;
	private static RailwayCrossings instance = null;
	boolean DebugMode;

	/**
	 * Constructor
	 * 
	 * @param DebugMode
	 *            Used to debug the system
	 */
	protected RailwayCrossings(boolean DebugMode) {
		Greencrossinglocations = new ArrayList<Integer>();
		Redcrossinglocations = new ArrayList<Integer>();
		this.DebugMode = DebugMode;
	}

	/**
	 * Creates a singleton of the class
	 * 
	 * @param DebugMode
	 *            Used to debug the system
	 * @return Instance Returns the instance of the class
	 */
	public static RailwayCrossings getInstance(boolean DebugMode) {
		if (instance == null) {
			instance = new RailwayCrossings(DebugMode);
		}
		return instance;
	}

	/**
	 * Updates the blocks the railway crossing is located on
	 * 
	 * @param Blocks
	 *            The Track Block object
	 * @param Line
	 *            The block's line
	 */
	public void updateBlocks(AllTrackBlock Blocks, String Line) {
		this.Blocks = Blocks;
		updateCrossingLocations(Line);
	}

	/**
	 * Updates the Railroad crossing locations
	 * 
	 * @param Line
	 *            Railroad crossing line
	 */
	private void updateCrossingLocations(String Line) {
		if (Line.equals("Green")) {
			ArrayList<TrackBlock> GreenTrack = Blocks.getGreenTrack();
			for (int i = 0; i < GreenTrack.size(); i++) {
				if (GreenTrack.get(i).getInfrastructure().equals("RAILWAY CROSSING")) {
					Greencrossinglocations.add(GreenTrack.get(i).getBlockNum());
				}
			}

		}
		if (Line.equals("Red")) {
			ArrayList<TrackBlock> RedTrack = Blocks.getRedTrack();
			for (int i = 0; i < RedTrack.size(); i++) {
				if (RedTrack.get(i).getInfrastructure().equals("RAILWAY CROSSING")) {
					Redcrossinglocations.add(RedTrack.get(i).getBlockNum());
				}
			}

		}
	}

	/**
	 * Gets the Green railroading crossing location array list
	 * 
	 * @return Greencrossinglocations array list
	 */
	public ArrayList<Integer> getGreencrossinglocations() {
		return Greencrossinglocations;
	}

	/**
	 * Gets the Red railroading crossing location array list
	 * 
	 * @return Redcrossinglocations array list
	 */
	public ArrayList<Integer> getRedcrossinglocations() {
		return Redcrossinglocations;
	}

	/**
	 * Sets the railroad crossing locations
	 * 
	 * @param RailroadCross
	 *            Position
	 * @param BlockNum
	 *            Crossing Block number
	 * @param Line
	 *            Crossing Line
	 */
	public void setCrossingPosition(String RailroadCross, int BlockNum, String Line) {
		Blocks.setRailroadCross(RailroadCross, BlockNum, Line);
	}

	/**
	 * Gets the updated block object
	 * 
	 * @return Blocks Block object
	 */
	public AllTrackBlock getupdatedBlock() {
		return Blocks;
	}

}

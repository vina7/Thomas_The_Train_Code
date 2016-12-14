package CTC_office;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores the information of the system's track blocks
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class AllTrackBlock {
	private static AllTrackBlock instance = null;
	ArrayList<TrackBlock> GreenTrack;
	ArrayList<TrackBlock> RedTrack;
	ArrayList<BrokenTracks> BrokenRails;
	boolean DebugMode;

	/**
	 * Constructor
	 * 
	 * @param DebugMode
	 *            Used as a way to debug the system
	 */
	protected AllTrackBlock(boolean DebugMode) {
		GreenTrack = new ArrayList<TrackBlock>();
		RedTrack = new ArrayList<TrackBlock>();
		BrokenRails = new ArrayList<BrokenTracks>();
	}

	/**
	 * Returns the list of green tracks in the system
	 * 
	 * @return GreenTrain
	 */
	public ArrayList<TrackBlock> getGreenTrack() {
		return GreenTrack;
	}

	/**
	 * Returns the list of red tracks in the system
	 * 
	 * @return GreenTrain
	 */
	public ArrayList<TrackBlock> getRedTrack() {
		return RedTrack;
	}

	/**
	 * Returns the list of broken tracks in the system
	 * 
	 * @return GreenTrain
	 */
	public ArrayList<BrokenTracks> getBrokenRails() {
		return BrokenRails;
	}

	/**
	 * Gets instance of this class
	 * 
	 * @param DebugMode
	 *            Used as a way to debug the system
	 * @return instance
	 */
	public static AllTrackBlock getInstance(boolean DebugMode) {
		if (instance == null) {
			instance = new AllTrackBlock(DebugMode);
		}
		return instance;
	}

	/**
	 * Adds blocks to the track list
	 * 
	 * @param Line
	 *            block's line
	 * @param Section
	 *            block's section
	 * @param BlockNum
	 *            block's block number
	 * @param BlockLen
	 *            block's length
	 * @param BlockGrade
	 *            block's grade
	 * @param SpeedLimit
	 *            block's speed limit
	 * @param Infrastructure
	 *            block's infrastructure
	 * @param Elevation
	 *            block's elevation
	 * @param CumElevation
	 *            block's cumulative elevation
	 * @param SwitchBlock
	 *            if the block is a switch block
	 * @param ArrowDirection
	 *            block's arrow direction
	 * @param SwitchPosition
	 *            block's switch position
	 * @param Closed
	 *            if the block is closed
	 * @param ClosedTime
	 *            time block was closed
	 * @param Broken
	 *            if the block is broken
	 * @param RailroadCross
	 *            if the block is a railroad crossing
	 * @param TimeToFixRail
	 *            time to fix the block
	 */
	public void addBlock(String Line, String Section, int BlockNum, int BlockLen, double BlockGrade, double SpeedLimit,
			String Infrastructure, double Elevation, double CumElevation, String SwitchBlock, String ArrowDirection,
			String SwitchPosition, boolean Closed, int ClosedTime, boolean Broken, String RailroadCross,
			int TimeToFixRail) {
		if (Line.equals("Green")) {

			TrackBlock newBlock = new TrackBlock(Line, Section, BlockNum, BlockLen, BlockGrade, SpeedLimit,
					Infrastructure, Elevation, CumElevation, SwitchBlock, ArrowDirection, SwitchPosition, Closed,
					ClosedTime, Broken, RailroadCross, TimeToFixRail);
			GreenTrack.add(newBlock);

		} else if (Line.equals("Red")) {
			TrackBlock newBlock = new TrackBlock(Line, Section, BlockNum, BlockLen, BlockGrade, SpeedLimit,
					Infrastructure, Elevation, CumElevation, SwitchBlock, ArrowDirection, SwitchPosition, Closed,
					ClosedTime, Broken, RailroadCross, TimeToFixRail);
			RedTrack.add(newBlock);
		}

	}

	/**
	 * Reset a track line
	 * 
	 * @param Line
	 *            block's line
	 */
	public void resetTracks(String Line) {
		if (Line.equals("Green")) {
			GreenTrack = new ArrayList<TrackBlock>();
		} else if (Line.equals("Red")) {
			RedTrack = new ArrayList<TrackBlock>();
		}
	}

	/**
	 * Gets the station's block number
	 * 
	 * @param station
	 *            block's station
	 * @param Line
	 *            block's line
	 * @return Block number
	 */
	public int getBlockNum(String station, String Line) {
		if (Line.equalsIgnoreCase("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				if (GreenTrack.get(i).getInfrastructure().equalsIgnoreCase(station)) {
					return GreenTrack.get(i).getBlockNum();
				}
			}
		} else if (Line.equalsIgnoreCase("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				if (RedTrack.get(i).getInfrastructure().equalsIgnoreCase(station)) {
					return RedTrack.get(i).getBlockNum();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets the station's block number
	 * 
	 * @param schedule
	 *            train's schedule
	 * @return block number
	 */
	public int getBlockNum(ScheduleInfo schedule) {
		if (schedule.getLine().equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				if (GreenTrack.get(i).getInfrastructure().equals(schedule.getStation())) {
					return GreenTrack.get(i).getBlockNum();
				}
			}
		} else if (schedule.getLine().equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				if (RedTrack.get(i).getInfrastructure().equals(schedule.getStation())) {
					return RedTrack.get(i).getBlockNum();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets the block's length
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return block length
	 */
	public int getBlockLen(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getBlockLen();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getBlockLen();
				}
			}
		}
		return -1;

	}

	/**
	 * Gets the block's section
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return block's section
	 */
	public String getSection(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getSection();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getSection();
				}
			}
		}
		return null;

	}

	/**
	 * Get the block's grade
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return block grade
	 */
	public double getBlockGrade(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getBlockGrade();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getBlockGrade();
				}
			}
		}
		return -1;

	}

	/**
	 * Get the train's Speed Limit
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return speed limit
	 */
	public double getSpeedLimit(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getSpeedLimit();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getSpeedLimit();
				}
			}
		}
		return -1;

	}

	/**
	 * Gets the block's infrastructure
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return Infrastructure
	 */
	public String getInfrastructure(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getInfrastructure();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getInfrastructure();
				}
			}
		}
		return null;

	}

	/**
	 * Gets the block elevation
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return elevation
	 */
	public double getElevation(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getElevation();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getElevation();
				}
			}
		}
		return -1;

	}

	/**
	 * Gets the cumulative elevation
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return cumulative elevation
	 */
	public double getCumElevation(int BlockNum, String Line) {

		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getCumElevation();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getCumElevation();
				}
			}
		}
		return -1;

	}

	/**
	 * Gets the block switch block
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return switch blocks
	 */
	public String getSwitchBlock(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getSwitchBlock();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getSwitchBlock();
				}
			}
		}
		return null;

	}

	/**
	 * Get the block's arrow direction
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return arrow direction
	 */
	public String getArrowDirection(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getArrowDirection();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getArrowDirection();
				}
			}
		}
		return null;

	}

	/**
	 * Gets the block switch position
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return switch position
	 */
	public String getSwitchPosition(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getSwitchPosition();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getSwitchPosition();
				}
			}
		}
		return null;

	}

	/**
	 * Gets whether the block is closed
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return Closed
	 */
	public boolean getClosed(int BlockNum, String Line) {
		BrokenTracks tracks;
		for (int i = 0; i < BrokenRails.size(); i++) {
			tracks = BrokenRails.get(i);
			if (tracks.getLine().equalsIgnoreCase(Line)) {
				if (tracks.getBlockNum() == BlockNum) {
					return tracks.getClosed();
				}
			}
		}
		return false;

	}

	/**
	 * gets the time the block was closed
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return closed time
	 */
	public int getClosedTime(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getClosedTime();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getClosedTime();
				}
			}
		}
		return -1;

	}

	/**
	 * Gets whether the block is broken
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return broken
	 */
	public boolean getBroken(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getBroken();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getBroken();
				}
			}
		}
		return true;

	}

	/**
	 * Gets whether the block is a railroad crossing
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return Railroadcroess
	 */
	public String getRailroadCross(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getRailroadCross();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getRailroadCross();
				}
			}
		}
		return null;

	}

	/**
	 * gets time to fix a broken rail
	 * 
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 * @return time to fix broken rails
	 */
	public int getTimeToFixRail(int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getTimeToFixRail();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					return temp.getTimeToFixRail();
				}
			}
		}
		return -1;

	}

	/**
	 * Sets the blocks switch position
	 * 
	 * @param SwitchPosition
	 *            block's switch position
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 */
	public void setSwitchPosition(String SwitchPosition, int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setSwitchPosition(SwitchPosition);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setSwitchPosition(SwitchPosition);
				}
			}
		}
	}

	/**
	 * Sets if the track is closed
	 * 
	 * @param Closed
	 *            if track is closed
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 */
	public void setClosed(boolean Closed, int BlockNum, String Line) {
		TrackBlock temp;
		BrokenTracks tracks;
		for (int i = 0; i < BrokenRails.size(); i++) {
			tracks = BrokenRails.get(i);
			if (tracks.getLine().equalsIgnoreCase(Line)) {
				if (tracks.getBlockNum() == BlockNum) {
					tracks.setClosed(Closed);
				}
			}
		}
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setClosed(Closed);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setClosed(Closed);
				}
			}
		}
	}

	/**
	 * Sets the block's closed time
	 * 
	 * @param ClosedTime
	 *            block's closed time
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 */
	public void setClosedTime(int ClosedTime, int BlockNum, String Line) {
		TrackBlock temp;
		BrokenTracks tracks;
		for (int i = 0; i < BrokenRails.size(); i++) {
			tracks = BrokenRails.get(i);
			if (tracks.getLine().equalsIgnoreCase(Line)) {
				if (tracks.getBlockNum() == BlockNum) {
					tracks.setClosedTime(ClosedTime);
				}
			}
		}
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setClosedTime(ClosedTime);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setClosedTime(ClosedTime);
				}
			}
		}
	}

	/**
	 * Set is the block is broken
	 * 
	 * @param Broken
	 *            if the block is broken
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 */
	public void setBroken(boolean Broken, int BlockNum, String Line) {
		TrackBlock temp;
		int fixtime = (int) ((Math.random() * 100) + 1);
		this.setTimeToFixRail(fixtime, BlockNum, Line);
		BrokenTracks tracks = new BrokenTracks(Line, BlockNum, fixtime, false, 0, true);
		BrokenRails.add(tracks);
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setBroken(Broken);

				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setBroken(Broken);
				}
			}
		}
	}

	/**
	 * Removes broken blocks
	 * 
	 * @param Broken
	 *            if block is not broken anymore
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 */
	public void removeBroken(boolean Broken, int BlockNum, String Line) {
		TrackBlock temp;
		BrokenTracks tracks;
		for (int i = 0; i < BrokenRails.size(); i++) {
			tracks = BrokenRails.get(i);
			if (tracks.getLine().equalsIgnoreCase(Line)) {
				if (tracks.getBlockNum() == BlockNum) {
					BrokenRails.remove(i);
				}
			}
		}
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setBroken(Broken);

				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setBroken(Broken);
				}
			}
		}
	}

	/**
	 * Sets the track railroad crossing locations
	 * 
	 * @param RailroadCross
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 */
	public void setRailroadCross(String RailroadCross, int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setRailroadCross(RailroadCross);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setRailroadCross(RailroadCross);
				}
			}
		}
	}

	/**
	 * Sets time to fix broken rails
	 * 
	 * @param TimeToFixRail
	 *            block's time to fix
	 * @param BlockNum
	 *            block's number
	 * @param Line
	 *            block's line
	 */
	private void setTimeToFixRail(int TimeToFixRail, int BlockNum, String Line) {
		TrackBlock temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrack.size(); i++) {
				temp = GreenTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setTimeToFixRail(TimeToFixRail);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrack.size(); i++) {
				temp = RedTrack.get(i);
				if (temp.getBlockNum() == BlockNum) {
					temp.setTimeToFixRail(TimeToFixRail);
				}
			}
		}
	}
}

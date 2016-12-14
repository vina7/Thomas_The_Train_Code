package CTC_office;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores the information of the system's trains
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class AllTrains {
	private static AllTrains instance = null;
	ArrayList<Trains> GreenTrain;
	ArrayList<Trains> RedTrain;
	boolean DebugMode;

	/**
	 * Constructor
	 * 
	 * @param DebugMode
	 *            Used as a way to debug the system
	 */
	protected AllTrains(boolean DebugMode) {
		this.GreenTrain = new ArrayList<Trains>();
		this.RedTrain = new ArrayList<Trains>();
		this.DebugMode = DebugMode;
	}

	/**
	 * Returns the list of green trains in the system
	 * 
	 * @return GreenTrain
	 */
	public ArrayList<Trains> getGreenTrain() {
		return GreenTrain;
	}

	/**
	 * Returns the list of red trains in the system
	 * 
	 * @return RedTrain
	 */
	public ArrayList<Trains> getRedTrain() {
		return RedTrain;
	}

	/**
	 * Gets instance of this class
	 * 
	 * @param DebugMode
	 *            Used as a way to debug the system
	 * @return instance
	 */
	public static AllTrains getInstance(boolean DebugMode) {
		if (instance == null) {
			instance = new AllTrains(DebugMode);
		}
		return instance;
	}

	/**
	 * Adds a train to the list
	 * 
	 * @param color
	 *            Train's color
	 * @param ID
	 *            Train's ID
	 * @param Speed
	 *            Train's speed
	 * @param Authority
	 *            Train's authority
	 * @param Direction
	 *            Train's direction
	 * @param PrevSection
	 *            Train's previous section
	 * @param Section
	 *            Train's section
	 * @param BlockNum
	 *            Train's block number
	 * @param BlockLen
	 *            Train's block length
	 * @param BlockGrade
	 *            Train's block grade
	 * @param BlockSpeedLim
	 *            Train's block speed limit
	 * @param Elevation
	 *            Train's elevation
	 * @param Retire
	 *            Train's retire status
	 * @param Status
	 *            Train's status
	 * @param Station
	 *            Train's section
	 * @param DestBlock
	 *            Train's destination block
	 * @param TrainSchedule
	 *            Train's schedule
	 * @param UserSetSpeed
	 *            User set the speed
	 * @param UserSetDest
	 *            User set the destination
	 * @param DisplaySpeed
	 *            Train's display speed
	 * @param StationNum
	 *            Train's station number
	 */
	public void addTrain(Color color, int ID, int Speed, int Authority, String Direction, String PrevSection,
			String Section, int BlockNum, int BlockLen, double BlockGrade, int BlockSpeedLim, double Elevation,
			boolean Retire, String Status, String Station, int DestBlock, List<ScheduleInfo> TrainSchedule,
			boolean UserSetSpeed, boolean UserSetDest, int DisplaySpeed, int StationNum) {
		if (TrainSchedule.get(0).getLine().equals("Green")) {
			Trains newTrain = new Trains(color, ID, Speed, Authority, Direction, PrevSection, Section, BlockNum,
					BlockLen, BlockGrade, BlockSpeedLim, Elevation, Retire, Status, Station, DestBlock, TrainSchedule,
					UserSetSpeed, UserSetDest, DisplaySpeed, StationNum);
			GreenTrain.add(newTrain);

		} else if (TrainSchedule.get(0).getLine().equals("Red")) {
			Trains newTrain = new Trains(color, ID, Speed, Authority, Direction, PrevSection, Section, BlockNum,
					BlockLen, BlockGrade, BlockSpeedLim, Elevation, Retire, Status, Station, DestBlock, TrainSchedule,
					UserSetSpeed, UserSetDest, DisplaySpeed, StationNum);
			RedTrain.add(newTrain);
		}

	}

	/**
	 * Gets trains color
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return Color
	 */
	public Color getColor(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getColor();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getColor();
				}
			}
		}
		return null;

	}

	/**
	 * Get Train's status
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return Status
	 */
	public String getStatus(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getStatus();
				}
			}
		} else {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getStatus();
				}
			}
		}
		return null;

	}

	/**
	 * Gets train's speed
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return Speed
	 */
	public int getSpeed(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getSpeed();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getSpeed();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets the train's display speed
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return Display Speed
	 */
	public int getDisplaySpeed(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getDisplaySpeed();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getDisplaySpeed();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets the train's authority
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return Authority
	 */
	public int getAuthority(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getAuthority();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getAuthority();
				}
			}
		}
		return -1;
	}

	/**
	 * Get the train's direction
	 * 
	 * @param ID
	 *            train's id
	 * @param Line
	 *            Train's line
	 * @return direction
	 */
	public String getDirection(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getDirection();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getDirection();
				}
			}
		}

		return null;
	}

	/**
	 * Get train's previous section
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return previous section
	 */
	public String getPrevSection(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getPrevSection();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getPrevSection();
				}
			}
		}
		return null;
	}

	/**
	 * Gets train's section
	 * 
	 * @param ID
	 *            Train's Id
	 * @param Line
	 *            Train's line
	 * @return section
	 */
	public String getSection(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getSection();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getSection();
				}
			}
		}
		return null;
	}

	/**
	 * Gets the train's block number
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return train's block number
	 */
	public int getBlockNum(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getBlockNum();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getBlockNum();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets the train current block's length
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return Block Length
	 */
	public int getBlockLen(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getBlockLen();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getBlockLen();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets the train's block grade
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return block grade
	 */
	public double getBlockGrade(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getBlockGrade();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getBlockGrade();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets the blocks speed limit
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's Line
	 * @return Speed Limit
	 */
	public int getBlockSpeedLim(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getBlockSpeedLim();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getBlockSpeedLim();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets train's elevation
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return Elevation
	 */
	public double getElevation(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getElevation();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getElevation();
				}
			}
		}
		return -1;
	}

	/**
	 * Get train's retired status
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return retire
	 */
	public boolean getRetire(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getRetire();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getRetire();
				}
			}
		}
		return true;
	}

	/**
	 * Gets the train's station
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return Station
	 */
	public String getStation(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getStation();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getStation();
				}
			}
		}
		return null;
	}

	/**
	 * Get train's station number
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return station number
	 */
	public int getStationNum(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getStationNum();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getStationNum();
				}
			}
		}
		return -1;
	}

	/**
	 * Sets the train's status
	 * 
	 * @param Status
	 *            Train's status
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setStatus(String Status, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setStatus(Status);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setStatus(Status);
				}
			}
		}
	}

	/**
	 * Get the train's destination block
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return destination block
	 */
	public int getDestBlock(int ID, String Line) {
		Trains temp;
		if (Line.equalsIgnoreCase("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getDestBlock();
				}
			}
		} else if (Line.equalsIgnoreCase("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getDestBlock();
				}
			}
		}
		return -1;
	}

	/**
	 * Gets the train schedule
	 * 
	 * @param ID
	 *            Train's id
	 * @return Train schedule
	 */
	public List<ScheduleInfo> getTrainSchedule(int ID) {
		Trains temp;
		for (int i = 0; i < GreenTrain.size(); i++) {
			temp = GreenTrain.get(i);
			if (temp.getID() == ID) {
				return temp.getTrainSchedule();
			}
		}
		for (int i = 0; i < RedTrain.size(); i++) {
			temp = RedTrain.get(i);
			if (temp.getID() == ID) {
				return temp.getTrainSchedule();
			}
		}
		return null;
	}

	/**
	 * Get if the user set the speed
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return User set speed
	 */
	public boolean getUserSetSpeed(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getUserSetSpeed();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getUserSetSpeed();
				}
			}
		}
		return false;
	}

	/**
	 * Get if the user set the authority
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return User set Authority
	 */
	public boolean getUserSetAth(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getUserSetAth();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getUserSetAth();
				}
			}
		}
		return false;
	}

	/**
	 * Get if the user set the destination
	 * 
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 * @return User set destination
	 */
	public boolean getUserSetDest(int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getUserSetDest();
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					return temp.getUserSetDest();
				}
			}
		}
		return false;
	}

	/**
	 * Set the train's speed
	 * 
	 * @param Speed
	 *            Train's speed
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setSpeed(int Speed, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setSpeed(Speed);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setSpeed(Speed);
				}
			}
		}
	}

	/**
	 * Set the display speed
	 * 
	 * @param DisplaySpeed
	 *            Train's display speed
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setDisplaySpeed(int DisplaySpeed, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setDisplaySpeed(DisplaySpeed);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setDisplaySpeed(DisplaySpeed);
				}
			}
		}
	}

	/**
	 * Set the train's authority
	 * 
	 * @param Authority
	 *            Train's authority
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setAuthority(int Authority, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setAuthority(Authority);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setAuthority(Authority);
				}
			}
		}
	}

	/**
	 * Set the train's direction
	 * 
	 * @param Direction
	 *            Train's direction
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setDirection(String Direction, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setDirection(Direction);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setDirection(Direction);
				}
			}
		}
	}

	/**
	 * Set train's previous section
	 * 
	 * @param PrevSection
	 *            Train's previous section
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setPrevSection(String PrevSection, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setPrevSection(PrevSection);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setPrevSection(PrevSection);
				}
			}
		}
	}

	/**
	 * Set the train section
	 * 
	 * @param Section
	 *            Train's section
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's id
	 */
	public void setSection(String Section, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setSection(Section);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setSection(Section);
				}
			}
		}
	}

	/**
	 * Set the train's block number
	 * 
	 * @param BlockNum
	 *            Train's block number
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setBlockNum(int BlockNum, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setBlockNum(BlockNum);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setBlockNum(BlockNum);
				}
			}
		}
	}

	/**
	 * Set the train's block length
	 * 
	 * @param BlockLen
	 *            Train's block length
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setBlockLen(int BlockLen, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setBlockLen(BlockLen);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setBlockLen(BlockLen);
				}
			}
		}
	}

	/**
	 * Set the train's block grade
	 * 
	 * @param BlockGrade
	 *            Train's block grade
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setBlockGrade(double BlockGrade, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setBlockGrade(BlockGrade);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setBlockGrade(BlockGrade);
				}
			}
		}
	}

	/**
	 * Set the train's block speed limit
	 * 
	 * @param BlockSpeedLim
	 *            Train's block speed limit
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setBlockSpeedLim(int BlockSpeedLim, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setBlockSpeedLim(BlockSpeedLim);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setBlockSpeedLim(BlockSpeedLim);
				}
			}
		}
	}

	/**
	 * Set the train's elevation
	 * 
	 * @param Elevation
	 *            Train's elevation
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setElevation(double Elevation, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setElevation(Elevation);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setElevation(Elevation);
				}
			}
		}
	}

	/**
	 * Set if the train is retired
	 * 
	 * @param Retire
	 *            Train's retire status
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setRetire(boolean Retire, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setRetire(Retire);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setRetire(Retire);
				}
			}
		}
	}

	/**
	 * Set the train's station
	 * 
	 * @param Station
	 *            Train's station
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setStation(String Station, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setStation(Station);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setStation(Station);
				}
			}
		}
	}

	/**
	 * Sets the train's station number
	 * 
	 * @param StationNum
	 *            Train's station number
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setStationNum(int StationNum, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setStationNum(StationNum);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setStationNum(StationNum);
				}
			}
		}
	}

	/**
	 * Sets the train's destination block
	 * 
	 * @param DestBlock
	 *            Train's destination block
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setDestBlock(int DestBlock, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setDestBlock(DestBlock);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setDestBlock(DestBlock);
				}
			}
		}
	}

	/**
	 * Sets the train's schedule
	 * 
	 * @param TrainSchedule
	 *            train's schedule
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setTrainSchedule(List<ScheduleInfo> TrainSchedule, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setTrainSchedule(TrainSchedule);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setTrainSchedule(TrainSchedule);
				}
			}
		}
	}

	/**
	 * Sets if the user set the speed
	 * 
	 * @param UserSetSpeed
	 *            Train's UserSetSpeed
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setUserSetSpeed(boolean UserSetSpeed, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setUserSetSpeed(UserSetSpeed);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setUserSetSpeed(UserSetSpeed);
				}
			}
		}
	}

	/**
	 * Sets if the user set the authority
	 * 
	 * @param UserSetAuth
	 *            Train's UseSetAuth
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setUserSetAth(boolean UserSetAuth, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setUserSetAth(UserSetAuth);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setUserSetAth(UserSetAuth);
				}
			}
		}
	}

	/**
	 * Sets if the user set the train's destination
	 * 
	 * @param UserSetDest
	 *            train's UserSetDest
	 * @param ID
	 *            Train's id
	 * @param Line
	 *            Train's line
	 */
	public void setUserSetDest(boolean UserSetDest, int ID, String Line) {
		Trains temp;
		if (Line.equals("Green")) {
			for (int i = 0; i < GreenTrain.size(); i++) {
				temp = GreenTrain.get(i);
				if (temp.getID() == ID) {
					temp.setUserSetDest(UserSetDest);
				}
			}
		} else if (Line.equals("Red")) {
			for (int i = 0; i < RedTrain.size(); i++) {
				temp = RedTrain.get(i);
				if (temp.getID() == ID) {
					temp.setUserSetDest(UserSetDest);
				}
			}
		}
	}
}

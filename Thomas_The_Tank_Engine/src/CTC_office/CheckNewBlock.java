package CTC_office;

import java.util.ArrayList;

import Interface.CTC_TC_Trains;
import Interface.CTCandTrackControllerInterface;
import Interface.Route;
import Interface.TrackCircuit;

/**
 * Checks to see if a train has moved to a new block
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class CheckNewBlock {
	/**
	 * Constructor
	 */
	public CheckNewBlock() {

	}

	/**
	 * Checks if the train has moved to a new block
	 * 
	 * @param circuit
	 *            TrackCircuit object
	 * @param ID
	 *            Train's id
	 * @param train
	 *            AllTrains object
	 * @param Blocks
	 *            AllTrackBlock object
	 * @param map
	 *            CTCMapUI object
	 * @param mode
	 *            The CTC's mode
	 * @param TCinterface
	 *            CTCandTrackControllerInterface object
	 * @return train
	 */
	public AllTrains check(TrackCircuit circuit, int ID, AllTrains train, AllTrackBlock Blocks, CTCMapUI map,
			boolean mode, CTCandTrackControllerInterface TCinterface) {
		Route ourroute = new Route();
		SetDestination dest = new SetDestination();
		if (!(Blocks.getClosed(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()),
				train.getTrainSchedule(ID).get(0).getLine()))) {
			if (circuit.getDisplacement(ID) >= train.getBlockLen(ID, train.getTrainSchedule(ID).get(0).getLine())) {
				circuit.resetDisplacement(ID);
				ArrayList<TrackBlock> Track = null;
				if (train.getTrainSchedule(ID).get(0).getLine().equals("Green")) {

					Track = Blocks.getGreenTrack();
					int curEntry = ourroute.getGreenEntryBlock(train.getPrevSection(ID, "Green"),
							train.getSection(ID, "Green"));
					int curExit = ourroute.getGreenExitBlock(train.getPrevSection(ID, "Green"),
							train.getSection(ID, "Green"));
					boolean direction = ourroute.getGreendirect(train.getPrevSection(ID, "Green"),
							train.getSection(ID, "Green"));
					String NextSection = ourroute.getNextGreen(train.getPrevSection(ID, "Green"),
							train.getSection(ID, "Green"));
					if (train.getBlockNum(ID, "Green") == curExit) {
						train.setBlockNum(ourroute.getGreenEntryBlock(train.getSection(ID, "Green"), NextSection), ID,
								"Green");
						train.setPrevSection(train.getSection(ID, "Green"), ID, "Green");
						train.setSection(NextSection, ID, "Green");
						map.updateColor(train.getSection(ID, "Green"), train.getPrevSection(ID, "Green"), "Green",
								train.getColor(ID, "Green"));

					} else {
						if (direction) {

							train.setBlockNum(train.getBlockNum(ID, "Green") - 1, ID, "Green");
						} else {

							train.setBlockNum(train.getBlockNum(ID, "Green") + 1, ID, "Green");
						}
					}
					if (direction) {
						circuit.setDirection(true, ID);
					} else {
						circuit.setDirection(false, ID);
					}
				} else if (train.getTrainSchedule(ID).get(0).getLine().equals("Red")) {
					Track = Blocks.getRedTrack();
					int curEntry = ourroute.getRedEntryBlock(train.getPrevSection(ID, "Red"),
							train.getSection(ID, "Red"));
					int curExit = ourroute.getRedExitBlock(train.getPrevSection(ID, "Red"),
							train.getSection(ID, "Red"));
					boolean direction = ourroute.getReddirect(train.getPrevSection(ID, "Red"),
							train.getSection(ID, "Red"));
					String NextSection = ourroute.getNextRed(train.getPrevSection(ID, "Red"),
							train.getSection(ID, "Red"));
					if (train.getBlockNum(ID, "Red") == curExit) {
						train.setBlockNum(ourroute.getRedEntryBlock(train.getSection(ID, "Red"), NextSection), ID,
								"Red");
						train.setPrevSection(train.getSection(ID, "Red"), ID, "Red");
						train.setSection(NextSection, ID, "Red");
						map.updateColor(train.getSection(ID, "Red"), train.getPrevSection(ID, "Red"), "Red",
								train.getColor(ID, "Red"));
					} else {
						if (direction) {
							train.setBlockNum(train.getBlockNum(ID, "Red") - 1, ID, "Red");
						} else {
							train.setBlockNum(train.getBlockNum(ID, "Red") + 1, ID, "Red");
						}
					}
					if (direction) {
						circuit.setDirection(true, ID);
					} else {
						circuit.setDirection(false, ID);
					}

				}
				train = dest.checkPastDestionation(ID, train, Blocks, circuit.getDirection(ID), TCinterface);
				train.setBlockGrade(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1)
						.getBlockGrade(), ID, train.getTrainSchedule(ID).get(0).getLine());
				train.setBlockLen(
						Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1).getBlockLen(),
						ID, train.getTrainSchedule(ID).get(0).getLine());
				train.setElevation(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1)
						.getElevation(), ID, train.getTrainSchedule(ID).get(0).getLine());
				train.setSection(
						Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1).getSection(),
						ID, train.getTrainSchedule(ID).get(0).getLine());
				train.setBlockSpeedLim((int) Track
						.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1).getSpeedLimit(),
						ID, train.getTrainSchedule(ID).get(0).getLine());
				train.setDirection(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1)
						.getArrowDirection(), ID, train.getTrainSchedule(ID).get(0).getLine());
				if (!(train.getUserSetSpeed(ID, train.getTrainSchedule(ID).get(0).getLine()) && mode)) {
					train.setSpeed(
							(int) (Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1)
									.getSpeedLimit()),
							ID, train.getTrainSchedule(ID).get(0).getLine());
				}
				if (train.getSpeed(ID, train.getTrainSchedule(ID).get(0).getLine()) == 0) {

					train.setSpeed(
							(int) (Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1)
									.getSpeedLimit()),
							ID, train.getTrainSchedule(ID).get(0).getLine());
				}
				if (Blocks.getClosed(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()),
						train.getTrainSchedule(ID).get(0).getLine())) {
					train.setSpeed(0, ID, train.getTrainSchedule(ID).get(0).getLine());
				}
				if (!(train.getUserSetAth(ID, train.getTrainSchedule(ID).get(0).getLine()) && mode)) {
					train.setAuthority(
							(int) (((Math.pow(
									(Track.get(train.getBlockNum(ID, train.getTrainSchedule(ID).get(0).getLine()) - 1)
											.getSpeedLimit()) * .447,
									2)) / (2 * 1.2)) * 3.3),
							ID, train.getTrainSchedule(ID).get(0).getLine());
				}
			}
		}
		train.setDisplaySpeed((int) (circuit.getDisplayDisplacement(ID) * 2.23), ID,
				train.getTrainSchedule(ID).get(0).getLine());
		if (train.getDisplaySpeed(ID, train.getTrainSchedule(ID).get(0).getLine()) <= 0) {
			train.setStatus("Stopped", ID, train.getTrainSchedule(ID).get(0).getLine());
		} else {
			train.setStatus("Good", ID, train.getTrainSchedule(ID).get(0).getLine());
		}
		return train;
	}
}

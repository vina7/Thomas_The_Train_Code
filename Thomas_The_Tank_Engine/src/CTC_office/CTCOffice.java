package CTC_office;

import javax.swing.JFrame;

import Interface.*;
import Overall_Sys.TimeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * The main ctc class
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class CTCOffice {
	private CTCOfficeLoginScreen LoginScreen;
	private CTCMapUI Mapwindow;
	private ClosedRails closerails;
	private CTCandTrackControllerInterface ctctcint = CTCandTrackControllerInterface.getInstance(false);
	private RailwayCrossings railways;
	private Switches switching = Switches.getInstance(false);
	private TrackCircuit circuit = TrackCircuit.getInstance(false);
	private AllTrackBlock Blocks = AllTrackBlock.getInstance(true);
	private CheckNewBlock newBlock = new CheckNewBlock();
	private ScheduleInfo sinfo;
	private SetDestination setD;
	private TrackModelFileParser TMparser;
	private TrainScheduleFileParser TSparser;
	private int mult = 0;
	private AllTrains train = AllTrains.getInstance(true);

	public static void main(String[] args) {
		CTCOffice myself = new CTCOffice();
		JFrame frame = new JFrame();
		TimeClass timer = TimeClass.getInstance(false);
		CTCMapUI mapwindow;
		CTCOfficeUI Mainwindow;
		try {
			myself.LoginScreen = new CTCOfficeLoginScreen();
			myself.LoginScreen.setSize(450, 300);
			myself.LoginScreen.setVisible(true);
			while (myself.LoginScreen.isDisplayable()) {
				System.out.print("");
			}
			mapwindow = new CTCMapUI();
			Mainwindow = new CTCOfficeUI(myself.train, myself.Blocks, myself, myself.circuit, mapwindow);

			while (true) {
				myself.Blocks = Mainwindow.getupdatedBlocks();
				boolean manualmode = Mainwindow.getMode();
				ArrayList<Trains> redlinetrains = myself.train.getRedTrain();
				for (int i = 0; i < redlinetrains.size(); i++) {
					mapwindow.updateColor(redlinetrains.get(i).getSection(), redlinetrains.get(i).getPrevSection(),
							"Red", redlinetrains.get(i).getColor());
					myself.train = myself.newBlock.check(myself.circuit, redlinetrains.get(i).getID(), myself.train,
							myself.Blocks, mapwindow, manualmode, myself.ctctcint);
					myself.circuit.setAuthority(myself.train.getAuthority(redlinetrains.get(i).getID(), "Red"),
							redlinetrains.get(i).getID());
					myself.circuit.setCurBlock(myself.train.getBlockNum(redlinetrains.get(i).getID(), "Red"),
							redlinetrains.get(i).getID());
					myself.circuit.setGrade(myself.train.getBlockGrade(redlinetrains.get(i).getID(), "Red"),
							redlinetrains.get(i).getID());
					myself.circuit.setSpeed(myself.train.getSpeed(redlinetrains.get(i).getID(), "Red"),
							redlinetrains.get(i).getID());
					if (myself.ctctcint.getActiveTrains().size() > 0) {
						myself.ctctcint.setBlockSpeedLim(redlinetrains.get(i).getID(),
								myself.train.getBlockSpeedLim(redlinetrains.get(i).getID(), "Red"));
						myself.ctctcint.setNextDestination(redlinetrains.get(i).getID(),
								myself.train.getDestBlock(redlinetrains.get(i).getID(), "Red"));
						myself.ctctcint.setNextStation(redlinetrains.get(i).getID(),
								myself.train.getStation(redlinetrains.get(i).getID(), "Red"));
					}
				}
				Mainwindow.updateTrains(myself.train);
				ArrayList<Trains> greenlinetrains = myself.train.getGreenTrain();
				for (int i = 0; i < greenlinetrains.size(); i++) {
					mapwindow.updateColor(greenlinetrains.get(i).getSection(), greenlinetrains.get(i).getPrevSection(),
							"Green", greenlinetrains.get(i).getColor());
					myself.train = myself.newBlock.check(myself.circuit, greenlinetrains.get(i).getID(), myself.train,
							myself.Blocks, mapwindow, manualmode, myself.ctctcint);
					myself.circuit.setAuthority(myself.train.getAuthority(greenlinetrains.get(i).getID(), "Green"),
							greenlinetrains.get(i).getID());
					myself.circuit.setCurBlock(myself.train.getBlockNum(greenlinetrains.get(i).getID(), "Green"),
							greenlinetrains.get(i).getID());
					myself.circuit.setGrade(myself.train.getBlockGrade(greenlinetrains.get(i).getID(), "Green"),
							greenlinetrains.get(i).getID());
					myself.circuit.setSpeed(myself.train.getSpeed(greenlinetrains.get(i).getID(), "Green"),
							greenlinetrains.get(i).getID());
					if (myself.ctctcint.getActiveTrains().size() > 0) {
						myself.ctctcint.setBlockSpeedLim(greenlinetrains.get(i).getID(),
								myself.train.getBlockSpeedLim(greenlinetrains.get(i).getID(), "Green"));
						myself.ctctcint.setNextDestination(greenlinetrains.get(i).getID(),
								myself.train.getDestBlock(greenlinetrains.get(i).getID(), "Green"));
						myself.ctctcint.setNextStation(greenlinetrains.get(i).getID(),
								myself.train.getStation(greenlinetrains.get(i).getID(), "Green"));
					}
				}
				Mainwindow.updateTrains(myself.train);
				myself.Blocks = myself.switching.getupdatedBlock();
				if (myself.Blocks.getRedTrack() != null) {
					Mainwindow.updateSwitchTable(myself.Blocks);

				}
				if (myself.Blocks.getGreenTrack() != null) {
					Mainwindow.updateSwitchTable(myself.Blocks);
				}

				if (myself.Blocks.getBrokenRails() != null) {
					ArrayList<BrokenTracks> Brokentracks = myself.Blocks.getBrokenRails();
					for (int i = 0; i < Brokentracks.size(); i++) {
						int overalltime = timer.getTime() - Brokentracks.get(i).getClosedTime();
						if (Brokentracks.get(i).getClosed()) {
							if (Brokentracks.get(i).getTimeToFixRail() < overalltime) {
								myself.Blocks.removeBroken(false, Brokentracks.get(i).getBlockNum(),
										Brokentracks.get(i).getLine());
								Mainwindow.updateBrokenRails(myself.Blocks);
							}
						}
					}
				}

				if (myself.mult == 0) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (myself.mult == 1) {
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				timer.incrementTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Updates the track block object
	 * 
	 * @param Blocks
	 *            AllTrackBlock object
	 */
	public void updateTrack(AllTrackBlock Blocks) {
		this.Blocks = Blocks;
	}

	/**
	 * Updates the train object
	 * 
	 * @param train
	 *            AllTrains object
	 */
	public void updateTrain(AllTrains train) {
		this.train = train;
	}

	/**
	 * Updates the time multiplier
	 * 
	 * @param mult
	 *            Time multiplier
	 */
	public void updateMult(int mult) {
		this.mult = mult;
	}
}

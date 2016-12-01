package CTC_office;

import javax.swing.JFrame;

import Interface.*;
import Overall_Sys.TimeClass;
import java.util.concurrent.TimeUnit;

public class CTC_Office {
	private CTCOfficeLoginScreen LoginScreen;
	private CTCMapUI Mapwindow;
	private ClosedRails closerails;
	private CTCandTrackControllerInterface ctctcint;
	private RailwayCrossings railways;
	private Switches switching;
	private TrackCircuitTrainInfo circuit;
	private AllTrackBlock Blocks =AllTrackBlock.getInstance(true) ;
	private BrokenRailDetection broke;
	private CheckNewBlock newBlock;
	private ScheduleInfo sinfo;
	private SetDestination setD;
	private TrackModelFileParser TMparser;
	private TrainScheduleFileParser TSparser;
	private int mult=0;
	private AllTrains train= AllTrains.getInstance(true);
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		TimeClass timer = TimeClass.getInstance(false);
		CTC_Office myself = new CTC_Office();
		CTCOfficeUI Mainwindow;
		try {
			
			Mainwindow= new CTCOfficeUI(myself.train,myself.Blocks, myself);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(true){
			if(myself.mult==0){
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		} else if (myself.mult ==1){
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		timer.incrementTime();
		}
		
	}
	public void updateTrack(AllTrackBlock Blocks){
		this.Blocks =Blocks;
	}
	public void updateTrain(AllTrains train){
		this.train =train;
	}
    public void updateMult(int mult){
    	this.mult = mult;
    }
}


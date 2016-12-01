package CTC_office;

import javax.swing.JFrame;

import Interface.*;
import Overall_Sys.TimeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//prevSection
public class CTC_Office {
	private CTCOfficeLoginScreen LoginScreen;
	private CTCMapUI Mapwindow;
	private ClosedRails closerails;
	private CTCandTrackControllerInterface ctctcint;
	private RailwayCrossings railways;
	private Switches switching;
	private TrackCircuit circuit = TrackCircuit.getInstance(false);
	private AllTrackBlock Blocks =AllTrackBlock.getInstance(true) ;
	private BrokenRailDetection broke;
	private CheckNewBlock newBlock = new CheckNewBlock();
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
		Mainwindow= new CTCOfficeUI(myself.train,myself.Blocks,myself, myself.circuit);
		
		while(true){
			ArrayList <Trains> redlinetrains = myself.train.getRedTrain();
			for(int i = 0; i<redlinetrains.size();i++){
				myself.train=myself.newBlock.check(myself.circuit, redlinetrains.get(i).getID(), myself.train, myself.Blocks);
				myself.circuit.setAuthority(myself.train.getAuthority(redlinetrains.get(i).getID(), "Green"), redlinetrains.get(i).getID());
				myself.circuit.setCurBlock(myself.train.getBlockNum(redlinetrains.get(i).getID(), "Green"), redlinetrains.get(i).getID());
				myself.circuit.setGrade(myself.train.getBlockGrade(redlinetrains.get(i).getID(), "Green"), redlinetrains.get(i).getID());
				myself.circuit.setSpeed(myself.train.getSpeed(redlinetrains.get(i).getID(), "Green"), redlinetrains.get(i).getID());
				myself.circuit.addDisplacement(25,redlinetrains.get(i).getID());
			}
			Mainwindow.updateRedTrains(myself.train);
			ArrayList <Trains> greenlinetrains = myself.train.getGreenTrain();
			for(int i = 0; i<greenlinetrains.size();i++){
				myself.train=myself.newBlock.check(myself.circuit, greenlinetrains.get(i).getID(), myself.train, myself.Blocks);
				myself.circuit.setAuthority(myself.train.getAuthority(greenlinetrains.get(i).getID(), "Green"), greenlinetrains.get(i).getID());
				myself.circuit.setCurBlock(myself.train.getBlockNum(greenlinetrains.get(i).getID(), "Green"), greenlinetrains.get(i).getID());
				myself.circuit.setGrade(myself.train.getBlockGrade(greenlinetrains.get(i).getID(), "Green"), greenlinetrains.get(i).getID());
				myself.circuit.setSpeed(myself.train.getSpeed(greenlinetrains.get(i).getID(), "Green"), greenlinetrains.get(i).getID());
				myself.circuit.addDisplacement(25,greenlinetrains.get(i).getID());
			}
			Mainwindow.updateGreenTrains(myself.train);
			
			
			
			
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

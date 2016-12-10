package TrainModelControler;

import java.awt.EventQueue;
import java.util.ArrayList;

import Interface.CTCandTrackControllerInterface;
import Interface.TrackCircuit;
import Overall_Sys.TimeClass;


public class TrainModel{
	
	private TrackCircuit circuit = TrackCircuit.getInstance(false);
	private CTCandTrackControllerInterface CTCinterface = CTCandTrackControllerInterface.getInstance(false);
	public ArrayList<Train> trains;
	//TrainController trainController;
	static TrainModelUI ui;
	
	public TrainModel(/*TrainController trainController*/){
		///this.trainController = trainController;
		trains = new ArrayList<Train>();
		ui = new TrainModelUI(this);
	}
	
	public int addTrain(){
		int trainID = trains.size();
		Train newTrain = new Train(trainID);
		newTrain.setUI(ui);
		trains.add(trainID,newTrain);
		//trainController.createTrainController(newTrain);
		ui.addTrain(trainID);
		return trainID;
	}
	
	public void removeTrain(int trainID){
		trainID -= 1;
		trains.remove(trainID);
	}
	
	public Train getTrain(int trainID){
		return trains.get(trainID);
	}
	
	
	public void showUI(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui.frmTrainmodelmodule.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void tick(){
			for(int i = 0; i < trains.size();i++){
				trains.get(i).setEnginePower(50000+i*10000);
				trains.get(i).setGrade(circuit.getGrade(trains.get(i).getID()));
				trains.get(i).setAuthority(circuit.getAuthorityVerify(trains.get(i).getID()));
			    System.out.println(circuit.getAuthorityVerify(trains.get(i).getID()));
				trains.get(i).setSpeed((int)((circuit.getSpeedVerify(trains.get(i).getID()))*.447));
				trains.get(i).setBlockSpeedLimit((CTCinterface.getBlockSpeedLim(trains.get(i).getID()))*.447);
				trains.get(i).updateTrain();
				
			}
		}
	
	
	public static void main(String[] args) {
		int ID;
		//TrainController trainCon = new TrainController();
		TrainModel trainMod = new TrainModel(/*trainCon*/);
		TimeClass timer = TimeClass.getInstance(false);
		//ui.setTrain(trainMod.getTrain(ID+1));
		//ui.setTrain(trainMod.getTrain(ID));
		trainMod.showUI();
		
		while(true) {
			while(trainMod.circuit.getActiveTrains().size()!=trainMod.trains.size()){
				
				trainMod.addTrain();
				}
			if(trainMod.trains.size()>0){
			trainMod.tick();
			}
		   while(!timer.getChangedTrainTime()){ 
		   }
		   timer.gotChangedTrainTime();
		
		}
	}
}

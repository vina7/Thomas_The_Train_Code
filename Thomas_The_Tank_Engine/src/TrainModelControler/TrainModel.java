package TrainModel;

import TrainController.*;

import java.awt.EventQueue;
import java.util.ArrayList;

public class TrainModel{
	
	
	public ArrayList<Train> trains;
	TrainController trainController;
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
				trains.get(i).setGrade(.25);
				trains.get(i).setAuthority(100+i*2);
				trains.get(i).setSpeed(19-i*3);
				trains.get(i).setBlockSpeedLimit(19-i*10);
				trains.get(i).updateTrain();
			}
		}
	
	
	public static void main(String[] args) throws InterruptedException{
		int ID;
		//TrainController trainCon = new TrainController();
		TrainModel trainMod = new TrainModel(/*trainCon*/);
		ID = trainMod.addTrain();
		trainMod.addTrain();
		ui.setTrain(trainMod.getTrain(ID+1));
		ui.setTrain(trainMod.getTrain(ID));
		trainMod.showUI();
		
		while(true) {
			trainMod.tick();
			Thread.sleep(100);
		
		}
	}
}
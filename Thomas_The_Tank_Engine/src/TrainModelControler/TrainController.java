package TrainModelControler;
import java.awt.EventQueue;

import java.util.*;

@SuppressWarnings("unused")
public class TrainController {
	
	private ArrayList<Controller> controllers;
	private TrainControllerUI ui;

	public TrainController() {
		controllers = new ArrayList<Controller>();
		ui = new TrainControllerUI(this);
	}
	
	
	public Controller getTrainController(int targetID) {
		return controllers.get(targetID);
	}
	
	public void createTrainController(Train newModel) {
		int nextID = controllers.size();
		controllers.add(new Controller(nextID, newModel, ui));
		ui.addTrain(nextID);
	}
	
	
	
	public void tick() {
		for(int i = 0; i < controllers.size(); i++) {
			
		controllers.get(i).tick();
		}
		ui.update();
		}
	
	public void showUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}

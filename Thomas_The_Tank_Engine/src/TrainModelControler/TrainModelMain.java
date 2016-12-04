package TrainModelControler;

import java.util.concurrent.TimeUnit;

import Interface.TrackCircuit;
import Overall_Sys.TimeClass;

public class TrainModelMain {
	private TrackCircuit trackCricuit=TrackCircuit.getInstance(false);
	private TimeClass timer = TimeClass.getInstance(false);
	private TimeClass timer2 = TimeClass.getInstance(false);
	   public static void main() {
		    TrainModelMain myself = new TrainModelMain();
		    Train t=new Train();
			trainController tc = new trainController();
			while (true)
			{
				if(myself.trackCricuit.getActiveTrains().size()>0){
				tc.powerCalculator();
				t.setEnginePower(tc.getpower());
				t.calculateTrainForce();
				t.calculateAcceleration();
				t.calculateCurrentSpeed();
				t.calculateDisplacmnet();
				tc.setCurrentSpeed(t.getCurrentSpeed());
				
				myself.trackCricuit.addDisplacement(t.getDisplacement(), 0);		
				}
			 
			   
			   while(!myself.timer.getChangedTrainTime()){ 
			   }
			   myself.timer.gotChangedTrainTime();
			
			}
		   
	   }
}

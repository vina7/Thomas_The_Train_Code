package TrainModelControler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Interface.TrackCircuit;
import Overall_Sys.TimeClass;

public class TrainModelMain {
	private TrackCircuit trackCricuit=TrackCircuit.getInstance(false);
	private TimeClass timer = TimeClass.getInstance(false);
	private List <Train> setoftrains = new ArrayList<Train>();
	private List <trainController> setofcontrollers = new ArrayList<trainController>();
	   public static void main() {
		    TrainModelMain myself = new TrainModelMain();
			while (true)
			{
				
				if(myself.trackCricuit.getActiveTrains().size()>0){
				while(myself.trackCricuit.getActiveTrains().size()!=myself.setoftrains.size()){
				    Train t=new Train();
					trainController tc = new trainController();
					myself.setoftrains.add(t);
					myself.setofcontrollers.add(tc);
					}
				for(int i=0; i<myself.setoftrains.size(); i++){
				trainController tc=myself.setofcontrollers.get(i);
				Train t = myself.setoftrains.get(i);
				tc.powerCalculator();
				t.setEnginePower(tc.getpower());
				t.calculateTrainForce();
				t.calculateAcceleration();
				t.calculateCurrentSpeed();
				t.calculateDisplacmnet();
				tc.setCurrentSpeed(t.getCurrentSpeed());	
				myself.trackCricuit.addDisplacement(t.getDisplacement(), i);	
				}
					
				}
			 
			   
			   while(!myself.timer.getChangedTrainTime()){ 
			   }
			   myself.timer.gotChangedTrainTime();
			
			}
		   
	   }
}

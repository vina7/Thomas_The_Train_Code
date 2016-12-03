import Interface.TrackCircuit;

public class TrainModelMain {
		  
private TrackCircuit tc=TrackCircuit.getInstance(false);
		   public static void main(String args[]) {
			   TrainModelMain myself=new TrainModelMain();
			  myself.tc.makeNewTrain(0, .2, 0, 20, 20, "Green", 1);
			   while(true)
			   {
				myself.tc.addDisplacement(25, 0);   
			   }
			   
		   }
		      
			   
		   
		}



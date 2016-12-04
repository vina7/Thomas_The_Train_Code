package TrackController;

public class TrackControllerLoginVerifier {
	   public TrackControllerLoginVerifier(){   
	   }
	   public boolean verify(String username, String password){
		   if(username.equals("default") && password.equals("default")){
			   System.out.println("verified");

			   return true;
		   } 
		   System.out.println("not verified");

		   return false;
		   
	   }
	}

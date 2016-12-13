package CTC_office;

/**
 * This class is used to verify the user's login information 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class LoginScreenVerifier {
	/**
	   * Constructor
	   */
   public LoginScreenVerifier(){
	   
   }
   /**
    * Verifies the users login information
    * @param username Username
    * @param password Password
    * @return
    */
   public boolean verify(String username, String password){
	   if(username.equals("dispatcher") && password.equals("CTC")){
		   return true;
	   } else {
		   return false;
	   }
   }
}

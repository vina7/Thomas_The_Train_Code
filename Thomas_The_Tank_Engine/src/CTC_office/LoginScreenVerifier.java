package CTC_office;

public class LoginScreenVerifier {
   public LoginScreenVerifier(){
	   
   }
   public boolean verify(String username, String password){
	   if(username.equals("dispatcher") && password.equals("CTC")){
		   return true;
	   } else {
		   return false;
	   }
   }
}

package Overall_Sys;

public class TimeClass {
	private static TimeClass instance =null;
	boolean DebugMode;
	int Time;
	protected TimeClass(boolean DebugMode){
		  this.Time =0;
		  this.DebugMode=DebugMode;
	  }
	public static TimeClass getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new TimeClass(DebugMode);
		  }
		  return instance;
	  }
	public int getTime(){
		return Time;
	}
	public void incrementTime(){
		Time= Time+1;
	}
	
}

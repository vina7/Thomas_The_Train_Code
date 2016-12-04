package Overall_Sys;

import java.sql.Time;

public class TimeClass {
	private static TimeClass instance =null;
	boolean DebugMode;
	static int Time;
	boolean changed;
	boolean changed2;
	protected TimeClass(boolean DebugMode){
		  TimeClass.Time =0;
		  this.DebugMode=DebugMode;
		  changed2 =false;
		  changed =false;
	  }
	public static TimeClass getInstance(boolean DebugMode){
		  if(instance == null){
			  synchronized(TimeClass.class){
			  instance= new TimeClass(DebugMode);
			  }
		  }
		  return instance;
	  }
	public int getTime(){
		return Time;
	}
	public boolean getChangedTrackTime(){
		System.out.print("");
		return this.changed;
	}
	public void gotChangedTrackTime(){
		System.out.print("");
	    this.changed = false;
	}
	public boolean getChangedTrainTime(){
		System.out.print("");
		return this.changed2;
	}
	public void gotChangedTrainTime(){
		System.out.print("");
	    this.changed2 = false;
	}
	public void incrementTime(){
		changed =true;
		changed2 =true;
		Time= Time+1;
		
	}
	
}

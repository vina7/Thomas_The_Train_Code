package CTC_Office_Track_Model;

public class ScheduleInfo {
   
    private String Line;
    private String Station;
    private double Time;
    
    
    public ScheduleInfo( String Line,String Station,double Time){

      this.Line =Line;
      this.Station =Station;
      this.Time = Time;
    }
    
    public String getLine(){
      return Line;
    }
    public String getStation(){
      return Station;
    }
    public double getTime(){
      return Time;
    }
    public void setStation(String Station){
      this.Station=Station;
    }
  }

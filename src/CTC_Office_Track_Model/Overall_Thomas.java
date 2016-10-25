package CTC_Office_Track_Model;
//use cases(dispatch a train to a block), class diagrams, and sequence diagram 
public class Overall_Thomas {
  private static int time_speed;
  public static void main(String arg[])
  {
    CTC_Office_System ctc = new CTC_Office_System();
    time_speed = ctc.gettime_delay();
    
  }
  public int gettime_delay(){
    return time_speed;
  }
  
}

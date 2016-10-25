package CTC_Office_Track_Model;

import java.util.ArrayList;
import java.util.List;

public class CTC_Office_System {
  private List<TrainInfo> RedLineList;
  private List<TrainInfo> GreenLineList;
  private List<LineInfo> RedTrackList;
  private List<LineInfo> GreenTrackList;
  private int time_speed;
  private static CTC_Office_System instance = null;
  protected CTC_Office_System(){
    RedLineList= new  ArrayList<TrainInfo>();
    GreenLineList = new  ArrayList<TrainInfo>();
    RedTrackList= new ArrayList<LineInfo>();
    GreenTrackList= new ArrayList<LineInfo>();
    MainPage main_ctc = new MainPage(RedLineList,GreenLineList,RedTrackList,GreenTrackList);
    RedLineList = main_ctc.getRedLineList();
    GreenLineList = main_ctc.getGreenLineList();
    RedTrackList = main_ctc.getRedTrackList();
    GreenTrackList = main_ctc.getGreenTrackList();
    time_speed = main_ctc.gettime_delay();
  }
  public static CTC_Office_System getIntance(){
    if(instance == null){
      instance = new CTC_Office_System();
    }
    return instance;
  }
  public List<TrainInfo> getRedLineList(){
    return RedLineList;
  }
  public List<TrainInfo> getGreenLineList(){
    return GreenLineList;
  }
   public List<LineInfo> getRedTrackList(){
     return RedTrackList;
   }
   public List<LineInfo> getGreenTrackList(){
     return GreenTrackList;
   }
   public int gettime_delay(){
     return time_speed;
   }
   
}

package CTC_office;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TrainScheduleFileParser {
  private boolean DebugMode;
  private ArrayList usedR;
  private ArrayList usedG;
  private ArrayList usedB;
  public TrainScheduleFileParser(boolean DebugMode){
	  this.DebugMode = DebugMode;
	  usedR= new ArrayList();
	  usedG= new ArrayList();
	   usedB= new ArrayList();
  }
  public AllTrains Parser(AllTrains trainlist, String fileAddress, AllTrackBlock tracks){
	  List<ScheduleInfo> TrainSchedule = new ArrayList<ScheduleInfo>();
	  try {
		  BufferedReader br = new BufferedReader(new FileReader(fileAddress)); 
		  br.readLine();
		  String line = "";
		  while ((line = br.readLine()) != null) {

              String[] info = line.split(",");
              ScheduleInfo schedule = new ScheduleInfo(info[0],info[1],Double.parseDouble(info[2]));
              TrainSchedule.add(schedule);
          }
		  int R;
          int G;
          int B;
          do{
          R = (int)(Math.random()*256);
          G = (int)(Math.random()*256);
          B= (int)(Math.random()*256);
          }while(usedR.contains(R) && usedG.contains(G) && usedB.contains(B));
          Color color = new Color(R, G, B);
          if(TrainSchedule.get(1).getLine().equals("Green")){
              TrackBlock startLine=tracks.getGreenTrack().get(1);
              loop:
              for(int i =0;i<tracks.getGreenTrack().size(); i++){
                if(tracks.getGreenTrack().get(i).getSection().equals("YY")){
                  startLine = tracks.getGreenTrack().get(i);
                  break loop;
                }
              }
              trainlist.addTrain(color, trainlist.getRedTrain().size()+trainlist.getGreenTrain().size(), (int) (startLine.getSpeedLimit()/1.61), 
            		  (int) ((((((startLine.getSpeedLimit())*.27)/1.2)/3600)*startLine.getSpeedLimit())*3280.84),"Head", "YY", 
            		  startLine.getBlockNum(),(int) (startLine.getBlockLen()*3.2), 
            		  startLine.getBlockGrade(),(int) (startLine.getSpeedLimit()/1.61), startLine.getElevation()*3.2, false, 
            		  "Good",  "Yard", tracks.getBlockNum(TrainSchedule.get(1)), TrainSchedule, false, false);
              
            
            }else {
              TrackBlock startLine=tracks.getRedTrack().get(1);
              loop2:
                for(int i =0;i<tracks.getRedTrack().size(); i++){
                  if(tracks.getRedTrack().get(i).getSection().equals("U")){
                    startLine = tracks.getRedTrack().get(i);
                    break loop2;
                  }
                }
              trainlist.addTrain(color, trainlist.getRedTrain().size()+trainlist.getGreenTrain().size(), (int) (startLine.getSpeedLimit()/1.61), 
            		  (int) ((((((startLine.getSpeedLimit())*.27)/1.2)/3600)*startLine.getSpeedLimit())*3280.84),"Head", "U", 
            		  startLine.getBlockNum(),(int) (startLine.getBlockLen()*3.2), 
            		  startLine.getBlockGrade(),(int) (startLine.getSpeedLimit()/1.61), startLine.getElevation()*3.2, false, 
            		  "Good",  "Yard", tracks.getBlockNum(TrainSchedule.get(1)), TrainSchedule, false, false);
            }
          br.close();
	  } catch (Exception p){
		  System.out.println(p);
	  }
	  return trainlist;
  }
}
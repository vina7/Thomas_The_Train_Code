package CTC_office;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to parse the train schedule
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

public class TrainScheduleFileParser {
  private boolean DebugMode;
  private ArrayList usedR;
  private ArrayList usedG;
  private ArrayList usedB;
  /**
	 * Constructor
	 * @param DebugMode Used as a way to debug the system
	 */
  public TrainScheduleFileParser(boolean DebugMode){
	  this.DebugMode = DebugMode;
	  usedR= new ArrayList();
	  usedG= new ArrayList();
	   usedB= new ArrayList();
  }
  /**
   * Method used to parse a schedule file
   * @param trainlist AllTrains object
   * @param fileAddress File address of schedule file
   * @param tracks AllTrackBlock object
   * @param map CTCMapUI object
   * @return trainlist AllTrains object
   */
  public AllTrains Parser(AllTrains trainlist, String fileAddress, AllTrackBlock tracks, CTCMapUI map){
	  List<ScheduleInfo> TrainSchedule = new ArrayList<ScheduleInfo>();
	  try {
		  BufferedReader br = new BufferedReader(new FileReader(fileAddress)); 
		  br.readLine();
		  String line = "";
		  while ((line = br.readLine()) != null) {

              String[] info = line.split(",");
              
                  ScheduleInfo schedule = new ScheduleInfo(info[0],info[1],Double.parseDouble(info[2]),tracks.getBlockNum(info[1], info[0]));
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
          if(TrainSchedule.get(0).getLine().equals("Green")){
              TrackBlock startLine=tracks.getGreenTrack().get(0);
             
              loop:
              for(int i =0;i<tracks.getGreenTrack().size(); i++){
                if(tracks.getGreenTrack().get(i).getSection().equals("YY")){
                  startLine = tracks.getGreenTrack().get(i);
                  break loop;
                }
              }
              trainlist.addTrain(color, trainlist.getRedTrain().size()+trainlist.getGreenTrain().size(), (int) (startLine.getSpeedLimit()), 
            		  (int) (((Math.pow((startLine.getSpeedLimit()*.447),2))/(2*1.2))*3.3),"Head","-1" ,"YY", 
            		  startLine.getBlockNum(),(int) (startLine.getBlockLen()), 
            		  startLine.getBlockGrade(),(int) (startLine.getSpeedLimit()), startLine.getElevation(), false, 
            		  "Good",  "PIONEER", TrainSchedule.get(0).getBlockNum(), TrainSchedule, false, false,0, 0);
              map.updateColor("YY","-1", "Green", color);
            
            }else {
              TrackBlock startLine=tracks.getRedTrack().get(0);
              loop2:
                for(int i =0;i<tracks.getRedTrack().size(); i++){
                  if(tracks.getRedTrack().get(i).getSection().equals("U")){
                    startLine = tracks.getRedTrack().get(i);
                    break loop2;
                  }
                }
              trainlist.addTrain(color, trainlist.getRedTrain().size()+trainlist.getGreenTrain().size(), (int) (startLine.getSpeedLimit()), 
            		  (int) (((Math.pow((startLine.getSpeedLimit()*.447),2))/(2*1.2))*3.3),"Head", "-1" ,"U", 
            		  startLine.getBlockNum(),(int) (startLine.getBlockLen()), 
            		  startLine.getBlockGrade(),(int) (startLine.getSpeedLimit()), startLine.getElevation(), false, 
            		  "Good",  "SHADYSIDE", TrainSchedule.get(0).getBlockNum(), TrainSchedule, false, false,0, 0);
              map.updateColor("U","-1", "Red", color);
            }
          br.close();
	  } catch (Exception p){
		  System.out.println(p);
	  }
	  return trainlist;
  }
}

package CTC_office;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class AllTrackBlock {
	private static AllTrackBlock instance =null;
	  ArrayList <TrackBlock> GreenTrack;
	  ArrayList <TrackBlock> RedTrack;
	  ArrayList <BrokenTracks> BrokenRails;
	  boolean DebugMode;
	  protected AllTrackBlock(boolean DebugMode){
		  GreenTrack = new ArrayList <TrackBlock>();
		  RedTrack = new ArrayList <TrackBlock>();
		  BrokenRails = new ArrayList <BrokenTracks>();
	  }
	  public ArrayList <TrackBlock> getGreenTrack(){
		  return GreenTrack;
	  }
	  public ArrayList <TrackBlock> getRedTrack(){
		  return RedTrack;
	  }
	  public ArrayList <BrokenTracks> getBrokenRails(){
		  return BrokenRails;
	  }
	  public static AllTrackBlock getInstance(boolean DebugMode){
		  if(instance == null){
			  instance= new AllTrackBlock(DebugMode);
		  }
		  return instance;
	  }
	  public void addBlock( String Line,String Section, int BlockNum, int BlockLen, double BlockGrade,
			  double SpeedLimit, String Infrastructure, double Elevation, double CumElevation, String SwitchBlock,
			  String ArrowDirection, String SwitchPosition, boolean Closed, int ClosedTime, boolean Broken, String RailroadCross,
			  int TimeToFixRail){
		       if(Line.equals("Green")){
		    	   
		    	   TrackBlock newBlock =new TrackBlock(Line,Section, BlockNum, BlockLen, BlockGrade,
		    				  SpeedLimit, Infrastructure, Elevation, CumElevation, SwitchBlock,
		    				   ArrowDirection, SwitchPosition, Closed, ClosedTime,  Broken,RailroadCross,TimeToFixRail);
		    	    GreenTrack.add(newBlock);
		    	   
		    	   
		       } else if (Line.equals("Red")){
		    	   TrackBlock newBlock =new TrackBlock(Line,Section, BlockNum, BlockLen, BlockGrade,
		    				  SpeedLimit, Infrastructure, Elevation, CumElevation, SwitchBlock,
		    				   ArrowDirection, SwitchPosition, Closed, ClosedTime,  Broken,RailroadCross,TimeToFixRail);
		    	   RedTrack.add(newBlock);
		       }
		  
	  }
	  public void resetTracks(String Line){
		  if(Line.equals("Green")){
			  GreenTrack = new ArrayList <TrackBlock>();
		  }else if (Line.equals("Red")){
			  RedTrack = new ArrayList <TrackBlock>();
		  }
	  }
	  public int getBlockNum(String station, String Line){
		  if(Line.equalsIgnoreCase("Green")){
			  for(int i =0;i<GreenTrack.size(); i++){
                  if(GreenTrack.get(i).getInfrastructure().equalsIgnoreCase(station)){
                    return GreenTrack.get(i).getBlockNum();
                  }
                }
		  } else if(Line.equalsIgnoreCase("Red")){
			  for(int i =0;i<RedTrack.size(); i++){
                  if(RedTrack.get(i).getInfrastructure().equalsIgnoreCase(station)){
                    return RedTrack.get(i).getBlockNum();
                  }
                }
		  }
		  return -1;
	  }
	  public int getBlockNum(ScheduleInfo schedule){
		  if(schedule.getLine().equals("Green")){
			  for(int i =0;i<GreenTrack.size(); i++){
                  if(GreenTrack.get(i).getInfrastructure().equals(schedule.getStation())){
                    return GreenTrack.get(i).getBlockNum();
                  }
                }
		  } else if(schedule.getLine().equals("Red")){
			  for(int i =0;i<RedTrack.size(); i++){
                  if(RedTrack.get(i).getInfrastructure().equals(schedule.getStation())){
                    return RedTrack.get(i).getBlockNum();
                  }
                }
		  }
		  return -1;
	  }
	  public int getBlockLen(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getBlockLen();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getBlockLen();
				  }
			  }
		  }
		  return -1;
	      
		}
	  public String getSection(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getSection();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getSection();
				  }
			  }
		  }
		  return null;
	      
		}
	  public double getBlockGrade(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getBlockGrade();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getBlockGrade();
				  }
			  }
		  }
		  return -1;
	      
		}
	  public double getSpeedLimit(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getSpeedLimit();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getSpeedLimit();
				  }
			  }
		  }
		  return -1;
	      
		}
	  public String getInfrastructure(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getInfrastructure();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getInfrastructure();
				  }
			  }
		  }
		  return null;
	      
		}
	  public double getElevation(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getElevation();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getElevation();
				  }
			  }
		  }
		  return -1;
	      
		}
	  public double getCumElevation(int BlockNum, String Line){

		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getCumElevation();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getCumElevation();
				  }
			  }
		  }
		  return -1;
	      
		}
	  public String getSwitchBlock(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getSwitchBlock();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getSwitchBlock();
				  }
			  }
		  }
		  return null;
	      
		}
	  public String getArrowDirection(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getArrowDirection();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getArrowDirection();
				  }
			  }
		  }
		  return null;
	      
		}
	  public String getSwitchPosition(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getSwitchPosition();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getSwitchPosition();
				  }
			  }
		  }
		  return null;
	      
		}
	  public boolean getClosed(int BlockNum, String Line){
		  BrokenTracks tracks;
		  for(int i =0; i<BrokenRails.size(); i++){
			  tracks = BrokenRails.get(i);
			  if(tracks.getLine().equalsIgnoreCase(Line)){
			  if(tracks.getBlockNum()==BlockNum){
				  return tracks.getClosed();
			  }
			  }
		  }
		  return false;
	      
		}
	  public int getClosedTime(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getClosedTime();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getClosedTime();
				  }
			  }
		  }
		  return -1;
	      
		}
	  public boolean getBroken(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getBroken();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getBroken();
				  }
			  }
		  }
		  return true;
	      
		}
	  public String getRailroadCross(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getRailroadCross();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getRailroadCross();
				  }
			  }
		  }
		  return null;
	      
		}
	  public int getTimeToFixRail(int BlockNum, String Line){
		  TrackBlock temp;
		  if (Line.equals("Green")){
			  for(int i =0; i<GreenTrack.size(); i++){
				  temp = GreenTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getTimeToFixRail();
				  }
			  }
		  } else if(Line.equals("Red")){
			  for(int i =0; i<RedTrack.size(); i++){
				  temp = RedTrack.get(i);
				  if(temp.getBlockNum()==BlockNum){
					  return temp.getTimeToFixRail();
				  }
			  }
		  }
		  return -1;
	      
		}
	  public void setSwitchPosition(String SwitchPosition, int BlockNum, String Line){
			TrackBlock temp;
			  if (Line.equals("Green")){
				  for(int i =0; i<GreenTrack.size(); i++){
					  temp = GreenTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setSwitchPosition(SwitchPosition);
					  }
				  }
			  } else if(Line.equals("Red")){
				  for(int i =0; i<RedTrack.size(); i++){
					  temp = RedTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setSwitchPosition(SwitchPosition);
					  }
				  }
			  }
		}
	  public void setClosed(boolean Closed, int BlockNum, String Line){
			TrackBlock temp;
			BrokenTracks tracks;
			for(int i =0; i<BrokenRails.size(); i++){
				  tracks = BrokenRails.get(i);
				  if(tracks.getLine().equalsIgnoreCase(Line)){
				  if(tracks.getBlockNum()==BlockNum){
					  tracks.setClosed(Closed); 
				  }
				  }
			  }
			  if (Line.equals("Green")){
				  for(int i =0; i<GreenTrack.size(); i++){
					  temp = GreenTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setClosed(Closed);
					  }
				  }
			  } else if(Line.equals("Red")){
				  for(int i =0; i<RedTrack.size(); i++){
					  temp = RedTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setClosed(Closed);
					  }
				  }
			  }
		}
	  public void setClosedTime(int ClosedTime, int BlockNum, String Line){
			TrackBlock temp;
			BrokenTracks tracks;
			for(int i =0; i<BrokenRails.size(); i++){
				  tracks = BrokenRails.get(i);
				  if(tracks.getLine().equalsIgnoreCase(Line)){
				  if(tracks.getBlockNum()==BlockNum){
					  tracks.setClosedTime(ClosedTime);
				  }
				  }
			  }
			  if (Line.equals("Green")){
				  for(int i =0; i<GreenTrack.size(); i++){
					  temp = GreenTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setClosedTime(ClosedTime);
					  }
				  }
			  } else if(Line.equals("Red")){
				  for(int i =0; i<RedTrack.size(); i++){
					  temp = RedTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setClosedTime(ClosedTime);
					  }
				  }
			  }
		}
	  public void setBroken(boolean Broken, int BlockNum, String Line){
			TrackBlock temp;
			int fixtime=(int)((Math.random()*100)+1);
			this.setTimeToFixRail(fixtime, BlockNum, Line);
			BrokenTracks tracks = new BrokenTracks(Line, BlockNum, fixtime,false, 0, true);
			BrokenRails.add(tracks);
			  if (Line.equals("Green")){
				  for(int i =0; i<GreenTrack.size(); i++){
					  temp = GreenTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setBroken(Broken);
						  
					  }
				  }
			  } else if(Line.equals("Red")){
				  for(int i =0; i<RedTrack.size(); i++){
					  temp = RedTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setBroken(Broken);
					  }
				  }
			  }
		}
	  public void removeBroken(boolean Broken, int BlockNum, String Line){
			TrackBlock temp;
			BrokenTracks tracks;
			for(int i =0; i<BrokenRails.size(); i++){
				  tracks = BrokenRails.get(i);
				  if(tracks.getLine().equalsIgnoreCase(Line)){
				  if(tracks.getBlockNum()==BlockNum){
					  BrokenRails.remove(i);
				  }
				  }
			  }
			  if (Line.equals("Green")){
				  for(int i =0; i<GreenTrack.size(); i++){
					  temp = GreenTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setBroken(Broken);
						  
					  }
				  }
			  } else if(Line.equals("Red")){
				  for(int i =0; i<RedTrack.size(); i++){
					  temp = RedTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setBroken(Broken);
					  }
				  }
			  }
		}
	  public void setRailroadCross(String RailroadCross, int BlockNum, String Line){
			TrackBlock temp;
			  if (Line.equals("Green")){
				  for(int i =0; i<GreenTrack.size(); i++){
					  temp = GreenTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setRailroadCross(RailroadCross);
					  }
				  }
			  } else if(Line.equals("Red")){
				  for(int i =0; i<RedTrack.size(); i++){
					  temp = RedTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setRailroadCross(RailroadCross);
					  }
				  }
			  }
		}
	  private void setTimeToFixRail(int TimeToFixRail, int BlockNum, String Line){
			TrackBlock temp;
			  if (Line.equals("Green")){
				  for(int i =0; i<GreenTrack.size(); i++){
					  temp = GreenTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setTimeToFixRail(TimeToFixRail);
					  }
				  }
			  } else if(Line.equals("Red")){
				  for(int i =0; i<RedTrack.size(); i++){
					  temp = RedTrack.get(i);
					  if(temp.getBlockNum()==BlockNum){
						  temp.setTimeToFixRail(TimeToFixRail);
					  }
				  }
			  }
		}
}


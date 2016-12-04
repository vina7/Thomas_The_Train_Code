/**
 * 
 */
package CTC_office;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author van
 *
 */
public class TrackModelFileParser {
  private boolean DebugMode;
  public TrackModelFileParser(boolean DebugMode){
	  this.DebugMode = DebugMode;
  }
  public AllTrackBlock Parser(String fileAddress, AllTrackBlock tracks){
	  try {
          BufferedReader br = new BufferedReader(new FileReader(fileAddress));
          br.readLine();
          String line = "";
          int counter =0;
          while ((line = br.readLine()) != null) {
              String[] info = line.split(",");
              if(counter==0){
            	  if(info[0].equals("Green")){
            		  if(tracks.getGreenTrack().size()>0){
            			  tracks.resetTracks("Green");
            		  }
            		  
            	  }else if (info[0].equals("Red")){
                     if(tracks.getRedTrack().size()>0){
                    	 tracks.resetTracks("Red");
            		  }
            	  }
            	  counter=1;
              }
              if(info.length == 11){
              tracks.addBlock(info[0],info[1],Integer.parseInt(info[2]),(int) (Double.parseDouble(info[3])*3.3),
                  Double.parseDouble(info[4]),Double.parseDouble(info[5])*.621,info[6],Double.parseDouble(info[7])*3.3, 
                  Double.parseDouble(info[8])*3.3, info[9], info[10], "", false,0, false, info[6].equals("RAILWAY CROSSING") ? "UP" : "",0);
              } else{
                tracks.addBlock(info[0],info[1],Integer.parseInt(info[2]),(int) (Double.parseDouble(info[3])*3.3),
                    Double.parseDouble(info[4]),Integer.parseInt(info[5])*.621,info[6],Double.parseDouble(info[7])*3.3, 
                    Double.parseDouble(info[8])*3.3, info[9], "", "", false,0, false, info[6].equals("RAILWAY CROSSING") ? "UP" : "",0);
              }  
          }
          br.close();
	  } catch (Exception p){
		  System.out.println(p);
	  }
	  return tracks;
  }
}

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
          while ((line = br.readLine()) != null) {
              String[] info = line.split(",");
              if(info.length == 11){
              tracks.addBlock(info[0],info[1],Integer.parseInt(info[2]),(int) Double.parseDouble(info[3]),
                  Double.parseDouble(info[4]),Double.parseDouble(info[5]),info[6],Double.parseDouble(info[7]), 
                  Double.parseDouble(info[8]), info[9], info[10], "", false,0, false, "UP",0);
              } else{
                tracks.addBlock(info[0],info[1],Integer.parseInt(info[2]),(int) Double.parseDouble(info[3]),
                    Double.parseDouble(info[4]),Integer.parseInt(info[5]),info[6],Double.parseDouble(info[7]), 
                    Double.parseDouble(info[8]), info[9], "", "", false,0, false, "UP",0);
              }  
          }
          br.close();
	  } catch (Exception p){
		  System.out.println(p);
	  }
	  return tracks;
  }
}

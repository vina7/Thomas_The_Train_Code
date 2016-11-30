package CTC_office;

import java.io.BufferedReader;
import java.io.FileReader;

public class BrokenRailDetection {
  boolean DebugMode;
  public BrokenRailDetection(){
  }
  public AllTrackBlock checkRails(AllTrackBlock Blocks){
	  try(BufferedReader br = new BufferedReader(new FileReader("GreenLineBroken.txt"))) {
          String line = "";
          while ((line = br.readLine()) != null) {
              for(int i =0; i<Blocks.getGreenTrack().size(); i++){         
                  Blocks.setBroken(true, Integer.parseInt(line), "Green");
              }
          }
          br.close();
        } catch(Exception k){
          System.out.println(k);
        }
	  try(BufferedReader br = new BufferedReader(new FileReader("RedLineBroken.txt"))) {
          String line = "";
          while ((line = br.readLine()) != null) {
              for(int i =0; i<Blocks.getRedTrack().size(); i++){         
                  Blocks.setBroken(true, Integer.parseInt(line), "Red");
              }
          }
          br.close();
        } catch(Exception k){
          System.out.println(k);
        }
	  return Blocks;
  }
  public AllTrackBlock closeBrokenRail(int BlockNum, String Line, AllTrackBlock Blocks){
	  Blocks.setClosed(true, BlockNum, Line);
	  return Blocks;
  }
}

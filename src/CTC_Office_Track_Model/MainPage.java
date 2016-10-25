package CTC_Office_Track_Model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class MainPage {
       private List<TrainInfo> RedLineList;
       private List<TrainInfo> GreenLineList;
       private List<LineInfo> RedTrackList;
       private List<LineInfo> GreenTrackList;
       private int time_delay;
	   public MainPage(List<TrainInfo> RedLineList, List<TrainInfo> GreenLineList,
	       List<LineInfo> RedTrackList, List<LineInfo> GreenTrackList)
	   {
	     this.RedLineList = RedLineList;
	     this.GreenLineList = GreenLineList;
	     this.RedTrackList = RedTrackList;
	     this.GreenTrackList = GreenTrackList;
	   try
	   {
	   Login frame=new Login();
	   frame.setSize(300,100);
	   frame.setVisible(true);
	   while(frame.isDisplayable()){
	     System.out.print("");
	   }
	   CTCOfficeMap page=new CTCOfficeMap();
	   MainTables tables = new MainTables(this.RedLineList,this.GreenLineList,this.RedTrackList, this.GreenTrackList);
	   this.RedLineList = tables.getRedLineList();
	   this.GreenLineList = tables.getGreenLineList();
	   this.RedTrackList = tables.getRedTrackList();
	   this.GreenTrackList = tables.getGreenTrackList();
	   this.time_delay = tables.gettime_delay();
	   while(true){
	     PrintWriter writer = new PrintWriter("redLineInfo.txt", "UTF-8");
	     for(int i=0; i<RedLineList.size(); i++){
	     int prevBlock = RedLineList.get(i).getBlockNum();
	     int nextblock=0;
	       for(int o=0; o<RedTrackList.size(); o++){
	         if(RedTrackList.get(o).getBlockNum() == prevBlock){
	           if(RedTrackList.get(o).getInfrastructure().equals("SWITCH")){
                 String switchloc = RedTrackList.get(o).getSwitchBlock();
                 for(int j = 0; j<RedTrackList.size(); j++){
                   if(RedTrackList.get(j).getSwitchBlock().equals(switchloc)){
                     if(RedTrackList.get(j).getSection().equals(RedTrackList.get(o).getSwitchPosition())){
                       nextblock = RedTrackList.get(j).getBlockNum();
                     }
                   }
                 }
               } else if(RedTrackList.get(o).getSwitchBlock().contains("Switch")){
                 String switchloc = RedTrackList.get(o).getSwitchBlock();
                 for(int j = 0; j<RedTrackList.size(); j++){
                   if(RedTrackList.get(j).getSwitchBlock().equals(switchloc)){
                     if(RedTrackList.get(j).getInfrastructure().equals("SWITCH") && RedTrackList.get(j).getBlockNum() != RedTrackList.get(o).getBlockNum()){
                       nextblock = RedTrackList.get(j).getBlockNum();
                     } else {
                       nextblock= prevBlock+1;
                     }
                   }
                 }
               } else {
                 nextblock= prevBlock+1;
               }
	           }
	         }
	       int authority = RedLineList.get(i).getAuthority();
	       int speed = RedLineList.get(i).getSpeed();
	       double gradient = RedLineList.get(i).getBlockGrade();
	       String nextStation = "";
	       if(RedLineList.get(i).getLastStation().equals("Yard")){
	          nextStation = RedLineList.get(i).getSchedule().get(0).getStation();
	       } else {
	         for(int p =0; p<RedLineList.get(i).getSchedule().size(); p++){
	           if(RedLineList.get(i).getSchedule().get(p).getStation().equals(RedLineList.get(i).getLastStation())){
	             nextStation = RedLineList.get(i).getSchedule().get(p+1).getStation();
	           }
	         }
	       }
	       writer.println(RedLineList.get(i).getId()+" , "+prevBlock+" , "+nextblock+" , "+authority+" , "+speed+" , "+ gradient+","+nextStation);
	     }
	     writer.close();
	     writer = new PrintWriter("greenLineInfo.txt", "UTF-8");
         for(int i=0; i<GreenLineList.size(); i++){
         int prevBlock = GreenLineList.get(i).getBlockNum();
         int nextblock=0;
           for(int o=0; o<GreenTrackList.size(); o++){
             if(GreenTrackList.get(o).getBlockNum() == prevBlock){
               if(GreenTrackList.get(o).getInfrastructure().equals("SWITCH")){
                 String switchloc = GreenTrackList.get(o).getSwitchBlock();
                 for(int j = 0; j<GreenTrackList.size(); j++){
                   if(GreenTrackList.get(j).getSwitchBlock().equals(switchloc)){
                     if(GreenTrackList.get(j).getSection().equals(GreenTrackList.get(o).getSwitchPosition())){
                       nextblock = GreenTrackList.get(j).getBlockNum();
                     }
                   }
                 }
               } else if(GreenTrackList.get(o).getSwitchBlock().contains("Switch")){
                 String switchloc = GreenTrackList.get(o).getSwitchBlock();
                 for(int j = 0; j<GreenTrackList.size(); j++){
                   if(GreenTrackList.get(j).getSwitchBlock().equals(switchloc)){
                     if(GreenTrackList.get(j).getInfrastructure().equals("SWITCH") && GreenTrackList.get(j).getBlockNum() != GreenTrackList.get(o).getBlockNum()){
                       nextblock = GreenTrackList.get(j).getBlockNum();
                     }
                   }
                 }
               } else {
                 nextblock= prevBlock+1;
               }
               }
             }
           int authority = GreenLineList.get(i).getAuthority();
           int speed = GreenLineList.get(i).getSpeed();
           double gradient = GreenLineList.get(i).getBlockGrade();
           String nextStation = "";
           if(GreenLineList.get(i).getLastStation().equals("Yard")){
             nextStation = GreenLineList.get(i).getSchedule().get(0).getStation();
           } else {
             for(int p =0; p<GreenLineList.get(i).getSchedule().size(); p++){
               if(GreenLineList.get(i).getSchedule().get(p).getStation().equals(GreenLineList.get(i).getLastStation())){
                 nextStation = GreenLineList.get(i).getSchedule().get(p+1).getStation();
               }
             }
           }
           writer.println(GreenLineList.get(i).getId()+" , "+prevBlock+" , "+nextblock+" , "+authority+" , "+speed+" , "+ gradient+","+nextStation);
         }
         writer.close();
         try(BufferedReader br = new BufferedReader(new FileReader("RedLineInputInfo.txt"))) {
           String line = "";
           while ((line = br.readLine()) != null) {

               String[] info = line.split(",");
               for(int i =0; i<RedLineList.size(); i++){
                 if(RedLineList.get(i).getId() == Integer.parseInt(info[0])){
                   RedLineList.get(i).setBlockNum(Integer.parseInt(info[1]));
                   RedLineList.get(i).setStatus(info[2]);
                   for(int t= 0; t<RedTrackList.size(); t++){
                     if(RedTrackList.get(t).getBlockNum() == Integer.parseInt(info[1])){
                       RedLineList.get(i).setSection(RedTrackList.get(t).getSection());
                     }
                     
                   }
                 }
               }
           }
           br.close();
         } catch(Exception k){
           System.out.println(k);
         }
         try(BufferedReader br = new BufferedReader(new FileReader("GreenLineInputInfo.txt"))) {
           String line = "";
           while ((line = br.readLine()) != null) {

               String[] info = line.split(",");
               for(int i =0; i<GreenLineList.size(); i++){
                 if(GreenLineList.get(i).getId() == Integer.parseInt(info[0])){
                   GreenLineList.get(i).setBlockNum(Integer.parseInt(info[1]));
                   GreenLineList.get(i).setStatus(info[2]);
                   for(int t= 0; t<GreenTrackList.size(); t++){
                     if(GreenTrackList.get(t).getBlockNum() == Integer.parseInt(info[1])){
                       GreenLineList.get(i).setSection(GreenTrackList.get(t).getSection());
                     }
                     
                   }
                 }
               }
           }
           br.close();
         } catch(Exception k){
           System.out.println(k);
         }
         try(BufferedReader br = new BufferedReader(new FileReader("GreenLineBroken.txt"))) {
           String line = "";
           while ((line = br.readLine()) != null) {
               for(int i =0; i<GreenTrackList.size(); i++){
                 if(GreenTrackList.get(i).getBlockNum() == Integer.parseInt(line)){            
                   GreenTrackList.get(i).setBroken(true);
                 }
               }
           }
           br.close();
         } catch(Exception k){
           System.out.println(k);
         }
         try(BufferedReader br = new BufferedReader(new FileReader("RedLineBroken.txt"))) {
           String line = "";
           while ((line = br.readLine()) != null) {
               for(int i =0; i<RedTrackList.size(); i++){
                 if(RedTrackList.get(i).getBlockNum() == Integer.parseInt(line)){            
                   RedTrackList.get(i).setBroken(true);
                 }
               }
           }
           br.close();
         } catch(Exception k){
           System.out.println(k);
         }
         writer = new PrintWriter("GreenLineClosure.txt", "UTF-8");
         for(int i=0; i<GreenTrackList.size(); i++){
           if(GreenTrackList.get(i).getBroken()){
             writer.println(GreenTrackList.get(i).getClosed()+" , "+GreenTrackList.get(i).getBlockNum());
           }
          
         }
         writer.close();
         writer = new PrintWriter("RedLineClosure.txt", "UTF-8");
         for(int i=0; i<RedTrackList.size(); i++){
           if(RedTrackList.get(i).getBroken()){
             writer.println(RedTrackList.get(i).getClosed()+" , "+GreenTrackList.get(i).getBlockNum());
           }
          
         }
         writer.close();
       tables.refresh();
       if(time_delay ==2){
	   TimeUnit.MILLISECONDS.sleep(100); 	  
        } else {
          TimeUnit.SECONDS.sleep(1); 
        }
        }
	   }
	   catch(Exception e)
	   {JOptionPane.showMessageDialog(null, e.getMessage());}
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
	      return time_delay;
	    }
	 }


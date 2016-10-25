package CTC_Office_Track_Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class MainTables implements ActionListener{
  
  private int numberofTrains =0;
  private ArrayList usedR;
  private ArrayList usedG;
  private ArrayList usedB;
  private List<TrainInfo> RedLineList;
  private List<TrainInfo> GreenLineList;
  private List<LineInfo> RedTrackList;
  private List<LineInfo> GreenTrackList;
  private List<LineInfo> TrackList;
  private int speedval;
  private JButton TrainSchedule;
  private JButton TrackLayout;
  private JSlider speed;
  private JSlider mode;
  private MainLineTablePanel redTable;
  private MainLineTablePanel greenTable;
  private MainTrackTablePanel redBrokenTable;
  private MainTrackTablePanel greenBrokenTable;
  private MainSwitchRailsPanel switchTable;
  private MainRailroadPanel crossingTable; 
  private JFrame tableFrame;
  private JLabel redLine;
  private JLabel greenLine;
  private JLabel redBrokenLine;
  private JLabel greenBrokenLine;
  private JLabel Switches;
  private JLabel Crossing;
  MainTables(List<TrainInfo> RedLineList, List<TrainInfo> GreenLineList, List<LineInfo> RedTrackList, List<LineInfo> GreenTrackList){
    usedR= new ArrayList();
    usedG= new ArrayList();
    usedB= new ArrayList();
    this.RedLineList = RedLineList;
    this.GreenLineList = GreenLineList;
    this.RedTrackList = RedTrackList;
    this.GreenTrackList = GreenTrackList;
    TrackList = new ArrayList <LineInfo>();
    tableFrame = new JFrame();
    tableFrame.setLayout(new GridLayout(8, 2));
    
    redBrokenTable = new MainTrackTablePanel(RedTrackList);
    greenBrokenTable = new MainTrackTablePanel(GreenTrackList);
    switchTable = new MainSwitchRailsPanel(TrackList);
    crossingTable = new MainRailroadPanel(TrackList);
    TrainSchedule = new JButton("Import Train Schedule");
    TrainSchedule.addActionListener(this);
    TrackLayout = new JButton("Import Track Layout");
    TrackLayout.addActionListener(this);
    speed = new JSlider(JSlider.HORIZONTAL,1, 2, 1);
    speed.setMajorTickSpacing(1);
    speed.setMinorTickSpacing(1);
    Hashtable labelTable = new Hashtable();
    labelTable.put( new Integer( 1 ), new JLabel("1x speed") );
    labelTable.put( new Integer( 2 ), new JLabel("10x speed") );
    speed.setLabelTable( labelTable );
    speed.setPaintTicks(true);
    speed.setPaintLabels(true);
    speedval = speed.getValue();
    mode = new JSlider(JSlider.HORIZONTAL,1, 2, 1);
    mode.setMajorTickSpacing(1);
    mode.setMinorTickSpacing(1);
    Hashtable labelTableMode = new Hashtable();
    labelTableMode.put( new Integer( 1 ), new JLabel("Automatic") );
    labelTableMode.put( new Integer( 2 ), new JLabel("Manual") );
    mode.setLabelTable( labelTableMode );
    mode.setPaintTicks(true);
    mode.setPaintLabels(true);
    redTable = new MainLineTablePanel(RedLineList, mode);
    greenTable = new MainLineTablePanel(GreenLineList, mode);
    redLine = new JLabel("Red Line Info");
    greenLine = new JLabel("Green Line Info");
    redBrokenLine = new JLabel("Red Line Broken Rails");
    greenBrokenLine = new JLabel("Green Line Broken Rails");
    Switches = new JLabel("Switches");
    Crossing = new JLabel("Railroad Crossings");
    tableFrame.add(TrainSchedule);
    tableFrame.add(speed);
    tableFrame.add(TrackLayout);
    tableFrame.add(mode);
    tableFrame.add(redLine);
    tableFrame.add(redTable);
    tableFrame.add(greenLine);
    tableFrame.add(greenTable);
    tableFrame.add(redBrokenLine);
    tableFrame.add(redBrokenTable);
    tableFrame.add(greenBrokenLine);
    tableFrame.add(greenBrokenTable);
    tableFrame.add(Switches);
    tableFrame.add(switchTable);
    tableFrame.add(Crossing);
    tableFrame.add(crossingTable);
    tableFrame.pack();
    tableFrame.setVisible(true);
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
    return speedval;
  }
  public void refresh(){
    SwingUtilities.updateComponentTreeUI(tableFrame);
  }
  public void actionPerformed(ActionEvent e){
    final JFileChooser fc = new JFileChooser();
    if(e.getSource() == TrainSchedule ){
      int returnVal = fc.showOpenDialog(null);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
          File file = fc.getSelectedFile();
          List<ScheduleInfo> TrainSchedule= new ArrayList<ScheduleInfo>();
          try {
            BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
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
              LineInfo startLine=GreenTrackList.get(1);
              loop:
              for(int i =0;i<GreenTrackList.size(); i++){
                if(GreenTrackList.get(i).getSection().equals("YY")){
                  startLine = GreenTrackList.get(i);
                  break loop;
                }
              }
              TrainInfo newTrain = new TrainInfo(color, numberofTrains, (int) (startLine.getSpeedLimit()/1.61), 
                  (int) ((((((startLine.getSpeedLimit())*.27)/1.2)/3600)*startLine.getSpeedLimit())*3280.84),"Head", "YY",
                  startLine.getBlockNum(),(int) (startLine.getBlockLen()*3.2), startLine.getBlockGrade(), (int) (startLine.getSpeedLimit()/1.61),
                  startLine.getElevation()*3.2,false,"Good", "Yard",TrainSchedule );
            numberofTrains++;
            GreenLineList.add(newTrain);
            
            }else {
              LineInfo startLine=RedTrackList.get(1);
              loop2:
                for(int i =0;i<RedTrackList.size(); i++){
                  if(RedTrackList.get(i).getSection().equals("U")){
                    startLine = RedTrackList.get(i);
                    break loop2;
                  }
                }
              TrainInfo newTrain = new TrainInfo(color, numberofTrains, (int) (startLine.getSpeedLimit()/1.61), 
                  (int) ((((((startLine.getSpeedLimit())*.27)/1.2)/3600)*startLine.getSpeedLimit())*3280.84),"Head", "U",
                  startLine.getBlockNum(),(int) (startLine.getBlockLen()*3.2), startLine.getBlockGrade(), (int) (startLine.getSpeedLimit()/1.61),
                  startLine.getElevation()*3.2,false,"Good", "Yard",TrainSchedule );
              numberofTrains++;
              RedLineList.add(newTrain);
            }
            SwingUtilities.updateComponentTreeUI(tableFrame);
            
           } catch (Exception p) {
             System.out.println(p);
            }

      }
    } else if (e.getSource() == TrackLayout) {
      int returnVal = fc.showOpenDialog(null);
      boolean green =false;
      if (returnVal == JFileChooser.APPROVE_OPTION) {
          File file = fc.getSelectedFile();
          try {
            BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
            br.readLine();
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                LineInfo linedata;
                if(info.length == 11){
                linedata = new LineInfo(info[0],info[1],Integer.parseInt(info[2]),(int) Double.parseDouble(info[3]),
                    Double.parseDouble(info[4]),Integer.parseInt(info[5]),info[6],Double.parseDouble(info[7]), 
                    Double.parseDouble(info[8]), info[9], info[10], "", false, false, "UP");
                } else{
                  linedata = new LineInfo(info[0],info[1],Integer.parseInt(info[2]),(int) Double.parseDouble(info[3]),
                      Double.parseDouble(info[4]),Integer.parseInt(info[5]),info[6],Double.parseDouble(info[7]), 
                      Double.parseDouble(info[8]), info[9], "", "", false, false, "UP");
                }
                if(info[0].equals("Green")){
                  GreenTrackList.add(linedata);
                  green=true;
                } else if (info[0].equals("Red")) {
                  RedTrackList.add(linedata);
                }
                
            }
            br.close();
            SwingUtilities.updateComponentTreeUI(tableFrame);
            //come back when you are down with track layout input
           } catch (Exception p) {
             System.out.println(p);
            }

    }
  }
}  
}
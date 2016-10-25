package CTC_Office_Track_Model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

public class MainRailroadPanel extends JPanel {
  MainRailroadPanel(List<LineInfo> TrackList){
  MainRailroadModel RailroadCrossing = new MainRailroadModel(TrackList);
  //create the table
  JTable table = new JTable(RailroadCrossing);
   
  //add the table to the frame
  this.add(new JScrollPane(table));
  this.setVisible(true);
  }

}
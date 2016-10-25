package CTC_Office_Track_Model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

public class MainGreenTablePanel extends JPanel {
  MainGreenTablePanel(List<TrainInfo> GreenLineList){
  MainLineTableModel redLine = new MainLineTableModel(GreenLineList);
  //create the table
  JTable table = new JTable(redLine);
   
  //add the table to the frame
  this.add(new JScrollPane(table));
  this.setVisible(true);
  }

}

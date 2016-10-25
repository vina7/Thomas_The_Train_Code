package CTC_Office_Track_Model;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainTrackTablePanel extends JPanel {
  private MainBrokenRailsModel BrokenRails;
  MainTrackTablePanel(List<LineInfo> TrackList){
  BrokenRails = new MainBrokenRailsModel(TrackList);
  //create the table
  JTable table = new JTable(BrokenRails);
  table.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
      if (e.getClickCount() == 2) {
        JTable target = (JTable)e.getSource();
        int row = target.getSelectedRow();
        int column = target.getSelectedColumn();
        if(column== 1){
        String close = JOptionPane.showInputDialog(table, "Close Block (true/false)");
        table.setValueAt(Boolean.parseBoolean(close), row, column);
        }
        // do some action if appropriate column
      }
    }
  });
  //add the table to the frame
  this.add(new JScrollPane(table));
  this.setVisible(true);
  }
}
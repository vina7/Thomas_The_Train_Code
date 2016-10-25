package CTC_Office_Track_Model;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainLineTablePanel extends JPanel {
  MainLineTablePanel(List<TrainInfo> LineList, JSlider mode){
  MainLineTableModel Line = new MainLineTableModel(LineList);
  //create the table
  JTable table = new JTable(Line);
  table.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
      if(mode.getValue()==2 ){
      if (e.getClickCount() == 2) {
        JTable target = (JTable)e.getSource();
        int row = target.getSelectedRow();
        int column = target.getSelectedColumn();
        if(column== 2){
        String speed = JOptionPane.showInputDialog(table, "Set new Speed (mph)");
        table.setValueAt(Integer.parseInt(speed), row, column);
        }
        if(column== 4){
          String authority= JOptionPane.showInputDialog(table, "Set new Authority (ft)");
          table.setValueAt(Integer.parseInt(authority), row, column);
          }
        if(column== 3){
          String block = JOptionPane.showInputDialog(table, "Set destination block");
          table.setValueAt(Integer.parseInt(block), row, column);
          }
        if(column== 6){
          String retire= JOptionPane.showInputDialog(table, "Retire Train (true/false)?");
          table.setValueAt(Boolean.parseBoolean(retire), row, column);
          }
        // do some action if appropriate column
      }
    }
    }
  });
  //add the table to the frame
  this.add(new JScrollPane(table));
  this.setVisible(true);
  }

}

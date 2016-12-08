package CTC_office;
import java.awt.Color;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MainLineTableModel extends AbstractTableModel {
  
  private List<Trains> TrainList;
  private final String[] columnNames = new String[] {
      "color","Line","ID","Speed (mph)", "Block Number","Authority (ft)","Direction", "Status"
  };
  private final Class[] columnClass = new Class[] {
      Color.class,String.class, String.class, Integer.class, Integer.class, Integer.class, String.class, String.class
  };

  public MainLineTableModel(List<Trains> TrainList)
  {
      this.TrainList = TrainList;
  }
  public void updateTrainList(List<Trains> TrainList){
	  this.TrainList = TrainList;
  }
  @Override
  public String getColumnName(int column)
  {
      return columnNames[column];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex)
  {
      return columnClass[columnIndex];
  }

  @Override
  public int getColumnCount()
  {
      return columnNames.length;
  }

  @Override
  public int getRowCount()
  {
      return TrainList.size();
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
      Trains row = TrainList.get(rowIndex);
      if(0 == columnIndex) {
         return row.getColor();
      }
      else if(1 == columnIndex) {
          return row.getTrainSchedule().get(0).getLine();
      }
      else if(2 == columnIndex) {
          return row.getID();
      }
      else if(3 == columnIndex) {
    	  return row.getDisplaySpeed();
        
       }
      else if(4 == columnIndex) {
    	  return row.getBlockNum();
      }
      else if(5 == columnIndex) {
          return row.getAuthority();
      }
      else if(6 == columnIndex) {
        return row.getDirection();
    }
      else if(8 == columnIndex) {
        return row.getStatus();
    }
      return null;
  }
   
     
  }
  
  
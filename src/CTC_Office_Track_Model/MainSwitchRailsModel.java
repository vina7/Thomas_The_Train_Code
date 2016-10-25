package CTC_Office_Track_Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MainSwitchRailsModel extends AbstractTableModel {
  
  private final List<LineInfo> LineList;
  private int lastindex=0;
  
  private final String[] columnNames = new String[] {
      "Section","Block", "Line", "Positon(Section)"
  };
  private final Class[] columnClass = new Class[] {
      String.class, Integer.class, String.class, String.class
  };

  public MainSwitchRailsModel(List<LineInfo> LineList)
  {
      this.LineList = LineList;
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
    int count=0;
    for(int i =0; i<LineList.size(); i++){ 
      if(LineList.get(i).getInfrastructure().equals("SWITCH")){
       count++;
      }
    }
      return count;
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    LineInfo row;
    System.out.println(LineList.size());
    System.out.println(rowIndex);
    for(int i =lastindex; i<LineList.size(); i++){ 
      if(LineList.get(i).getInfrastructure().equals("SWITCH")){
       row = LineList.get(i);
       if(0 == columnIndex) {
         return row.getSection();
      }
      else if(1 == columnIndex) {
          return row.getBlockNum();
      }
      else if(2 == columnIndex) {
          return row.getLine();
      }
      else if(3 == columnIndex) {
        lastindex=i+1;
        if(rowIndex == this.getRowCount()-1){
          lastindex=0;
        }
        //System.out.println(lastindex);
        return row.getSwitchPosition();
    }
      }
    }
    lastindex=0;
      return null;
  }
  /*@Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex)
  {
      LineInfo row = LineList.get(rowIndex);
      if(3 == columnIndex) {
          row.setSwitchPosition((String) aValue);
      }
     
  }*/
  
  
}


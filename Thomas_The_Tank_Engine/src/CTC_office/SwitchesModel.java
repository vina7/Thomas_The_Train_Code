package CTC_office;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;
import javax.swing.table.AbstractTableModel;

public class SwitchesModel extends AbstractTableModel {		  
		  private final List<TrackBlock> LineList;
		  private ArrayList <Integer> switchlocations;
		  private int lastindex=0;
		  
		  private final String[] columnNames = new String[] {
		      "Section","Block", "Line", "Positon(Section)"
		  };
		  private final Class[] columnClass = new Class[] {
		      String.class, Integer.class, String.class, String.class
		  };

		  public SwitchesModel(List<TrackBlock> LineList, ArrayList <Integer> switchlocations)
		  {
		      this.LineList = LineList;
		      this.switchlocations =switchlocations; 
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
		    TrackBlock row = LineList.get(switchlocations.get(rowIndex)-1);
		    System.out.println(LineList.size());
		    System.out.println(rowIndex);
		       if(0 == columnIndex && row!=null) {
		         return row.getSection();
		      }
		      else if(1 == columnIndex && row!=null) {
		          return row.getBlockNum();
		      }
		      else if(2 == columnIndex && row!=null) {
		          return row.getLine();
		      }
		      else if(3 == columnIndex && row!=null) {
		       /* lastindex=i+1;
		        if(rowIndex == this.getRowCount()-1){
		          System.out.println("got here");
		          lastindex=0;
		        }*/
		        return row.getSwitchPosition();
		    }
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

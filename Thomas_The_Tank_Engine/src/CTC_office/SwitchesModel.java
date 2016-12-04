package CTC_office;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;
import javax.swing.table.AbstractTableModel;

public class SwitchesModel extends AbstractTableModel {		  
		  private AllTrackBlock Blocks;
		  private ArrayList <Integer> rswitchlocations;
		  private ArrayList <Integer> gswitchlocations;
		  private int lastindex=0;
		  
		  private final String[] columnNames = new String[] {
		      "Section","Block", "Line", "Positon(Section)"
		  };
		  private final Class[] columnClass = new Class[] {
		      String.class, Integer.class, String.class, String.class
		  };

		  public SwitchesModel(AllTrackBlock Blocks, ArrayList <Integer> rswitchlocations,ArrayList <Integer> gswitchlocations )
		  {
		      this.Blocks= Blocks;
		      this.rswitchlocations =rswitchlocations; 
		      this.gswitchlocations =gswitchlocations; 
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
		    count = rswitchlocations.size() + gswitchlocations.size();
		     return count;
		  }
		  
		  @Override
		  public Object getValueAt(int rowIndex, int columnIndex)
		  {
		    if(rswitchlocations.size()>rowIndex){
		       if(0 == columnIndex && rswitchlocations!=null) {
		         return Blocks.getSection(rswitchlocations.get(rowIndex), "Red");
		      }
		      else if(1 == columnIndex && rswitchlocations!=null) {
		          return rswitchlocations.get(rowIndex);
		      }
		      else if(2 == columnIndex && rswitchlocations!=null) {
		          return "Red";
		      }
		      else if(3 == columnIndex && rswitchlocations!=null) {
		        return Blocks.getSwitchPosition(rswitchlocations.get(rowIndex), "Red");
		    }
		    } else {
		    	 if(0 == columnIndex && gswitchlocations!=null) {
			         return Blocks.getSection(gswitchlocations.get(rowIndex), "Green");
			      }
			      else if(1 == columnIndex && gswitchlocations!=null) {
			          return gswitchlocations.get(rowIndex);
			      }
			      else if(2 == columnIndex && gswitchlocations!=null) {
			          return "Green";
			      }
			      else if(3 == columnIndex && gswitchlocations!=null) {
			        return Blocks.getSwitchPosition(gswitchlocations.get(rowIndex), "Green");
		    	
		      }
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

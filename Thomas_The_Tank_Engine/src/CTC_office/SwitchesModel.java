/**
 * This class is used as the model for the track model table
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
package CTC_office;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;
import javax.swing.table.AbstractTableModel;

public class SwitchesModel extends AbstractTableModel {
	private AllTrackBlock Blocks = null;

	private final String[] columnNames = new String[] { "Line", "Section", "Block", "Block Len (ft)", "Block Grade (%)",
			"Speed Lim (mph)", "Infrastructure", "Switch Positon", "Railroad Crossing", "Elevation (ft)" };
	private final Class[] columnClass = new Class[] { String.class, String.class, Integer.class, Integer.class,
			Double.class, Double.class, String.class, String.class, String.class, Double.class };

	/**
	 * Constructor
	 * 
	 * @param Blocks
	 *            AllTrackBlock object
	 */
	public SwitchesModel(AllTrackBlock Blocks) {
		this.Blocks = Blocks;
	}

	/**
	 * Updates the blocks object with the track information
	 * 
	 * @param Blocks
	 *            AllTrackBlock object
	 */
	public void updateBlocks(AllTrackBlock Blocks) {
		this.Blocks = Blocks;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		int count = 0;
		if (Blocks != null) {
			count = Blocks.getRedTrack().size() + Blocks.getGreenTrack().size();
		}
		return count;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (Blocks.getRedTrack().size() > rowIndex) {
			if (0 == columnIndex && Blocks.getRedTrack() != null) {
				return "Red";
			} else if (1 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getSection(rowIndex + 1, "Red");
			} else if (2 == columnIndex && Blocks.getRedTrack() != null) {
				return rowIndex + 1;
			} else if (3 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getBlockLen(rowIndex + 1, "Red");
			} else if (4 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getBlockGrade(rowIndex + 1, "Red");
			} else if (5 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getSpeedLimit(rowIndex + 1, "Red");
			} else if (6 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getInfrastructure(rowIndex + 1, "Red");
			} else if (7 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getSwitchPosition(rowIndex + 1, "Red");
			} else if (8 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getRailroadCross(rowIndex + 1, "Red");
			} else if (9 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getElevation(rowIndex + 1, "Red");
			}
		} else {
			if (0 == columnIndex && Blocks.getRedTrack() != null) {
				return "Green";
			} else if (1 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getSection(rowIndex + 1 - Blocks.getRedTrack().size(), "Green");
			} else if (2 == columnIndex && Blocks.getRedTrack() != null) {
				return rowIndex + 1 - Blocks.getRedTrack().size();
			} else if (3 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getBlockLen(rowIndex + 1 - Blocks.getRedTrack().size(), "Green");
			} else if (4 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getBlockGrade(rowIndex + 1 - Blocks.getRedTrack().size(), "Green");
			} else if (5 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getSpeedLimit(rowIndex + 1 - Blocks.getRedTrack().size(), "Green");
			} else if (6 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getInfrastructure(rowIndex + 1 - Blocks.getRedTrack().size(), "Green");
			} else if (7 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getSwitchPosition(rowIndex + 1 - Blocks.getRedTrack().size(), "Green");
			} else if (8 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getRailroadCross(rowIndex + 1 - Blocks.getRedTrack().size(), "Green");
			} else if (9 == columnIndex && Blocks.getRedTrack() != null) {
				return Blocks.getElevation(rowIndex + 1 - Blocks.getRedTrack().size(), "Green");
			}
		}

		return null;
	}

}

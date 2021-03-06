package CTC_office;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * This class is used as the model for the Broken rail table
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class BrokenRailsModel extends AbstractTableModel {
	private AllTrackBlock Blocks = null;

	private final String[] columnNames = new String[] { "Line", "Block", "Time To Fix (s)", "Closed" };
	private final Class[] columnClass = new Class[] { String.class, Integer.class, Integer.class, Boolean.class };

	/**
	 * Constructor
	 * 
	 * @param Blocks
	 *            AllTrackBlock object
	 */
	public BrokenRailsModel(AllTrackBlock Blocks) {
		this.Blocks = Blocks;
	}

	/**
	 * Updates the track block object
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
			count = Blocks.getBrokenRails().size();
		}
		return count;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArrayList<BrokenTracks> BTracks = Blocks.getBrokenRails();
		if (BTracks.size() > rowIndex) {
			if (0 == columnIndex && BTracks != null) {
				return BTracks.get(rowIndex).getLine();
			} else if (1 == columnIndex && BTracks != null) {
				return BTracks.get(rowIndex).getBlockNum();
			} else if (2 == columnIndex && BTracks != null) {
				return BTracks.get(rowIndex).getTimeToFixRail();
			} else if (3 == columnIndex && BTracks != null) {
				return BTracks.get(rowIndex).getClosed();
			}
		}

		return null;
	}

}

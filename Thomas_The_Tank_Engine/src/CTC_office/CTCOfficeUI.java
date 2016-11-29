package CTC_office;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

public class CTCOfficeUI {

	private JFrame frame;
	private JTable table;
	private AllTrains Train;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllTrains temp = AllTrains.getInstance();
					CTCOfficeUI window = new CTCOfficeUI(temp);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CTCOfficeUI(AllTrains Train) {
		this.Train = Train;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1013, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Manual Mode?");
		tglbtnNewToggleButton.setBounds(12, 12, 207, 55);
		tglbtnNewToggleButton.setToolTipText("Controls \nSelected Manual Mode \nNot Selected Autoamatic Mode");
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnxMode = new JToggleButton("10x Mode");
		tglbtnxMode.setBounds(806, 12, 193, 55);
		tglbtnxMode.setToolTipText("Speed \nSelected 10x normal speed \nNot Selected 1x normal speed");
		frame.getContentPane().add(tglbtnxMode);
		
		JButton btnNewButton = new JButton("<html>Import</br> Train Schedule</html>");
		btnNewButton.setBounds(231, 12, 189, 55);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<html>Import</br> Track Layout</html>");
		btnNewButton_1.setBounds(603, 12, 191, 55);
		frame.getContentPane().add(btnNewButton_1);
		
		MainLineTableModel Line = new MainLineTableModel(Train.getRedTrain());
		table = new JTable(Line);
		table.setBackground(Color.RED);
		table.setBounds(31, 105, 354, 32);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 330, 624, 173);
		frame.getContentPane().add(scrollPane);
		
		MainLineTableModel Line2 = new MainLineTableModel(Train.getGreenTrain());
		table = new JTable(Line2);
		table.setBackground(Color.GREEN);
		table.setBounds(31, 105, 354, 32);
		JScrollPane scrollPane2 = new JScrollPane(table);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane2.setBounds(12, 127, 624, 149);
		frame.getContentPane().add(scrollPane2);
		
	}
}


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {

	public JFrame frame2;
	public String filename;

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 350, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("<html>Track Controller UI</html>");
		lbl.setBounds(10, 10, 203, 91);
		frame2.getContentPane().add(lbl);
		
		JFormattedTextField filenameIn = new JFormattedTextField();
		filenameIn.setText("Paste PLC File Contents to Modify PLC Code.");
		filenameIn.setBounds(10, 75, 300, 100);
		frame2.getContentPane().add(filenameIn);
		
		String filename = filenameIn.getText();

		JButton uploadButton = new JButton("Upload");
		uploadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					 frame2.setVisible(false);
					 frame2.dispose();
			
			}
		});
		uploadButton.setBounds(0, 190, 117, 25);
		frame2.getContentPane().add(uploadButton);
				
	}
}
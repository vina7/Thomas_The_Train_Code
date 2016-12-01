package TrackController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrackControllerUI {

	private JFrame frame2;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackControllerUI window = new TrackControllerUI();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrackControllerUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 650, 400);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblCtcOffice = new JLabel("<html>Track Controller UI</html>");
		lblCtcOffice.setBounds(120, 12, 203, 91);
		frame2.getContentPane().add(lblCtcOffice);
		
		JLabel lblUsername = new JLabel("PLC Filename:");
		lblUsername.setBounds(130, 115, 150, 15);
		frame2.getContentPane().add(lblUsername);
		
		JFormattedTextField username = new JFormattedTextField();
		username.setText("Enter Filename, Path");
		username.setBounds(214, 115, 150, 19);
		frame2.getContentPane().add(username);

		JButton uploadButton = new JButton("Upload");
		uploadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					 frame2.setVisible(false);
					 frame2.dispose();
				
			}
		});
		uploadButton.setBounds(153, 205, 117, 25);
		frame2.getContentPane().add(uploadButton);
		
		
	}
}
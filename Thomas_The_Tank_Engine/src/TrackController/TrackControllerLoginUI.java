package TrackController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TrackControllerLoginUI {

	private JFrame frame;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackControllerLoginUI window = new TrackControllerLoginUI();
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
	public TrackControllerLoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCtcOffice = new JLabel("<html>Track Controller Login</html>");
		lblCtcOffice.setBounds(120, 12, 203, 91);
		frame.getContentPane().add(lblCtcOffice);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(130, 115, 150, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(130, 164, 150, 15);
		frame.getContentPane().add(lblPassword);
		
		JFormattedTextField username = new JFormattedTextField();
		username.setText("default");
		username.setBounds(214, 115, 150, 19);
		frame.getContentPane().add(username);
		
		password = new JPasswordField();
		password.setText("default");
		password.setBounds(214, 162, 150, 19);
		frame.getContentPane().add(password);
		
		JButton loginButton = new JButton("Log In");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TrackControllerLoginVerifier verifier = new TrackControllerLoginVerifier();
				if(verifier.verify(username.getText(),String.valueOf(password.getPassword()))){
					 frame.setVisible(false);
					 frame.dispose();
				}
			}
		});
		loginButton.setBounds(153, 205, 117, 25);
		frame.getContentPane().add(loginButton);
		
		
	}
}

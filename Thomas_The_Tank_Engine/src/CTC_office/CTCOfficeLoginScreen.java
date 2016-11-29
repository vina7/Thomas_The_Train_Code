package CTC_office;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CTCOfficeLoginScreen {

	private JFrame frame;
	private JPasswordField pwdCtc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CTCOfficeLoginScreen window = new CTCOfficeLoginScreen();
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
	public CTCOfficeLoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCtcOffice = new JLabel("<html><h3>CTC Office Track Model &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login Screen</h3></html>");
		lblCtcOffice.setBounds(120, 12, 203, 91);
		frame.getContentPane().add(lblCtcOffice);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(130, 115, 91, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(130, 164, 91, 15);
		frame.getContentPane().add(lblPassword);
		
		JFormattedTextField frmtdtxtfldDispatcher = new JFormattedTextField();
		frmtdtxtfldDispatcher.setText("dispatcher");
		frmtdtxtfldDispatcher.setBounds(214, 115, 71, 19);
		frame.getContentPane().add(frmtdtxtfldDispatcher);
		
		pwdCtc = new JPasswordField();
		pwdCtc.setText("CTC");
		pwdCtc.setBounds(214, 162, 71, 19);
		frame.getContentPane().add(pwdCtc);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(153, 205, 117, 25);
		frame.getContentPane().add(btnOk);
	}
}

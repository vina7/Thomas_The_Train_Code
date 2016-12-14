package CTC_office;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is used as the CTC office login screen's UI
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */
public class CTCOfficeLoginScreen extends JFrame {

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
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblCtcOffice = new JLabel(
				"<html><h3>CTC Office Track Model &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login Screen</h3></html>");
		lblCtcOffice.setBounds(120, 12, 203, 91);
		getContentPane().add(lblCtcOffice);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(130, 115, 91, 15);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(130, 164, 91, 15);
		getContentPane().add(lblPassword);

		JFormattedTextField frmtdtxtfldDispatcher = new JFormattedTextField();
		frmtdtxtfldDispatcher.setText("dispatcher");
		frmtdtxtfldDispatcher.setBounds(214, 115, 71, 19);
		getContentPane().add(frmtdtxtfldDispatcher);

		pwdCtc = new JPasswordField();
		pwdCtc.setText("CTC");
		pwdCtc.setBounds(214, 162, 71, 19);
		getContentPane().add(pwdCtc);

		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginScreenVerifier verifier = new LoginScreenVerifier();
				if (verifier.verify(frmtdtxtfldDispatcher.getText(), String.valueOf(pwdCtc.getPassword()))) {
					setVisible(false);
					dispose();
				}
			}
		});
		btnOk.setBounds(153, 205, 117, 25);
		getContentPane().add(btnOk);

	}
}

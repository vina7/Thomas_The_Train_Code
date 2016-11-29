import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Overall_Thomas_UI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Overall_Thomas_UI window = new Overall_Thomas_UI();
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
	public Overall_Thomas_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 164);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 0, 138);
		frame.getContentPane().add(separator);
		
		JButton btnCtcofficeTrack = new JButton("CTC_Office & Track Model");
		btnCtcofficeTrack.setBounds(12, 48, 210, 25);
		frame.getContentPane().add(btnCtcofficeTrack);
		
		JButton button = new JButton("Track Controller");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(245, 48, 147, 25);
		frame.getContentPane().add(button);
		
		JButton btnTrainModel = new JButton("Train Model");
		btnTrainModel.setBounds(417, 48, 117, 25);
		frame.getContentPane().add(btnTrainModel);
		
		JButton btnTrainController = new JButton("Train Controller");
		btnTrainController.setBounds(561, 48, 147, 25);
		frame.getContentPane().add(btnTrainController);
	}
}

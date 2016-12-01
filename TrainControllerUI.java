import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class TrainControllerUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainControllerUI window = new TrainControllerUI();
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
	public TrainControllerUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.setBounds(100, 100, 713, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Open");
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton_2.setBounds(117, 126, 69, 25);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Close");
		rdbtnNewRadioButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton_3.setBounds(191, 126, 76, 25);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Open");
		rdbtnNewRadioButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton_4.setBounds(117, 157, 69, 25);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Close");
		rdbtnNewRadioButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnNewRadioButton_5.setBounds(191, 157, 84, 25);
		frame.getContentPane().add(rdbtnNewRadioButton_5);
		
		JSlider slider = new JSlider();
		slider.setMaximum(70);
		slider.setBounds(12, 280, 200, 26);
		frame.getContentPane().add(slider);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Emergency Brake");
		tglbtnNewToggleButton.setForeground(Color.RED);
		tglbtnNewToggleButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tglbtnNewToggleButton.setBounds(283, 126, 176, 56);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Service Brake");
		tglbtnNewToggleButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tglbtnNewToggleButton_1.setBounds(502, 126, 176, 56);
		frame.getContentPane().add(tglbtnNewToggleButton_1);
		
		JLabel lblNewLabel = new JLabel("Left Doors:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 126, 90, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Right Doors:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 160, 114, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Set Speed:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(12, 241, 90, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(106, 241, 80, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Block Speed Limit:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(265, 241, 163, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Current Speed:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(298, 279, 124, 27);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(428, 280, 114, 26);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Power:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setBounds(359, 312, 68, 25);
		frame.getContentPane().add(lblNewLabel_7);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(86, 10, 150, 34);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_8 = new JLabel("Train ID:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_8.setBounds(8, 9, 76, 34);
		frame.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Automatic");
		btnNewButton.setBounds(440, 10, 119, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manual");
		btnNewButton_1.setBounds(566, 10, 119, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Operation Mode:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_9.setBounds(291, 10, 137, 34);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Approaching Station:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_10.setBounds(12, 78, 174, 34);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(198, 78, 480, 34);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setBounds(428, 241, 114, 26);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(428, 312, 114, 26);
		frame.getContentPane().add(label_1);
	}
}

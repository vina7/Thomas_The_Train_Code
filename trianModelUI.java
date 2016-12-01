import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.TextArea;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.Action;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class trianModelUI {

	private JFrame frame;
	
	private static Movement train = new Movement(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trianModelUI window = new trianModelUI();
					window.frame.setVisible(true);
					
					   
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 
		   train.start();
	}

	/**
	 * Create the application.
	 */
	public trianModelUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton engineFailureButton = new JButton("Engine Failure");
		engineFailureButton.setBounds(12, 245, 396, 145);
		engineFailureButton.addActionListener( new ActionListener()
				{
		public void actionPerformed(ActionEvent e)
		{
			
		}
				}
		);
		JButton brakeFailureButton = new JButton("Brake Failure");
		brakeFailureButton.setBounds(12, 94, 396, 138);
		brakeFailureButton.addActionListener( new ActionListener()
		{
public void actionPerformed(ActionEvent e)
{
	
}
		}
);
		
		JButton signalPickupFailureButton = new JButton("Signal Pickup Failure");
		signalPickupFailureButton.setBounds(12, 403, 396, 145);
		signalPickupFailureButton.addActionListener( new ActionListener()
		{
public void actionPerformed(ActionEvent e)
{
	System.out.print("gi");
}
		}
);
		
		JLabel lblNewLabel = new JLabel("Failure Modes:");
		lblNewLabel.setBounds(12, 47, 125, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_1 = new JLabel("Left Door Status:");
		lblNewLabel_1.setBounds(445, 133, 135, 22);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Right Door Status:");
		lblNewLabel_2.setBounds(445, 94, 146, 22);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_3 = new JLabel("Current Speed");
		lblNewLabel_3.setBounds(445, 342, 112, 22);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_4 = new JLabel("Block Speed Limit:");
		lblNewLabel_4.setBounds(445, 238, 164, 22);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblSetSpeed = new JLabel("Set Speed");
		lblSetSpeed.setBounds(445, 273, 75, 22);
		lblSetSpeed.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblEmergencyBrakeStatus = new JLabel("Emergency Brake Status:");
		lblEmergencyBrakeStatus.setBounds(445, 203, 194, 22);
		lblEmergencyBrakeStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblServiceBrakeStatus = new JLabel("Service Brake Status:");
		lblServiceBrakeStatus.setBounds(445, 168, 164, 22);
		lblServiceBrakeStatus.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblEnginePower = new JLabel("Engine Power");
		lblEnginePower.setBounds(445, 308, 106, 22);
		lblEnginePower.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_9 = new JLabel("Grade");
		lblNewLabel_9.setBounds(445, 410, 48, 22);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblAcceleration = new JLabel("Acceleration");
		lblAcceleration.setBounds(445, 377, 97, 22);
		lblAcceleration.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel_4);
		frame.getContentPane().add(brakeFailureButton);
		frame.getContentPane().add(signalPickupFailureButton);
		frame.getContentPane().add(engineFailureButton);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblEmergencyBrakeStatus);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(lblServiceBrakeStatus);
		frame.getContentPane().add(lblNewLabel_9);
		frame.getContentPane().add(lblSetSpeed);
		frame.getContentPane().add(lblEnginePower);
		frame.getContentPane().add(lblNewLabel_3);
		frame.getContentPane().add(lblAcceleration);
		
		JLabel lblNewLabel_5 = new JLabel("Length");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(445, 445, 56, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Width");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6.setBounds(445, 474, 56, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Height:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setBounds(445, 503, 86, 16);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mass");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_8.setBounds(445, 532, 56, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel(""+train.getAcceleration());
		lblNewLabel_10.setBounds(583, 309, 56, 16);
		frame.getContentPane().add(lblNewLabel_10);
		
	}


}

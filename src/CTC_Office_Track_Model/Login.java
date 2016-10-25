package CTC_Office_Track_Model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
 JButton SUBMIT;
 JPanel panel;
 JLabel title,label1,label2;
 final JTextField  text1,text2;
  Login()
  {
  label1 = new JLabel();
  label1.setText("Username:");
  text1 = new JTextField(15);

  label2 = new JLabel();
  label2.setText("Password:");
  text2 = new JPasswordField(15);
 
  SUBMIT=new JButton("SUBMIT");
  
  panel=new JPanel(new GridLayout(3,1));
  panel.add(label1);
  panel.add(text1);
  panel.add(label2);
  panel.add(text2);
  panel.add(SUBMIT);
  add(panel,BorderLayout.CENTER);
  SUBMIT.addActionListener(this);
  setTitle("Thomas the Tank Engine CTC Office & Track Model");
  }
 public void actionPerformed(ActionEvent ae)
  {
  String value1=text1.getText();
  String value2=text2.getText();
  if (value1.equals("vin") && value2.equals("ctc")) {
	  setVisible(false);
	  dispose();
  }
  else{
  System.out.println("enter the valid username and password");
  JOptionPane.showMessageDialog(this,"Incorrect login or password",
  "Error",JOptionPane.ERROR_MESSAGE);
  }
 }
}

package CTC_office;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class CTCMapUI {

	private JFrame frame;
	List<ShapeItem> shapes = new ArrayList<ShapeItem>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CTCMapUI window = new CTCMapUI();
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
	public CTCMapUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
        shapes.add(new ShapeItem(new Rectangle2D.Double(5, 40, 60, 375),
                Color.BLACK, "Yard", "Yard"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(70, 40, 40, 10),
                Color.RED, "U", "RU"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(90, 55, 10, 45),
            Color.RED, "D", "RD"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(105, 90, 140, 10),
            Color.RED, "D", "RD"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(252, 90, 155, 10),
            Color.RED, "E", "RE" ));
        shapes.add(new ShapeItem(new Rectangle2D.Double(115, 40, 80, 10),
            Color.RED, "C", "RC"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(200, 20, 50, 50),
            Color.RED, "Shadyside", "Shadyside"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(255, 40, 70, 10),
            Color.RED, "B", "RB"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(330, 40, 60, 10),
            Color.RED, "A", "RA"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(395, 20, 50, 50),
            Color.RED, "Herron Ave","Herron Ave" ));
        shapes.add(new ShapeItem(new Rectangle2D.Double(415, 75, 10, 27),
            Color.RED, "E", "RE"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(450, 40, 130, 10),
            Color.RED, "F", "RF"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(585, 20, 50, 50),
            Color.RED, "Swissville", "Swissville"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(640, 40, 100, 10),
            Color.RED, "G", "RG"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(745, 40, 40, 10),
            Color.RED, "H", "RH"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(790, 20, 50, 50),
            Color.RED, "Penn Station", "Penn Station"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(845, 40, 130, 10),
            Color.RED, "H", "RH"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(870, 55, 10, 45),
            Color.RED, "T", "RT"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(885, 90, 70, 10),
            Color.RED, "S", "RS"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(960, 55, 10, 45),
            Color.RED, "R", "RR"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(980, 20, 50, 50),
            Color.RED, "Steel Plaza", "Steel Plaza"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1035, 40, 130, 10),
            Color.RED, "H", "RH"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1050, 55, 10, 45),
            Color.RED, "Q", "RQ"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1065, 90, 70, 10),
            Color.RED, "P", "RP"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1140, 55, 10, 45),
            Color.RED, "O","RO" ));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1170, 20, 50, 50),
            Color.RED, "First Ave","First Ave" ));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1225, 40, 130, 10),
            Color.RED, "I", "RI"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1360, 20, 50, 50),
            Color.RED, "Station Square","Station Square" ));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1415, 40, 60, 10),
            Color.RED, "J", "RJ"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1480, 40, 80, 10),
            Color.RED, "K", "RK"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1565, 40, 10, 50),
            Color.RED, "L", "RL"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1545, 95, 50, 50),
            Color.RED, "South Hills Junction", "South Hills Junction"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1460, 115, 80, 10),
            Color.RED, "M", "RM"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1445, 55, 10, 70),
            Color.RED, "N", "RN"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(70, 250, 40, 10),
            Color.GREEN, "YY", "GYY"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(115, 250, 70, 10),
            Color.GREEN, "K", "GK"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(190, 250, 50, 50),
            Color.GREEN, "Glenbury", "GGlenbury"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(245, 250, 70, 10),
            Color.GREEN, "K", "GK"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(320, 250, 70, 10),
            Color.GREEN, "L", "GL"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(395, 250, 50, 50),
            Color.GREEN, "Dormont", "Dormont" ));
        shapes.add(new ShapeItem(new Rectangle2D.Double(450, 250, 40, 10),
            Color.GREEN, "L", "GL"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(495, 250, 500, 10),
            Color.GREEN, "M", "GM"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1000, 250, 40, 10),
            Color.GREEN, "N", "GN"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1045, 250, 50, 50),
            Color.GREEN, "Mt. Lebanon", "Mt. Lebanon"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1100, 250, 60, 10),
            Color.GREEN, "N", "GN"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1165, 250, 80, 10),
            Color.GREEN, "O", "GO"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1250, 230, 50, 50),
            Color.GREEN, "Poplar", "Poplar"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1305, 250, 40, 10),
            Color.GREEN, "O", "GO"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1350, 250, 10, 40),
            Color.GREEN, "P", "GP"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1330, 295, 50, 50),
            Color.GREEN, "Castle Shannon", "Castle Shannon"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1165, 320, 160, 10),
            Color.GREEN, "P2", "GP"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1150, 265, 10, 65),
            Color.GREEN, "Q", "GQ"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1000, 265, 10, 30),
            Color.GREEN, "R", "GR")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(495, 285, 500, 10),
            Color.GREEN, "S", "GS")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(450, 285, 40, 10),
            Color.GREEN, "T", "GT")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(320, 285, 70, 10),
            Color.GREEN, "T", "GT")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(245, 285, 70, 10),
            Color.GREEN, "U", "GU")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(165, 285, 20, 10),
            Color.GREEN, "U", "GU")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(150, 285, 10, 40),
            Color.GREEN, "V", "GV")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(150, 330, 10, 40),
            Color.GREEN, "W", "GW")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(205, 370, 50, 10),
            Color.GREEN, "W", "GW")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(315, 370, 50, 10),
            Color.GREEN, "W", "GW")); 
        shapes.add(new ShapeItem(new Rectangle2D.Double(425, 370, 50, 10),
            Color.GREEN, "W", "GW"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(480, 370, 155, 10),
            Color.GREEN, "X", "GX"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(640, 370, 100, 10),
            Color.GREEN, "Y", "GY"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(745, 370, 10, 25),
            Color.GREEN, "Z", "GZ"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(70, 400, 40, 10),
            Color.GREEN, "ZZ", "GZZ"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(115, 400, 30, 10),
            Color.GREEN, "I", "GI"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(150, 365, 50, 50),
            Color.GREEN, "Overbrook", "Overbrook"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(205, 400, 50, 10),
            Color.GREEN, "I", "GI"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(260, 365, 50, 50),
            Color.GREEN, "Inglewood", "Inglewood"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(315, 400, 50, 10),
            Color.GREEN, "I", "GI"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(370, 365, 50, 50),
            Color.GREEN, "Central", "Central"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(425, 400, 50, 10),
            Color.GREEN, "I", "GI"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(480, 400, 50, 10),
            Color.GREEN, "H", "GH"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(535, 400, 50, 10),
            Color.GREEN, "G", "GG"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(590, 385, 50, 50),
            Color.GREEN, "South Bank","South Bank"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(645, 400, 100, 10),
            Color.GREEN, "G", "GG"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(750, 400, 80, 10),
            Color.GREEN, "F", "GF"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(835, 380, 50, 50),
            Color.GREEN, "Whited", "Whited"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(890, 400, 80, 10),
            Color.GREEN, "F", "GF"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(975, 400, 150, 10),
            Color.GREEN, "E", "GE"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1130, 400, 30, 10),
            Color.GREEN, "D", "GD"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1165, 380, 50, 50),
            Color.GREEN, "Station", "Station"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1220, 400, 50, 10),
            Color.GREEN, "D", "GD"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1275, 400, 100, 10),
            Color.GREEN, "C", "GC"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1380, 380, 50, 50),
            Color.GREEN, "Edgebrook", "Edgebrook"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1435, 400, 100, 10),
            Color.GREEN, "C", "GC"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1525, 415, 10, 70),
            Color.GREEN, "B", "GB"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1305, 475, 215, 10),
            Color.GREEN, "A","GA"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1250, 455, 50, 50),
            Color.GREEN, "Pioneer", "Pioneer"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(1265, 415, 10, 35),
            Color.GREEN, "A", "GA"));
        shapes.add(new ShapeItem(new Rectangle2D.Double(415, 500 , 60 ,10),
            Color.ORANGE, "Underground", "Underground"));
        shapes.add(new ShapeItem(new Ellipse2D.Double(815, 475, 50, 50),
            Color.BLACK, "Multiple Trains", "Multiple Trains"));
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel = new MapPanel(shapes);
		panel.setPreferredSize(new Dimension(1700,550));
		 frame.getContentPane().add(panel);
         frame.pack();
         frame.setTitle("Track Map");
         frame.setResizable(true);
         frame.setVisible(true);
         for (ShapeItem item : shapes) {
           if(item.getName().equals("Yard")){
             item.setColor(Color.BLUE);
             frame.repaint();
           }
         }
	}
	public void updateColor(String Section, String Line, Color color){
		if(Line.equals("Green")){
			String temp = "G"+Section;
			for (ShapeItem item : shapes) {	 
		           if(item.getID().equals(temp)){	  
		             item.setColor(color);
		             frame.repaint();
		           }
		         }
		}else if (Line.equals("Red")){
			String temp = "R"+Section;
			for (ShapeItem item : shapes) {
		           if(item.getName().equals(temp)){
		             item.setColor(color);
		             frame.pack();
		             frame.repaint();
		           }
		         }
			
		}
		
	}
}

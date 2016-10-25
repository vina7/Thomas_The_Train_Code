package CTC_Office_Track_Model;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.awt.Dimension;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
public class CTCOfficeMap{
       CTCOfficeMap()
	   { 
             List<ShapeItem> shapes = new ArrayList<ShapeItem>();
             shapes.add(new ShapeItem(new Rectangle2D.Double(5, 40, 60, 375),
                     Color.BLACK, "Yard"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(70, 40, 40, 10),
                     Color.RED, "U"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(90, 55, 10, 45),
                 Color.RED, "D"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(105, 90, 140, 10),
                 Color.RED, "D"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(252, 90, 155, 10),
                 Color.RED, "E"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(115, 40, 80, 10),
                 Color.RED, "C"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(200, 20, 50, 50),
                 Color.RED, "Shadyside"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(255, 40, 70, 10),
                 Color.RED, "B"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(330, 40, 60, 10),
                 Color.RED, "A"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(395, 20, 50, 50),
                 Color.RED, "Herron Ave"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(415, 75, 10, 27),
                 Color.RED, "E"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(450, 40, 130, 10),
                 Color.RED, "F"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(585, 20, 50, 50),
                 Color.RED, "Swissville"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(640, 40, 100, 10),
                 Color.RED, "G"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(745, 40, 40, 10),
                 Color.RED, "H"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(790, 20, 50, 50),
                 Color.RED, "Penn Station"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(845, 40, 130, 10),
                 Color.RED, "H"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(870, 55, 10, 45),
                 Color.RED, "T"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(885, 90, 70, 10),
                 Color.RED, "S"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(960, 55, 10, 45),
                 Color.RED, "R"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(980, 20, 50, 50),
                 Color.RED, "Steel Plaza"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1035, 40, 130, 10),
                 Color.RED, "H"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1050, 55, 10, 45),
                 Color.RED, "Q"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1065, 90, 70, 10),
                 Color.RED, "P"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1140, 55, 10, 45),
                 Color.RED, "0"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1170, 20, 50, 50),
                 Color.RED, "First Ave"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1225, 40, 130, 10),
                 Color.RED, "I"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1360, 20, 50, 50),
                 Color.RED, "Station Square"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1415, 40, 60, 10),
                 Color.RED, "J"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1480, 40, 80, 10),
                 Color.RED, "K"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1565, 40, 10, 50),
                 Color.RED, "L"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1545, 95, 50, 50),
                 Color.RED, "South Hills Junction"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1460, 115, 80, 10),
                 Color.RED, "M"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1445, 55, 10, 70),
                 Color.RED, "N"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(70, 250, 40, 10),
                 Color.GREEN, "YY"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(115, 250, 70, 10),
                 Color.GREEN, "K"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(190, 250, 50, 50),
                 Color.GREEN, "Glenbury"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(245, 250, 70, 10),
                 Color.GREEN, "K"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(320, 250, 70, 10),
                 Color.GREEN, "L"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(395, 250, 50, 50),
                 Color.GREEN, "Dormont"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(450, 250, 40, 10),
                 Color.GREEN, "L"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(495, 250, 500, 10),
                 Color.GREEN, "M"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1000, 250, 40, 10),
                 Color.GREEN, "N"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1045, 250, 50, 50),
                 Color.GREEN, "Mt. Lebanon"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1100, 250, 60, 10),
                 Color.GREEN, "N"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1165, 250, 80, 10),
                 Color.GREEN, "O"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1250, 230, 50, 50),
                 Color.GREEN, "Poplar"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1305, 250, 40, 10),
                 Color.GREEN, "O"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1350, 250, 10, 40),
                 Color.GREEN, "P"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1330, 295, 50, 50),
                 Color.GREEN, "Castle Shannon"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1165, 320, 160, 10),
                 Color.GREEN, "P2"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1150, 265, 10, 65),
                 Color.GREEN, "Q"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1000, 265, 10, 30),
                 Color.GREEN, "R")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(495, 285, 500, 10),
                 Color.GREEN, "S")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(450, 285, 40, 10),
                 Color.GREEN, "T")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(320, 285, 70, 10),
                 Color.GREEN, "T")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(245, 285, 70, 10),
                 Color.GREEN, "U")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(165, 285, 20, 10),
                 Color.GREEN, "U")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(150, 285, 10, 40),
                 Color.GREEN, "V")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(150, 330, 10, 40),
                 Color.GREEN, "W")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(205, 370, 50, 10),
                 Color.GREEN, "W")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(315, 370, 50, 10),
                 Color.GREEN, "W")); 
             shapes.add(new ShapeItem(new Rectangle2D.Double(425, 370, 50, 10),
                 Color.GREEN, "W"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(480, 370, 155, 10),
                 Color.GREEN, "X"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(640, 370, 100, 10),
                 Color.GREEN, "Y"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(745, 370, 10, 25),
                 Color.GREEN, "Z"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(70, 400, 40, 10),
                 Color.GREEN, "ZZ"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(115, 400, 30, 10),
                 Color.GREEN, "I"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(150, 365, 50, 50),
                 Color.GREEN, "Overbrook"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(205, 400, 50, 10),
                 Color.GREEN, "I"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(260, 365, 50, 50),
                 Color.GREEN, "Inglewood"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(315, 400, 50, 10),
                 Color.GREEN, "I"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(370, 365, 50, 50),
                 Color.GREEN, "Central"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(425, 400, 50, 10),
                 Color.GREEN, "I"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(480, 400, 50, 10),
                 Color.GREEN, "H"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(535, 400, 50, 10),
                 Color.GREEN, "G"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(590, 385, 50, 50),
                 Color.GREEN, "South Bank"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(645, 400, 100, 10),
                 Color.GREEN, "G"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(750, 400, 80, 10),
                 Color.GREEN, "F"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(835, 380, 50, 50),
                 Color.GREEN, "Whited"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(890, 400, 80, 10),
                 Color.GREEN, "F"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(975, 400, 150, 10),
                 Color.GREEN, "E"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1130, 400, 30, 10),
                 Color.GREEN, "D"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1165, 380, 50, 50),
                 Color.GREEN, "Station"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1220, 400, 50, 10),
                 Color.GREEN, "D"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1275, 400, 100, 10),
                 Color.GREEN, "C"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1380, 380, 50, 50),
                 Color.GREEN, "Edgebrook"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1435, 400, 100, 10),
                 Color.GREEN, "C"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1525, 415, 10, 70),
                 Color.GREEN, "B"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1305, 475, 215, 10),
                 Color.GREEN, "A"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(1250, 455, 50, 50),
                 Color.GREEN, "Pioneer"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(1265, 415, 10, 35),
                 Color.GREEN, "A"));
             shapes.add(new ShapeItem(new Rectangle2D.Double(415, 500 , 60 ,10),
                 Color.ORANGE, "Underground"));
             shapes.add(new ShapeItem(new Ellipse2D.Double(815, 475, 50, 50),
                 Color.BLACK, "Multiple Trains"));
             JFrame frame = new JFrame();
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             MapPanel panel = new MapPanel(shapes);
             panel.setPreferredSize(new Dimension(1700,550));
             JScrollPane scrPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
             frame.add(scrPane);
             frame.setLocationByPlatform(true);
             frame.pack();
             frame.setTitle("Track Map");
             frame.setSize(1366,450);
             frame.setResizable(false);
             frame.setVisible(true);
             for (ShapeItem item : shapes) {
               if(item.getName().equals("Yard")){
                 item.setColor(Color.BLUE);
                 frame.repaint();
               }
             }
             
	   }
}

    
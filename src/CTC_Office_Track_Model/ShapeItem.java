package CTC_Office_Track_Model;

  import java.awt.Color;
  import java.awt.Dimension;
  import java.awt.Graphics;
  import java.awt.Graphics2D;
  import java.awt.Shape;
  import java.awt.event.MouseAdapter;
  import java.awt.event.MouseEvent;
  import java.awt.geom.Ellipse2D;
  import java.awt.geom.Rectangle2D;
  import java.util.ArrayList;
  import java.util.List;
  import java.util.Random;

  import javax.swing.JFrame;
  import javax.swing.JPanel;
  import javax.swing.SwingUtilities;

 
      class ShapeItem {
          private Shape shape;
          private Color color;
          private String name;
          public ShapeItem(Shape shape, Color color, String name) {
              super();
              this.shape = shape;
              this.color = color;
              this.name = name;
          }

          public Shape getShape() {
              return shape;
          }
          public String getName() {
            return name;
          }

          public void setShape(Shape shape) {
              this.shape = shape;
          }

          public Color getColor() {
              return color;
          }

          public void setColor(Color color) {
              this.color = color;
          }
      }


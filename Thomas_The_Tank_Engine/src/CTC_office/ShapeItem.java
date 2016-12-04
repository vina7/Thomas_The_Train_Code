package CTC_office;

import java.awt.Color;
import java.awt.Shape;



    class ShapeItem {
        private Shape shape;
        private Color color;
        private String name;
        private String id;
        public ShapeItem(Shape shape, Color color, String name, String id) {
            super();
            this.shape = shape;
            this.color = color;
            this.name = name;
            this.id = id;
        }

        public Shape getShape() {
            return shape;
        }
        public String getName() {
          return name;
        }

        public String getID() {
            return id;
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

package CTC_office;

import java.awt.Color;
import java.awt.Shape;



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

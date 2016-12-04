package CTC_office;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.List;


import javax.swing.JPanel;


    class MapPanel extends JPanel {
        private List<ShapeItem> shapes;

        public MapPanel(List<ShapeItem> shapesList) {
            this.shapes = shapesList;

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            for (ShapeItem item : shapes) {
                g2.setColor(item.getColor());
                g2.fill(item.getShape());  
                g2.setColor(Color.BLACK);
                g2.setFont(new Font("Times New Roman", Font.BOLD, 15));
                if(item.getName().equals("Shadyside") || 
                    item.getName().equals("Herron Ave") ||
                    item.getName().equals("Yard")|| 
                    item.getName().equals("Penn Station") || 
                    item.getName().equals("Steel Plaza") || item.getName().equals("Station Square") || item.getName().length() < 2){
                  g2.drawString(item.getName(),(int) item.getShape().getBounds2D().getX(),(int) item.getShape().getBounds2D().getY()-5);
                } else if(item.getName().equals("Underground") ){
                  g2.drawString(item.getName(),(int) item.getShape().getBounds2D().getX()+70,(int) item.getShape().getBounds2D().getY()+10);
                } else if (item.getName().equals("Multiple Trains")){
                  g2.drawString(item.getName(),(int) item.getShape().getBounds2D().getX()+60,(int) item.getShape().getBounds2D().getY()+30);
                }
                else if(item.getName().length() > 2){
                  g2.drawString(item.getName(),(int) item.getShape().getBounds2D().getX(),(int) item.getShape().getBounds2D().getY() + 70);
                  } 
            }

            g2.dispose();
        }
    }

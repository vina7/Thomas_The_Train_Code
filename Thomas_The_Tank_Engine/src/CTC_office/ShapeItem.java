package CTC_office;

import java.awt.Color;
import java.awt.Shape;

/**
 * This class is used as the shape item object for the map ui
 * 
 * @author Vinayak Nesarikar
 * @version 12/8/16
 *
 */

class ShapeItem {
	private Shape shape;
	private Color color;
	private String name;
	private String id;

	/**
	 * Constructor
	 * 
	 * @param shape
	 *            Shape object
	 * @param color
	 *            Color object
	 * @param name
	 *            Name of the shape
	 * @param id
	 *            Shape of the id
	 */
	public ShapeItem(Shape shape, Color color, String name, String id) {
		super();
		this.shape = shape;
		this.color = color;
		this.name = name;
		this.id = id;
	}

	/**
	 * Gets the shape object
	 * 
	 * @return shape object
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * Gets the shapeitem's name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the shapeitem's id
	 * 
	 * @return id
	 */
	public String getID() {
		return id;
	}

	/**
	 * Sets the shape object
	 * 
	 * @param shape
	 *            Shape object
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	/**
	 * Gets the shapeitem's color
	 * 
	 * @return color Color object
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Sets the shape item's color object
	 * 
	 * @param color
	 *            Color object
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}

package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public abstract class AbstractElement implements Element {

	protected Point p1, p2, upperLeftPoint;
	protected Dimension dimension;
	private Color elementColor;
	
	public AbstractElement(Color c) {
		this.elementColor = c;
	}
	
	public void setEndPoint(Point p2) {
		this.p2 = p2;
		upperLeftPoint = upperLeftPoint(p1, p2);
		dimension = dimension(p1, p2);
	}
	
	public Color getColor() {
		return elementColor;
	}

	public Point upperLeftPoint(Point p1, Point p2) {
		return new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
	}

	public Dimension dimension(Point p1, Point p2) {
		return new Dimension(1 + Math.abs(p1.x - p2.x), 1 + Math.abs(p1.y
			- p2.y));
	}
	
}

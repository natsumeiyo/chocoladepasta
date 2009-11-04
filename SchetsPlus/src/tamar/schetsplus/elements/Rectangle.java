package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Rectangle extends AbstractElement {
	
	protected Color elementColor;
	private boolean filled;
	
	public Rectangle(Point p1, Point p2, Color c, boolean filled) {
		this.p1 = p1;
		this.p2 = p2;
		elementColor = c;
		this.filled = filled;
	}

	public void paint(Graphics2D g) {
		g.setColor(elementColor);
		if (filled) {
			g.fillRect(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), Math
					.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));
		} else {
			g.drawRect(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), Math
					.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));
		}
	}

}

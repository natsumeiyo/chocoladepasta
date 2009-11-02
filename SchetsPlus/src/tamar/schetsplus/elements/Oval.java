package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Oval extends AbstractElement {
	
	protected Color elementColor;
	private boolean filled;
	
	public Oval(Point p1, Point p2, Color c, boolean filled) {
		this.p1 = p1;
		this.p2 = p2;
		elementColor = c;
		this.filled = filled;
	}

	public void paint(Graphics2D g) {
		g.setColor(elementColor);
		if (filled) {
			g.fillOval(p1.x, p1.y, Math.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));			
		} else {
			g.drawOval(p1.x, p1.y, Math.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));
		}
	}

}

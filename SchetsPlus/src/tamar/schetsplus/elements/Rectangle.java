package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Rectangle extends AbstractElement {
	
	private boolean filled;
	
	public Rectangle(Point p1, Point p2, Color c, boolean filled) {
		super(c);
		this.p1 = p1;
		this.p2 = p2;
		this.filled = filled;
	}

	public void paint(Graphics2D g) {
		g.setColor(getColor());
		if (filled) {
			g.fillRect(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), Math
					.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));
		} else {
			g.drawRect(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), Math
					.abs(p2.x - p1.x), Math.abs(p2.y - p1.y));
		}
	}

	public boolean hits(Point mp) {
		if (filled && mp.x > p1.x && mp.x < p2.x && mp.y > p1.y && mp.y < p2.y) {
			return true;
		}	
		if ((mp.x == p1.x || mp.x == p2.x) && (mp.y == p1.y || mp.y == p2.y)) {
			return true;
		}
		return false;
	}
	
	

}

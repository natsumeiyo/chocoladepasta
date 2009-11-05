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
			g.fillRect(upperLeftPoint.x, upperLeftPoint.y, dimension.width, dimension.height);
		} else {
			g.drawRect(upperLeftPoint.x, upperLeftPoint.y, dimension.width, dimension.height);
		}
	}

	public boolean isHitBy(Point mp) {
		if (filled && mp.x > p1.x && mp.x < p2.x && mp.y > p1.y && mp.y < p2.y) {
			return true;
		}
		if ((mp.x == p1.x || mp.x == p2.x) && (mp.y == p1.y || mp.y == p2.y)) {
			return true;
		}
		return false;
	}

}

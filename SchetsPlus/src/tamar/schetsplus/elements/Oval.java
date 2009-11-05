package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Oval extends AbstractElement {

	private boolean filled;

	public Oval(Point p1, Point p2, Color c, boolean filled) {
		super(c);
		this.p1 = p1;
		this.p2 = p2;
		this.filled = filled;
	}

	public void paint(Graphics2D g) {
		g.setColor(getColor());
		if (filled) {
			g.fillOval(upperLeftPoint.x, upperLeftPoint.y, dimension.width, dimension.height);
		} else {
			g.drawOval(upperLeftPoint.x, upperLeftPoint.y, dimension.width, dimension.height);
		}
	}

	public boolean isHitBy(Point mp) {
		if (filled) {
			
		}
//		if () {
//			
//		}	
		return false;
	}

}
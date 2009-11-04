package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends AbstractElement {
		
	public Line(Point p1, Point p2, Color c) {
		super(c);
		this.p1 = p1;	
		this.p2 = p2;
	}

	public void paint(Graphics2D g) {
		g.setColor(getColor());
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	public boolean hits(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

}

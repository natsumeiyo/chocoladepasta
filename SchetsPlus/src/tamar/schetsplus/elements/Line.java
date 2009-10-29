package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line implements Element {

	private Point p1, p2;
	private Color elementColor;
	
	public Line(Point p1, Point p2, Color c) {
		this.p1 = p1;
		this.p2 = p2;
		elementColor = c;
		
	}
	
	public void setEndPoint(Point p2) {
		this.p2 = p2;
	}

	public void paint(Graphics2D g) {
		g.setColor(elementColor);
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

}

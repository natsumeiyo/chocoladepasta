package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Rectangle extends ElementTool {
	
	private Color elementColor;
	
	public Rectangle(Point p1, Point p2, Color c) {
		this.p1 = p1;
		this.p2 = p2;
		elementColor = c;
	}

	public void paint(Graphics2D g) {
		g.setColor(elementColor);
		g.drawRect(p1.x, p1.y, p2.x, p2.y);
	}

}

package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Pen extends AbstractElement {
	
	private List<Point> points;

	public Pen(Color c) {
		points = new LinkedList<Point>();
		elementColor = c;
	}

	public void paint(Graphics2D g) {
		Point last = null;
		for (Point p : points) {
			if (last != null) {
				g.drawLine(last.x, last.y, p.x, p.y);
			}
			last = p;
		}
	}
	
	public void addPoint(Point p) {
		points.add(p);
	}

}

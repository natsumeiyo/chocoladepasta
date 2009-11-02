import java.awt.*;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Line;

class LijnTool extends TweepuntTool {
	
	public Element createElement(Point p1, Point p2, Color c) {
		return new Line(p1, p2, c);
	}

	public void tekenContour(Graphics g, Point p1, Point p2) {
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
}
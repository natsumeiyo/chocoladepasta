import java.awt.*;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Line;

class LijnTool extends TweepuntTool {
	
	public Element createElement(Point p, Color c) {
		return new Line(p, p, c);
	}

	public void drawIcon(Graphics2D g, int x, int y, int w, int h) {
		g.drawLine(x + 2, y + 2, x + w - 3, y + h - 3);
	}
	
	

//	public void tekenContour(Graphics g, Point p1, Point p2) {
//		g.drawLine(p1.x, p1.y, p2.x, p2.y);
//	}
}
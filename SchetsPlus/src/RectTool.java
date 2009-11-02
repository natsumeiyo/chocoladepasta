import java.awt.*;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Rectangle;

class RectTool extends TweepuntTool {
	
	private boolean filled;

	public RectTool(boolean filled) {
		this.filled = filled;
	}
		
	public Element createElement(Point p1, Point p2, Color c) {
		return new Rectangle (p1, p2, c, filled);
	}
	
	public void tekenContour(Graphics g, Point p1, Point p2) {
		Point xy = minimumPunt(p1, p2);
		Dimension wh = puntAfstand(p1, p2);
		g.drawRect(xy.x, xy.y, wh.width, wh.height);
	}
}
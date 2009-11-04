import java.awt.*;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Oval;

class OvalTool extends TweepuntTool {
	
	private boolean filled;

	public OvalTool(boolean filled) {
		this.filled = filled;
	}
	
	public Element createElement(Point p1, Point p2, Color c) {
		return new Oval(p1, p2, c, filled);
	}

//	public void tekenContour(Graphics g, Point p1, Point p2) {
//		Point xy = minimumPunt(p1, p2);
//		Dimension wh = puntAfstand(p1, p2);
//		g.drawOval(xy.x, xy.y, wh.width, wh.height);
//	}

}
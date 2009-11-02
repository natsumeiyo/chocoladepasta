import java.awt.*;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.FilledOval;

class FillOvalTool extends OvalTool {
	
	public Element createElement(Point p1, Point p2, Color c) {
		return new FilledOval(p1, p2, c);
	}
	
	public void tekenFiguur(Graphics g, Point p1, Point p2) {
		Point xy = minimumPunt(p1, p2);
		Dimension wh = puntAfstand(p1, p2);
		g.fillOval(xy.x, xy.y, wh.width, wh.height);
	}
}
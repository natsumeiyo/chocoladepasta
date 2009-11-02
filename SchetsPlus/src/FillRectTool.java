import java.awt.*;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.FilledRectangle;

class FillRectTool extends RectTool {
	
	public Element createElement(Point p1, Point p2, Color c) {
		return new FilledRectangle(p1, p2, c);
	}
	
	public void tekenFiguur(Graphics g, Point p1, Point p2) {
		Point xy = minimumPunt(p1, p2);
		Dimension wh = puntAfstand(p1, p2);
		g.fillRect(xy.x, xy.y, wh.width, wh.height);
	}
}
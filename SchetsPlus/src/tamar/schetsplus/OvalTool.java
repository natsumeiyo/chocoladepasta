package tamar.schetsplus;
import java.awt.*;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Oval;

class OvalTool extends TweepuntTool {
	
	private boolean filled;

	public OvalTool(boolean filled) {
		this.filled = filled;
	}
	
	public Element createElement(Point p, Color c) {
		return new Oval(p, p, c, filled);
	}

	public void drawIcon(Graphics2D g, int x, int y, int w, int h) {
		if (filled) {
			g.fillOval(x + 1, y + 2, x + w - 10, y + h - 10);	
		} else {
			g.drawOval(x + 1, y + 2, x + w - 10, y + h - 10);	
		}
	}

}
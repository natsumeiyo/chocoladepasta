import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import tamar.schetsplus.elements.*;

public class GumTool implements Tool {
	
	public void muisIngedrukt(SchetsCanv canvas, Point p) {
		for (Element e : canvas.getSchets().elements) {
			if (e.hits(p)) {
				canvas.getSchets().eraseElement(e);
				canvas.repaint();
				return;
			}
		}
	}

	public Element createElement(Point p, Color c) {
		return null;
	}

	public void letterIngetikt(SchetsCanv canvas, char c) {	
	}

	public void muisVersleept(SchetsCanv canvas, Point p) {
	}

	public void drawIcon(Graphics2D g, int x, int y, int w, int h) {		
	}
}
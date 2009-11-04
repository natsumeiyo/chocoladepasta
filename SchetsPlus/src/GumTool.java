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

// public void tekenContour(Graphics g, Point p1, Point p2) {
// ((Graphics2D) g).setStroke(new BasicStroke(7));
// g.setColor(Color.WHITE);
// super.tekenContour(g, p1, p2);
// }
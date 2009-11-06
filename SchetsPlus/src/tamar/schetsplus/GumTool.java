package tamar.schetsplus;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import tamar.schetsplus.elements.Element;

public class GumTool implements Tool {

	private List<Element> el;

	public void muisIngedrukt(SchetsCanv canvas, Point p) {
		el = canvas.getSchets().elements;
		// traverse the list backwards, so that the most recent element is
		// removed
		for (int i = el.size() - 1; i >= 0; i--) {
			if (el.get(i).isHitBy(p)) {
				canvas.getSchets().eraseElement(el.get(i));
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
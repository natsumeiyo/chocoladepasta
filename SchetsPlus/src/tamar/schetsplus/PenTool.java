package tamar.schetsplus;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Pen;

public class PenTool extends StartpuntTool {

	public Element createElement(Point p, Color c) {
		Pen pen = new Pen(c);
		pen.addPoint(p);
		return pen;
	}

	public void letterIngetikt(SchetsCanv canvas, char c) {
	}

	public void muisLosgelaten(SchetsCanv canvas, Point p) {
	}

	public void muisVersleept(SchetsCanv canvas, Point p) {
		((Pen) element).addPoint(p);
		canvas.repaint();
	}

	public void drawIcon(Graphics2D g, int x, int y, int w, int h) {		
	}
}

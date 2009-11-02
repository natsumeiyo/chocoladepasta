import java.awt.Color;
import java.awt.Point;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Pen;

public class PenTool extends StartpuntTool {

	public Element createElement(Point p1, Point p2, Color c) {
		Pen pen = new Pen(c);
		pen.addPoint(p1);
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
}

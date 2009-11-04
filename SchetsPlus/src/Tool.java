import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import tamar.schetsplus.elements.Element;

public interface Tool {
	
	Element createElement(Point p, Color c);
	
	void muisIngedrukt(SchetsCanv canvas, Point p);

//	void muisLosgelaten(SchetsCanv canvas, Point p);

	void muisVersleept(SchetsCanv canvas, Point p);

	void letterIngetikt(SchetsCanv canvas, char c);
	
	void drawIcon(Graphics2D g, int x, int y, int w, int h);
}

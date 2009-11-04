import java.awt.Color;
import java.awt.Point;

import tamar.schetsplus.elements.Element;

public interface Tool {
	
	Element createElement(Point p1, Point p2, Color c);
	
	void muisIngedrukt(SchetsCanv canvas, Point p);

//	void muisLosgelaten(SchetsCanv canvas, Point p);

	void muisVersleept(SchetsCanv canvas, Point p);

	void letterIngetikt(SchetsCanv canvas, char c);
	
//	void drawLogo(Graphics2D g);
}


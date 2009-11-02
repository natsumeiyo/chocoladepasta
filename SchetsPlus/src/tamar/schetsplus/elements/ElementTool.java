package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Point;

public abstract class ElementTool implements Element {

	protected Point p1, p2;
	protected Color elementColor;
	
	public void setEndPoint(Point p2) {
		this.p2 = p2;
	}
	
}

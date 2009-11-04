package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Point;

public abstract class AbstractElement implements Element {

	protected Point p1, p2;
	private Color elementColor;
	
	public AbstractElement(Color c) {
		this.elementColor = c;
	}
	
	public void setEndPoint(Point p2) {
		this.p2 = p2;
	}
	
	public Color getColor() {
		return elementColor;
	}
	
}

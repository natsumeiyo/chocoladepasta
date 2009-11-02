package tamar.schetsplus.elements;

import java.awt.Graphics2D;
import java.awt.Point;

public interface Element {
	
	public void setEndPoint(Point p2);
	
	public void paint(Graphics2D g);

}

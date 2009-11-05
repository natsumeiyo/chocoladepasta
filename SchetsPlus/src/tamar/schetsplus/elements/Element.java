package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public interface Element {
	
	public void setEndPoint(Point p2);
	
	public void paint(Graphics2D g);
	
	public Color getColor();
	
	public boolean isHitBy(Point p);
	
	public Point getMin();
	
	public Point getMax();

	Dimension dimension();

}

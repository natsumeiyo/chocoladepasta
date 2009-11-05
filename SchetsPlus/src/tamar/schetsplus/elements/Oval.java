package tamar.schetsplus.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

public class Oval extends AbstractElement {

	private boolean filled;

	public Oval(Point p1, Point p2, Color c, boolean filled) {
		super(c);
		this.p1 = p1;
		this.p2 = p2;
		this.filled = filled;
	}

	public void paint(Graphics2D g) {
		g.setColor(getColor());
		if (filled) {
			g.fillOval(getMin().x, getMin().y, dimension().width,
					dimension().height);
		} else {
			g.drawOval(getMin().x, getMin().y, dimension().width,
					dimension().height);
		}
	}

	public boolean isHitBy(Point mp) {
		if (filled) {
			Shape shape = new Ellipse2D.Float(getMin().x,
					getMin().y, dimension().width, dimension().height);
			return shape.contains(mp);
		} else {
			Stroke s = new BasicStroke(SELECTIONMARGIN);
			Shape shape = s.createStrokedShape(new Ellipse2D.Float(getMin().x,
					getMin().y, dimension().width, dimension().height));
			return shape.contains(mp);
		}
	}

}
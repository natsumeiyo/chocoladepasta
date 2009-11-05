package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

public class Rectangle extends AbstractElement {

	private boolean filled;

	public Rectangle(Point p1, Point p2, Color c, boolean filled) {
		super(c);
		this.p1 = p1;
		this.p2 = p2;
		this.filled = filled;
	}

	public void paint(Graphics2D g) {
		g.setColor(getColor());
		if (filled) {
			g.fillRect(getMin().x, getMin().y, dimension().width,
					dimension().height);
		} else {
			g.drawRect(getMin().x, getMin().y, dimension().width,
					dimension().height);
		}
	}

	public boolean isHitBy(Point mp) {
		if (filled) {
			return (mp.x > getMin().x && mp.x < getMax().x && mp.y > getMin().y && mp.y < getMax().y);
		} else {
			return Line2D.ptSegDist(getMin().x, getMin().y, getMax().x,
					getMin().y, mp.x, mp.y) <= SELECTIONMARGIN
					|| Line2D.ptSegDist(getMax().x, getMin().y, getMax().x,
							getMax().y, mp.x, mp.y) <= SELECTIONMARGIN
					|| Line2D.ptSegDist(getMax().x, getMax().y, getMin().x,
							getMax().y, mp.x, mp.y) <= SELECTIONMARGIN
					|| Line2D.ptSegDist(getMin().x, getMax().y, getMin().x,
							getMin().y, mp.x, mp.y) <= SELECTIONMARGIN;
		}
	}

}

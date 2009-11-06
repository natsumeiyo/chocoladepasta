package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.io.DataOutputStream;
import java.io.IOException;

public class Line extends AbstractElement {

	public Line(Point p1, Point p2, Color c) {
		super(c);
		this.p1 = p1;
		this.p2 = p2;
	}

	public void paint(Graphics2D g) {
		g.setColor(getColor());
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	public boolean isHitBy(Point mp) {
		return Line2D.ptSegDist(p1.x, p1.y, p2.x, p2.y, mp.x, mp.y) < SELECTIONMARGIN;
	}

	public void write(DataOutputStream dos) throws IOException {
		dos.writeUTF("Line");
		dos.write(getColor().getRGB());
		dos.write(p1.x);
		dos.write(p1.y);
		dos.write(p2.x);
		dos.write(p2.y);
	}

}

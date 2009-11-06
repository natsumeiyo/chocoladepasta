package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Pen extends AbstractElement {

	private List<Point> points;

	public Pen(Color c) {
		super(c);
		points = new LinkedList<Point>();
	}

	public void paint(Graphics2D g) {
		g.setColor(getColor());
		Point last = null;
		for (Point p : points) {
			if (last != null) {
				g.drawLine(last.x, last.y, p.x, p.y);
			}
			last = p;
		}
	}

	public void addPoint(Point p) {
		points.add(p);
	}

	public boolean isHitBy(Point mp) {
		Point last = null;
		for (Point p : points) {
			if (last != null
					&& Line2D.ptSegDist(last.x, last.y, p.x, p.y, mp.x, mp.y) < SELECTIONMARGIN) {
				return true;
			}
			last = p;
		}
		return false;
	}

	public void write(DataOutputStream dos) throws IOException {
		dos.writeUTF("Pen");
		dos.writeInt(getColor().getRGB());
		dos.writeInt(points.size());
		for (Point p : points) {
			dos.writeInt(p.x);
			dos.writeInt(p.x);

		}
	}
}
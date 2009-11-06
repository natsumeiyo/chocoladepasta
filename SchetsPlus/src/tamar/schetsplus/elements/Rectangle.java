package tamar.schetsplus.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.io.DataOutputStream;
import java.io.IOException;

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
			Shape shape = new Rectangle2D.Float(getMin().x,
					getMin().y, dimension().width, dimension().height);
			return shape.contains(mp);
		} else {
			Stroke s = new BasicStroke(SELECTIONMARGIN);
			Shape shape = s.createStrokedShape(new Rectangle2D.Float(getMin().x,
					getMin().y, dimension().width, dimension().height));
			return shape.contains(mp);
		}
	}

	public void write(DataOutputStream dos) throws IOException {
		dos.writeUTF("Rectangle");
		dos.writeBoolean(filled);
		dos.writeInt(getColor().getRGB());
		dos.writeInt(p1.x);
		dos.writeInt(p1.y);
		dos.writeInt(p2.x);
		dos.writeInt(p2.y);
	}

}

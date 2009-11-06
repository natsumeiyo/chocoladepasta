package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.DataOutputStream;
import java.io.IOException;

public class Text extends AbstractElement {

	String s;

	public Text(Color c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	public boolean isHitBy(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	public void write(DataOutputStream dos) throws IOException {
		dos.writeChars("Text");
		dos.write(getColor().getRGB());
		dos.write(p1.x);
		dos.write(p1.y);
		dos.writeChars(s);
	}
}
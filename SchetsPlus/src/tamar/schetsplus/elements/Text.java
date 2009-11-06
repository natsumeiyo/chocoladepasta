package tamar.schetsplus.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Text extends AbstractElement {

	private String s = "";

	public Text(Point p, Color c) {
		super(c);
		this.p1 = p;
	}

	public void paint(Graphics2D g) {
		g.setColor(getColor());
		g.drawString(s, p1.x, p1.y);
	}
	
	public boolean isHitBy(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	public void write(DataOutputStream dos) throws IOException {
		dos.writeUTF("Text");
		dos.writeInt(getColor().getRGB());
		dos.writeInt(p1.x);
		dos.writeInt(p1.y);
		dos.writeUTF(s);
	}

	public void addCharacter(char c) {
		s += c;
	}

	public void removeLastCharacter() {
		s = s.substring(0, s.length()-1);
	}
}
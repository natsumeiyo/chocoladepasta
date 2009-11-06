package tamar.schetsplus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Line;
import tamar.schetsplus.elements.Oval;
import tamar.schetsplus.elements.Pen;
import tamar.schetsplus.elements.Rectangle;
import tamar.schetsplus.elements.Text;

class Schets {
	protected List<Element> elements;

	Schets() {
		elements = new LinkedList<Element>();
	}

	public void teken(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		for (Element e : elements) {
			g.setColor(e.getColor());
			e.paint(g);
		}
	}

	public void addElement(Element e) {
		elements.add(e);
	}

	public void eraseElement(Element e) {
		elements.remove(e);
	}

	public void clear() {
		elements.clear();
	}

	public void write(File file) throws IOException {
		OutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		dos.write(elements.size());
		for (Element e : elements) {
			e.write(dos);
		}
	}

	public void read(File file) throws IOException {
		InputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		int numberOfElements = dis.read();
		for (int i = 0; i < numberOfElements; i++) {
			String elementName = dis.readUTF();
			if (elementName.equals("Rectangle")) {
				Boolean filled = dis.readBoolean();
				Color c = new Color(dis.readInt());
				Point p1 = new Point(dis.readInt(), dis.readInt());
				Point p2 = new Point(dis.readInt(), dis.readInt());
				addElement(new Rectangle(p1, p2, c, filled));
			}
			if (elementName.equals("Oval")) {
				Boolean filled = dis.readBoolean();
				Color c = new Color(dis.readInt());
				Point p1 = new Point(dis.readInt(), dis.readInt());
				Point p2 = new Point(dis.readInt(), dis.readInt());
				addElement(new Oval(p1, p2, c, filled));
			}
			if (elementName.equals("Line")) {
				Color c = new Color(dis.readInt());
				Point p1 = new Point(dis.readInt(), dis.readInt());
				Point p2 = new Point(dis.readInt(), dis.readInt());
				addElement(new Line(p1, p2, c));
			}
			if (elementName.equals("Pen")) {
				Color c = new Color(dis.readInt());
				int numberOfPoints = dis.readInt();
				Pen pen = new Pen(c);
				addElement(pen);
				for (int p = 0; p < numberOfPoints; p++) {
					pen.addPoint(new Point(dis.readInt(), dis.readInt()));
				}
			}
			if (elementName.equals("Text")) {
				Color c = new Color(dis.readInt());
				Point p1 = new Point(dis.readInt(), dis.readInt());
				Text text = new Text(p1, c);
				addElement(text);
				String s = dis.readUTF();
				text.setString(s);
			}
		}
	}
}
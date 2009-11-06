package tamar.schetsplus;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import tamar.schetsplus.elements.Element;

class Schets {
	protected List<Element> elements;

	Schets() {
		elements = new LinkedList<Element>();
	}

	public void teken(Graphics g1) {
		System.out.println("Schets bevat " + elements.size() + " elementen.");
		Graphics2D g = (Graphics2D) g1;
		for (Element e : elements) {
			g.setColor(e.getColor());
			e.paint(g);
		}
	}

	public void resize(int w, int h) {
//		if (w != bitmap.getWidth() || h != bitmap.getHeight()) {
//			BufferedImage nieuw = new BufferedImage(w, h,
//					BufferedImage.TYPE_INT_RGB);
//			Graphics g = nieuw.getGraphics();
//			g.setColor(Color.WHITE);
//			g.fillRect(0, 0, w, h);
//			g.drawImage(bitmap, 0, 0, null);
//			bitmap = nieuw;
//		}
	}

	public void addElement(Element e) {
		elements.add(e);
	}
	
	public void eraseElement(Element e) {
		elements.remove(e);
	}
	
	public Graphics getBitmapGraphics() {
//		return bitmap.getGraphics();
		return null;
	}

	public void clear() {
		elements.clear();
	}
	
	public void write(File file) throws IOException {
		OutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		for (Element e : elements) {
				e.write(dos);
		}
	}
}
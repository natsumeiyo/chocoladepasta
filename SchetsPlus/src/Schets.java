import java.awt.Graphics;
//import java.awt.Color;
//import java.awt.image.BufferedImage;
import java.util.LinkedList;

class Schets {
//	private BufferedImage bitmap;
	private LinkedList<Element> elements;

	Schets() {
		elements = new LinkedList<Element>();
//		bitmap = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	}

	public void teken(Graphics g) {
//		g.drawImage(bitmap, 0, 0, null);
		
		for (int i = elements.size() - 1; i >= 0; i++) {
			elements.get(i).draw(g);
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

	public Graphics getBitmapGraphics() {
//		return bitmap.getGraphics();
		return this.getBitmapGraphics();
	}

	public void clear() {
//		Graphics g = bitmap.getGraphics();
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
	}
}
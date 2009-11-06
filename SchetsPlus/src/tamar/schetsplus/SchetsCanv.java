package tamar.schetsplus;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class SchetsCanv extends JPanel {
	private Schets schets;
	private Color penkleur = Color.BLACK;

	public SchetsCanv() {
		schets = new Schets();
	}

	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(1f));
		
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		g2.setColor(Color.BLACK);
		schets.teken(g2);
		
	}

	public void setBounds(int x, int y, int w, int h) {
		super.setBounds(x, y, w, h);
		this.repaint();
	}

	public Schets getSchets() {
		return schets;
	}
	
	public void setPenkleur(Color c) {
		penkleur = c;
	}
	
	public Color getPenkleur() {
		return penkleur;
	}

	public void clear() {
		schets.clear();
		this.repaint();
	}
	
	public void writePNG(File f) throws IOException {
		BufferedImage image = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		paint(image.createGraphics());
		ImageIO.write(image, "png", f);
	}
	
	private static final long serialVersionUID = 1;
}
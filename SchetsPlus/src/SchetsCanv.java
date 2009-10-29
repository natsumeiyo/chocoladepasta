import java.awt.*;

import javax.swing.*;

class SchetsCanv extends JPanel {
	private Schets schets;
	private Color penkleur = Color.BLACK;

	public SchetsCanv() {
		schets = new Schets();
	}

	public void update(Graphics g) {
		this.paint(g);
	}

	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(1f));
		
		schets.teken(g2);
		
	}

	public void setBounds(int x, int y, int w, int h) {
		schets.resize(w, h);
		super.setBounds(x, y, w, h);
		this.repaint();
	}

	public Graphics getBitmapGraphics() {
		Graphics g = schets.getBitmapGraphics();
		g.setColor(penkleur);
		return g;
	}

	public Schets getSchets() {
		return schets;
	}
	
	public void setPenkleur(Color c) {
		penkleur = c;
	}

	public void clear() {
		schets.clear();
		this.repaint();
	}

	private static final long serialVersionUID = 1;
}
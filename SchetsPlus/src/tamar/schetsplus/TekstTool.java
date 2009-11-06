package tamar.schetsplus;
import java.awt.*;
import java.awt.font.*;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Text;

class TekstTool extends StartpuntTool {
		
	private Font font = new Font("Helvetica", Font.BOLD, 24);

	public void letterIngetikt(SchetsCanv canvas, char c) {
//		startpunt.x += this.tekenTekst(canvas, p, "" + c);
		canvas.repaint();
	}

	public void muisVersleept(SchetsCanv canvas, Point p) {
	}

	public void muisLosgelaten(SchetsCanv canvas, Point p) {
	}

	public int tekenTekst(SchetsCanv canvas, Point p, String s) {
		Graphics g = canvas.getBitmapGraphics();
		g.setFont(font);
		this.tekenTekst(g, p, s);
		FontRenderContext frc = ((Graphics2D) g).getFontRenderContext();
		return font.getStringBounds(s, frc).getBounds().width;
	}

	public void tekenTekst(Graphics g, Point p, String s) {
		g.drawString(s, p.x, p.y);
	}

	public Element createElement(Point p, Color c) {
		return new Text(c);
	}

	public void drawIcon(Graphics2D g, int x, int y, int w, int h) {
		g.setFont(new Font("Helvetica", Font.BOLD, h - 5));
		g.drawString("Tx", x + 2, y + h - 2);
	}


}
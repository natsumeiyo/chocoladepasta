package tamar.schetsplus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Text;

class TekstTool extends StartpuntTool {

	public void letterIngetikt(SchetsCanv canvas, char c) {
		Text text = (Text) element;
		System.out.println((int) c);
		if (c == 8) {
			text.removeLastCharacter();
		} else {
			text.addCharacter(c);			
		}
		canvas.repaint();
	}

	// public int tekenTekst(SchetsCanv canvas, Point p, String s) {
	// Graphics g = canvas.getBitmapGraphics();
	// g.setFont(font);
	// this.tekenTekst(g, p, s);
	// FontRenderContext frc = ((Graphics2D) g).getFontRenderContext();
	// return font.getStringBounds(s, frc).getBounds().width;
	// }

	public Element createElement(Point p, Color c) {
		Text text = new Text(p, c);
		return text;
	}

	public void drawIcon(Graphics2D g, int x, int y, int w, int h) {
		g.setFont(new Font("Helvetica", Font.BOLD, h - 5));
		g.drawString("Tx", x + 2, y + h - 2);
	}

	public void muisVersleept(SchetsCanv canvas, Point p) {
	}

}
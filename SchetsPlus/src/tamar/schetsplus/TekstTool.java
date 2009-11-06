package tamar.schetsplus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

import tamar.schetsplus.elements.Element;
import tamar.schetsplus.elements.Text;

class TekstTool extends StartpuntTool {

	public void letterIngetikt(SchetsCanv canvas, char c) {
		Text text = (Text) element;
		if (c == 8) {
			// backspace key
			text.removeLastCharacter();
		} else {
			if (c == 10) {
				// return key
				Text newText = (Text) createElement(text.getReturnPoint(), text.getColor());
				canvas.getSchets().addElement(newText);
				element = newText;
			} else {
				// all other keys
				text.addCharacter(c);
			}
		}
		canvas.repaint();
	}

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
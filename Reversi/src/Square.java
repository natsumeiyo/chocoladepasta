import java.awt.Color;
import java.awt.Graphics;

/**
 * A Java applet that generates the gameboard Reversi.
 * 
 * @author Tamar van Steenbergen, student no. 3233308
 */

public class Square {

	final int row, column;
	int owner;
	int pixelsPerSquare = 40;

	public Square(int r, int c, int o) {
		row = r;
		column = c;
		owner = o;
	}

	public void paint(Graphics g, boolean legalMove) {
		// paint the squares according to their status
		
		if ((row % 2) == (column % 2)) {
			g.setColor(Color.WHITE);
		} else {
			g.setColor(new Color(200, 200, 200));
		}
		g.fillRect(pixelsPerSquare * column, pixelsPerSquare * row,
				pixelsPerSquare, pixelsPerSquare);

		if (!isFree()) {
			if (owner == 1) {
				g.setColor(new Color(255, 50, 50));
			}
			if (owner == 2) {
				g.setColor(new Color(50, 50, 255));
			}
			g.fillOval(pixelsPerSquare * column + 4, pixelsPerSquare * row
					+ 4, pixelsPerSquare - 10, pixelsPerSquare - 10);
		}
		
		if (legalMove) {
			g.setColor(Color.BLACK);
			g.drawOval(pixelsPerSquare * column + 9, pixelsPerSquare * row
					+ 9, pixelsPerSquare - 20, pixelsPerSquare - 20);
		}

	}

	public boolean isFree() {
		// is particular square free?
		return owner == 0;
	}
	
	public int getOwner() {
		// get owner of particular square
		return owner;
	}

	public void setOwner(int o) {
		// set owner of particular square
		owner = o;
	}

}

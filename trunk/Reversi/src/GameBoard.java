import java.awt.*;
import java.awt.event.*;

public class GameBoard extends Canvas implements MouseListener {

	int pixelsPerSquare, canvasWidth, canvasHeight;
	int numberOfRows, numberOfColumns;
	int player;
	Graphics gr;

	Square[][] board;

	public GameBoard(int rows, int columns) {
		pixelsPerSquare = 40;
		numberOfRows = rows;
		numberOfColumns = columns;
		canvasWidth = numberOfColumns * pixelsPerSquare;
		canvasHeight = numberOfRows * pixelsPerSquare;
		setSize(canvasWidth, canvasHeight);

		board = new Square[numberOfRows][numberOfColumns];

		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				board[r][c] = new Square(r, c, 0);
			}
		}

		setUpGameboard();

		addMouseListener(this);
	}

	public void setUpGameboard() {

		player = 1;

		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				board[r][c].setOwner(0);
			}
		}

		int rp = numberOfRows / 2;
		int cp = numberOfColumns / 2;

		board[rp - 1][cp - 1].setOwner(1);
		board[rp][cp].setOwner(1);
		board[rp - 1][cp].setOwner(2);
		board[rp][cp - 1].setOwner(2);

	}

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(1f));

		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				board[r][c].paint(g2);
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		int r = e.getY() / pixelsPerSquare;
		int c = e.getX() / pixelsPerSquare;
		board[r][c].setOwner(player);
		player = player == 1 ? 2 : 1;
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	private static final long serialVersionUID = 1;
}

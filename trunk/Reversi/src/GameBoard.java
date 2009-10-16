import java.awt.*;
import java.awt.event.*;

public class GameBoard extends Canvas implements MouseListener {

	int pixelsPerSquare, canvasWidth, canvasHeight;
	int numberOfRows, numberOfColumns;
	int player;
	boolean showLegalMoves;

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
		showLegalMoves = false;

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

	public boolean legalMove(Square s) {
		if (!s.isFree()) {
			return false;
		}

		for (Direction d : Direction.values()) {
			if (legalDirection(s, d)) {
				return true;
			}
		}
		return false;
	}

	private Square neighbor(Square s, Direction d) {
		return board[s.row + d.dy][s.column + d.dx];
	}

	private boolean hasNeighbor(Square s, Direction d) {
		return ((s.column + d.dx) >= 0)
				&& ((s.column + d.dx) < numberOfColumns)
				&& ((s.row + d.dy) >= 0) && ((s.row + d.dy) < numberOfRows);
	}

	private boolean legalDirection(Square s, Direction d) {

		if (hasNeighbor(s, d)) {
			s = neighbor(s, d);

			while (!s.isFree() && hasNeighbor(s, d) && s.getOwner() != player) {
				s = neighbor(s, d);

				if (s.getOwner() == player) {
					return true;
				}
			}
		}

		return false;
	}

	public void paint(Graphics g) {
		System.out.println("painting board");

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(1f));

		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				board[r][c].legalMove = legalMove(board[r][c]);
			}
		}

		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				board[r][c].paint(g2, showLegalMoves);
			}
		}

	}

	public Square getSquareAt(int mx, int my) {
		int c = mx / pixelsPerSquare;
		int r = my / pixelsPerSquare;
		return board[r][c];
	}

	public void mouseClicked(MouseEvent e) {
		Square s = getSquareAt(e.getX(), e.getY());

		if (legalMove(s)) {
			doMove(s);
		}
	}

	private int otherPlayer() {
		return 3 - player;
	}

	private void doMove(Square s) {
		s.setOwner(player);

		for (Direction d : Direction.values()) {
			if (legalDirection(s, d)) {
				doMoveDirection(s, d);
			}
		}

		player = otherPlayer();
		repaint();
	}

	private void doMoveDirection(Square s, Direction d) {
		s = neighbor(s, d);
		while (s.getOwner() == otherPlayer()) {
			s.setOwner(player);
			s = neighbor(s, d);
		}
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

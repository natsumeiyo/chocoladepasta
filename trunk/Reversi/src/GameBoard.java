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
		return (s.isFree() && legalDirection(s));
	}

	public boolean legalDirection(Square s) {

		for (Direction d : Direction.values()) {
			if (onBoard(s, d) && otherOwner(s, d) && endsInCurrentPlayer(s, d)) {
				return true;
			}
		}

		return false;
	}	
	
	private boolean otherOwner(Square s, Direction d) {
		Square n = neighbor(s, d);
		return !(n.isFree() || player == n.getOwner());
	}

	private Square neighbor(Square s, Direction d) {
		return board[s.row + d.dy][s.column + d.dx];
	}

	private boolean onBoard(Square s, Direction d) {
		return ((s.column + d.dx) >= 0)
				&& ((s.column + d.dx) < numberOfColumns)
				&& ((s.row + d.dy) >= 0)
				&& ((s.row + d.dy) < numberOfRows);
	}
	
	private boolean endsInCurrentPlayer(Square s, Direction d) {
		
		int r = s.row + d.dy;
		int c = s.column + d.dx;
	
		while (onBoard(board[r][c], d) && !board[r][c].isFree()
				&& board[r][c].owner != player) {

			r += d.dy;
			c += d.dx;

			if (board[r][c].getOwner() == player) {
				return true;
			}
			

	
		}
		return false;
	}

	public void paint(Graphics g) {
		
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

	public void mouseClicked(MouseEvent e) {
		int r = e.getY() / pixelsPerSquare;
		int c = e.getX() / pixelsPerSquare;

		if (legalMove(board[r][c])) {
			board[r][c].setOwner(player);
			player = player == 1 ? 2 : 1;
			repaint();
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

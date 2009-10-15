import java.awt.*;
import java.awt.event.*;

public class GameBoard extends Canvas implements MouseListener {

	int pixelsPerSquare, canvasWidth, canvasHeight;
	int numberOfRows, numberOfColumns;
	int player;
	Graphics gr;

	Square[][] board;
	private int[][] directions = { 
			{ -1, -1 }, // N-W
			{  0, -1 }, // N
			{  1, -1 }, // N-E
			{  1,  0 }, // E
			{  1,  1 }, // S-E
			{  0,  1 }, // S
			{ -1,  1 }, // S-W
			{ -1,  0 }, // W
	};

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
		
		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				board[r][c].legalMove = legalMove(board[r][c]);
			}
		}

	}

	public boolean legalMove(Square s) {
		return (s.isFree() && legalDirection(s));
	}

	public boolean legalDirection(Square s) {

		for (int i = 0; i < directions.length; i++) {
			if (onBoard(s, directions[i]) 
					&& otherOwner(s, directions[i])
					&& endsInCurrentPlayer(s, directions[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean otherOwner(Square s, int[] d) {
		Square n = neighbor(s, d);
		return !(n.isFree() || player == n.getOwner());
	}

	private Square neighbor(Square s, int[] d) {
		return board[s.row + d[1]][s.column + d[0]];
	}

	private boolean onBoard(Square s, int[] d) {
		return ((s.column + d[0]) >= 0)
				&& ((s.column + d[0]) < numberOfColumns)
				&& ((s.row + d[1]) >= 0)
				&& ((s.row + d[1]) < numberOfRows);
	}
	private boolean onBoard(int r, int c) {
		return c >= 0 && c < numberOfColumns
		&& r >= 0 && r < numberOfRows;
	}
	
	private boolean endsInCurrentPlayer(Square s, int[] d) {
		
		int r = s.row + d[1];
		int c = s.column + d[0];
	
		while (onBoard(r, c) && !board[r][c].isFree() && board[r][c].owner != player) {
			r += d[1];
			c += d[0];
			
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
				board[r][c].paint(g2);
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		int r = e.getY() / pixelsPerSquare;
		int c = e.getX() / pixelsPerSquare;
		if (board[r][c].legalMove) {
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

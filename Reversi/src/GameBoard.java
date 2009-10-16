import java.awt.*;

/**
 * A Java applet that generates the gameboard Reversi.
 * 
 * @author Tamar van Steenbergen, student no. 3233308
 */

public class GameBoard extends Canvas {

	int numberOfRows, numberOfColumns;
	int player;
	boolean showLegalMoves, endGame;

	// the dimensions
	int pixelsPerSquare, canvasWidth, canvasHeight;
	
	Square[][] board;

	public GameBoard(int rows, int columns) {
		pixelsPerSquare = 40;
		numberOfRows = rows;
		numberOfColumns = columns;
		canvasWidth = numberOfColumns * pixelsPerSquare;
		canvasHeight = numberOfRows * pixelsPerSquare;
		setSize(canvasWidth, canvasHeight);

		board = new Square[numberOfRows][numberOfColumns];

		// create the gameboard's squares
		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				board[r][c] = new Square(r, c, 0);
			}
		}

		// initiate game
		setUpGameboard();

	}

	public void setUpGameboard() {
		// initial game settings
		
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
		// is this move legal?
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
		// take step to neigboring square
		return board[s.row + d.dy][s.column + d.dx];
	}

	private boolean hasNeighbor(Square s, Direction d) {
		// does a square have a neighbor in a certain direction? 
		return ((s.column + d.dx) >= 0)
				&& ((s.column + d.dx) < numberOfColumns)
				&& ((s.row + d.dy) >= 0) && ((s.row + d.dy) < numberOfRows);
	}

	private boolean legalDirection(Square s, Direction d) {
		// is moving in this direction legal?

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
		// paint board
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(1f));

		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				board[r][c].paint(g, showLegalMoves && legalMove(board[r][c]));
			}
		}

	}

	public Square getSquareAt(int mx, int my) {
		// which square was clicked by player?
		int c = mx / pixelsPerSquare;
		int r = my / pixelsPerSquare;
		return board[r][c];
	}

	public int otherPlayer() {
		return 3 - player;
	}

	public String getStatusText() {
		// show how many squares each player owns
		String s1 = "RED has " + getNumberOfStones(1)
				+ " stones\nBLUE has " + getNumberOfStones(2) + " stones";
		String s2 = "\n";
		String s3 = "'s turn";
		if (player == 1) {
			s2 = "\n\nRED";
			return s1 + s2 + s3;
		} else {
			if (player == 2) {
				s2 = "\n\nBLUE";
				return s1 + s2 + s3;
			}
		}
		return s1;
	}
	
	public int getNumberOfStones(int player) {
		// how many squares does each players own?
		int i = 0;
		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				if (board[r][c].getOwner() == player) {
					i++;
				}
			}
		}
		return i;
	}

	public void squareClicked(int mx, int my) {
		// accept player's move if move is legal
		Square s = getSquareAt(mx, my);

		if (legalMove(s)) {
			doMove(s);
		}

	}

	private void doMove(Square s) {
		s.setOwner(player);

		for (Direction d : Direction.values()) {
			// switch stones' owner in all legal directions
			if (legalDirection(s, d)) {
				doMoveDirection(s, d);
			}
		}

		player = otherPlayer();
		
		if (!canMove()) {
			// switch player if current player has no legal moves
			player = otherPlayer();
			if (!canMove()) {
				// end game if both players have no legal moves
				endGame = true;
			}
		}
		
		repaint();
	}
	
	public boolean canMove() {
		// are there any legal moves for the current player?
		for (int r = 0; r < numberOfRows; r++) {
			for (int c = 0; c < numberOfColumns; c++) {
				if (legalMove(board[r][c])) {
					return true;
				}
			}
		}
		return false;
	}

	private void doMoveDirection(Square s, Direction d) {
		// switch stones' owner in certain direction
		
		s = neighbor(s, d);
		while (s.getOwner() == otherPlayer()) {
			s.setOwner(player);
			s = neighbor(s, d);
		}
	}

	public String getWinner() {
		// which player has won?
		
		int player1 = getNumberOfStones(1);
		int player2 = getNumberOfStones(2);
		
		if (player1 > player2) {
			return "RED wins with " + player1 + " to " + player2 + "!";
		} else {
			if (player1 < player2) {
				return "BLUE wins with " + player2 + " to " + player1 + "!";
			}
		}
		return "it's a draw!";
	}

	private static final long serialVersionUID = 1;

}

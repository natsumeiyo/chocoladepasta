import java.applet.Applet;

import java.awt.*;
import java.awt.event.*;

public class Reversi extends Applet implements ActionListener, MouseListener {

	GameBoard gameBoard;
	Button newGame, pass, help;
	Label status;

	public void init() {
		Panel buttons, canvas;

		setBackground(new Color(240, 240, 240));

		setLayout(new BorderLayout());

		buttons = new Panel();
		buttons.setLayout(new FlowLayout());

		newGame = new Button("New Game");
		buttons.add(newGame);
		newGame.addActionListener(this);

		help = new Button("Help");
		buttons.add(help);
		help.addActionListener(this);

		add(buttons, BorderLayout.NORTH);

		status = new Label("RED has 2 stones\nBLUE has 2 stones\n\nRED's turn",
				Label.CENTER);
		add(status, BorderLayout.CENTER);

		canvas = new Panel();
		canvas.setLayout(new FlowLayout());
		gameBoard = new GameBoard(
				Integer.parseInt(getParam("boardWidth", "6")), 
				Integer.parseInt(getParam("boardHeight", "6")));
		canvas.add(gameBoard);
		add(canvas, BorderLayout.SOUTH);

		gameBoard.addMouseListener(this);
	}

	private String getParam(String name, String def) {
		// if there is no HTML file, make sure text fields still get a default
		// value

		String value = getParameter(name);
		if (value == null) {
			value = def;
		}
		return value;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			gameBoard.setUpGameboard();
			status.setText("RED has 2 stones\nBLUE has 2 stones\n\nRED's turn");
		} else {
			gameBoard.showLegalMoves = !gameBoard.showLegalMoves;
		}

		gameBoard.repaint();
	}

	public void mouseClicked(MouseEvent e) {
		gameBoard.squareClicked(e.getX(), e.getY());

		if (gameBoard.endGame) {
			status.setText("Game over. " + gameBoard.getWinner());
		} else {
			status.setText(gameBoard.getStatusText());
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

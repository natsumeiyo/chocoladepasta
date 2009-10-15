import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Reversi extends Applet implements ActionListener {

	GameBoard gameBoard;
	Button newGame, help;

	public void init() {
		
		newGame = new Button("New Game");
		add(newGame);
		newGame.addActionListener(this);

		help = new Button("Help");
		add(help);
		help.addActionListener(this);

		gameBoard = new GameBoard(6, 6);
		add(gameBoard);
	}

	public void actionPerformed(ActionEvent e) {
		if  (e.getSource() == newGame) {
			gameBoard.setUpGameboard();
		} else {
			// show game options
		}
		gameBoard.repaint();
	}

	
	private static final long serialVersionUID = 1;

}

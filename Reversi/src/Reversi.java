import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Reversi extends Applet implements ActionListener {

	GameBoard gameBoard;
	Button newGame, pass, help;
	Label status;

	public void init() {
		
		setBackground(new Color(240, 240, 240));
		
		newGame = new Button("New Game");
		add(newGame);
		newGame.addActionListener(this);
		
		pass = new Button("Pass");
		add(pass);
		pass.addActionListener(this);

		help = new Button("Help");
		add(help);
		help.addActionListener(this);
		
//		status = new Label("blabla", Label.CENTER);
//		add(status);
//		status.setBackground(Color.WHITE);

		gameBoard = new GameBoard(6, 6);
		add(gameBoard);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newGame) {
			gameBoard.setUpGameboard();
		} else {
			if (e.getSource() == help) {
				gameBoard.showLegalMoves = !gameBoard.showLegalMoves;
			} else {
				if (e.getSource() == pass) {
					gameBoard.player = gameBoard.player == 1 ? 2 : 1;
				}
			}
		}

		gameBoard.repaint();
	}

	
	private static final long serialVersionUID = 1;

}

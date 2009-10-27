import java.awt.event.*;
import javax.swing.*;

public class ControlAktie extends AbstractAction {
	private SchetsCanv canvas;

	public ControlAktie(SchetsCanv canvas, String naam, String tip) {
		super(naam);
		this.canvas = canvas;
		putValue(Action.SHORT_DESCRIPTION, tip);
	}

	public void actionPerformed(ActionEvent event) {
		String naam = (String) this.getValue(Action.NAME);
		if (naam.equals("Clear"))
			canvas.clear();
	}

	private static final long serialVersionUID = 1;
}
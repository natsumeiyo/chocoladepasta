package tamar.schetsplus;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class FileAction extends AbstractAction {
	private SchetsCanv canvas;

	public FileAction(SchetsCanv canvas, String naam, String tip) {
		super(naam);
		this.canvas = canvas;
		putValue(Action.SHORT_DESCRIPTION, tip);
	}

	public void actionPerformed(ActionEvent event) {
		String naam = (String) this.getValue(Action.NAME);
		if (naam.equals("Save")) {
			File f = new File("drawing.txt");
			try {
				canvas.getSchets().write(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (naam.equals("Open")) {
			canvas.clear();
			File f = new File("drawing.txt");
			try {
				canvas.getSchets().read(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			canvas.repaint();
		}
	}

	private static final long serialVersionUID = 1;
}

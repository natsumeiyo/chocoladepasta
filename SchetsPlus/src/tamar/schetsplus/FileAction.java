package tamar.schetsplus;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;

public class FileAction extends AbstractAction {
	private SchetsCanv canvas;

	JFileChooser chooser;

	public FileAction(SchetsCanv canvas, String naam, String tip) {
		super(naam);
		this.canvas = canvas;
		putValue(Action.SHORT_DESCRIPTION, tip);

		chooser = new JFileChooser();
	}

	public void actionPerformed(ActionEvent event) {
		String naam = (String) this.getValue(Action.NAME);
		if (naam.equals("Save")) {
			int result = chooser.showSaveDialog(canvas);
			if (result == JFileChooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
				try {
					canvas.getSchets().write(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (naam.equals("Open")) {
			int result = chooser.showOpenDialog(canvas);
			if (result == JFileChooser.APPROVE_OPTION) {
				canvas.clear();
				File f = chooser.getSelectedFile();
				try {
					canvas.getSchets().read(f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				canvas.repaint();
			}
		}
	}

	private static final long serialVersionUID = 1;
}

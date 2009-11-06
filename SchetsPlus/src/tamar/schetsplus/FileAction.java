package tamar.schetsplus;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

public class FileAction extends AbstractAction {
	private SchetsCanv canvas;

	JFileChooser chooser;

	public FileAction(SchetsCanv canvas, String naam, String tip) {
		super(naam);
		this.canvas = canvas;
		putValue(Action.SHORT_DESCRIPTION, tip);
		if (naam.startsWith("Save")) {
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.META_MASK));
		} else if (naam.startsWith("Open")) {
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.META_MASK));
		}

		chooser = new JFileChooser();
	}

	public void actionPerformed(ActionEvent event) {
		String naam = (String) this.getValue(Action.NAME);
		if (naam.startsWith("Save")) {
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
		if (naam.startsWith("Open")) {
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

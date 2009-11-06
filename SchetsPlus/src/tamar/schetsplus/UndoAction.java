package tamar.schetsplus;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class UndoAction extends AbstractAction {
	
	private SchetsCanv canvas;

	public UndoAction(SchetsCanv canvas) {
		super("Undo");
		putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.META_MASK));
		this.canvas = canvas;
	}

	public void actionPerformed(ActionEvent e) {
		canvas.getSchets().eraseLastElement();
		canvas.repaint();
	}
}

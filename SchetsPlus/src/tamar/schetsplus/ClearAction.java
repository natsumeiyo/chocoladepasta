package tamar.schetsplus;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class ClearAction extends AbstractAction {

	SchetsCanv canvas;

	public ClearAction(SchetsCanv canvas) {
		super("Clear");
		this.canvas = canvas;
		putValue(Action.SHORT_DESCRIPTION, "Clear canvas");
		putValue(Action.NAME, "Clear");
	}

	public void actionPerformed(ActionEvent event) {
		canvas.clear();
	}
	
	private static final long serialVersionUID = 1;
}

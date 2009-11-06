package tamar.schetsplus;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JColorChooser;

public class ColorAction extends AbstractAction {

	SchetsApplet applet;
	ColorIcon colorIcon;

	public ColorAction(SchetsApplet applet, Icon icon) {
		super("Color");
		this.applet = applet;
		colorIcon = (ColorIcon) icon;
		putValue(Action.SHORT_DESCRIPTION, "Pick a color");
		putValue(Action.SMALL_ICON, icon);
	}

	public void actionPerformed(ActionEvent arg0) {
		Color c = JColorChooser.showDialog(null, "Color", Color.BLACK);
		colorIcon.setColor(c);
		applet.canvas.setPenkleur(c);
		applet.repaint();
	}

	private static final long serialVersionUID = 1;
}

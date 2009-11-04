import java.awt.event.*;
import javax.swing.*;

public class ToolAktie extends AbstractAction {
	protected Tool tool;
	protected SchetsApplet applet;

	public ToolAktie(SchetsApplet applet, String naam, String tip, Tool tool,
			Icon icon) {
		super(naam /* ,icon */); // twee parameters geeft icons in de menu's
		this.applet = applet;
		this.tool = tool;
		putValue(Action.DEFAULT, icon);
		putValue(Action.SHORT_DESCRIPTION, tip);
	}

	public ToolAktie(SchetsApplet applet, String naam, String tip,
			TweepuntTool tool) {
		this(applet, naam, tip, tool, new ToolIcon(tool));
	}

	public ToolAktie(SchetsApplet applet, String naam, String tip,
			TekstTool tool) {
		this(applet, naam, tip, tool, new TekstIcon(tool));
	}

	public void actionPerformed(ActionEvent event) {
		applet.setCurrentTool(tool);
	}

	private static final long serialVersionUID = 1;
}
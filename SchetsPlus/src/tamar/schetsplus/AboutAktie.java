package tamar.schetsplus;
import java.awt.event.*;
import javax.swing.*;

public class AboutAktie extends AbstractAction {
	public AboutAktie() {
		super("About");
	}

	public void actionPerformed(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "SketchEditor version 2", "About",
				JOptionPane.INFORMATION_MESSAGE);
	}

	private static final long serialVersionUID = 1;
}
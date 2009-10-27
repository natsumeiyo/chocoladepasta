import java.awt.event.*;

public class WindowSluiter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
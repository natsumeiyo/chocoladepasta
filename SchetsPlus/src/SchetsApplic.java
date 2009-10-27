import java.awt.*;
import javax.swing.JFrame;

public class SchetsApplic extends JFrame {
	SchetsApplic() {
		this.setSize(800, 600);
		this.setTitle("Schets editor");
		this.setBackground(Color.LIGHT_GRAY);
		this.addWindowListener(new WindowSluiter());
		this.getContentPane().add(new SchetsApplet(true), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new SchetsApplic().setVisible(true);
	}

	private static final long serialVersionUID = 1;
}
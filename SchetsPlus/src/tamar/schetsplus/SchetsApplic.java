package tamar.schetsplus;
import java.awt.*;
import javax.swing.JFrame;

public class SchetsApplic extends JFrame {
	SchetsApplic() {
		this.setSize(800, 600);
		this.setTitle("Schets editor");
		this.setBackground(Color.LIGHT_GRAY);
		this.addWindowListener(new WindowSluiter());
		this.getContentPane().add(new SchetsApplet(true), BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) { 
		System.out.println(System.getProperty("user.dir"));
		new SchetsApplic().setVisible(true);
	}

	private static final long serialVersionUID = 1;
}
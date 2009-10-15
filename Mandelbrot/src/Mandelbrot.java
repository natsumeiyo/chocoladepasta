import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A program that generates a Mandelbrot fractal.
 * 
 * @author Tamar van Steenbergen Student no. 3233308
 */

public class Mandelbrot extends Applet implements MouseListener,
		ActionListener, ItemListener {

	// the x- and y-coordinates of the centre of the Mandelbrot space
	double xOrigin, yOrigin;

	double scaleFactor;
	int iterations;
	int zoomFactor;

	TextField xOriginTextField, yOriginTextField, iterationsTextField,
			scaleFactorTextField, zoomFactorTextField;

	// the color theme drop-down menu
	Choice colorThemeMenu;

	// the reset-button
	Button resetButton;

	// the names of the different color themes
	String[] colorThemeStrings = { "Gray", "Green", "Fire", "Coffee", "Rainbow" };

	public void init() {

		// add all text fields with initial values
		xOriginTextField = new TextField(""
				+ Double.parseDouble(getParam("xOrigin", "0")), 8);
		add(xOriginTextField);
		xOriginTextField.addActionListener(this);
		xOrigin = Double.parseDouble(getParam("xOrigin", "0"));

		yOriginTextField = new TextField(""
				+ Double.parseDouble(getParam("yOrigin", "0")), 8);
		add(yOriginTextField);
		yOriginTextField.addActionListener(this);
		yOrigin = Double.parseDouble(getParam("yOrigin", "0"));

		iterationsTextField = new TextField(""
				+ Integer.parseInt(getParam("iterations", "100")), 8);
		add(iterationsTextField);
		iterationsTextField.addActionListener(this);
		iterations = Integer.parseInt(getParam("iterations", "100"));

		scaleFactorTextField = new TextField(""
				+ Double.parseDouble(getParam("scaleFactor", "0.01")), 8);
		add(scaleFactorTextField);
		scaleFactorTextField.addActionListener(this);
		scaleFactor = Double.parseDouble(getParam("scaleFactor", "0.01"));

		zoomFactorTextField = new TextField(""
				+ Integer.parseInt(getParam("zoomFactor", "2")), 8);
		add(zoomFactorTextField);
		zoomFactorTextField.addActionListener(this);
		zoomFactor = Integer.parseInt(getParam("zoomFactor", "2"));

		// the color theme menu
		colorThemeMenu = new Choice();
		add(colorThemeMenu);
		for (int t = 0; t < colorThemeStrings.length; t++) {
			colorThemeMenu.add(colorThemeStrings[t]);
		}
		colorThemeMenu.addItemListener(this);
		colorThemeMenu.select(Integer.parseInt(getParam("colorTheme", "0")));

		// the reset-button
		resetButton = new Button("Reset");
		this.add(resetButton);
		resetButton.addActionListener(this);

		// listen to mouse-clicking
		addMouseListener(this);

	}

	private String getParam(String name, String def) {
		// if there is no HTML file, make sure text fields still get a default value
		
		String value = getParameter(name);
		if (value == null) {
			value = def;
		}
		return value;
	}

	private int mandelNumber(double x, double y) {
		// the mandel number formula

		int i = 0;
		double a, aTemp, b;
		a = 0;
		b = 0;
		while ((a * a + b * b) <= 4 && i < iterations) {
			aTemp = a * a - b * b + x;
			b = 2 * a * b + y;
			a = aTemp;
			i++;
		}

		return i;
	}

	public void paint(Graphics g) {
		// generate mandelbrot

		for (int xpixel = 0; xpixel < getWidth(); xpixel++) {
			for (int ypixel = 0; ypixel < getHeight(); ypixel++) {
				g.setColor(mandelColor(mandelNumber(toMandelX(xpixel),
						toMandelY(ypixel))));
				g.fillRect(xpixel, ypixel, 1, 1);

			}
		}
	}

	// convert pixel space (xpixel, ypixel) to mandelbrot space (x, y)
	private double toMandelX(int xpixel) {
		return scaleFactor * (xpixel - getWidth() / 2) + xOrigin;
	}

	private double toMandelY(int ypixel) {
		return -scaleFactor * (ypixel - getHeight() / 2) + yOrigin;
	}

	private Color mandelColor(int mandelNumber) {
		// generate color theme
		
		// get user-selected color theme
		int colorTheme = colorThemeMenu.getSelectedIndex();
		
		Color c;
		c = Color.BLACK;

		switch (colorTheme) {
		case 0:
			// gray
			c = new Color(mandelNumber * 255 / iterations, mandelNumber * 255 / iterations, mandelNumber * 255 / iterations);
			break;
		case 1:
			// green
			c = new Color(0, mandelNumber * 255 / iterations, 0);
			break;
		case 2:
			// fire
			if (mandelNumber == iterations) {
				c = Color.BLACK;
			} else {
				c = colorCombinationGenerator(Color.BLACK, Color.RED, Color.YELLOW, mandelNumber);
			}
			break;
		case 3:
			// coffee
			if (mandelNumber == iterations) {
				c = Color.BLACK;
			} else {
				c = colorCombinationGenerator(Color.BLACK, new Color(139, 69,
						19), new Color(222, 184, 135), mandelNumber);
			}
			break;
		case 4:
			// rainbow
			return Color.getHSBColor((float) mandelNumber / iterations * 2 / 3, 1, 1);
		}

		return c;
	}

	private Color colorCombinationGenerator(Color startColor, Color middleColor, Color endColor, int mandelNumber) {
		// generate color combination
		
		int r, b, g;
		r = g = b = 0;
		if (mandelNumber < iterations / 2) {
			// mg value between 0 and 48
			r = 2 * mandelNumber * (middleColor.getRed() - startColor.getRed()) / iterations;
			g = 2 * mandelNumber * (middleColor.getGreen() - startColor.getGreen()) / iterations;
			b = 2 * mandelNumber * (middleColor.getBlue() - startColor.getBlue()) / iterations;
		} else {
			// mg value between 49 and 99
			r = (mandelNumber - iterations / 2) * 2 * (endColor.getRed() - middleColor.getRed())
					/ iterations + middleColor.getRed();
			g = (mandelNumber - iterations / 2) * 2 * (endColor.getGreen() - middleColor.getGreen())
					/ iterations + middleColor.getGreen();
			b = (mandelNumber - iterations / 2) * 2 * (endColor.getBlue() - middleColor.getBlue())
					/ iterations + middleColor.getBlue();
		}

		return new Color(r, g, b);
	}

	public void mouseClicked(MouseEvent e) {
		// assign new values to variables and text fields when mouse is clicked

		if (e.getY() < 75) {
			// Ugly hack: make sure the applet doesn't zoom in when a text field
			// is clicked.
			return;
		}

		xOrigin = toMandelX(e.getX());
		yOrigin = toMandelY(e.getY());

		// normal click zooms in, ctrl+click or right-click zooms out
		if (e.getButton() == MouseEvent.BUTTON3 || e.isControlDown())
			scaleFactor *= zoomFactor;
		else
			scaleFactor /= zoomFactor;

		xOriginTextField.setText("" + xOrigin);
		yOriginTextField.setText("" + yOrigin);
		iterationsTextField.setText("" + iterations);
		scaleFactorTextField.setText("" + scaleFactor);
		zoomFactorTextField.setText("" + zoomFactor);

		repaint();
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent e) {
		// assign new values to variables and text fields when action is performed
		
		if (e.getSource() == resetButton) {
			// set text field values to default when reset-button is clicked
			xOriginTextField.setText("0");
			yOriginTextField.setText("0");
			iterationsTextField.setText("100");
			scaleFactorTextField.setText("0.01");
			zoomFactorTextField.setText("2");
		}

		xOrigin = Double.parseDouble(xOriginTextField.getText());
		yOrigin = Double.parseDouble(yOriginTextField.getText());
		iterations = Integer.parseInt(iterationsTextField.getText());
		scaleFactor = Double.parseDouble(scaleFactorTextField.getText());
		zoomFactor = Integer.parseInt(zoomFactorTextField.getText());

		repaint();

	}

	public void itemStateChanged(ItemEvent e) {
		// repaint when user selects a color theme
		repaint();
	}

	private static final long serialVersionUID = 1;
}

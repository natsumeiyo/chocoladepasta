import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Mandelbrot extends Applet implements MouseListener, ActionListener {

	double xOrigin, yOrigin, scaleFactor;
	int iterations, zoomFactor;
	TextField xOriginTextField, yOriginTextField, iterationsTextField,
			scaleFactorTextField, zoomFactorTextField;
	Choice colorThemeMenu;

	String[] colorThemeStrings = { "Black and White", "Gray", "Red", "Green",
			"Blue", "Purple", "Yellow", "Rainbow" };

	public void init() {

		xOriginTextField = new TextField("0.0", 10);
		add(xOriginTextField);
		xOriginTextField.addActionListener(this);
		xOrigin = 0.0;

		yOriginTextField = new TextField("0.0", 10);
		add(yOriginTextField);
		yOriginTextField.addActionListener(this);
		yOrigin = 0.0;

		iterationsTextField = new TextField("50", 10);
		add(iterationsTextField);
		iterationsTextField.addActionListener(this);
		iterations = 50;

		scaleFactorTextField = new TextField("0.01", 10);
		add(scaleFactorTextField);
		scaleFactorTextField.addActionListener(this);
		scaleFactor = 0.01;

		zoomFactorTextField = new TextField("2", 10);
		add(zoomFactorTextField);
		zoomFactorTextField.addActionListener(this);
		zoomFactor = 2;

		addMouseListener(this);

		colorThemeMenu = new Choice();
		add(colorThemeMenu);
		for (int t = 0; t < colorThemeStrings.length; t++) {
			colorThemeMenu.add(colorThemeStrings[t]);
		}
		colorThemeMenu.select(1);

	}

	private int mandelNumber(double x, double y) {

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

	private Color mandelColor(int ms) {

		int colorTheme = colorThemeMenu.getSelectedIndex();

		int r, g, b;
		r = g = b = 0;
		double saturation = 0.3;

		/*
		 * String[] colorThemeStrings = { "Black and White", "Gray", "Red",
		 * "Green", "Blue", "Purple", "Yellow", "Rainbow" };
		 */

		switch (colorTheme) {
		case 0:
			// black and white
			if (ms % 2 == 1) {
				r = g = b = 255;
			} else {
				r = g = b = 0;
			}
			break;
		case 1:
			// gray
			r = g = b = ms * 255 / iterations;
			break;
		case 2:
			// red
			r = 255;
			g = b = 255 - ms * 255 / iterations;
			break;
		case 7:
			return Color.getHSBColor((float) ms / iterations * 2 / 3, 1, 1);
		}

		return new Color(r, g, b);

	}

	private double toMandelX(int xpixel) {
		return scaleFactor * (xpixel - getWidth() / 2) + xOrigin;
	}

	private double toMandelY(int ypixel) {
		return -scaleFactor * (ypixel - getHeight() / 2) + yOrigin;
	}

	public void paint(Graphics g) {

		for (int xpixel = 0; xpixel < getWidth(); xpixel++) {
			for (int ypixel = 0; ypixel < getHeight(); ypixel++) {
				g.setColor(mandelColor(mandelNumber(toMandelX(xpixel),
						toMandelY(ypixel))));
				g.fillRect(xpixel, ypixel, 1, 1);

			}
		}
	}

	public void mouseClicked(MouseEvent e) {

		if (e.getY() < 50) {
			// Ugly hack: make sure the applet doesn't zoom in when a text field
			// is clicked.
			return;
		}

		xOrigin = toMandelX(e.getX());
		yOrigin = toMandelY(e.getY());

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

		xOrigin = Double.parseDouble(xOriginTextField.getText());
		yOrigin = Double.parseDouble(yOriginTextField.getText());
		iterations = Integer.parseInt(iterationsTextField.getText());
		scaleFactor = Double.parseDouble(scaleFactorTextField.getText());
		zoomFactor = Integer.parseInt(zoomFactorTextField.getText());

		repaint();

	}

	private static final long serialVersionUID = 1;
}

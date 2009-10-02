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

public class Mandelbrot extends Applet implements MouseListener,
		ActionListener, ItemListener {

	double xOrigin, yOrigin, scaleFactor;
	int iterations, zoomFactor;
	TextField xOriginTextField, yOriginTextField, iterationsTextField,
			scaleFactorTextField, zoomFactorTextField;
	Choice colorThemeMenu;
	Button resetButton;

	String[] colorThemeStrings = { "Gray", "Green", "Fire", "Rainbow" };

	public void init() {

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

		addMouseListener(this);

		colorThemeMenu = new Choice();
		add(colorThemeMenu);
		for (int t = 0; t < colorThemeStrings.length; t++) {
			colorThemeMenu.add(colorThemeStrings[t]);
		}
		colorThemeMenu.addItemListener(this);
		colorThemeMenu.select(Integer.parseInt(getParam("colorTheme", "0")));

		resetButton = new Button("Reset");
		this.add(resetButton);
		resetButton.addActionListener(this);

	}

	private String getParam(String name, String def) {
		String value = getParameter(name);
		if (value == null) {
			value = def;
		}
		return value;
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

	private Color mandelColor(int mg) {

		int colorTheme = colorThemeMenu.getSelectedIndex();

		int r, g, b;
		r = g = b = 0;

		switch (colorTheme) {
		case 0:
			// gray
			r = g = b = mg * 255 / iterations;
			break;
		case 1:
			// green
			g = mg * 200 / iterations;
			r = b = 0;
			break;
		case 2:
			// fire
			if (mg == iterations) {
				r = g = b = 0;
			} else {
				// mg: 0 - 99
				if (mg < iterations / 2) {
					// mg: 0 - 48
					r = 2 * mg * 255 / iterations;
					g = 0;
				} else {
					// 49 - 99
					r = 255;
					g = (mg - iterations / 2) * 2 * 255 / iterations;
					// 2 * mg * 255 / iterations;
				}

				b = 0;
			}
			break;
		case 3:
			// rainbow
			return Color.getHSBColor((float) mg / iterations * 2 / 3, 1, 1);
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

		if (e.getY() < 75) {
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

		if (e.getSource() == resetButton) {
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

	private static final long serialVersionUID = 1;

	public void itemStateChanged(ItemEvent e) {
		repaint();
	}
}

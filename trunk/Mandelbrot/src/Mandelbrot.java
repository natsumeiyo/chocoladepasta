import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Mandelbrot extends Applet implements MouseListener, ActionListener {

	double xOrigin, yOrigin, scaleFactor;
	int iterations, zoomFactor;
	TextField xOriginTextField, yOriginTextField, iterationsTextField,
			scaleFactorTextField, zoomFactorTextField;

	public void init() {

		xOriginTextField = new TextField("0.0", 10);
		this.add(xOriginTextField);
		xOriginTextField.addActionListener(this);
		xOrigin = 0.0;

		yOriginTextField = new TextField("0.0", 10);
		this.add(yOriginTextField);
		yOriginTextField.addActionListener(this);
		yOrigin = 0.0;

		iterationsTextField = new TextField("50", 10);
		this.add(iterationsTextField);
		iterationsTextField.addActionListener(this);
		iterations = 50;

		scaleFactorTextField = new TextField("0.01", 10);
		this.add(scaleFactorTextField);
		scaleFactorTextField.addActionListener(this);
		scaleFactor = 0.01;

		zoomFactorTextField = new TextField("2", 10);
		this.add(zoomFactorTextField);
		zoomFactorTextField.addActionListener(this);
		zoomFactor = 2;

		this.addMouseListener(this);

	}

	private int mandelbrotSet(double x, double y) {

		int i = 0;
		double a, aTemp, b;
		a = 0;
		b = 0;
		while ((a * a + b * b) <= 4 && i <= iterations) {
			aTemp = a * a - b * b + x;
			b = 2 * a * b + y;
			a = aTemp;
			i++;
		}

		return i;
	}

	private Color mandelColor(int ms) {

		int r, b, g;
		r = b = g = 0;

		if (ms % 2 == 0) {
			r = b = g = 255;
		} else {
			r = b = g = 0;
		}
		return new Color(r, b, g);
	}

	private double toMandelX(int xpixel) {
		return scaleFactor * (xpixel - getWidth() / 2) + xOrigin;
	}

	private double toMandelY(int ypixel) {
		return scaleFactor * (ypixel - getWidth() / 2) + yOrigin;
	}

	public void paint(Graphics g) {

		for (int xpixel = 0; xpixel < getWidth(); xpixel++) {
			for (int ypixel = 0; ypixel < getWidth(); ypixel++) {
				g.setColor(mandelColor(mandelbrotSet(toMandelX(xpixel),
						toMandelY(ypixel))));
				g.fillRect(xpixel, ypixel, 1, 1);

			}
		}
	}

	public void mouseClicked(MouseEvent e) {

		if (e.getX() < 50) {
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

		this.repaint();
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

		this.repaint();

	}

	private static final long serialVersionUID = 1;
}

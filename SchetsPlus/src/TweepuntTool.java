import java.awt.*;

import tamar.schetsplus.elements.Line;

public abstract class TweepuntTool extends StartpuntTool {
	protected static Point minimumPunt(Point p1, Point p2) {
		return new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
	}

	protected static Dimension puntAfstand(Point p1, Point p2) {
		return new Dimension(1 + Math.abs(p1.x - p2.x), 1 + Math.abs(p1.y
				- p2.y));
	}

	public void muisVersleept(SchetsCanv canvas, Point p) {
		
//		Graphics g = canvas.getGraphics();
//		canvas.paint(g); // Teken het plaatje, om de vorige contour kwijt te
//							// raken
//		g.setColor(Color.GRAY);
//		this.tekenContour(g, startpunt, p);
//		element.setEndPoint(p);
		canvas.repaint();
	}


	public void muisLosgelaten(SchetsCanv canvas, Point p) {
		this.tekenFiguur(canvas, p, p);
		canvas.repaint();
	}

	public void letterIngetikt(SchetsCanv canvas, char c) {
	}

	public void tekenFiguur(SchetsCanv canvas, Point p1, Point p2) {
	}

	public void tekenFiguur(Graphics g, Point p1, Point p2) {
		this.tekenContour(g, p1, p2);
	}

	public abstract void tekenContour(Graphics g, Point p1, Point p2);
}
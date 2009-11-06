package tamar.schetsplus;
import java.awt.*;

public abstract class TweepuntTool extends StartpuntTool {
//	protected static Point minimumPunt(Point p1, Point p2) {
//		return new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
//	}

//	protected static Dimension puntAfstand(Point p1, Point p2) {
//		return new Dimension(1 + Math.abs(p1.x - p2.x), 1 + Math.abs(p1.y
//				- p2.y));
//	}

	public void muisVersleept(SchetsCanv canvas, Point p) {
		element.setEndPoint(p);
		canvas.repaint();
	}


//	public void muisLosgelaten(SchetsCanv canvas, Point p) {
//		this.tekenFiguur(canvas, p, p);
//		canvas.repaint();
//	}

	public void letterIngetikt(SchetsCanv canvas, char c) {
	}
}
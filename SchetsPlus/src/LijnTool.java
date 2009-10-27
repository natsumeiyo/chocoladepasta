import java.awt.*;

class LijnTool extends TweepuntTool {
	public void tekenContour(Graphics g, Point p1, Point p2) {
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
}
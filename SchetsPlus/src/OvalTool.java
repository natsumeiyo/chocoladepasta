import java.awt.*;

class OvalTool extends TweepuntTool {
	public void tekenContour(Graphics g, Point p1, Point p2) {
		Point xy = minimumPunt(p1, p2);
		Dimension wh = puntAfstand(p1, p2);
		g.drawOval(xy.x, xy.y, wh.width, wh.height);
	}
}
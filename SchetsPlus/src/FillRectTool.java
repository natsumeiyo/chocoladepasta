import java.awt.*;

class FillRectTool extends RectTool {
	public void tekenFiguur(Graphics g, Point p1, Point p2) {
		Point xy = minimumPunt(p1, p2);
		Dimension wh = puntAfstand(p1, p2);
		g.fillRect(xy.x, xy.y, wh.width, wh.height);
	}
}
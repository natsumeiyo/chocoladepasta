import java.awt.*;

public class Rectangle extends Element {
	
	private Color color;
	private Point p1, p2;
	private boolean isFilled;

	Rectangle(Point p1, Point p2, Color c, boolean f) {
		this.p1 = p1;
		this.p2 = p2;
		isFilled = f;
		color = c;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void drawRectangle(Graphics g) {
		g.setColor(color);
		if (isFilled) {
			Point xy = minimumPunt(p1, p2);
			Dimension wh = puntAfstand(p1, p2);
			g.fillRect(xy.x, xy.y, wh.width, wh.height);
		}
	
	}
	
	
}

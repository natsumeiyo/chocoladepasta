import java.awt.Point;

public class PenTool extends LijnTool {
	public void muisVersleept(SchetsCanv canvas, Point p) {
		this.muisLosgelaten(canvas, p);
		this.muisIngedrukt(canvas, p);
	}
}

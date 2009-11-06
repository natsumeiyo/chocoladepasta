package tamar.schetsplus;
import java.awt.*;

public abstract class TweepuntTool extends StartpuntTool {
	public void muisVersleept(SchetsCanv canvas, Point p) {
		// set new end point when mouse is dragged
		element.setEndPoint(p);
		canvas.repaint();
	}

	public void letterIngetikt(SchetsCanv canvas, char c) {
	}
}
package tamar.schetsplus;
import java.awt.*;

public abstract class TweepuntTool extends StartpuntTool {
	public void muisVersleept(SchetsCanv canvas, Point p) {
		element.setEndPoint(p);
		canvas.repaint();
	}

	public void letterIngetikt(SchetsCanv canvas, char c) {
	}
}
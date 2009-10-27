import java.awt.*;

public abstract class StartpuntTool implements Tool {
	protected Point startpunt;

	public void muisIngedrukt(SchetsCanv canvas, Point p) {
		startpunt = p;
	}
}
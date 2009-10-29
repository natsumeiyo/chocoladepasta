import java.awt.*;

import tamar.schetsplus.elements.Line;

public abstract class StartpuntTool implements Tool {
	
	protected Line currentLine;

	public void muisIngedrukt(SchetsCanv canvas, Point p) {
		currentLine = new Line(p, p, canvas.getPenkleur());
		canvas.getSchets().addElement(currentLine);
	}
}
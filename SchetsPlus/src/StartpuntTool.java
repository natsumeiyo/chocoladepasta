import java.awt.*;

import tamar.schetsplus.elements.*;

public abstract class StartpuntTool implements Tool {

	public void muisIngedrukt(SchetsCanv canvas, Point p) {
		Element element = createElement(p, p, canvas.getPenkleur());
		canvas.getSchets().addElement(element);
	}
}
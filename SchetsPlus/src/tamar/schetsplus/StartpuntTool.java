package tamar.schetsplus;
import java.awt.*;

import tamar.schetsplus.elements.*;

public abstract class StartpuntTool implements Tool {
	
	protected Element element;

	public void muisIngedrukt(SchetsCanv canvas, Point p) {
		element = createElement(p, canvas.getPenkleur());
		canvas.getSchets().addElement(element);
	}
}
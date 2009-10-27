import java.awt.Dimension;
import javax.swing.Icon;

public abstract class ToolIcon implements Icon {
	private Dimension dim = new Dimension(36, 36);

	public int getIconWidth() {
		return dim.width;
	}

	public int getIconHeight() {
		return dim.height;
	}
}
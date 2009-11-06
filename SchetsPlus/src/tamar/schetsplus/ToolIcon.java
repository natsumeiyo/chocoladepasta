package tamar.schetsplus;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

public class ToolIcon implements Icon {
	private Dimension dim = new Dimension(36, 36);
	private Tool tool;

	public ToolIcon(Tool tool) {
		this.tool = tool;
	}

	public int getIconWidth() {
		return dim.width;
	}

	public int getIconHeight() {
		return dim.height;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int w = getIconWidth();
		int h = getIconHeight();
		tool.drawIcon(g2, x, y, w, h);
	}
}
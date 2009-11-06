package tamar.schetsplus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class ColorIcon implements Icon {
	
	private Color iconColor;
	
	public ColorIcon(Color c) {
		iconColor = c;
	}

	public int getIconHeight() {
		return 14;
	}

	public int getIconWidth() {
		return 16;
	}
	
	public void setColor(Color c) {
		iconColor = c;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(iconColor);
		g.fillRect(x, y, getIconWidth(), getIconHeight() - 1);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, getIconWidth(), getIconHeight() - 1);
	}

}

import java.awt.*;

public class TekstIcon extends ToolIcon {
	
	public TekstIcon(Tool tool) {
		super(tool);
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		int w = this.getIconWidth(), h = this.getIconHeight();
		g.setColor(c.getBackground());
		g.fillRect(x, y, w, h);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Helvetica", Font.BOLD, h - 5));
		g.drawString("Tx", x + 2, y + h - 2);
	}
}
import java.awt.*;
import java.awt.font.*;

class TekstTool extends StartpuntTool {
	private Font font = new Font("Helvetica", Font.BOLD, 24);

	public void letterIngetikt(SchetsCanv canvas, char c) {
//		startpunt.x += this.tekenTekst(canvas, p, "" + c);
		canvas.repaint();
	}

	public void muisVersleept(SchetsCanv canvas, Point p) {
	}

	public void muisLosgelaten(SchetsCanv canvas, Point p) {
	}

	public int tekenTekst(SchetsCanv canvas, Point p, String s) {
		Graphics g = canvas.getBitmapGraphics();
		g.setFont(font);
		this.tekenTekst(g, p, s);
		FontRenderContext frc = ((Graphics2D) g).getFontRenderContext();
		return font.getStringBounds(s, frc).getBounds().width;
	}

	public void tekenTekst(Graphics g, Point p, String s) {
		g.drawString(s, p.x, p.y);
	}
}
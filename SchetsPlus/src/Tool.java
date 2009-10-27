import java.awt.Point;

public interface Tool {
	void muisIngedrukt(SchetsCanv canvas, Point p);

	void muisLosgelaten(SchetsCanv canvas, Point p);

	void muisVersleept(SchetsCanv canvas, Point p);

	void letterIngetikt(SchetsCanv canvas, char c);
}

import java.awt.Color;
import java.awt.Graphics;

public class Square {

	int row, column, owner;
	int pixelsPerSquare = 40;

	public enum Direction {
		NORTH,
		NORTH_EAST,
		EAST,
		SOUTH_EAST,
		SOUTH,
		SOUTH_WEST,
		WEST,
		NORTH_WEST,
	};

	public Square(int r, int c, int o) {
		row = r;
		column = c;
		owner = o;

	}

	public void paint(Graphics g) {
		if ((row % 2) == (column % 2)) {
			g.setColor(Color.WHITE);
		} else {
			g.setColor(new Color(200, 200, 200));
		}
		g.fillRect(pixelsPerSquare * column, pixelsPerSquare * row,
				pixelsPerSquare, pixelsPerSquare);

		if (!isFree()) {
			if (owner == 1) {
				g.setColor(new Color(255, 50, 50));
			}
			if (owner == 2) {
				g.setColor(new Color(50, 50, 255));
			}
			g.fillOval(pixelsPerSquare * (column) + 4, pixelsPerSquare * (row)
					+ 4, pixelsPerSquare - 10, pixelsPerSquare - 10);
		}

	}
	
	public boolean isFree() {
		return owner == 0;

	}

//	public boolean hasNeighbor(Square s, Direction d) {
//
//		return !(d == Direction.SOUTH && row == numberOfRows)
//				|| !(d == Direction.EAST && column == numberOfColumns)
//				|| !(d == Direction.WEST && column == 0)
//				|| !(d == Direction.NORTH && row == 0)
//
//				|| !(d == Direction.NORTH_EAST && column == numberOfColumns && row == 0)
//				|| !(d == Direction.NORTH_WEST && column == 0 && row == 0)
//				|| !(d == Direction.SOUTH_EAST && column == numberOfColumns && row == numberOfRows)
//				|| !(d == Direction.SOUTH_WEST && column == 0 && row == numberOfRows);
//	}

	public void setOwner(int o) {
		owner = o;
	}

}

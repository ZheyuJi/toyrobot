
/**
 * 	This class represents a coordinate of the toy car,
 *  The origin (0,0) can be considered to be the SOUTH WEST most corner.
 * 
 * @author zheyuji
 *
 */
public class Coordinate {
	private int x, y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * set the Coordinate if x and y are valid, 
	 * otherwise do nothing
	 * @param x the x
	 * @param y the y
	 * @return if new Coordinate is set return true, else return false
	 */
	public boolean setCoordinate(int x, int y) {
		if(isValidCoordinate(x, y)) {
			this.x = x;
			this.y = y;
			return true;
		}

		return false;
	}

	/**
	 * increase X by delta if the new x is valid
	 * otherwise do nothing
	 * @param delta the delta to increase
	 * @return if x is changed return true, else return false
	 */
	public boolean increaseX(int delta) {
		if(x + delta <= Global.MAX_X) {
			x += delta;
			return true;
		}
		return false;
	}

	/**
	 * decrease X by delta if the new x is valid
	 * otherwise do nothing
	 * @param delta the delta to decrease
	 * @return if x is changed return true, else return false
	 */
	public boolean decreaseX(int delta) {
		if(x - delta >= Global.MIN_X) {
			x -= delta;
			return true;
		}
		return false;
	}


	/**
	 * increase Y by delta if the new y is valid
	 * otherwise do nothing
	 * @param delta the delta to increase
	 * @return if y is changed return true, else return false
	 */
	public boolean increaseY(int delta) {
		if(y + delta <= Global.MAX_Y) {
			y += delta;
			return true;
		}
		return false;
	}

	/**
	 * decrease Y by delta if the new y is valid
	 * otherwise do nothing
	 * @param delta the delta to decrease
	 * @return if y is changed return true, else return false
	 */
	public boolean decreaseY(int delta) {
		if(y - delta >= Global.MIN_Y) {
			y -= delta;
			return true;
		}
		return false;
	}

	/**
	 * judge whether a (x,y) coordinate is valid or not
	 * @param x the x
	 * @param y the y
	 * @return true if (x,y) is a valid coordinate, else return false
	 */
	public static boolean isValidCoordinate(int x, int y) {
		return x >= Global.MIN_X && x <= Global.MAX_X
				&& y >= Global.MIN_Y &&  y <= Global.MAX_Y;
	}

	public String toString() {
		return String.format("%d,%d", x, y);
	}




}


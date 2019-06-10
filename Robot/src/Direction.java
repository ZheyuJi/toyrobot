
/**
 * The enum represents for directions
 * @author zheyuji
 */
public enum Direction {
	NORTH{

		@Override
		public Direction left() {
			return WEST;
		}

		@Override
		public Direction right() {
			return EAST;
		}

		@Override
		public boolean updateCoordinate(Coordinate c) {
			return c.increaseY(Global.STEP);
		}
		
	},
	
	SOUTH{

		@Override
		public Direction left() {
			return EAST;
		}

		@Override
		public Direction right() {
			return WEST;
		}

		@Override
		public boolean updateCoordinate(Coordinate c) {
			return c.decreaseY(Global.STEP);
		}
		
	},
	
	WEST{

		@Override
		public Direction left() {
			return SOUTH;
		}

		@Override
		public Direction right() {
			return NORTH;
		}

		@Override
		public boolean updateCoordinate(Coordinate c) {
			return c.decreaseX(Global.STEP);
		}
		
	},
	
	EAST{

		@Override
		public Direction left() {
			return NORTH;
		}

		@Override
		public Direction right() {
			return SOUTH;
		}

		@Override
		public boolean updateCoordinate(Coordinate c) {
			return c.increaseX(Global.STEP);
		}
		
	};

	/**
	 * Turn left from current direction
	 * @return the new direction
	 */
	public abstract Direction left();
	
	/**
	 * Turn right from current direction
	 * @return the new direction
	 */
	public abstract Direction right();
	
	/**
	 * Update the coordinate based on current direction
	 * @param c the coordinate to update
	 * @return true if updated successfully, else return false
	 */
	public abstract boolean updateCoordinate(Coordinate c);
}

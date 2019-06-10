import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TestDirection extends BasicTest{

	@Test
	void testNorthValidMove() {
		Coordinate c = new Coordinate(Global.MIN_X, Global.MIN_Y);
		Direction.NORTH.updateCoordinate(c);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y + Global.STEP);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testWestValidMove() {
		Coordinate c = new Coordinate(Global.MAX_X, Global.MIN_Y);
		Direction.WEST.updateCoordinate(c);
		
		try {
			assertEquals(getField(c, "x"), Global.MAX_X - Global.STEP);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testSouthValidMove() {
		Coordinate c = new Coordinate(Global.MIN_X, Global.MAX_Y);
		Direction.SOUTH.updateCoordinate(c);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MAX_Y - Global.STEP);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testEastValidMove() {
		Coordinate c = new Coordinate(Global.MIN_X, Global.MIN_Y);
		Direction.EAST.updateCoordinate(c);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X + Global.STEP);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testNorthInvalidMove() {
		Coordinate c = new Coordinate(Global.MIN_X, Global.MAX_Y);
		Direction.NORTH.updateCoordinate(c);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MAX_Y);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testWestInvalidMove() {
		Coordinate c = new Coordinate(Global.MIN_X, Global.MIN_Y);
		Direction.WEST.updateCoordinate(c);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testSouthInvalidMove() {
		Coordinate c = new Coordinate(Global.MIN_X, Global.MIN_Y);
		Direction.SOUTH.updateCoordinate(c);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testEastInvalidMove() {
		Coordinate c = new Coordinate(Global.MAX_X, Global.MIN_Y);
		Direction.EAST.updateCoordinate(c);
		
		try {
			assertEquals(getField(c, "x"), Global.MAX_Y);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}

}

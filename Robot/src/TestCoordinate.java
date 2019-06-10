import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestCoordinate extends BasicTest{
	Coordinate c;
	
	@BeforeEach
	public void initialize() {
		c = new Coordinate(Global.MIN_X, Global.MIN_Y);
	}
	
	@Test
	void testSetInvalidXLessThanMin() {
		boolean b = c.setCoordinate(Global.MIN_X - 1, Global.MIN_Y);
		assertFalse(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testSetInvalidXMoreThanMax() {
		boolean b = c.setCoordinate(Global.MAX_X + 1, 0);
		assertFalse(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testSetInvalidYLessThanMin() {
		boolean b = c.setCoordinate(0, Global.MIN_Y - 1);
		assertFalse(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testSetInvalidYMoreThanMax() {
		boolean b = c.setCoordinate(0, Global.MAX_Y + 1);
		assertFalse(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testSetValidXY() {
		boolean b = c.setCoordinate(Global.MAX_X, Global.MAX_Y);
		assertTrue(b);
		try {
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MAX_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	
	@Test
	void testIncreaseXSuccessful() {
		boolean b = c.increaseX(Global.STEP);
		assertTrue(b);
		
		try {
			assertEquals(getField(c, "x"), Global.STEP);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testIncreaseXFail() {
		boolean b = c.increaseX(Global.MAX_X - Global.MIN_X + Global.STEP);
		assertFalse(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testIncreaseYSuccessful() {
		boolean b = c.increaseY(Global.STEP);
		assertTrue(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.STEP);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testIncreaseYFail() {
		boolean b = c.increaseY(Global.MAX_Y - Global.MIN_Y + Global.STEP);
		assertFalse(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MIN_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	
	@Test
	void testDecreaseXSuccessful() {
		boolean b = c.setCoordinate(Global.MAX_X, Global.MAX_Y);
		assertTrue(b);
		
		b = c.decreaseX(Global.STEP);
		assertTrue(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MAX_X - Global.STEP);
			assertEquals(getField(c, "y"), Global.MAX_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testDecreaseXFail() {
		boolean b = c.setCoordinate(Global.MAX_X, Global.MAX_Y);
		assertTrue(b);
		
		b = c.decreaseX(Global.MAX_X - Global.MIN_X + Global.STEP);
		assertFalse(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MAX_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testDecreaseYSuccessful() {
		boolean b = c.setCoordinate(Global.MAX_X, Global.MAX_Y);
		assertTrue(b);
		
		b = c.decreaseY(Global.STEP);
		assertTrue(b);
		
		try {
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MAX_Y - Global.STEP);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
	
	@Test
	void testDecreaseYFail() {
		boolean b = c.setCoordinate(Global.MAX_X, Global.MAX_Y);
		assertTrue(b);
		
		b = c.decreaseY(Global.MAX_Y - Global.MIN_Y + Global.STEP);
		assertFalse(b);
		try {
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MAX_Y);
		} catch (IllegalArgumentException | IllegalAccessException 
				| NoSuchFieldException | SecurityException e) {
			fail("Cannot retreive x filed from coordinate");
		}
	}
}

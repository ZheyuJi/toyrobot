import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRobotMove extends BasicTest{
	private RobotMove robotMove;
	
	@BeforeEach
	public void initialize() {
		robotMove = new RobotMove();
	}
	
	
	@Test
	void testValidPlace() {
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MIN_Y, Direction.NORTH.name()));
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
			assertEquals(d, Direction.NORTH);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	
	@Test
	void testInValidCoordinatePlace() {
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MIN_Y, Direction.NORTH.name()));
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X + 1, Global.MIN_Y, Direction.NORTH.name()));
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
			assertEquals(d, Direction.NORTH);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testInValidCoordinatePlaceWithWrongFormat() {
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MIN_Y, Direction.NORTH.name()));
		robotMove.respond(String.format("PLACE %s,%s,%s", 
				"invalid", "invalid", Direction.NORTH.name()));
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
			assertEquals(d, Direction.NORTH);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testInValidDirectionPlace() {
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MIN_Y, Direction.NORTH.name()));
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X + 1, Global.MIN_Y, "Invalid"));
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
			assertEquals(d, Direction.NORTH);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testValidMove() {
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MIN_Y, Direction.NORTH.name()));
		robotMove.respond("MOVE");
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MIN_Y + 1);
			assertEquals(d, Direction.NORTH);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testInValidMove() {
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MAX_Y, Direction.NORTH.name()));
		robotMove.respond("MOVE");
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MAX_Y);
			assertEquals(d, Direction.NORTH);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testTurnLeft() {
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MAX_Y, Direction.NORTH.name()));
		robotMove.respond("LEFT");
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MAX_Y);
			assertEquals(d, Direction.WEST);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testTurnRight(){
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MAX_Y, Direction.NORTH.name()));
		robotMove.respond("RIGHT");
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MAX_Y);
			assertEquals(d, Direction.EAST);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testReport(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		PrintStream originalOut = System.out;
		
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MAX_Y, Direction.NORTH.name()));
		robotMove.respond("REPORT");
		
		String reportString = outContent.toString();
		assertEquals(reportString, String.format("%d,%d,%s\n", 
				Global.MAX_X, Global.MAX_Y, Direction.NORTH.name()));
		
		System.setOut(originalOut);
	}
	
	@Test
	void testNoMoveUntilOntable(){
		robotMove.respond("MOVE");
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(c, null);
			assertEquals(d, null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testNoLeftUntilOntable(){
		robotMove.respond("LEFT");
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(c, null);
			assertEquals(d, null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testNoRightUntilOntable(){
		robotMove.respond("RIGHT");
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(c, null);
			assertEquals(d, null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testIgnoreInvalidCommand(){
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MIN_Y, Direction.NORTH.name()));
		robotMove.respond("Invalid");
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
			assertEquals(d, Direction.NORTH);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}
	
	@Test
	void testIgnoreInvalidPlaceCommand(){
		robotMove.respond(String.format("PLACE %d,%d,%s", 
				Global.MAX_X, Global.MIN_Y, Direction.NORTH.name()));
		robotMove.respond("PLACE Invalid");
		
		try {
			Coordinate c = getCoordinate(robotMove);
			Direction d = getDirection(robotMove);
			
			assertEquals(getField(c, "x"), Global.MAX_X);
			assertEquals(getField(c, "y"), Global.MIN_Y);
			assertEquals(d, Direction.NORTH);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			fail("Fail to get data from robotMove Object");
		}
	}

}

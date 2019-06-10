import java.lang.reflect.Field;
/**
 * Test base stores util methods
 * 
 * @author zheyuji
 *
 */
class BasicTest {

	static int getField(Coordinate c, String fieldName) 
			throws IllegalArgumentException, 
					IllegalAccessException, 
					NoSuchFieldException, 
					SecurityException {
		Field field = c.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.getInt(c);
	}
	
	static Coordinate getCoordinate(RobotMove r) 
			throws NoSuchFieldException, 
					SecurityException, 
					IllegalArgumentException, 
					IllegalAccessException {
		Field field = r.getClass().getDeclaredField("coordinate");
		field.setAccessible(true);
		return (Coordinate) field.get(r);
	}
	
	static Direction getDirection(RobotMove r) 
			throws NoSuchFieldException, 
					SecurityException, 
					IllegalArgumentException, 
					IllegalAccessException {
		Field field = r.getClass().getDeclaredField("direction");
		field.setAccessible(true);
		return (Direction) field.get(r);
	}

}

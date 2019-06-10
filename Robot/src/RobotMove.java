import java.util.Scanner;
/**
 * The RobotMove class, stores the coordinate and direction,
 * and responding to different command from command line
 * 
 * @author zheyuji
 *
 */
public class RobotMove {
	
	public static Scanner scanner = new Scanner(System.in);
	private Coordinate coordinate = null;
	private Direction direction = null;
	
	public static void main(String[] args) {
		new RobotMove().start();
	}
	
	/**
	 * start responding
	 */
	public void start() {
		String line;
		while(true) {
			line = scanner.nextLine();
			respond(line);
		}
	}
	
	/**
	 * respond to cmd line instructions
	 * @param line the line received from cmd line
	 */
	public void respond(String line) {
		Command cmd = Command.parseCommand(line.split(" ")[0].trim());
		
		switch (cmd) {
		case PLACE:
			place(line);
			break;
		case MOVE:
			move();
			break;
		case LEFT:
			left();
			break;
		case RIGHT:
			right();
			break;
		case REPORT:
			report();
			break;
		case EXIT:
			exit();
		default:
			break;
		}
	}

	private void exit() {
		System.out.println("Receiving Exit Command.");
		System.exit(0);
	}

	private void report() {
		if(onTable()) {
			String report = 
					String.format("%s,%s\n",coordinate.toString(), direction.name());
			System.out.print(report);
		}
	}

	private void right() {
		if(onTable()) {
			direction = direction.right();
		}
	}

	private void left() {
		if(onTable()) {
			direction = direction.left();
		}
	}

	private void move() {
		if(onTable()) {
			direction.updateCoordinate(coordinate);
		}
	}

	private void place(String line) {
		// if the line is not in required format, do nothing
		// required example: "PLACE 0,0,NORTH"
		String[] placeStrings = line.split(" ");
		if(placeStrings.length != Global.PLACE_CMD_LEN) {
			return;
		}
		
		String[] dataStrings = placeStrings[1].split(",");
		if(dataStrings.length != Global.PLACE_CMD_DATA_LEN) {
			return;
		}
		
		int x, y;
		Direction d;
		try {
			x = Integer.parseInt(dataStrings[0]);
			y = Integer.parseInt(dataStrings[1]);
			d = Direction.valueOf(dataStrings[2]);
		}
		catch (Exception e) {
			return;
		}
		
		if(Coordinate.isValidCoordinate(x, y)) {
			if(onTable()) {
				coordinate.setCoordinate(x, y);
			} else {
				coordinate = new Coordinate(x, y);
			}
			
			direction = d;
		}
	}
	
	private boolean onTable() {
		return coordinate != null && direction != null;
	}
}

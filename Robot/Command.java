/**
 * Enum represents different command
 * 
 * @author zheyuji
 *
 */
public enum Command{
	PLACE,
	MOVE,
	LEFT,
	RIGHT,
	REPORT,
	EXIT,
	UNKNOWN;
	
	/**
	 * parse a string to a Command
	 * 
	 * @param cmdString the string to parse
	 * @return the parsed Command, if cannot parse to a command
	 * 			return UNKNOWN
	 */
	public static Command parseCommand(String cmdString) {
		Command cmd;
		try {
			cmd = Command.valueOf(cmdString);
		}
		catch (IllegalArgumentException e) {
			cmd = UNKNOWN;
		}
		return cmd;
	}
}



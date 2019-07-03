import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCommand {

	@Test
	void testInvalidCommand() {
		Command cmd = Command.parseCommand("Invalid");
		assertEquals(cmd, Command.UNKNOWN);
	}

}

package dataTest;

import data.Commands;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandsTest {

    private final String[] expectedCommands = {"/help", "/add", "/show", "/remove", "/removeLast", "/close", "/removeAll"};

    @Test
    public void getCommandsShouldReturnTheListOfCommands() {
        Assertions.assertArrayEquals(expectedCommands, Commands.getCommands().toArray());
    }
}

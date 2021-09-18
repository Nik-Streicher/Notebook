package data;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private static final List<String> commands = new ArrayList<>(List.of("/help","/add", "/show", "/remove", "/removeLast", "/close", "/removeAll", "/Pshow"));
    // add short commands list

    public static List<String> getCommands() {
        return commands;
    }
}

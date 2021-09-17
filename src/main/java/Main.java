import data.Commands;
import functions.CommandSwitch;
import functions.notebook.Note;
import functions.notebook.Notebook;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        Notebook notebook = new Notebook(reader, writer);

        CommandSwitch commandSwitch = new CommandSwitch(notebook , reader);
        Note note1 = new Note(false, "Complete app", "20.07.2021", 1);
        Note note2 = new Note(true, "Read book", "25.07.2021", 2);

        String command = "";

        notebook.add(note1);
        notebook.add(note2);


        while (!command.equals("/close")) {
            command = reader.readLine();
            if (!Commands.getCommands().contains(command))
                if (command.contains(" "))
                    commandSwitch.choose(command.substring(0, command.indexOf(" ")), command.substring(command.indexOf(" ")));
                else System.err.println("Command does not exist, please \"\\help\" to view command list.");
            else commandSwitch.choose(command);
        }

        notebook.close();
    }
}

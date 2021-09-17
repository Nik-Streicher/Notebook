package functions;

import functions.notebook.Note;
import functions.notebook.Notebook;

import java.io.BufferedReader;

public class CommandSwitch {

    Notebook notebook;
    BufferedReader reader;

    public CommandSwitch(Notebook notebook, BufferedReader reader) {
        this.notebook = notebook;
        this.reader = reader;
    }

    public void choose(String command) {
        switch (command) {
            case "/show" -> notebook.show();
            case "/add" -> notebook.add(Note.createFromString(TaskReader.read(reader), (notebook.getSize()) + 1));
            case "/removeLast" -> notebook.removeLast();
            case "/removeAll" -> notebook.removeAll();
            case "/help" -> HelpNote.WriteHelp();
            case "/close" -> System.out.println("App has been closed");
            default -> System.err.println("Command does not exist, please \"\\help\" to view command list.");
        }
    }


    // only for "/add" and "/remove" commands
    public void choose(String command, String task) {
        switch (command) {
            case "/remove" -> notebook.removeById(task.replace(" ", ""));
            case "/add" -> notebook.add(Note.createFromString(task, (notebook.getSize()) + 1));
            default -> System.err.println("Command does not exist, please \\help to view command list.");

        }
    }
}
package functions;

import functions.notebook.Note;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;


public class TaskWriter {

    public static void write(List<Note> notebook, Writer writer) {
        for (Note note : notebook) {
            try {
                writer.write(String.format("Task -> %s : Expiration date -> %s : id -> %d\n", note.getTask(), note.getExpirationDate(), note.getId()));
                writer.flush();
            } catch (IOException ignored) {
                // unreachable exception
            }
        }
    }

    public static void writePriorityTusk(List<Note> notebook, Writer writer) {
        write(notebook.stream().filter(Note::isPriority).collect(Collectors.toList()), writer);
    }
}

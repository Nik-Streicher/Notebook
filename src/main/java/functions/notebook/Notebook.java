package functions.notebook;

import functions.TaskWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Notebook {

    private final List<Note> notebook = new ArrayList<>();
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Notebook(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void show() {
        TaskWriter.write(notebook, writer);
    }

    public void add(Note note) {
        if (note != null)
            notebook.add(note);
    }

    public void removeAll() {
        notebook.clear();
    }

    public void refresh() {
        for (int x = 0; x != notebook.size(); x++)
            notebook.get(x).setId(x + 1);
    }

    public int getSize() {
        return notebook.size();
    }

    public void removeById(int id) {
        notebook.remove(id - 1);
        refresh();
    }

    public void removeById(String id){
        try {
            notebook.remove(Integer.parseInt(id) - 1);
            refresh();
        } catch (NumberFormatException ignored) {
            System.err.println("Id must be number");
        }catch (IndexOutOfBoundsException ignored){
            System.err.println("Id does not exist");
        }
    }

    public void removeLast() {
        try {
            notebook.remove(notebook.size() - 1);
        } catch (IndexOutOfBoundsException ignored) {
            System.err.println("Notebook is already empty");
        }
        refresh();
    }

    public List<Note> getNotebook() {
        return notebook;
    }

    public void close() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("The notebook is already closed");
        }
    }
}

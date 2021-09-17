package functionsTest.notebookTest;

import functions.notebook.Note;
import functions.notebook.Notebook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class NotebookTest {

    private final Notebook notebook;
    private final Note testNote1 = new Note(true, "Test One", "09.09.1999", 1);
    private final Note testNote2 = new Note(true, "Test Two", "09.09.1999", 1);
    private final Note testNote3 = new Note(true, "Test Three", "09.09.1999", 1);
    BufferedWriter writer;
    BufferedReader reader;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    NotebookTest() {
        System.setOut(new PrintStream(outputStreamCaptor));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        reader = new BufferedReader(new InputStreamReader(System.in));
        notebook = new Notebook(reader, writer);
    }

    @Test
    public void showShouldReturnTasks() {

        String expectedOutput = "Task -> Test One : Expiration date -> 09.09.1999 : id -> 1";

        notebook.add(testNote1);
        notebook.show();
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void refreshShouldSetNewIdToTasks() {
        notebook.add(testNote1);
        notebook.add(testNote2);
        notebook.add(testNote3);

        notebook.refresh();

        for (int x = 0; x != notebook.getNotebook().size(); x++)
            Assertions.assertEquals(x + 1, notebook.getNotebook().get(x).getId());

    }

    @Test
    public void removeByIdShouldRemoveSecondElement() {
        notebook.add(testNote1);
        notebook.add(testNote2);
        notebook.add(testNote3);
        notebook.refresh();

        notebook.removeById(2);

        Assertions.assertEquals(2, notebook.getNotebook().size());
        Assertions.assertEquals("Test One", notebook.getNotebook().get(0).getTask());
        Assertions.assertEquals("Test Three", notebook.getNotebook().get(1).getTask());
    }


    @Test
    public void removeLastShouldRemoveLastAddedElement() {
        notebook.add(testNote1);
        notebook.add(testNote2);

        notebook.removeLast();
        Assertions.assertEquals(1, notebook.getNotebook().size());
        Assertions.assertEquals("Test One", notebook.getNotebook().get(0).getTask());
    }

    @Test
    public void removeAllShouldClearTheNotebook() {
        notebook.add(testNote1);
        notebook.add(testNote2);
        notebook.removeAll();

        Assertions.assertEquals(0, notebook.getSize());
    }

    @Test
    public void addShouldExpandTheNotebookByEnteredNote() {
        notebook.add(testNote1);
        Assertions.assertEquals(1, notebook.getSize());
    }

    @Test
    public void getSizeShouldReturnSizeOfNotebook() {
        Assertions.assertEquals(0, notebook.getSize());
        notebook.add(testNote1);
        Assertions.assertEquals(1, notebook.getSize());
    }

    @Test
    public void addShouldNotExpandTheNotebookByEnteredNullNote() {
        notebook.add(null);
        Assertions.assertEquals(0, notebook.getSize());
    }

    @Test
    public void closeShouldCloseReaderAndWriter() {
        notebook.close();
        Assertions.assertThrows(IOException.class, () -> reader.readLine());
        Assertions.assertThrows(IOException.class, () -> writer.write("Hello World"));
    }

}

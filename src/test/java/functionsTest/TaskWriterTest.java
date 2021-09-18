package functionsTest;

import functions.TaskWriter;
import functions.notebook.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TaskWriterTest {


    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final BufferedWriter writer;
    private final List<Note> list;

    TaskWriterTest() {
        System.setOut(new PrintStream(outputStreamCaptor));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Note testNote1 = new Note(true, "Test One", "09.09.1999", 1);

        list = new ArrayList<>(List.of(testNote1));
    }

    @Test
    public void writeShouldWriteTask() {
        String expectedOutput = "Task -> Test One : Expiration date -> 09.09.1999 : id -> 1";

        TaskWriter.write(list, writer);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void writePriorityTaskShouldWritePriorityTask() {
        String expectedOutput = "Task -> Test One : Expiration date -> 09.09.1999 : id -> 1";

        TaskWriter.writePriorityTusk(list, writer);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void writePriorityTaskShouldNotWriteNonPriorityTask() {
        String expectedOutput = "";

        TaskWriter.writePriorityTusk(new ArrayList<>(List.of(new Note(false, "Hello World", "", 1))), writer);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

}

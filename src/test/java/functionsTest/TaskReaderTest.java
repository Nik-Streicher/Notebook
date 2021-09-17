package functionsTest;

import functions.TaskReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskReaderTest {

    private final String task = "*\"Hello World\" 20.07.2022";
    private final BufferedReader reader;

    TaskReaderTest(){
        System.setIn(new ByteArrayInputStream(task.getBytes()));
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Test
    public void taskReaderShouldReturnTask(){
        Assertions.assertEquals(task, TaskReader.read(reader));
    }

    @Test
    public void taskReaderShouldReturnEmptyString() throws IOException {
        reader.close();
        Assertions.assertEquals("", TaskReader.read(reader));
    }
}

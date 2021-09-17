package functionsTest.notebookTest;

import functions.notebook.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoteTest {

    @Test
    public void createFromStringShouldCreateNewNote() {
        Note testedMote1 = new Note(true, "Hello World", "20.07.2022", 1);
        Note testedNote2 = Note.createFromString("*\"Hello World\" 20.7.2022", 1);

        assert testedNote2 != null;
        Assertions.assertEquals(testedMote1.getId(), testedNote2.getId());
        Assertions.assertEquals(testedMote1.getTask(), testedNote2.getTask());
        Assertions.assertEquals(testedMote1.getExpirationDate(), testedNote2.getExpirationDate());
        Assertions.assertEquals(testedMote1.getCurrentDate(), testedNote2.getCurrentDate());

        Assertions.assertEquals("functions.notebook.Note", testedNote2.getClass().getName());
    }
}

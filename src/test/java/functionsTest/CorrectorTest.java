package functionsTest;

import functions.Corrector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CorrectorTest {

    @Test
    public void checkTaskShouldReturnTrue() {
        Assertions.assertTrue(Corrector.checkTask("*\"Hello World\" 20.07.2022"));
    }

    @Test
    public void checkTaskShouldReturnFalse() {
        Assertions.assertFalse(Corrector.checkTask("*\"Hello World 20.07.2022"));
    }

    @Test
    public void countCharsShouldReturnCountOfSignsInTheString() {
        Assertions.assertEquals(2, Corrector.countChars("*\"Hello World\" 20.07.2022", '"'));
    }

    @Test
    public void formatDateShouldReturnFormattedDate() {
        Assertions.assertEquals("20.07.2020", Corrector.formatDate("20.7.2020"));
    }

    @Test
    public void formatDateShouldReturnNull() {
        Assertions.assertNull(Corrector.formatDate("Hello World"));
    }

    @Test
    public void formatDateShouldReturnUnknown() {
        Assertions.assertEquals("Unknown", Corrector.formatDate(""));
    }
}

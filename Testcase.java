import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    void testSearchBogieByIdWhenPresent() {
        String[] bogies = {"BG101", "BG205", "BG309"};

        boolean result = Train.searchBogieById(bogies, "BG205");

        assertTrue(result);
    }

    @Test
    void testSearchBogieByIdWhenNotPresent() {
        String[] bogies = {"BG101", "BG205", "BG309"};

        boolean result = Train.searchBogieById(bogies, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearchBogieByIdThrowsExceptionForEmptyArray() {
        String[] bogies = {};

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> Train.searchBogieById(bogies, "BG101")
        );

        assertEquals(
                "Search Operation Failed: No bogies are currently attached to the train consist.",
                exception.getMessage()
        );
    }

    @Test
    void testSearchBogieByIdThrowsExceptionForNullArray() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> Train.searchBogieById(null, "BG101")
        );

        assertEquals(
                "Search Operation Failed: No bogies are currently attached to the train consist.",
                exception.getMessage()
        );
    }

    @Test
    void testSearchBogieByIdSortsAndSearchesCorrectly() {
        String[] bogies = {"BG309", "BG101", "BG205"};

        boolean result = Train.searchBogieById(bogies, "BG101");

        assertTrue(result);
        assertArrayEquals(new String[]{"BG101", "BG205", "BG309"}, bogies);
    }

    @Test
    void testMainDisplaysExpectedOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("--- UC20: Exception Handling & State Validation ---"));
        assertTrue(output.contains("Test 1 (Valid Data): Bogie Found? true"));
        assertTrue(output.contains("Test 2 (Empty Train): CAUGHT EXPECTED ERROR: Search Operation Failed: No bogies are currently attached to the train consist."));
        assertTrue(output.contains("Test 3 (Bogie Missing): Bogie Found? false"));
    }
}

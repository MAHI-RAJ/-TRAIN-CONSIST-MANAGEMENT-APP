import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    void testFindBogieByIdWhenPresentInMiddle() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean result = Train.findBogieById(bogieIds, "BG309");

        assertTrue(result);
    }

    @Test
    void testFindBogieByIdWhenPresentAtFirst() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean result = Train.findBogieById(bogieIds, "BG101");

        assertTrue(result);
    }

    @Test
    void testFindBogieByIdWhenPresentAtLast() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean result = Train.findBogieById(bogieIds, "BG550");

        assertTrue(result);
    }

    @Test
    void testFindBogieByIdWhenNotPresent() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        boolean result = Train.findBogieById(bogieIds, "BG999");

        assertFalse(result);
    }

    @Test
    void testFindBogieByIdWithSingleElementArray() {
        String[] bogieIds = {"BG101"};

        boolean result = Train.findBogieById(bogieIds, "BG101");

        assertTrue(result);
    }

    @Test
    void testFindBogieByIdPrintsMatchPosition() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            boolean result = Train.findBogieById(bogieIds, "BG205");
            assertTrue(result);
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();
        assertTrue(output.contains("Searching for Bogie ID: BG205..."));
        assertTrue(output.contains("Match found at position: 2"));
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

        assertTrue(output.contains("=== Train Consist Management System (UC18: Linear Search) ==="));

        assertTrue(output.contains("Searching for Bogie ID: BG309..."));
        assertTrue(output.contains("RESULT: Bogie BG309 is present in the consist."));

        assertTrue(output.contains("Searching for Bogie ID: BG101..."));
        assertTrue(output.contains("RESULT: Bogie BG101 is present in the consist."));

        assertTrue(output.contains("Searching for Bogie ID: BG550..."));
        assertTrue(output.contains("RESULT: Bogie BG550 is present in the consist."));

        assertTrue(output.contains("Searching for Bogie ID: BG999..."));
        assertTrue(output.contains("RESULT: Bogie BG999 not found in the current consist."));

        assertTrue(output.contains("Search operations completed. System ready for next task."));
    }
}

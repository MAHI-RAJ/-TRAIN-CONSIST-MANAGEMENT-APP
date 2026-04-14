import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    void testSearchBogieByIdWhenPresent() {
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        boolean result = Train.searchBogieById(bogies, "BG309");

        assertTrue(result);
    }

    @Test
    void testSearchBogieByIdWhenNotPresent() {
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        boolean result = Train.searchBogieById(bogies, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearchBogieByIdForFirstElement() {
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        boolean result = Train.searchBogieById(bogies, "BG101");

        assertTrue(result);
    }

    @Test
    void testSearchBogieByIdWithEmptyArray() {
        String[] bogies = {};

        boolean result = Train.searchBogieById(bogies, "BG101");

        assertFalse(result);
    }

    @Test
    void testSearchBogieByIdPrintsSortedIds() {
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            boolean result = Train.searchBogieById(bogies, "BG309");
            assertTrue(result);
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();
        assertTrue(output.contains("Sorted IDs: [BG101, BG205, BG309, BG412, BG550]"));
    }

    @Test
    void testSearchBogieByIdPrintsErrorForEmptyArray() {
        String[] bogies = {};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            boolean result = Train.searchBogieById(bogies, "BG101");
            assertFalse(result);
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();
        assertTrue(output.contains("Error: Bogie list is empty."));
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

        assertTrue(output.contains("--- UC19: Binary Search Optimization ---"));
        assertTrue(output.contains("Searching for BG309: true"));
        assertTrue(output.contains("Searching for BG999: false"));
        assertTrue(output.contains("Searching for First Element (BG101): true"));
        assertTrue(output.contains("Searching in Empty Array: false"));
        assertTrue(output.contains("Error: Bogie list is empty."));
    }
}

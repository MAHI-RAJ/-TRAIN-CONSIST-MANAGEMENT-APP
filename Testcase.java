import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainTest {

    @Test
    void testSortWithBasicAlphabeticalInput() throws Exception {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        invokeSortAndDisplay("Basic Alphabetical Sort", input);

        assertArrayEquals(
                new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"},
                input
        );
    }

    @Test
    void testSortWithUnsortedInput() throws Exception {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};

        invokeSortAndDisplay("Unsorted Input Handling", input);

        assertArrayEquals(
                new String[]{"AC Chair", "General", "Luxury", "Sleeper"},
                input
        );
    }

    @Test
    void testSortWithDuplicateValues() throws Exception {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};

        invokeSortAndDisplay("Duplicate Bogie Names", input);

        assertArrayEquals(
                new String[]{"AC Chair", "General", "Sleeper", "Sleeper"},
                input
        );
    }

    @Test
    void testSortWithSingleElement() throws Exception {
        String[] input = {"Sleeper"};

        invokeSortAndDisplay("Single Element Array", input);

        assertArrayEquals(
                new String[]{"Sleeper"},
                input
        );
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

        assertTrue(output.contains("=== Train Consist Management System (UC17: Optimized Sorting) ==="));
        assertTrue(output.contains("--- Execution: Sorting Bogie Names ---"));

        assertTrue(output.contains("Scenario: Basic Alphabetical Sort"));
        assertTrue(output.contains("Before: [Sleeper, AC Chair, First Class, General, Luxury]"));
        assertTrue(output.contains("After : [AC Chair, First Class, General, Luxury, Sleeper]"));

        assertTrue(output.contains("Scenario: Unsorted Input Handling"));
        assertTrue(output.contains("Before: [Luxury, General, Sleeper, AC Chair]"));
        assertTrue(output.contains("After : [AC Chair, General, Luxury, Sleeper]"));

        assertTrue(output.contains("Scenario: Duplicate Bogie Names"));
        assertTrue(output.contains("Before: [Sleeper, AC Chair, Sleeper, General]"));
        assertTrue(output.contains("After : [AC Chair, General, Sleeper, Sleeper]"));

        assertTrue(output.contains("Scenario: Single Element Array"));
        assertTrue(output.contains("Before: [Sleeper]"));
        assertTrue(output.contains("After : [Sleeper]"));

        assertTrue(output.contains("System Status: All bogie names indexed alphabetically."));
    }

    private void invokeSortAndDisplay(String scenario, String[] array) throws Exception {
        Method method = Train.class.getDeclaredMethod("sortAndDisplay", String.class, String[].class);
        method.setAccessible(true);
        method.invoke(null, scenario, array);
    }
}

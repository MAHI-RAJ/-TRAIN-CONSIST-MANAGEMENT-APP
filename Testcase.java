import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainTest {

    @Test
    void testMainDisplaysTotalBogiesCreated() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Total bogies created: 100000"));
    }

    @Test
    void testMainDisplaysLoopBasedFilteringResults() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Loop-Based Filtering:"));
        assertTrue(output.contains("Filtered bogies count: 33333"));
        assertTrue(output.contains("Execution time:"));
    }

    @Test
    void testMainDisplaysStreamBasedFilteringResults() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Stream-Based Filtering:"));
        assertTrue(output.contains("Filtered bogies count: 33333"));
        assertTrue(output.contains("Execution time:"));
    }

    @Test
    void testMainDisplaysConsistencyCheck() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Result Consistency Check:"));
        assertTrue(output.contains("Both loop and stream produced the same number of filtered bogies."));
    }

    @Test
    void testMainDisplaysSampleFilteredBogies() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Sample Filtered Bogies:"));
        assertTrue(output.contains("Bogie Name: Sleeper, Capacity: 72"));
    }

    @Test
    void testMainDisplaysProgramContinuesMessage() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Program continues..."));
    }

    private String runMainAndCaptureOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        return outputStream.toString();
    }
}

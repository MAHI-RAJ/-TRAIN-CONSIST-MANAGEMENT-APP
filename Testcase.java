import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    void testPassengerBogieCreatedSuccessfully() throws Train.InvalidCapacityException {
        Train.PassengerBogie bogie = new Train.PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.getType());
        assertEquals(72, bogie.getCapacity());
        assertEquals("PassengerBogie{type='Sleeper', capacity=72}", bogie.toString());
    }

    @Test
    void testPassengerBogieThrowsExceptionForZeroCapacity() {
        Exception exception = assertThrows(
                Train.InvalidCapacityException.class,
                () -> new Train.PassengerBogie("First Class", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testPassengerBogieThrowsExceptionForNegativeCapacity() {
        Exception exception = assertThrows(
                Train.InvalidCapacityException.class,
                () -> new Train.PassengerBogie("AC Chair", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testMainDisplaysAddedSuccessfullyMessages() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Added successfully: PassengerBogie{type='Sleeper', capacity=72}"));
        assertTrue(output.contains("Added successfully: PassengerBogie{type='AC Chair', capacity=56}"));
    }

    @Test
    void testMainDisplaysErrorMessageForInvalidCapacity() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Error: Capacity must be greater than zero"));
    }

    @Test
    void testMainDisplaysOnlyValidBogiesInTrainConsist() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Valid bogies currently in train consist:"));
        assertTrue(output.contains("PassengerBogie{type='Sleeper', capacity=72}"));
        assertTrue(output.contains("PassengerBogie{type='AC Chair', capacity=56}"));
        assertFalse(output.contains("PassengerBogie{type='First Class', capacity=0}"));
    }

    @Test
    void testMainDisplaysProgramContinuesSafelyMessage() {
        String output = runMainAndCaptureOutput();

        assertTrue(output.contains("Program continues safely..."));
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

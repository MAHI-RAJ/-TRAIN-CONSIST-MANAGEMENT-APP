import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainTest {

    @Test
    void testValidTrainIdAndValidCargoCode() {
        String input = "TRN-1234\nPET-AB\n";
        String output = runMainWithInput(input);

        assertTrue(output.contains("Train ID is valid."));
        assertTrue(output.contains("Cargo Code is valid."));
        assertTrue(output.contains("Program continues..."));
    }

    @Test
    void testInvalidTrainIdAndValidCargoCode() {
        String input = "TRAIN-1234\nPET-AB\n";
        String output = runMainWithInput(input);

        assertTrue(output.contains("Train ID is invalid. Format should be like TRN-1234"));
        assertTrue(output.contains("Cargo Code is valid."));
        assertTrue(output.contains("Program continues..."));
    }

    @Test
    void testValidTrainIdAndInvalidCargoCode() {
        String input = "TRN-5678\nPET-ab\n";
        String output = runMainWithInput(input);

        assertTrue(output.contains("Train ID is valid."));
        assertTrue(output.contains("Cargo Code is invalid. Format should be like PET-AB"));
        assertTrue(output.contains("Program continues..."));
    }

    @Test
    void testInvalidTrainIdAndInvalidCargoCode() {
        String input = "TR-999\nPE-XY\n";
        String output = runMainWithInput(input);

        assertTrue(output.contains("Train ID is invalid. Format should be like TRN-1234"));
        assertTrue(output.contains("Cargo Code is invalid. Format should be like PET-AB"));
        assertTrue(output.contains("Program continues..."));
    }

    private String runMainWithInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;
        java.io.InputStream originalIn = System.in;

        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return outputStream.toString();
    }
}

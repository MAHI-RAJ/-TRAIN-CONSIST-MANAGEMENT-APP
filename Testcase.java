import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainTest {

    @Test
    void testMainDisplaysPassengerBogies() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Passenger Bogies in Train:"));
        assertTrue(output.contains("Bogie Name: Sleeper, Capacity: 72"));
        assertTrue(output.contains("Bogie Name: AC Chair, Capacity: 56"));
        assertTrue(output.contains("Bogie Name: First Class, Capacity: 24"));
    }

    @Test
    void testMainDisplaysTotalSeatingCapacity() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Total Seating Capacity of Train: 152"));
    }

    @Test
    void testMainDisplaysProgramContinuesMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Program continues..."));
    }
}

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    void testMainDisplaysOriginalAndGroupedBogiesCorrectly() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Original Bogie List:"));
        assertTrue(output.contains("Grouped Bogies By Type:"));
        assertTrue(output.contains("Original Bogie List After Grouping (Unchanged):"));
        assertTrue(output.contains("Program continues..."));

        assertTrue(output.contains("Sleeper ->"));
        assertTrue(output.contains("AC Chair ->"));
        assertTrue(output.contains("First Class ->"));

        assertTrue(output.contains("Bogie Name: Sleeper, Capacity: 72"));
        assertTrue(output.contains("Bogie Name: AC Chair, Capacity: 56"));
        assertTrue(output.contains("Bogie Name: First Class, Capacity: 24"));
    }

    @Test
    void testMainContainsDuplicateBogiesInOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        int sleeperCount = countOccurrences(output, "Bogie Name: Sleeper, Capacity: 72");
        int acChairCount = countOccurrences(output, "Bogie Name: AC Chair, Capacity: 56");
        int firstClassCount = countOccurrences(output, "Bogie Name: First Class, Capacity: 24");

        assertTrue(sleeperCount >= 2);
        assertTrue(acChairCount >= 2);
        assertTrue(firstClassCount >= 1);
    }

    @Test
    void testGroupingSectionExists() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertAll(
                () -> assertTrue(output.contains("Sleeper ->")),
                () -> assertTrue(output.contains("AC Chair ->")),
                () -> assertTrue(output.contains("First Class ->"))
        );
    }

    private int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }

        return count;
    }
}

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainTest {

    @Test
    void testBubbleSortWithUnsortedArray() {
        int[] capacities = {72, 56, 24, 70, 60};

        Train.bubbleSort(capacities);

        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    @Test
    void testBubbleSortWithDuplicateValues() {
        int[] capacities = {72, 56, 56, 24};

        Train.bubbleSort(capacities);

        assertArrayEquals(new int[]{24, 56, 56, 72}, capacities);
    }

    @Test
    void testBubbleSortWithAlreadySortedArray() {
        int[] capacities = {10, 20, 30, 40};

        Train.bubbleSort(capacities);

        assertArrayEquals(new int[]{10, 20, 30, 40}, capacities);
    }

    @Test
    void testBubbleSortWithSingleElement() {
        int[] capacities = {72};

        Train.bubbleSort(capacities);

        assertArrayEquals(new int[]{72}, capacities);
    }

    @Test
    void testBubbleSortWithEmptyArray() {
        int[] capacities = {};

        Train.bubbleSort(capacities);

        assertArrayEquals(new int[]{}, capacities);
    }

    @Test
    void testDisplayCapacitiesOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.displayCapacities("Test Capacities", new int[]{72, 56, 24});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Test Capacities: [72, 56, 24]"));
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

        assertTrue(output.contains("=== Train Consist Management System (UC16: Manual Sorting) ==="));
        assertTrue(output.contains("Original Capacities: [72, 56, 24, 70, 60]"));
        assertTrue(output.contains("Executing Bubble Sort Algorithm..."));
        assertTrue(output.contains("Sorted Capacities (Ascending): [24, 56, 60, 70, 72]"));
        assertTrue(output.contains("Handling Duplicate Capacities..."));
        assertTrue(output.contains("Sorted Duplicates: [24, 56, 56, 72]"));
        assertTrue(output.contains("Sorting complete. System ready for passenger allocation."));
    }
}

import java.util.Arrays;

public class Train{

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System (UC17: Optimized Sorting) ===");

        // 1. Setup various test scenarios for bogie names
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] unsortedInput = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] duplicates = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] singleElement = {"Sleeper"};

        // 2. Perform sorting using Arrays.sort()
        System.out.println("\n--- Execution: Sorting Bogie Names ---");

        sortAndDisplay("Basic Alphabetical Sort", bogieTypes);
        sortAndDisplay("Unsorted Input Handling", unsortedInput);
        sortAndDisplay("Duplicate Bogie Names", duplicates);
        sortAndDisplay("Single Element Array", singleElement);

        System.out.println("\nSystem Status: All bogie names indexed alphabetically.");
    }

    /**
     * Utility method to sort and print results using Java standard library tools.
     */
    private static void sortAndDisplay(String scenario, String[] array) {
        System.out.println("\nScenario: " + scenario);
        System.out.println("Before: " + Arrays.toString(array));

        // Optimized built-in sorting (O(n log n))
        Arrays.sort(array);

        System.out.println("After : " + Arrays.toString(array));
    }
}
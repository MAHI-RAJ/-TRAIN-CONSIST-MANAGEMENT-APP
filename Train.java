import java.util.Arrays;

public class Train {

    /**
     * Performs a Binary Search on a sorted array of Bogie IDs.
     * Precondition: The array must be sorted.
     * Logic: Divide-and-Conquer using low, mid, and high pointers.
     * Time Complexity: O(log n)
     */
    public static boolean binarySearchBogie(String[] bogieIds, String searchKey) {
        // Requirement: Ensure data is sorted before searching
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        System.out.println("Searching for: " + searchKey + " (Optimized)");

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate middle index

            // Compare strings lexicographically
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                System.out.println("Match found at index: " + mid);
                return true; // Target found
            } else if (comparison < 0) {
                high = mid - 1; // Target is in the left half
            } else {
                low = mid + 1;  // Target is in the right half
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System (UC19: Binary Search) ===");

        // Test Case 1: Unsorted input (will be handled by internal sort)
        String[] consist = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        runTest("Standard Search", consist, "BG309");
        runTest("First Element", consist, "BG101");
        runTest("Last Element", consist, "BG550");
        runTest("Not Found", consist, "BG999");

        // Test Case 2: Empty Array
        String[] emptyConsist = {};
        runTest("Empty Array Handling", emptyConsist, "BG101");

        // Test Case 3: Single Element
        String[] singleBogie = {"BG101"};
        runTest("Single Element Handling", singleBogie, "BG101");
    }

    private static void runTest(String scenario, String[] data, String key) {
        System.out.println("\nScenario: " + scenario);
        boolean result = binarySearchBogie(data, key);
        System.out.println("RESULT: " + (result ? "Bogie Found!" : "Bogie Not Found."));
        System.out.println("-------------------------------------------------");
    }
}
import java.util.Arrays;

public class Train{

    /**
     * UC19: Binary Search for Bogie ID
     * Logic: Divide and Conquer (O(log n))
     */
    public static boolean searchBogieById(String[] bogieIds, String searchKey) {
        // 1. Empty Array Handling
        if (bogieIds == null || bogieIds.length == 0) {
            System.out.println("Error: Bogie list is empty.");
            return false;
        }

        // 2. Unsorted Input Handling (Precondition for Binary Search)
        Arrays.sort(bogieIds);
        System.out.println("Sorted IDs: " + Arrays.toString(bogieIds));

        // 3. Initialize low and high indexes
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            // 4. Find the middle index
            int mid = low + (high - low) / 2;
            
            // 5. Compare key with middle value using compareTo()
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Match Found
            } else if (comparison > 0) {
                low = mid + 1; // Range halved: Search right
            } else {
                high = mid - 1; // Range halved: Search left
            }
        }

        return false; // Exhausted: Match Not Found
    }

    public static void main(String[] args) {
        System.out.println("--- UC19: Binary Search Optimization ---");

        // Test Case 1: Standard Search
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String key1 = "BG309";
        System.out.println("Searching for " + key1 + ": " + searchBogieById(bogies, key1));

        System.out.println("---------------------------------------");

        // Test Case 2: Not Found
        String key2 = "BG999";
        System.out.println("Searching for " + key2 + ": " + searchBogieById(bogies, key2));

        System.out.println("---------------------------------------");

        // Test Case 3: First Element Match
        String key3 = "BG101";
        System.out.println("Searching for First Element (" + key3 + "): " + searchBogieById(bogies, key3));

        System.out.println("---------------------------------------");

        // Test Case 4: Empty Array Handling
        String[] emptyBogies = {};
        System.out.println("Searching in Empty Array: " + searchBogieById(emptyBogies, "BG101"));
    }
}

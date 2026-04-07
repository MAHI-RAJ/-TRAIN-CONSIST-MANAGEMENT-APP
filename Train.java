import java.util.Arrays;

public class Train{

    /**
     * UC20: Optimized Search with State Validation
     * Uses Defensive Programming to throw an IllegalStateException if the train is empty.
     */
    public static boolean searchBogieById(String[] bogieIds, String searchKey) throws IllegalStateException {

        // --- UC20: STATE VALIDATION (Fail-Fast) ---
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search Operation Failed: No bogies are currently attached to the train consist.");
        }

        // --- UC19: SEARCH LOGIC ---
        // Binary search requires sorted data
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Search Match Found
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false; // Search Match Not Found
    }

    public static void main(String[] args) {
        System.out.println("--- UC20: Exception Handling & State Validation ---");

        // TEST CASE 1: Search Allowed When Data Exists
        String[] activeTrain = {"BG101", "BG205", "BG309"};
        try {
            System.out.print("Test 1 (Valid Data): ");
            boolean found = searchBogieById(activeTrain, "BG205");
            System.out.println("Bogie Found? " + found);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------");

        // TEST CASE 2: Exception When Empty Data
        String[] emptyTrain = {};
        try {
            System.out.print("Test 2 (Empty Train): ");
            searchBogieById(emptyTrain, "BG101");
        } catch (IllegalStateException e) {
            // This block catches the Fail-Fast exception
            System.out.println("CAUGHT EXPECTED ERROR: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------");

        // TEST CASE 3: Search Match Not Found After Validation
        try {
            System.out.print("Test 3 (Bogie Missing): ");
            boolean found = searchBogieById(activeTrain, "BG999");
            System.out.println("Bogie Found? " + found);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
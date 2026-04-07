public class Train {

    /**
     * Performs a Linear Search to find a specific Bogie ID.
     * Logic: Sequential traversal with early termination upon match.
     * Time Complexity: O(n)
     */
    public static boolean findBogieById(String[] bogieIds, String searchKey) {
        System.out.println("Searching for Bogie ID: " + searchKey + "...");

        for (int i = 0; i < bogieIds.length; i++) {
            // Using .equals() for safe String comparison
            if (bogieIds[i].equals(searchKey)) {
                System.out.println("Match found at position: " + (i + 1));
                return true; // Early termination: stop searching once found
            }
        }

        return false; // Traversed entire list, no match found
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System (UC18: Linear Search) ===");

        // Initial Unsorted Consist Data
        String[] consist = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // TEST CASE 1: Basic Search (Bogie Found)
        runSearchTest(consist, "BG309");

        // TEST CASE 2: Search for First Element
        runSearchTest(consist, "BG101");

        // TEST CASE 3: Search for Last Element
        runSearchTest(consist, "BG550");

        // TEST CASE 4: Search for Non-Existent Bogie
        runSearchTest(consist, "BG999");

        // TEST CASE 5: Single Element Array
        String[] singleBogie = {"BG101"};
        runSearchTest(singleBogie, "BG101");

        System.out.println("\nSearch operations completed. System ready for next task.");
    }

    private static void runSearchTest(String[] data, String key) {
        System.out.println("-------------------------------------------------");
        boolean isFound = findBogieById(data, key);
        if (isFound) {
            System.out.println("RESULT: Bogie " + key + " is present in the consist.");
        } else {
            System.out.println("RESULT: Bogie " + key + " not found in the current consist.");
        }
    }

}
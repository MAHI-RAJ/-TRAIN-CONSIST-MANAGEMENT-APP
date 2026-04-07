public class Train {

    /**
     * Sorts bogie capacities using the Bubble Sort algorithm.
     * Logic: Compares adjacent elements and swaps them if they are in the wrong order.
     * Time Complexity: O(n^2)
     */
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        boolean swapped;

        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for adjacent comparisons
            // (n - i - 1) because the last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {
                    // Perform Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // Optimization: If no two elements were swapped in the inner loop, break
            if (!swapped) break;
        }
    }

    public static void displayCapacities(String message, int[] capacities) {
        System.out.print(message + ": [");
        for (int i = 0; i < capacities.length; i++) {
            System.out.print(capacities[i] + (i == capacities.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System (UC16: Manual Sorting) ===");

        // Test Case: Unsorted Passenger Bogie Capacities
        int[] bogieCapacities = {72, 56, 24, 70, 60};

        displayCapacities("Original Capacities", bogieCapacities);

        // Execute Manual Bubble Sort
        System.out.println("Executing Bubble Sort Algorithm...");
        bubbleSort(bogieCapacities);

        displayCapacities("Sorted Capacities (Ascending)", bogieCapacities);

        // Verify with Duplicate Values
        int[] duplicates = {72, 56, 56, 24};
        System.out.println("\nHandling Duplicate Capacities...");
        bubbleSort(duplicates);
        displayCapacities("Sorted Duplicates", duplicates);

        System.out.println("\nSorting complete. System ready for passenger allocation.");
    }
}
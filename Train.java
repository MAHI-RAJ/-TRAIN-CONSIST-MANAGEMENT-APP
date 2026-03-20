import java.util.HashMap;
import java.util.Map;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC6) ===");

        // 1. Initialize HashMap: Key (String) -> Value (Integer)
        Map<String, Integer> bogieCapacities = new HashMap<>();

        // 2. put() Method: Mapping Bogie Names to their Seat/Load Capacities
        System.out.println("Registering Bogie Capacities...");
        bogieCapacities.put("Sleeper", 72);
        bogieCapacities.put("AC Chair", 56);
        bogieCapacities.put("First Class", 24);
        bogieCapacities.put("General", 90);

        // 3. entrySet() Iteration: Accessing both Key and Value together
        System.out.println("\n--- Train Capacity Directory ---");
        for (Map.Entry<String, Integer> entry : bogieCapacities.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() +
                    " | Capacity: " + entry.getValue() + " seats");
        }

        // 4. Fast Lookup: Retrieving a specific value using a Key
        String searchBogie = "AC Chair";
        if (bogieCapacities.containsKey(searchBogie)) {
            System.out.println("\nQuick Search: " + searchBogie +
                    " has a capacity of " + bogieCapacities.get(searchBogie) + ".");
        }
    }
}
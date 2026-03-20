import java.util.HashSet;
import java.util.Set;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC3) ===");

        // 1. Initialize a HashSet to store unique Bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // 2. Add Bogie IDs (including intentional duplicates)
        System.out.println("Registering Bogie IDs...");
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        // Attempting to add a duplicate ID
        System.out.println("Attempting to add duplicate ID: BG101");
        boolean isAdded = bogieIds.add("BG101");

        // 3. Check if the duplicate was accepted
        if (!isAdded) {
            System.out.println("Alert: Duplicate ID 'BG101' rejected by the system.");
        }

        // 4. Display the Final Unique Set
        System.out.println("\nRegistered Unique Bogie IDs:");
        System.out.println(bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }
}
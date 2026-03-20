import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC2) ===");

        // 1. Initialize the ArrayList for Passenger Bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. ADD: Attaching bogies to the train
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Current Consist: " + passengerBogies);
        System.out.println("Total Bogies: " + passengerBogies.size());

        // 3. REMOVE: Detaching a bogie (e.g., maintenance or route change)
        System.out.println("\nRemoving 'AC Chair' from the consist...");
        passengerBogies.remove("AC Chair");

        // 4. CONTAINS: Checking if a specific bogie exists
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Does the train have a Sleeper bogie? " + (hasSleeper ? "Yes" : "No"));

        // 5. Final State Display
        System.out.println("\nFinal Consist Summary:");
        System.out.println(passengerBogies);
        System.out.println("Final Bogie Count: " + passengerBogies.size());
    }
}
import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {
        // 1. Print Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // 2. Dynamic Initialization
        // We use the List interface for abstraction and ArrayList for the implementation
        List<String> trainConsist = new ArrayList<>();

        // 3. Display Initial State
        // Using .size() demonstrates that the collection is currently empty
        System.out.println("Initializing system...");
        System.out.println("Current Bogie Count: " + trainConsist.size());

        System.out.println("System ready for composition.");
    }
}
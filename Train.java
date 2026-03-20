import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC5) ===");

        // 1. Initialize LinkedHashSet to maintain unique, ordered bogies
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies in a specific physical sequence
        System.out.println("Attaching bogies to the Engine...");
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 3. AUTOMATIC DEDUPLICATION: Attempting to add a duplicate
        System.out.println("Attempting to attach duplicate: Sleeper");
        boolean addedAgain = trainFormation.add("Sleeper");

        if (!addedAgain) {
            System.out.println("System Alert: Duplicate bogie 'Sleeper' rejected. Safety maintained.");
        }

        // 4. INSERTION ORDER PRESERVATION: Displaying the formation
        System.out.println("\nFinal Train Formation (Physical Sequence):");
        // The output will always follow the order: Engine -> Sleeper -> Cargo -> Guard
        System.out.println(trainFormation);

        System.out.println("Total Unique Bogies in Formation: " + trainFormation.size());
    }
}
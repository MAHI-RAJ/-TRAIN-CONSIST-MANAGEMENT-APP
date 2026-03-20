import java.util.LinkedList;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (UC4) ===");

        // 1. Initialize the LinkedList (The Chain)
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add base bogies
        trainConsist.add("Sleeper");
        trainConsist.add("AC Coach");
        trainConsist.add("Cargo");

        // 3. addFirst / addLast: Positioning the Engine and Guard
        System.out.println("Attaching Engine and Guard Coach...");
        trainConsist.addFirst("Engine");
        trainConsist.addLast("Guard Coach");

        // 4. add(index, element): Inserting in the middle
        System.out.println("Inserting Pantry Car at position 2...");
        trainConsist.add(2, "Pantry Car");

        System.out.println("Current Train Formation: " + trainConsist);

        // 5. removeFirst / removeLast: Detaching ends
        System.out.println("\nDetaching Engine and Guard Coach for maintenance...");
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // 6. Final State Display
        System.out.println("Final Ordered Consist: " + trainConsist);
        System.out.println("Total Bogies remaining: " + trainConsist.size());
    }
}
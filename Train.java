import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Train {

    static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return "Bogie Name: " + name + ", Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Creating a larger dataset for comparison
        for (int i = 1; i <= 100000; i++) {
            if (i % 3 == 0) {
                bogies.add(new Bogie("Sleeper", 72));
            } else if (i % 3 == 1) {
                bogies.add(new Bogie("AC Chair", 56));
            } else {
                bogies.add(new Bogie("First Class", 24));
            }
        }

        // Loop-based filtering
        long loopStart = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopFiltered.add(bogie);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // Stream-based filtering
        long streamStart = System.nanoTime();

        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // Display results
        System.out.println("Total bogies created: " + bogies.size());

        System.out.println("\nLoop-Based Filtering:");
        System.out.println("Filtered bogies count: " + loopFiltered.size());
        System.out.println("Execution time: " + loopTime + " ns");

        System.out.println("\nStream-Based Filtering:");
        System.out.println("Filtered bogies count: " + streamFiltered.size());
        System.out.println("Execution time: " + streamTime + " ns");

        // Result consistency check
        System.out.println("\nResult Consistency Check:");
        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("Both loop and stream produced the same number of filtered bogies.");
        } else {
            System.out.println("Loop and stream results are different.");
        }

        System.out.println("\nSample Filtered Bogies:");
        for (int i = 0; i < Math.min(5, loopFiltered.size()); i++) {
            System.out.println(loopFiltered.get(i));
        }

        System.out.println("\nProgram continues...");
    }
}
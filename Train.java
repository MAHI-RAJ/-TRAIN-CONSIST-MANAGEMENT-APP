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

    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General Coach", 90));

        int threshold = 60;

        System.out.println("Passenger Bogies Before Filtering:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        List<Bogie> filteredBogies = filterBogiesByCapacity(bogies, threshold);

        System.out.println("\nFiltered Passenger Bogies (Capacity > " + threshold + "):");
        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies matched the filter condition.");
        } else {
            for (Bogie bogie : filteredBogies) {
                System.out.println(bogie);
            }
        }

        System.out.println("\nOriginal Passenger Bogies After Filtering (Unchanged):");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
    }
}

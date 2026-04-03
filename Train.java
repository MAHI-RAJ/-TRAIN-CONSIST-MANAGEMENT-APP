import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Train{

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

        // Adding passenger bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        System.out.println("Passenger Bogies Before Sorting:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        // Sorting by capacity using Comparator
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nPassenger Bogies After Sorting by Capacity:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        System.out.println("\nProgram continues...");
        System.out.println("Executed successfully!");
    }
}

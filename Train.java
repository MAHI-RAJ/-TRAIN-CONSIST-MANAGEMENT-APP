import java.util.ArrayList;
import java.util.List;

public class Train {

    // Custom exception class
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie class
    static class PassengerBogie {
        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return "PassengerBogie{type='" + type + "', capacity=" + capacity + "}";
        }
    }

    public static void main(String[] args) {
        List<PassengerBogie> trainConsist = new ArrayList<>();

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            trainConsist.add(b1);
            System.out.println("Added successfully: " + b1);

            PassengerBogie b2 = new PassengerBogie("AC Chair", 56);
            trainConsist.add(b2);
            System.out.println("Added successfully: " + b2);

            PassengerBogie b3 = new PassengerBogie("First Class", 0); // invalid
            trainConsist.add(b3);
            System.out.println("Added successfully: " + b3);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nValid bogies currently in train consist:");
        for (PassengerBogie bogie : trainConsist) {
            System.out.println(bogie);
        }

        System.out.println("\nProgram continues safely...");
    }
}
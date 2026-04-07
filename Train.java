// Custom Runtime Exception for Cargo Safety violations
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String id;
    private String shape; // "Rectangular" or "Cylindrical"
    private String currentCargo = "None";

    public GoodsBogie(String id, String shape) {
        this.id = id;
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        System.out.println("\n>>> Initiating Safety Check for Bogie: " + id + " [" + shape + "]");

        try {
            // Business Logic: Petroleum is strictly forbidden in Rectangular bogies
            if (cargoType.equalsIgnoreCase("Petroleum") && shape.equalsIgnoreCase("Rectangular")) {
                throw new CargoSafetyException("CRITICAL SAFETY VIOLATION: Petroleum cannot be assigned to Rectangular bogies!");
            }

            // If no exception is thrown, assign the cargo
            this.currentCargo = cargoType;
            System.out.println("SUCCESS: " + cargoType + " has been safely loaded into " + id + ".");

        } catch (CargoSafetyException e) {
            // Handling the failure gracefully
            System.err.println("EXCEPTION CAUGHT: " + e.getMessage());
            System.out.println("STATUS: Assignment blocked. Bogie remains empty/unchanged.");

        } finally {
            // This block always runs regardless of success or failure
            System.out.println("LOG: Cargo assignment validation cycle finished for " + id + ".");
        }
    }

    public String getCurrentCargo() {
        return currentCargo;
    }
}

public class Train {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System (UC15: Structured Exception Handling) ===");

        // 1. Create Bogies
        GoodsBogie cylindricalBogie = new GoodsBogie("GB-101", "Cylindrical");
        GoodsBogie rectangularBogie = new GoodsBogie("GB-202", "Rectangular");

        // 2. Test Case: Safe Assignment (Cylindrical + Petroleum)
        cylindricalBogie.assignCargo("Petroleum");

        // 3. Test Case: Unsafe Assignment (Rectangular + Petroleum)
        // This will trigger the catch block but NOT crash the app
        rectangularBogie.assignCargo("Petroleum");

        // 4. Test Case: Program Continuation (Ensuring system is still alive)
        rectangularBogie.assignCargo("Grain");

        // 5. Final Summary
        System.out.println("\n--- FINAL CONSIST INVENTORY ---");
        System.out.println("Bogie GB-101 Status: " + cylindricalBogie.getCurrentCargo());
        System.out.println("Bogie GB-202 Status: " + rectangularBogie.getCurrentCargo());
        System.out.println("--------------------------------");
        System.out.println("System execution finished successfully.");
    }
}
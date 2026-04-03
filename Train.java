import java.util.ArrayList;
import java.util.List;

public class Train {

    static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return "GoodsBogie{type='" + type + "', cargo='" + cargo + "'}";
        }
    }

    public static void main(String[] args) {
        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie bogie : bogies) {
            System.out.println(bogie);
        }

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.getType().equalsIgnoreCase("Cylindrical")
                        || b.getCargo().equalsIgnoreCase("Petroleum"));

        System.out.println("\nSafety Compliance Check:");
        if (isSafe) {
            System.out.println("Train is safety compliant.");
        } else {
            System.out.println("Train is NOT safety compliant.");
        }

        System.out.println("\nProgram continues...");
    }
}
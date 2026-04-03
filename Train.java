import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Regex patterns
        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern trainPattern = Pattern.compile(trainIdRegex);
        Pattern cargoPattern = Pattern.compile(cargoCodeRegex);

        // User input
        System.out.print("Enter Train ID: ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();

        // Create matchers
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validate using matches()
        boolean isTrainIdValid = trainMatcher.matches();
        boolean isCargoCodeValid = cargoMatcher.matches();

        // Display results
        if (isTrainIdValid) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Train ID is invalid. Format should be like TRN-1234");
        }

        if (isCargoCodeValid) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Cargo Code is invalid. Format should be like PET-AB");
        }

        System.out.println("Program continues...");
        scanner.close();
    }
}
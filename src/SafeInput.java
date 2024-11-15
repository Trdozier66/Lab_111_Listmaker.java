import java.util.Scanner;

public class SafeInput {

    private static Scanner sc = new Scanner(System.in);

    // Get input matching a regular expression
    public static String getRegExString(String prompt, String regEx) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine();
            if (input.matches(regEx)) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return input;
    }

    // Get an integer within a specific range
    public static int getRangedInt(String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextInt();
            sc.nextLine(); // Consume the newline character left by nextInt()
            if (input >= min && input <= max) {
                break;
            } else {
                System.out.println("Input must be between " + min + " and " + max + ". Try again.");
            }
        }
        return input;
    }

    // Confirm with yes/no
    public static boolean getYNConfirm(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            input = sc.nextLine().toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }
}

package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput() {
        boolean valueInput = false;
        int input = 0;

        while (!valueInput) {
            try {
                input = scanner.nextInt();
                valueInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }
        return input;
    }

    public static String getStringInput() {
        return scanner.nextLine().trim();
    }
}

package utils;

import java.util.Scanner;

public class InputValidation {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getValidInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
//                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }

}

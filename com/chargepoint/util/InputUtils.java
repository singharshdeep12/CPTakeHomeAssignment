package com.chargepoint.util;

import java.util.Scanner;

public final class InputUtils {

    private InputUtils() {}
    private static final Scanner scanner = new Scanner(System.in);

    public static int getValidIntegerInput(String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if(number<=0) {
                    System.out.println("Cells and generations must be positive numbers. Enter again...");
                    continue;
                }
                break;
            } else {
                System.err.println("Invalid input! Please enter a positive integer...");
                scanner.next();
            }
        }
        return number;
    }
}

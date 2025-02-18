package JavaSem6;

import java.util.InputMismatchException;
import java.util.Scanner;

// Easy Level: Square Root Calculation with Exception Handling
class Project3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double number = scanner.nextDouble();
            if (number < 0) {
                throw new IllegalArgumentException("Error: Cannot calculate the square root of a negative number.");
            }
            System.out.println("Square Root: " + Math.sqrt(number));
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
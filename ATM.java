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

// Medium Level: ATM Withdrawal System
class ATM {
    private static final int CORRECT_PIN = 1234;
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int pin, double amount) throws Exception {
        if (pin != CORRECT_PIN) {
            throw new Exception("Error: Invalid PIN.");
        }
        if (amount > balance) {
            throw new Exception("Error: Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: " + balance);
    }

    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(3000);
        try {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            atm.withdraw(pin, amount);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            atm.showBalance();
            scanner.close();
        }
    }
}

// Hard Level: University Enrollment System with Custom Exceptions
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class UniversityEnrollment {
    private static final int MAX_STUDENTS = 5;
    private int enrolledStudents = 0;

    public void enrollStudent(String course, boolean prerequisiteCompleted)
            throws CourseFullException, PrerequisiteNotMetException {
        if (!prerequisiteCompleted) {
            throw new PrerequisiteNotMetException(
                    "Error: PrerequisiteNotMetException - Complete Core Java before enrolling in " + course + ".");
        }
        if (enrolledStudents >= MAX_STUDENTS) {
            throw new CourseFullException("Error: CourseFullException - Enrollment limit reached for " + course + ".");
        }
        enrolledStudents++;
        System.out.println("Enrollment successful in " + course);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniversityEnrollment enrollmentSystem = new UniversityEnrollment();
        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();
            System.out.print("Prerequisite Completed (true/false): ");
            boolean prerequisiteCompleted = scanner.nextBoolean();
            enrollmentSystem.enrollStudent(course, prerequisiteCompleted);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter correct values.");
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

package JavaSem6;

import java.util.InputMismatchException;
import java.util.Scanner;

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
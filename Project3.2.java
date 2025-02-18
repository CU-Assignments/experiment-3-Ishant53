package JavaSem6;

import java.util.InputMismatchException;
import java.util.Scanner;

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

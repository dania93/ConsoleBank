import java.util.Scanner;

public class Account {

    double balance;
    double previousTransaction;
    String clientName;
    String clientID;

    Account(String clientName, String clientID) {
        this.clientName = clientName;
        this.clientID = clientID;

    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + previousTransaction);
        } else {
            System.out.println("You have no transaction!");
        }
    }

    void calculateRate(int years) {
        double annualRate = 0.65;
        double newBalance = (balance * annualRate * years) + balance;
        System.out.println("The current annual rate is: " + (100 * annualRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("hi there, " + clientName + "!");
        System.out.println("your id is: " + clientID);
        System.out.println();
        System.out.println("what do you want to do?");
        System.out.println();
        System.out.println("a. check your balance");
        System.out.println("b. make a deposit");
        System.out.println("c. make a withdrawal");
        System.out.println("d. view previous transaction");
        System.out.println("e. calculate rate");
        System.out.println("f. exit");

        do {
            System.out.println();
            System.out.println("Enter your option: ");
            char scanOption = scanner.next().charAt(0);
            option = Character.toLowerCase(scanOption);
            System.out.println();

            switch (option) {

                case 'a':
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("Balance = $" + balance);
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println();
                    break;

                case 'b':
                    System.out.println("Enter an amount to deposit: ");
                    int scanAmount1 = scanner.nextInt();
                    deposit(scanAmount1);
                    System.out.println();
                    break;

                case 'c':
                    System.out.println("Enter an amount to withdraw: ");
                    int scanAmount2 = scanner.nextInt();
                    withdraw(scanAmount2);
                    System.out.println();
                    break;

                case 'd':
                    System.out.println("--------------------------------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println();
                    break;

                case 'e':
                    System.out.println("Enter how many years of accrued rate: ");
                    int scanYears = scanner.nextInt();
                    calculateRate(scanYears);
                    break;

                case 'f':
                    System.out.println("--------------------------------------------------------------------------------");
                    break;

                default:
                    System.out.println("error: invalid option. please enter a, b, c, d, e or f");
                    break;

            }
        } while(option != 'f');

        System.out.println("thank you for choosing our bank!");

    }
}
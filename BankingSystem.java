import java.util.Scanner;

class UserAccount {
    private int accountBalance;

    public UserAccount(int initialDeposit) {
        this.accountBalance = initialDeposit;
    }

    public int getBalance() {
        return accountBalance;
    }

    public void depositFunds(int amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Successfully deposited " + amount + " Rs.");
        } else {
            System.out.println("Invalid amount! Please enter a value greater than 0.");
        }
    }

    public void withdrawFunds(int amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Successfully withdrew " + amount + " Rs.");
        } else {
            System.out.println("Invalid request! Insufficient funds or negative amount.");
        }
    }
}

class ATMInterface {
    private UserAccount userAccount;

    public ATMInterface(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void showOptions() {
        System.out.println("Please select an option:");
        System.out.println("1. Deposit Funds");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Exit");
    }

    public void operateATM() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showOptions();
            System.out.print("Select an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    userAccount.depositFunds(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    userAccount.withdrawFunds(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is: " + userAccount.getBalance() + " Rs.");
                    break;
                case 4:
                    System.out.println("Thank you for using SBI Bank. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please choose a valid option from the menu.");
            }
        } while (choice != 4);
        scanner.close();
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAccount account = new UserAccount(30000);
        ATMInterface atm = new ATMInterface(account);

        System.out.print("Enter your PIN: ");
        String userPin = scanner.nextLine();
        if (userPin.equals("1234")) {
            atm.operateATM();
        } else {
            System.out.println("Incorrect PIN entered.");
        }

        scanner.close();
    }
}


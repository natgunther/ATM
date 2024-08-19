
package ATM;

import java.util.Scanner;
public class UI {
    public Scanner scanner;
    private Accounts accounts;

    public UI(Scanner scanner, Accounts accounts){
        this.scanner = scanner;
        this.accounts = accounts;
    }

    public void start(){
        accounts.initiate();
        int maxLimit = 3000;
        double runningWithdrawalSum = 0;
        System.out.println("Hello, please enter your unique 4-digit pin:");
        int pin = scanner.nextInt();
        while (true){
            if (!accounts.doesUserExist(pin)) {
                System.out.println("Error: Cannot find account, please see teller inside for assistance.");
                break;
            }
            System.out.println("Please select from the following list of options:");
            System.out.println("1: Withdraw");
            System.out.println("2: Deposit");
            System.out.println("3: Show Balance");
            System.out.println("4: Exit");
            int choice = scanner.nextInt();
            switch(choice){
                case 4:
                    System.out.println("Thank you for your business.");
                    System.exit(0);
                case 1:
                    System.out.println("Please enter how much money you would like to withdraw.");
                    double withdrawal = 0.0;
                    do {
                        try{
                            String s = scanner.next();
                            withdrawal = Double.parseDouble(s);
                            break;
                        }
                        catch (Exception e){
                            System.out.println("Invalid entry, please try again.");
                        }
                    }
                    while (true);
                    if (withdrawal < 0.0){
                        System.out.println("Withdraw unsuccessful.");
                        System.out.println("");
                    }
                    else if (withdrawal > accounts.getBalance(pin)){
                        System.out.println("Error, insufficient funds.");
                    } else if (runningWithdrawalSum + withdrawal > maxLimit){
                        System.out.println("Error, your desired withdrawal amount will exceed the daily allotted withdrawal limit.");
                    } else if (runningWithdrawalSum > maxLimit){
                        System.out.println("Error, you have reached the daily allotted withdrawal limit.");
                    } else {
                        accounts.withdraw(pin, withdrawal);
                        System.out.println("Withdrawal successful, please take your money below.");
                        runningWithdrawalSum += withdrawal;
                        //comment out, used for testing
                        System.out.println("You have " + accounts.getBalance(pin) + " left");
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("Please enter how much money you would like to deposit");
                    double deposit = 0.0;
                    do {
                        try{
                            String s = scanner.next();
                            deposit = Double.parseDouble(s);
                            break;
                        }
                        catch (Exception e){
                            System.out.println("Invalid entry, please try again.");
                        }
                    }
                    while (true);
                    accounts.deposit(pin, deposit);
                    break;
                case 3:
                    System.out.println("You have " + accounts.getBalance(pin) + " available.");
                    System.out.println("");
                    break;
            }
        }
    }
}

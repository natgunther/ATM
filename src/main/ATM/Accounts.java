package ATM;

import java.util.HashMap;

public class Accounts {
    private HashMap<Integer, Double> accounts = new HashMap<>();

    public Accounts(){

        this.accounts = new HashMap<>();
    }

    public void initiate(){
        accounts.put(8754, 1000.65);
        accounts.put(9332, 5980.45);
        accounts.put(7290, 3256.43);
        accounts.put(0230, 9034.87);
    }

    public double getBalance(int pin){

        return accounts.get(pin);
    }

    public boolean doesUserExist(int pin){

        return accounts.containsKey(pin);
    }

    public void withdraw(int pin, double amount){
        if (amount >= 0.0) {
            accounts.put(pin, accounts.get(pin) - amount);
        } else {
            System.out.println("Withdraw unsuccessful");
        }
    }

    public void deposit(int pin, double amount) {
        if (amount >= 0.0) {
            accounts.put(pin, accounts.get(pin) + amount);
            System.out.println("Deposit successful. You have " + accounts.get(pin) + " available");
            System.out.println("");
        } else {
            System.out.println("Deposit unsuccessful.");
            System.out.println("");
        }
    }
}

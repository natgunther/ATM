package ATM;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AccountsTest {

    @Test
    public void withdrawTest(){
        Accounts account = new Accounts();
        account.initiate();
        //you can change the value assigned to the amountToWithdraw variable throughout testing to validate that withdrawing different amounts results in successful "withdraws"
        double amountToWithdraw = 20.45;
        double result = account.getBalance(9332) - amountToWithdraw;
        account.withdraw(9332, amountToWithdraw);
        Assertions.assertEquals(result, account.getBalance(9332));
    }

    @Test
    public void getBalanceTest(){
        Accounts account = new Accounts();
        account.initiate();
        //pin options: 8754, 9332, 7290, or 0230. change the pin value to either of these options for testing purposes
        int pin = 8754;
        double result = account.getBalance(pin);
        Assertions.assertEquals(result, account.getBalance(pin));
    }

    @Test
    public void doesUserExistTest(){
        Accounts account = new Accounts();
        account.initiate();
        //pin options: 8754, 9332, 7290, or 0230. If you enter a pin different from these options as the pin variable value, the test should fail.
        int pin = 8754;
        Assertions.assertTrue(account.doesUserExist(pin));
    }

    @Test
    public void depositTest(){
        Accounts account = new Accounts();
        account.initiate();
        //you can change the value assigned to the amountToDeposit variable throughout testing to validate that depositing different amounts results in successful "deposits"
        double amountToDeposit = 50.00;
        int pin = 8754;
        double result = account.getBalance(pin) + amountToDeposit;
        account.deposit(pin, amountToDeposit);
        Assertions.assertEquals(result, account.getBalance(pin));

    }
}
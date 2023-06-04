package ATM;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        Accounts accounts = new Accounts();

        UI ui = new UI(scanner, accounts);
        ui.start();
    }
}

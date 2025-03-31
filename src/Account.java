import util.TextUI;

public class Account {
    private int balance;
    TextUI ui = new TextUI();

    public void deposit(int ammount){

    }

    public boolean withdraw(int ammount) {
        if(balance >= ammount) {
            balance -= ammount;
            return true;
        } else {
            ui.displayMessage("Du har ikke penge nok til at betale...");
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }
}

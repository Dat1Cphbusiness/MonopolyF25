public class Account {

    // Attributes
    private int balance;
    private TextUI ui = new TextUI();

    // _______________________________________

    public void deposit(int amount){
        this.balance += amount;
    }

    // _______________________________________

    public boolean withdraw(int amount){

        if(this.balance <= amount){
            this.balance -= amount;
            return true;
        }

        ui.displayMessage("Du her desværre ikke nok penge til at lave dette..");
        return false;

    }

    // _______________________________________

    public int getBalance(){
        return this.balance;
    }

}

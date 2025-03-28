public class Account {

    private int balance;

    public void deposit(int amount){
        this.balance += amount;
    }

    public boolean withdraw(int amount){

        // Only withdraw if enough money on account
        if(this.balance >= amount){
            this.balance -= amount;
            return true;
        }
            return false;
    }

    public int getBalance() {
        return this.balance;
    }
}

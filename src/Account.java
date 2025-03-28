public class Account {
    private int balance;
    public Account() {

    }


    public void deposit(int amount) {
        this.balance += amount;
    }
    public boolean withdraw(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    public int getBalance() {
        return this.balance;
    }
}

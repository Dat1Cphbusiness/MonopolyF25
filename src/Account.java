public class Account {
    private int balance;

    public void deposit(int amount){

    }

    public boolean withdraw(int amount){
        if(amount < this.balance){
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance(){
        return this.balance;
    }
}

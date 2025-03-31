import java.util.ArrayList;

public class Player {

    // Attributes
    private String name;
    private int score;
    private Account playerAccount;
    private boolean hasPassedStart;
    private int position = 0;
    private ArrayList<Field> deeds;

    // ______________________________________________

    public Player(String name, int score){
        this.name = name;
        this.score = score;
        this.playerAccount = new Account();
        deeds = new ArrayList<>();
    }

    // ______________________________________________

    public int updatePostion(int value){
        if (position+value > 40){
            receive(4000);
            position = (position + value) - 40;
        }else{
            position += value;
        }

        return this.position;

    }

    // ______________________________________________

    @Override
    public String toString(){
        return name + ", "+ score;
    }

    // ______________________________________________

    public String getName(){
        return name;
    }

    // ______________________________________________

    public void receive (int amount){
        playerAccount.deposit(amount);
    }

    // ______________________________________________

    // For the bank or the "universe"
    public boolean pay(int amount){
        if (!(playerAccount.getBalance() >= amount)) {
            return false;
        }
        playerAccount.withdraw(amount);
        return true;
    }

    // ______________________________________________

    // Overloading by changing the parameters. This allows the same method name as previously used.
    public boolean pay(int amount, Player recipient){ // Player to player payment

        if (!(playerAccount.getBalance() >= amount)) {
            return false;
        }
        playerAccount.withdraw(amount);
        recipient.receive(amount);
        return true;
    }

    // ______________________________________________

    public boolean buyProperty(Field f){

        if (!pay(f.getCost())) {
            return false;
        }

        deeds.add(f);
        return true;
    }

    // ______________________________________________

    public int getTotalWorth() {
        int amount = 0;

        // For-each loop
        for (Field f : deeds) {
            amount += f.getCost();
        }

        return amount + playerAccount.getBalance();
    }

} // Player class end

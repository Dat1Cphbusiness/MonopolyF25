import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    private Account playerAccount;
    private boolean hasPassedStart;
    private int position = 0;
    private ArrayList<Field> deeds;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        this.playerAccount = new Account();
        this.deeds = new ArrayList<>();
    }
    int updatePostion(int value){
        if (position+value > 40){
            receive(4000);
            position = (position + value) - 40;
        }else{
            position += value;
        }

        return this.position;

    }

    @Override
    public String toString(){
        return name + ", "+ score;
    }

    public String getName(){
        return name;
    }

    public void receive (int amount){
        playerAccount.deposit(amount);
    }

    public boolean pay(int amount) {
        return playerAccount.withdraw(amount);
    }

    public boolean pay(int amount, Player recipient){
        recipient.receive(amount);
        return pay(amount);

    }

    public boolean buyProperty(Field f) {
        if (pay(f.getCost())) {
            this.deeds.add(f);
            return true;
        }
        return false;
    }

    public int getTotalWorth(){
        int total = 0;
        for(Field f: deeds){
            total += f.getCost();
        }
        return total + playerAccount.getBalance();
    }
}

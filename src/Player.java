import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    private Account playerAccount;
    private ArrayList<Field> deeds;
    private boolean hasPassedStart;
    private int position = 0;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        this.playerAccount = new Account();
        this.deeds = new ArrayList<Field>();
    }
    int updatePostion(int value){
       /* if(hasPassedStart){

            hasPassedStart = false;
        }*/


        this.position += value;
        if(this.position > 40){
            this.position -= 40;
            receive(4000);
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

    void receive (int amount){
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
        if (pay(f.getCost()) == false)
            return false;
        deeds.add(f);
        return true;
    }
}

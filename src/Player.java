import java.util.ArrayList;

public class Player {
    private String name;
    private Account playerAccount;
    private boolean hasPassedStart;
    private int position = 0;
    private ArrayList<Property> deeds = new ArrayList<>();
    
    public Player(String name, int balance){
        this.name = name;
        this.playerAccount = new Account(balance);


    }
    public int updatePostion(int value){
        if (position+value > 40){
            receive(4000);
            position = (position + value) - 40;
        }else{
            position += value;
        }

        return this.position;

    }

    public void receive (int amount){
        playerAccount.deposit(amount);
    }

    public void pay(int amount){
        playerAccount.withdraw(amount);
    }

    public void pay(int amount, Player recipient){
        this.pay(amount);
        recipient.receive(amount);
    }

    public void buyProperty(Property p){
        this.pay(p.getCost());
        deeds.add(p);
    }

    public int getTotalWorth(){
        int totalDeedWorth = 0;

        for(Field d: deeds){
            totalDeedWorth += d.getCost();
        }
        int total = totalDeedWorth + playerAccount.getBalance();

        return total;
    }


    @Override
    public String toString(){
        return name + ", "+ playerAccount.getBalance();
    }

    public String getName(){
        return name;
    }


}
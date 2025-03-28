import java.util.ArrayList;

public class Player {

    // Attributes
    private String name;
    private int score;
    private int position;
    private Account account;
    private ArrayList <Field> deeds;
    private TextUI ui = new TextUI();

    // _______________________________________
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        account = new Account();
    }

    // _______________________________________

    @Override
    public String toString(){
        return name + ", "+ score;
    }

    // _______________________________________

    public String getName(){
        return name;
    }

    // _______________________________________

    public boolean pay(int amount){
        // Placeholder
        return true;
    }

    // _______________________________________

    public boolean pay(int amount, Player recipient){
        // Placeholder
        return true;
    }

    // _______________________________________

    public void collect(int amount){

    }

    // _______________________________________

    public int updatePosition(int value){

        if(startPassed()){
            recieve(4000);
        }

        return this.position = value;
    }

    // _______________________________________

    private boolean startPassed(){

        if(this.position == 0){
            ui.displayMessage("Du har passeret start.. Du modtager 4000 kr.");
            return true;
        }

        return false;

    }

    // _______________________________________

    public boolean buyProperty(Field f){
        // Placeholder
        return true;
    }

    // _______________________________________

    public void recieve(int amount){
        this.account.deposit(amount);
    }

    // _______________________________________

    public int getBalance(){
        return this.account.getBalance();
    }


}

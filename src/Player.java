public class Player {
    private String name;
    private int score;
    private Account playerAccount;
    private boolean hasPassedStart;
    private int position = 0;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        this.playerAccount = new Account();
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
}

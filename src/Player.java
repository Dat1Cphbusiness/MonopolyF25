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

    void receive (int amount){

        playerAccount.deposit(amount);
    }
}

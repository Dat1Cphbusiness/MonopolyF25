public class Player {
    private String name;
    private int score;
    private Account playerAccount;
    private boolean hasPassedStart;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        this.playerAccount = new Account();
    }
    int updatePostion(int value){
        if(hasPassedStart){
            receive(4000);
            hasPassedStart = false;
        }

        int position = value;
        return position;

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

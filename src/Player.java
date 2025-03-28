public class Player {
    private String name;
    private int score;
    private int position;
    private Account account;
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        account = new Account();
    }


    @Override
    public String toString(){
        return name + ", "+ score;
    }

    public String getName(){
        return name;
    }

    public int updatePosition(int position){
        this.position += position;
        if (this.position => 40) {
            receive(3000);
            this.position -= 40;
        }
        return this.position;
    }

    public void receive(int amount) {
        account.deposit(amount);
    }


}

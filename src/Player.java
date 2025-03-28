public class Player {
    private String name;
    private int score;
    private int position;
    private Account acc;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
        this.position = 0;
        acc = new Account();

    }

    @Override
    public String toString(){
        return name + ", "+ score;
    }

    public String getName(){
        return name;
    }

    public int updatePosition(int value){
        if(this.position + value >= 40) {
            this.receive(2000);
            return this.position = (this.position + value) - 40;   // returner ny position efter passret start/reset value counter;
        }
        return this.position = value;
    }

    public void receive(int amount){
        acc.deposit(amount);
    }


}

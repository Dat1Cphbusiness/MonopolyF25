public class Player {
    private String name;
    private int score;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return name + ", "+ score;
    }


}

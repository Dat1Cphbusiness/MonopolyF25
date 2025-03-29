public class Player {
    private String name;
    private int score;
    
    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }
    int updatePostion(int value){
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


}

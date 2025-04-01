import java.util.ArrayList;
import java.util.Random;

public class Dice {
    Random random = new Random();
    int[] dice = new int[2];
    public Boolean isDouble = false;


    public int rollDiceSum(){
        dice[0] = random.nextInt(1, 7);
        dice[1] = random.nextInt(1, 7);

        if(dice[0] == dice[1]){
            isDouble = true;
        }

        return dice[0] + dice[1];
    }

    public int getDice(int i){
        return dice[i];

    }



}

import java.util.Random;

public class Dice {
    int[] rolledTwoDice = new int[2];

    public int rollDiceSum(){
        Random dice = new Random();

        rolledTwoDice[0] = dice.nextInt(1,7);
        rolledTwoDice[1] = dice.nextInt(1,7);

        return rolledTwoDice[0] + rolledTwoDice[1];
    }

    public int getDice(int i){
        return rolledTwoDice[i];
    }
}

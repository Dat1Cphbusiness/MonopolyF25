import java.util.Random;

public class Dice {
    Random r = new Random();
    int[] savedThrows = new int [2];

    public int rollDiceSum() {
        int dice1 = r.nextInt(1, 7);
        int dice2 = r.nextInt(1, 7);
        savedThrows[0] = dice1;
        savedThrows[1] = dice1;

        return dice1 + dice2;
    }
    public int getDice(int i){
        return savedThrows[i-1];
    }
}

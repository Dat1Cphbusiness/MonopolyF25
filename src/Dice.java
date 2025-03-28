import java.util.ArrayList;
import java.util.Random;

public class Dice {
    Random random = new Random();
    int[] k = new int[2];


    public int rollDiceSum(){
        k[0] = random.nextInt(1, 7);
        k[1] = random.nextInt(1, 7);

        return k[0] + k[1];
    }

    public int getDice(int i){


        switch (i) {

            case 1:
                return k[0];

            case 2:
                return k[1];

            default:
                //ui.display("Vælg en terning der enten er 1 eller 2");
                return getDice(i);
        }

    }



}

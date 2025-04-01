import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlotTest {

    private int seriesID;
    protected boolean isMonopolized = false;


        Game game;
        Player p;
        Player p2;
        @BeforeEach
        void setUp() {
            //Arrange
            game = new Game("Matador", 6);
            game.buildBoard();
            p = new Player("Egon", 10000);
            p2 = new Player("Benny", 30000000);


        }
    @Test

    void onLand_Build() {
        //ARRANGE: få fat i Rådhuspladsen
        Plot  f = (Plot)game.board.getField(40);
        Plot  f2 = (Plot)game.board.getField(38);
        //ACT: Egon lander
        String msg = f.onLand(p);
        System.out.println(msg);

        //ASSERT: Egon får købstilbud
        assertEquals(f.getOption(), "buy");
        f.onAccept(p);

        boolean isMonopoly = f.isMonopolized(p);

    }

        @Test

        void onLand_Buy() {
            //ARRANGE: få fat i Rådhuspladsen
            Plot  f = (Plot)game.board.getField(40);

            //ACT: Egon lander
            String msg = f.onLand(p);
            System.out.println(msg);

            //ASSERT: Egon får købstilbud
            assertEquals(f.getOption(), "buy");
            f.onAccept(p);
        }

}
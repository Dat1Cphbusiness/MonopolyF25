import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Game game;
    Player player;
    Board b;
    private Field f;

    @BeforeEach
    void setUp() {
        game = new Game("testGame", 6);
        player = new Player("Egon", 10000);

        game.buildBoard();
    }

    @Test
    void getField() {

        //ARRANGE
        game.board.getField(4);
        String actual = f.toString();
        String expected = "5, Skat";

        //ACT


        //ASSERT
        assertEquals(expected,actual);

    }

}
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TokenPassTest {

    private TokenPass tp;
    private static final int MAXTOKENS = 30;

    @BeforeEach
    public void setUp() {
            // by default set up a 6 player game
        tp = new TokenPass(6);
    }

    @Test
    public void testConstructorNormal() {
        int expected = 6;
        int actual = tp.getPlayerCount();
        assertEquals(expected, tp.getPlayerCount(), "The number of players should be " + expected + ", but got " + actual);
    }

    @Test
    public void testConstructorTooLow() {
        tp = new TokenPass(2);
        int expected = 3;
        int actual = tp.getPlayerCount();
        assertEquals(expected, tp.getPlayerCount(), "The number of players should be " + expected + ", but got " + actual);
    }   

    @Test
    public void testConstructorTooHigh() {
        tp = new TokenPass(16);
        int expected = 15;
        int actual = tp.getPlayerCount();
        assertEquals(expected, tp.getPlayerCount(), "The number of players should be " + expected + ", but got " + actual);
    }     

    @Test
    public void testTokenCountInBounds() {
        // create 10 boards and check the token counts
        for (int i = 0; i < 10; i++) {
            tp = new TokenPass(7);
            assertTrue(tp.getTokenCount() >= tp.getPlayerCount(), "The number of tokens should be at least " + tp.getPlayerCount() + ", but got " + tp.getTokenCount());
            assertTrue(tp.getTokenCount() <= MAXTOKENS, "The number of tokens should be less than " + MAXTOKENS + ", but got " + tp.getTokenCount());
        }
    }

    @Test
    public void testTotalofBoardMatchesTokenCount() {
        int expected = tp.getTokenCount();
        int actual = 0;
            // loop through array and add up
        for (int val : tp.getBoardArray()) {
            actual += val;
        }
        assertEquals(expected, actual, "The number of tokens on the board should be " + expected + ", but got " + actual);
    }   

    @Test
    public void testGetWinner() {
            // play 10 times to see if the winner is accurately computed
        for (int i = 0; i < 10; i++) {
            int majority = tp.getTokenCount() / 2 + 1;
            tp.play();
            int actual = tp.getWinner();
            int expected = -1;
            for (int j = 0; j < tp.getPlayerCount(); j++) {
                if (tp.getBoardArray()[j] >= majority) {
                    expected = j;
                }
            }
            assertEquals(expected, actual, "The winner should be  " + expected + ", but got " + actual);
        }
    }  
}

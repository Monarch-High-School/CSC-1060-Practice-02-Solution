/**
 * Implements the TokenPass class, which is a simple token based game. This is the solution file.
 * @author J. Cihlar 
 * @version 1.0
 * @since 2025-01
 */

public class TokenPass {
        /** The maximum number of tokens allowed in a gamme */
    public static final int MAX_TOKENS = 30;
        /** The mininum number of players in a game */
    public static final int MIN_PLAYERS = 3; 
        /** The maximum number of players allowed in a game */
    public static final int MAX_PLAYERS = 15;

    private int [] board;
    
    private int tokenCount;

    /**
     * Constructor that sets up the board with the number of players
     * @param players The number of players. If less than MIN_PLAYERS defaults to MIN_PLAYERS 
     * and if greater than MAX_PLAYERS, defaults to MAX_PLAYERS
     */
    public TokenPass(int players) {
            // guard against out of bounds
        if (players < MIN_PLAYERS) 
            players = MIN_PLAYERS;

        if (players > MAX_PLAYERS)
            players = MAX_PLAYERS;
        
            // initialize board
        board = new int[players];

            // decide on a number of tokens
            // which is [playerCount ... MAX_TOKENS]
        tokenCount = (int)(Math.random() * (MAX_TOKENS - players + 1)) + players;
            // distribute tokens
        for (int i = 0; i < tokenCount; i++) {
            int index = (int)(Math.random() * board.length);
            board[index]++;
        }
    }
    /**
     * @return int the player count
     */
    public int getPlayerCount() {
        return board.length;
    }

    /**
     * @return int the number of tokens on the board
     */
    public int getTokenCount() {
        return tokenCount;
    }

    /**
     * @return String a String representation of the board
     */
    public String getBoard() {
        String str = "";
        for (int t : board) {
            str += "[" + t + "] ";
        }
        return str.substring(0, str.length()-1);
    }

    /**
     * @return int [] a reference to the board array
     */
    public int [] getBoardArray() {
        return board;
    }

    /**
     * Finds a winner, which is defined as having a majority of the tokens (50% + 1)
     * @return int the index of the winning player; -1 if no winner based on the current board
     */
    public int getWinner() {
        int majority = tokenCount / 2 + 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i] >= majority) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Plays the game by randomly selecting a player and redistributing
     * their chips moving backward
     */
    public void play() {
        int player = (int)(Math.random() * board.length);
        int tokensToRedistr = board[player]; // save the tokens to redistribute
        board[player] = 0; // zero out the player

        for (int i = 0; i < tokensToRedistr; i++) {
                // decrement and wrap-around if needed
            player--;
            if (player < 0) 
                player = board.length - 1;
            board[player]++;
        }
    }
}
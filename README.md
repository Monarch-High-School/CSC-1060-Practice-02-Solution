# CSC 1060 Practice 02

This example is based on FRQ 1 of the 2013 AP CSA exam; however, many of the rules have changed.

A multiplayer game called Token Pass has the following rules.
- There must be between 3 and 15 players.
- Each player begins with a random number of tokens (at least the number of players, but no more than 30) that are placed on a linear game board. There is one position on the game board for each player. After the game board has been filled, a player is randomly chosen to begin the game. Each position on the board is numbered, starting with 0.

The following rules apply for a player’s turn.
- The tokens are collected and removed from the game board at that player's position.
- The collected tokens are distributed one at a time, to each player, beginning with the next player in order of decreasing position.
- If there are still tokens to distribute after the player at the lowest position gets a token, the next token will be distributed to the player in the last position. (Wrap around)
- The distribution of tokens continues until there are no more tokens to distribute.

The Token Pass game board is represented by an array of integers. The indices of the array represent the player positions on the game board, and the corresponding values in the array represent the number of tokens that each player has. The following example illustrates one player's turn.

## Example
The following table represents a game with four players and 22 tokens. The player at position 2 was chosen to go first.

| Player | 0 | 1 | 2 | 3  |
|--------|---|---|---|----|
| Tokens | 3 | 4 | 5 | 10 |


The 5 tokens at position 2 are distributed as follows:
Token 1 goes to position 1.
Token 2 goes to position 0.
Token 3 goes to position 3. (We have to wrap around)
Token 4 goes to position 2. 
Token 5 goes to position 1.

After this round, the game board looks like the table below.
| Player | 0 | 1 | 2 | 3  |
|--------|---|---|---|----|
| Tokens | 4 | 6 | 1 | 11 |

A player wins when they earn a majority (50% + 1) of the tokens. In the case of 22 tokens, that is 12.

## Task
1. Implement the TokenPass class in the `TokenPass.java` file. Test that your class works by creating and object and testing the methods in the `TokenPassRunner.java` class.
2. Complete the REFLECTIONS.md file, part of the reflection will be to generate JavaDoc, but you do not need to add getters/setters if they exist.

## Usage Table
The following table illustrates all the methods you need to create along with their effect/return values.
## Example Data
| Code Statement | Effect / Return|
| :--- | :---  |
|`TokenPass tp = new TokenPass(5);` | Creates a TokenPass game for 5 players |
| `tp.getPlayerCount();` | `5` Returns the number of players |
| `tp.getTokenCount();` | `10` Returns the number of tokens randomly generated |
| `tp.getBoard();` | `[3] [5] [1] [1] [0]` Returns a String with the number of tokens for each position in square brackets |  
| `tp.getBoardArray();` | `{3,5,1,1,0}` Simply returns the array of ints that represents the board |
| `tp.getWinner();` | `-1` Returns the winning position based on the current board or -1 if no winner. |
| `tp.play();` | Randomly selects a player and distributes tokens per the rules. Here, assume the player at position 2 was selected.|
| `tp.getBoard()`; | `[3] [6] [0] [1] [0]` Returns a String with the number of tokens for each position in square brackets |
| `tp.getWinner();` |  `1` Returns the winning position based on the current board or -1 if no winner. |
|`tp = new TokenPass(2);` | Tries to create a TokenPass game for 2 players |
| `tp.getPlayerCount();` | `3` Returns the number of players; 2 is too low, so it defaults to 3 |
|`tp = new TokenPass(20);` | Tries to create a TokenPass game for 20 players |
| `tp.getPlayerCount();` | `15` Returns the number of players; 30 is too high, so it defaults to 15 |

## Unit Tests
There are units tests to check the constructors, player count, token count, that the token count matches the amounts on the board, and if the winner is correct. However, there is no method to verify that the `play()` method works. You will need to write code and verify in `TokenPassRunner` that it actually works.
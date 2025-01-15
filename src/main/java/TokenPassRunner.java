/**
 * This file runs the TokenPass game
 * @author
 * @version 1.0
 * @since 2025-01
 */

 public class TokenPassRunner {

    public static void main (String args[]) {
      TokenPass tp = new TokenPass(5);
      System.out.println(tp.getPlayerCount());
      System.out.println(tp.getTokenCount());
      System.out.println(tp.getBoard());
      System.out.println(tp.getWinner());

      for (int i = 0; i < 10; i++) {
         tp.play();
         System.out.println(tp.getBoard());
         System.out.println(tp.getWinner());
      }
    }
 }
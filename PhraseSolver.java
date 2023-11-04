
/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

public class PhraseSolver {
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;

  /* your code here - constructor(s) */
  public PhraseSolver() {
    this.player1 = new Player();
    this.player2 = new Player();
    this.board = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */
  public Player getPlayer(int number) {
    if (number == 0) {
      return player1;
    } else if (number == 1) {
      return player2;
    }
    return player2;
  }

  public Board getBoard() {
    return board;
  }

  public boolean getSolved() {
    return solved;
  }

  // /* your code here - mutator(s) */

  public void setSolved(boolean solved) {
    this.solved = solved;
  }

  public void play() {
    boolean solved = false;
    int curPlayerNum = 0;
    Player currentPlayer = getPlayer(curPlayerNum);

    Scanner input = new Scanner(System.in);

    boolean correct = true;
    while (!solved) {
      currentPlayer = getPlayer(curPlayerNum);
      System.out.println("Switching to player: " + currentPlayer.getName());
      System.out.println(this.board.getSolvedPhrase());
      String guess = input.nextLine().strip();
      solved = this.board.isSolved(guess);

      if (guess.length() == 1) {
        if (this.board.guessLetter(guess)) {
          System.out.println("good job!");
          currentPlayer.setPoints(currentPlayer.getPoints() + 2);
        }
      } else {
        if (this.board.isSolved(guess)) {
          System.out.println("You did it!");
        }
        currentPlayer.setPoints(currentPlayer.getPoints() + 5);
      }
      if (this.board.getSolvedPhrase().equals(guess)) {
        solved = true;
        break;
      }
      curPlayerNum = ((curPlayerNum + 1) % 2);

    }
    System.out.println(currentPlayer.getName() + " won with " + currentPlayer.getPoints() + " points!");

  }

}

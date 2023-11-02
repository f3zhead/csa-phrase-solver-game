
/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

/**
 * @author Franklin Liu
 * @author Leo Zhu
 * @version 1.0
 * @since 1.0
 **/

public class Player {
  /* your code here - attributes */
  private String name;
  private int points;

  /* your code here - constructor(s) */
  public Player() {
    System.out.print("Enter your name: ");
    Scanner in = new Scanner(System.in);
    this.name = in.nextLine();

    System.out.println("Welcome " + this.name);
    this.points = 0;

    in.close();
  }

  public Player(String inputName) {
    this.name = inputName;
    this.points = 0;

    System.out.println("Welcome " + this.name);
  }

  /* your code here - accessor(s) */
  public String getName() {
    return name;
  }

  public int getPoints() {
    return points;
  }

  /* your code here - mutator(s) */
  public void setName(String name) {
    this.name = name;
  }

  public void setPoints(int points) {
    this.points = points;
  }
}

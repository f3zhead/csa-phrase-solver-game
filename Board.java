/** 
 * @author Franklin Liu
 * @author Leo Zhu
 * @version 1.0
 * @since 1.0
 * **/

/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */

import java.util.Scanner;
import java.io.File;

public class Board {
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue;

  /* your code here - constructor(s) */
  public Board() {

    this.solvedPhrase = "";
    this.phrase = loadPhrase();
    setLetterValue();

  }

  /* your code here - accessor(s) */
  public String getSolvedPhrase() {
    return this.solvedPhrase;
  }

  public String getPhrase() {
    return phrase;
  }

  public int getCurrentLetterValue() {
    return currentLetterValue;
  }

  /* your code here - mutator(s) */
  public void setSolvedPhrase(String solvedPhrase) {
  }

  public void setPhrase(String phrase) {
  }

  public void setCurrentLetterValue(int currentLetterValue) {
  }

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue() {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess) {
    if (phrase.equals(guess)) {
      return true;
    }
    return false;
  }

  private String loadPhrase() {
    String tempPhrase = "";

    int numOfLines = 0;
    try {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine()) {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }

    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    try {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine()) {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt) {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }

    for (int i = 0; i < tempPhrase.length(); i++) {
      if (tempPhrase.substring(i, i + 1).equals(" ")) {
        solvedPhrase += "  ";
      } else {
        solvedPhrase += "_ ";
      }
    }
    return tempPhrase;
  }

  public boolean guessLetter(String guess) {
    // initialize foundLetter
    boolean foundLetter = false;
    // initialize String that represents the new solved phrase
    String newSolvedPhrase = "";

    // loop through each letter in the phrase
    for (int i = 0; i < phrase.length(); i++) {
      // letter is in phrase, add to newSolvedPhrase
      if (phrase.substring(i, i + 1).equals(guess)) {
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      } else {
        // letter is not in phrase, add underscore and space
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
      }
    }
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  }
}

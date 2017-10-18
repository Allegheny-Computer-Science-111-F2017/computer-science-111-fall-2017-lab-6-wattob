package labsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/** This class accepts user input and displays an output.
  *This program manipulates DNA using G, A, T, and C
  */

public class ManipulateDna {

  /** The user inputs DNA and an output is produced.
   * Strings have complements and sometimes undergo mutations.
   */

  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Benjamin Watto " + new Date());
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen DNA string
    String dnaString = scanner.nextLine();
    System.out.println("Okay, I am going to manipulate the DNA string, " + dnaString);
    System.out.println();
    System.out.println("Enter a string containing only C, G, T, and A: " + dnaString);

    // Step Two: Compute the complement of the DNA String
    String compDna = dnaString.replace('a','T');
    compDna = compDna.replace('t','A');
    compDna = compDna.replace('c','G');
    compDna = compDna.replace('g','C');
    System.out.println("Complement of " + dnaString + " is " + compDna);

    // Step Three: Insert a randomly chosen DNA letter into the DNA String
    String dnaLetters = "cgta";
    Random variable = new Random();
    char letter = dnaLetters.charAt(variable.nextInt(4));
    int randomInsertionIndex = variable.nextInt(dnaString.length());
    String mutation1 = dnaString.substring(0, randomInsertionIndex)
        + letter + dnaString.substring(randomInsertionIndex, dnaString.length());
    System.out.println("Inserting " + letter + " at position " 
        + randomInsertionIndex + " gives " + mutation1);
    // Step Four: Delete a DNA letter from a randomly chosen position in the DNA string
    int randomRemoveIndex = variable.nextInt(dnaString.length());
    String mutation2 = dnaString.substring(0, randomRemoveIndex);
    String mutation3 = dnaString.substring(randomRemoveIndex + 1, dnaString.length());
    System.out.println("Deleting from position " + randomRemoveIndex 
        + " gives " + mutation2 + mutation3);

    // Step Five: Change a random position in the DNA String to a randomly chosen DNA letter
    int randomInsertionIndexTwo = variable.nextInt(dnaString.length());
    String mutation4 = dnaString.substring(0, randomInsertionIndexTwo);
    String mutation5 = dnaString.substring(randomInsertionIndexTwo + 1, dnaString.length());
    System.out.println("Changing position " + randomInsertionIndexTwo + " gives " 
        + mutation4 + letter + mutation5);

    // Step Six: Display a final thank you message
    System.out.println();
    System.out.println("Thank you for using the ManipulateDNA program.");
    System.out.println("Have a great day!");

  }

}

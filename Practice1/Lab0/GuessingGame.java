package Lab0;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {

        // Create Random object to generate a number between 0 and 9
        Random random = new Random();
        int numberToGuess = random.nextInt(10);

        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Display welcome message 
        System.out.println("Welcome to the Guessing Game!");
        
        // Auto-generate a guess for demonstration
        Random guessRandom = new Random();
        int guessedNumber = guessRandom.nextInt(10);
        System.out.println("Auto-generated guess: " + guessedNumber);

        // Compare the guessed number with the generated number
        if (guessedNumber == numberToGuess) {
            System.out.println("Correct!");
        } else if (guessedNumber > numberToGuess) {
            System.out.println("Too High!");
        } else {
            System.out.println("Too Low!");
        }

        // Display the correct number
        System.out.println("The correct number is " + numberToGuess);

        // Scanner not needed in this version
    }
}

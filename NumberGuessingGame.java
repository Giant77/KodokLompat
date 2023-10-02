import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 100;
        final int MAX_ATTEMPTS = 10;
        int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ". Try to guess it.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            int userGuess = inputScanner.nextInt();
            inputScanner.nextLine(); // Consume the newline character

            if (userGuess < MIN_NUMBER || userGuess > MAX_NUMBER) {
                System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                continue;
            }

            attempts++;

            if (userGuess < secretNumber) {
                System.out.println("Too low. Try again.");
            } else if (userGuess > secretNumber) {
                System.out.println("Too high. Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the secret number " + secretNumber + " in " + attempts + " attempts.");
                break;
            }
        }

        if (attempts >= MAX_ATTEMPTS) {
            System.out.println("Sorry, you've run out of attempts. The secret number was " + secretNumber + ".");
        }

        inputScanner.close();
    }
}

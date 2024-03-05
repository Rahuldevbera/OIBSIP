import java.util.Random;
import java.util.Scanner;

public class Task2_NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int targetNumber;
        int maxAttempts = 5;
        int score = 0;
        int rounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nRound " + (rounds + 1) + " - I've selected a number between " + minRange + " and " + maxRange + ". Let's see if you can guess it.");
            
            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess < targetNumber) {
                    System.out.println("Too low! Try guessing higher.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try guessing lower.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    score += maxAttempts - attempts + 1;
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The correct number was: " + targetNumber);
                }
            }

            System.out.println("Your current score: " + score);
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing! Your final score: " + score);
        scanner.close();
    }
}

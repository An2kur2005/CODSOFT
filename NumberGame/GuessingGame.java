package com.aot.test;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRoundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Range: 1 to 100
            int attemptsLeft = 7; // Limit attempts (Requirement 5)
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI've picked a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You got it right.");
                    hasGuessedCorrectly = true;
                    totalRoundsWon++;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Attempts remaining: " + attemptsLeft);
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Game Over! You've run out of attempts.");
                System.out.println("The number was: " + targetNumber);
            }

            // Display Score (Requirement 7)
            System.out.println("Current Score (Rounds Won): " + totalRoundsWon);

            // Play Again Option (Requirement 6)
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Final Score: " + totalRoundsWon);
        scanner.close();
    }
}

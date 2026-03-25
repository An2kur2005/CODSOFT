package com.aot.test;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Input: Get the number of subjects
        System.out.print("Enter the total number of subjects: ");
        int numSubjects = input.nextInt();

        int totalMarks = 0;

        // 2. Input: Take marks with validation
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (0-100): ");
            int marks = input.nextInt();

            // Validation loop: ensures marks are between 0 and 100
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid input! Marks must be between 0 and 100.");
                System.out.print("Please re-enter marks for subject " + i + ": ");
                marks = input.nextInt();
            }
            
            totalMarks += marks;
        }

        // 3. Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // 4. Grade Calculation logic
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+ (Excellent)";
        } else if (averagePercentage >= 80) {
            grade = "A (Very Good)";
        } else if (averagePercentage >= 70) {
            grade = "B (Good)";
        } else if (averagePercentage >= 60) {
            grade = "C (Satisfactory)";
        } else if (averagePercentage >= 50) {
            grade = "D (Pass)";
        } else {
            grade = "F (Fail)";
        }

        // 5. Display Results
        System.out.println("\n--- FINAL REPORT ---");
        System.out.println("Total Marks Obtained: " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Assigned Grade: " + grade);
        

        input.close();
    }
}

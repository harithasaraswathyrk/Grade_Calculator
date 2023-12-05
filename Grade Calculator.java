import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take marks obtained in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");

        int totalSubjects;
        do {
            System.out.print("Enter the total number of subjects: ");
            totalSubjects = scanner.nextInt();
        } while (totalSubjects <= 0);

        int[] subjectMarks = new int[totalSubjects];
        for (int i = 0; i < totalSubjects; i++) {
            System.out.printf("Enter marks for Subject %d: ", i + 1);
            subjectMarks[i] = scanner.nextInt();
        }

        // Step 2: Calculate total marks
        int totalMarks = calculateTotalMarks(subjectMarks);

        // Step 3: Calculate average percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, totalSubjects);

        // Step 4: Grade calculation
        char grade = calculateGrade(averagePercentage);

        // Step 5: Display results
        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    private static int calculateTotalMarks(int[] subjectMarks) {
        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int totalSubjects) {
        return (double) totalMarks / totalSubjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'O';
        } else if (averagePercentage >= 80) {
            return 'A';
        } else if (averagePercentage >= 70) {
            return 'B';
        } else if (averagePercentage >= 60) {
            return 'C';
        } else {
            return 'U';
        }
    }

    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("\nResults:");
        System.out.printf("Total Marks: %d\n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.printf("Grade: %c\n", grade);
    }
}

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void updateProfile(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class MCQs {
    private String[] questions;
    private String[][] options;
    private char[] answers;

    public MCQs(String[] questions, String[][] options, char[] answers) {
        this.questions = questions;
        this.options = options;
        this.answers = answers;
    }

    public void displayQuestions() {
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((char) ('A' + j) + ") " + options[i][j]);
            }
        }
    }

    public boolean checkAnswers(char[] selectedAnswers) {
        for (int i = 0; i < selectedAnswers.length; i++) {
            if (selectedAnswers[i] != answers[i]) {
                return false;
            }
        }
        return true;
    }
}

public class Task4_OnlineExaminationSystem {
    static Timer timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        User user = new User("admin", "password");

        if (!user.authenticate(username, password)) {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        // Update Profile and Password
        System.out.println("Enter new username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();
        user.updateProfile(newUsername, newPassword);
        System.out.println("Profile updated successfully.");

        // Selecting answers for MCQs
        String[] questions = {"Q1. What is 5+5?", "Q2. What is the capital of India?"};
        String[][] options = {{"15", "10", "18"}, {"Kolkata", "Bengaluru", "New Delhi"}};
        char[] answers = {'B', 'C'};
        MCQs mcqs = new MCQs(questions, options, answers);

        System.out.println("Select answers for the following questions (A/B/C):");
        mcqs.displayQuestions();
        char[] selectedAnswers = new char[questions.length];
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Enter your answer for question " + (i + 1) + ":");
            selectedAnswers[i] = scanner.nextLine().toUpperCase().charAt(0);
        }

         // Check answers
         if (mcqs.checkAnswers(selectedAnswers)) {
            System.out.println("Congratulations! All answers are correct.");
        } else {
            System.out.println("Some answers are incorrect.");
        }

        // Timer and auto submit
        int examDurationMinutes = 2; // Change the duration as needed
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Submitting answers automatically...");
                if (mcqs.checkAnswers(selectedAnswers)) {
                    System.out.println("Congratulations! All answers are correct.");
                } else {
                    System.out.println("Some answers are incorrect.");
                }
                timer.cancel();
            }
        }, examDurationMinutes * 60 * 1000);

        // Closing session and Logout
        System.out.println("Closing session and logging out...");
    }
}

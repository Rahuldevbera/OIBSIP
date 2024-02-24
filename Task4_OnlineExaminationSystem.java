import java.util.Scanner;

public class Task4_OnlineExaminationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            System.out.println("Welcome to the Online Examination System");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    currentUser = login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (currentUser != null) {
                while (true) {
                    System.out.println("\nWelcome, " + currentUser.getUsername());
                    System.out.println("1. Update Profile and Password");
                    System.out.println("2. Start Exam");
                    System.out.println("3. Logout");
                    System.out.print("Enter your choice: ");
                    int userChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (userChoice) {
                        case 1:
                            updateProfile(scanner, currentUser);
                            break;
                        case 2:
                            startExam(scanner, currentUser);
                            break;
                        case 3:
                            currentUser = null;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    if (userChoice == 3 || currentUser == null) {
                        break; // Go back to the main menu
                    }
                }
            }
        }
    }

    private static User login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Validate username and password (check against a database or hardcoded credentials)
        // If valid, return a User object, otherwise return null
        // Implement this part according to your needs
        return new User(username);
    }

    private static void register(Scanner scanner) {
        // Implement user registration functionality
    }

    private static void updateProfile(Scanner scanner, User user) {
        // Implement profile and password update functionality
    }

    private static void startExam(Scanner scanner, User user) {
        // Implement exam functionality (selecting answers for MCQs, timer, auto submit, etc.)
    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    // Other user-related methods and fields can be added here
}

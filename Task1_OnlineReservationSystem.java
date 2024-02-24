import java.util.Scanner;

public class Task1_OnlineReservationSystem {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Reservation System");

        // Login
        boolean isLoggedIn = login(scanner);
        if (!isLoggedIn) {
            System.out.println("Login failed. Exiting...");
            return;
        }

        // Reservation System
        System.out.println("Welcome to the Reservation System");
        makeReservation(scanner);

        // Cancellation Form
        System.out.println("\nWelcome to the Cancellation Form");
        cancelReservation(scanner);

        // Close scanner
        scanner.close();
    }

    // Method to handle login
    private static boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // Method to make a reservation
    private static void makeReservation(Scanner scanner) {
        System.out.println("Reservation Form:");

        // Collecting reservation details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter train number: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        // Assuming train name is fetched from a database based on train number
        String trainName = fetchTrainName(trainNumber);
        System.out.println("Train Name: " + trainName);

        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();

        System.out.print("Enter date of journey (YYYY-MM-DD): ");
        String dateOfJourney = scanner.nextLine();

        System.out.print("Enter departure place: ");
        String departurePlace = scanner.nextLine();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        // Processing reservation
        System.out.println("\nProcessing Reservation...");
        System.out.println("Reservation Successful!");
        System.out.println("Name: " + name);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("From: " + departurePlace);
        System.out.println("To: " + destination);
    }

    // Method to fetch train name from database (dummy implementation)
    private static String fetchTrainName(int trainNumber) {
        // Dummy implementation, replace with actual database query
        return "Dummy Train";
    }

    // Method to cancel a reservation
    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter PNR number to cancel the reservation: ");
        String pnrNumber = scanner.nextLine();

        // Fetching reservation details based on PNR number (dummy implementation)
        String reservationDetails = fetchReservationDetails(pnrNumber);

        if (reservationDetails != null) {
            System.out.println("\nReservation details for PNR " + pnrNumber + ":");
            System.out.println(reservationDetails);

            // Prompt for confirmation
            System.out.print("Do you want to cancel this reservation? (Enter 'OK' to confirm): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("OK")) {
                // Perform cancellation (dummy implementation)
                System.out.println("Reservation with PNR " + pnrNumber + " has been cancelled.");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("No reservation found with PNR " + pnrNumber);
        }
    }

    // Method to fetch reservation details from database (dummy implementation)
    private static String fetchReservationDetails(String pnrNumber) {
        // Dummy implementation, replace with actual database query
        return "Dummy Reservation Details";
    }
}

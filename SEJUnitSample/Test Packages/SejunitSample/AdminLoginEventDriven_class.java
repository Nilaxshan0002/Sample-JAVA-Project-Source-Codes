import java.util.Scanner; // Import Scanner to read user input from the console

public class AdminLoginEventDriven_class {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for user input
        boolean exit = false; // Flag to control the menu loop

        // Keep showing the menu until the user decides to exit
        while (!exit) {
            // Display menu options
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // Clear leftover newline from input buffer
            // React based on user selection
            switch (choice) {
                case 1:
                    // Call method to handle admin login
                    handleAdminLogin(scanner);
                    break;
                case 2:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        scanner.close(); // Close scanner to free resources
    }

    // Method to perform the admin login process
    public static void handleAdminLogin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String user = scanner.nextLine(); // Read username

        System.out.print("Enter admin password: ");
        String pass = scanner.nextLine(); // Read password

        // Check if credentials match the updated admin credentials
        if (user.equals("adminCity01") && pass.equals("City@2025")) {
            System.out.println("Login Successful!"); // Correct credentials
        } else {
            System.out.println("Invalid login. Please try again."); // Incorrect credentials
        }
    }
}

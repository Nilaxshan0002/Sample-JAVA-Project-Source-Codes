import java.util.Scanner; // Import Scanner to read user input from the console

public class AdminLoginEventDriven {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize Scanner for input
        boolean exit = false; // Flag to control when to exit the menu loop

        // Loop continuously until user decides to exit
        while (!exit) {
            // Show menu options to the user
            System.out.println("1. Admin Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Read the menu choice (integer)
            scanner.nextLine(); // Clear newline from input buffer

            // Decide action based on user's choice
            switch (choice) {
                case 1:
                    // User wants to login as admin
                    handleAdminLogin(scanner);
                    break;
                case 2:
                    // User wants to exit the application
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    // Handle invalid menu input
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        scanner.close(); // Release scanner resource before program ends
    }

    // Method to perform admin login process
    public static void handleAdminLogin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String user = scanner.nextLine(); // Read username from user input

        System.out.print("Enter admin password: ");
        String pass = scanner.nextLine(); // Read password from user input

        // Validate the credentials against the new fixed values
        if (user.equals("cityadmin") && pass.equals("city@123")) {
            System.out.println("Login Successful!"); // Correct credentials
        } else {
            System.out.println("Invalid login."); // Credentials do not match
        }
    }
}


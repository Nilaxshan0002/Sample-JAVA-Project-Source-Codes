import java.util.Scanner; // Import Scanner class for getting user input

public class AdminLoginEventDriven {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for input
        boolean exit = false; // A flag to control the loop for menu interaction

        // Event-driven loop - waits for user to choose an option
        
while(!exit) {
            // Displaying the menu options
            System.out.println("1. Admin Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Read user choice (1 or 2)
            scanner.nextLine(); // Consume the leftover newline character

            // Switch-case to handle different user actions
            
switch(choice) {
                case 1:
                    // If user selects 1, proceed with login
                    handleAdminLogin(scanner);
                    break;
                case 2:
                    // If user selects 2, set exit flag to true to break the loop
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    // If input is invalid, show an error message
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        scanner.close(); // Close the scanner to free resources
    }

    // This method handles the admin login process
    public static void handleAdminLogin(Scanner scanner) {
        System.out.print("Enter admin username: ");
        String user = scanner.nextLine(); // Read the username

        System.out.print("Enter admin password: ");
        String pass = scanner.nextLine(); // Read the password

        // Check if entered credentials match the hardcoded values
       
 if(user.equals("admin") && pass.equals("admin123")) {
            System.out.println("Login Successful!"); // If correct, show success message
        } 

else {
            System.out.println("Invalid login."); // If incorrect, show error
        }
    }
}

import java.util.Scanner;

/**
 * Customer class for City Electronics located in Galle, Sri Lanka.
 * Handles secure login for customers with a limit on login attempts.
 * This allows customers to access their accounts and place orders.
 */
public class Customer {

    // Sample customer credentials for demonstration
    // In a real system, this would connect to a database or customer registry
    private static final String SAMPLE_USERNAME = "john123";     // Example username
    private static final String SAMPLE_PASSWORD = "abc@123";     // Example password

    // Maximum allowed login attempts to enhance security and prevent brute force
    private static final int MAX_ATTEMPTS = 3;

    /**
     * Method to authenticate a customer login.
     * Customer has up to 3 attempts to provide correct username and password.
     *
     * @param scanner Scanner object to capture input from the console
     * @return true if login is successful within allowed attempts, false otherwise
     */
    public boolean login(Scanner scanner) {
        int attempts = 0; // Track number of login attempts

        // Allow customer up to MAX_ATTEMPTS to enter valid credentials
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine().trim();   // Read customer username input

            System.out.print("Enter your password: ");
            String password = scanner.nextLine().trim();   // Read customer password input

            // Verify credentials match the sample credentials
            if (username.equals(SAMPLE_USERNAME) && password.equals(SAMPLE_PASSWORD)) {
                System.out.println(" Login successful. Welcome, " + username + "!");
                return true;    // Successful login grants access to customer functionalities
            } else {
                attempts++;    // Increment failed login attempt count
                System.out.println(" Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        // All login attempts failed - deny access
        System.out.println(" Too many failed attempts. Please try again later.");
        return false;
    }

    /**
     * Main method to demonstrate the login functionality for City Electronics customers.
     * This is a simple console test example.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        System.out.println("----- City Electronics Customer Login -----");
        System.out.println("For demo, use the following credentials:");
        System.out.println("Username: john123");
        System.out.println("Password: abc@123");

        // Start the customer login process
        customer.login(scanner);

        scanner.close();
    }
}

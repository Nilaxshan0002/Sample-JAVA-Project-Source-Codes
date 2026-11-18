import java.util.Scanner;

/**
 * Customer_Class handles customer authentication for City Electronics in Galle, Sri Lanka.
 * It ensures only authorized customers can access their accounts and place orders.
 */
public class Customer_class {

    // Customer credentials for demonstration
    private static final String SAMPLE_USERNAME = "michaelC2025";  // Updated username
    private static final String SAMPLE_PASSWORD = "Hello@789";     // Updated password

    // Maximum allowed login attempts to prevent brute-force access
    private static final int MAX_ATTEMPTS = 3;

    /**
     * Authenticates a customer login.
     * The customer has up to 3 attempts to enter correct username and password.
     *
     * @param scanner Scanner object to capture input from console
     * @return true if login succeeds within allowed attempts, false otherwise
     */
    public boolean login(Scanner scanner) {
        int attempts = 0;  // Track login attempts

        // Loop until login succeeds or max attempts reached
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine().trim();

            // Validate credentials
            if (username.equals(SAMPLE_USERNAME) && password.equals(SAMPLE_PASSWORD)) {
                System.out.println(" Login successful. Welcome, " + username + "!");
                return true;
            } else {
                attempts++;
                System.out.println(" Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        // Deny access after maximum failed attempts
        System.out.println(" Too many failed login attempts. Please try again later.");
        return false;
    }

    /**
     * Main method to test customer login functionality.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer_class customer = new Customer_class();

        System.out.println("----- City Electronics Customer Login -----");
        System.out.println("For demo, use the following credentials:");
        System.out.println("Username: michaelC2025");
        System.out.println("Password: Hello@789");

        // Start login process
        customer.login(scanner);

        scanner.close();
    }
}

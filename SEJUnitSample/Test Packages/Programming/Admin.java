import java.util.Scanner;

/**
 * Admin class for City Electronics located in Galle, Sri Lanka.
 * This class handles the secure login process for administrators,
 * allowing only authorized personnel to manage the electronics store system.
 */
public class Admin {

    // Predefined administrator credentials for City Electronics system
    private static final String ADMIN_USERNAME = "admin";        // Admin username (fixed for this scenario)
    private static final String ADMIN_PASSWORD = "admin123";     // Admin password (fixed for this scenario)

    // Maximum number of allowed login attempts to prevent unauthorized access
    private static final int MAX_ATTEMPTS = 3;

    /**
     * Method to perform admin login authentication.
     * The admin has up to 3 attempts to enter correct username and password.
     *
     * @param scanner Scanner object used to capture admin input from the console
     * @return true if login succeeds within allowed attempts; false if login fails after maximum tries
     */
    public boolean login(Scanner scanner) {
        int attempts = 0;  // Track how many login attempts have been made

        // Loop until admin enters correct credentials or exceeds max attempts
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter admin username for City Electronics: ");
            String username = scanner.nextLine().trim();  // Read admin username input

            System.out.print("Enter admin password: ");
            String password = scanner.nextLine().trim();  // Read admin password input

            // Validate entered credentials against predefined admin credentials
            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                System.out.println(" Login successful. Welcome to City Electronics Admin Panel!");
                return true;  // Successful login, allow access to admin functions
            } else {
                attempts++;  // Increment failed attempt count
                System.out.println(" Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        // Admin failed to login after maximum allowed attempts
        System.out.println(" Maximum login attempts reached. Access denied for City Electronics Admin Panel.");
        return false;  // Deny access due to failed login attempts
    }
}

import java.util.Scanner;

/**
 * Admin_Class handles administrator authentication for City Electronics in Galle, Sri Lanka.
 * Only authorized users can access administrative functions of the store system.
 */
public class Admin_class {

    // Administrator credentials for City Electronics system
    private static final String ADMIN_USERNAME = "adminCity01";  // Updated admin username
    private static final String ADMIN_PASSWORD = "City@2025";    // Updated admin password

    // Maximum allowed login attempts to prevent unauthorized access
    private static final int MAX_ATTEMPTS = 3;

    /**
     * Authenticates the admin user.
     * The admin has up to 3 attempts to enter the correct username and password.
     *
     * @param scanner Scanner object to capture input from console
     * @return true if login succeeds within allowed attempts, false otherwise
     */
    public boolean login(Scanner scanner) {
        int attempts = 0;  // Track login attempts

        // Loop until login succeeds or maximum attempts are reached
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter admin username for City Electronics: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter admin password: ");
            String password = scanner.nextLine().trim();

            // Check credentials
            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                System.out.println(" Login successful. Welcome to City Electronics Admin Panel!");
                return true;
            } else {
                attempts++;
                System.out.println(" Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        // Deny access after maximum failed attempts
        System.out.println(" Maximum login attempts reached. Access denied to City Electronics Admin Panel.");
        return false;
    }

    // Example usage for testing
    public static void main(String[] args) {
        Admin_class admin = new Admin_class();
        Scanner scanner = new Scanner(System.in);

        if (admin.login(scanner)) {
            System.out.println("Access granted to admin functions.");
        } else {
            System.out.println("Exiting system due to failed login.");
        }

        scanner.close();
    }
}

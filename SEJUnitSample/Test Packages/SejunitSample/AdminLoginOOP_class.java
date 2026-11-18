import java.util.Scanner; // Import Scanner to read input from the user

// Admin class stores the correct credentials and checks login attempts
class Admin {
    // Fixed username and password for the admin
    private final String username = "adminCity01";
    private final String password = "City@2025";

    // Method to verify if the entered username and password match the stored ones
    public boolean login(String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }
}

// Main program class that handles user input and login process
public class AdminLoginOOP_class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read input
        Admin admin = new Admin(); // Create an Admin object to verify login

        System.out.print("Enter admin username: "); // Prompt user for username
        String user = scanner.nextLine(); // Read the entered username

        System.out.print("Enter admin password: "); // Prompt user for password
        String pass = scanner.nextLine(); // Read the entered password

        // Check if the entered credentials are correct
        if (admin.login(user, pass)) {
            System.out.println("Login Successful!"); // Login successful
        } else {
            System.out.println("Invalid login. Please try again."); // Login failed
        }

        scanner.close(); // Close the scanner to free resources
    }
}

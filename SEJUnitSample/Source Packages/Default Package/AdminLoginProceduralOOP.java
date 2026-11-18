import java.util.Scanner; // Import Scanner to get input from the user

// Admin class holds the fixed username and password and checks login credentials
class Admin {
    // Store the correct username and password internally
    private final String username = "cityadmin";
    private final String password = "city@123";

    // Method to check if provided credentials match the stored ones
    public boolean login(String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }
}

// Main class to interact with the user and handle the login process
public class AdminLoginProceduralOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner for input
        Admin admin = new Admin(); // Create an Admin object to verify credentials

        System.out.print("Enter admin username: "); // Ask for username
        String user = scanner.nextLine(); // Read username from user

        System.out.print("Enter admin password: "); // Ask for password
        String pass = scanner.nextLine(); // Read password from user

        // Validate credentials using Admin's login method
        if (admin.login(user, pass)) {
            System.out.println("Login Successful!"); // Correct login
        } else {
            System.out.println("Invalid login."); // Incorrect login
        }

        scanner.close(); // Close the scanner resource
    }
}

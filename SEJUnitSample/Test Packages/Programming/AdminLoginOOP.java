import java.util.Scanner; // Import Scanner class to allow user input

// Define the Admin class to encapsulate login credentials and behavior
class Admin {
    // Private fields store the valid username and password
    private final String username = "admin";
    private final String password = "admin123";

    // Public method to validate login by comparing input with stored credentials
    public boolean login(String user, String pass) {
        // Returns true if both username and password match
        return user.equals(username) && pass.equals(password);
    }
}

// Main class that handles user interaction and initiates the login process
public class AdminLoginOOP {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        // Create an object (instance) of the Admin class
        Admin admin = new Admin();

        // Prompt and read the admin username
        System.out.println("Enter admin username:");
        String user = scanner.nextLine();

        // Prompt and read the admin password
        System.out.println("Enter admin password:");
        String pass = scanner.nextLine();

        // Use the login method of Admin class to validate credentials
        if(admin.login(user, pass)) {
            // If login is successful
            System.out.println("Login Successful!");
        }
 else {
            // If login fails
            System.out.println("Invalid login.");
        }
        // Close the Scanner to avoid resource leaks
        scanner.close();
    }
}

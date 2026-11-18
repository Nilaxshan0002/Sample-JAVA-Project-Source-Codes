import java.util.Scanner; // Import Scanner class to read input from the user

public class AdminLoginProcedural {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the admin username
        System.out.println("Enter admin username:");
        String user = scanner.nextLine(); // Read the entered username

        // Prompt the user to enter the admin password
        System.out.println("Enter admin password:");
        String pass = scanner.nextLine(); // Read the entered password

        // Check if both username and password are correct
        if(user.equals("admin") && pass.equals("admin123")) {
            // If both match, display a success message
            System.out.println("Login Successful!");
        } 
else {
            // If either username or password is incorrect, show an error message
            System.out.println("Invalid login.");
        }

        // Close the Scanner object to prevent resource leaks
        scanner.close();
    }
}

package Programming;

import java.util.Scanner;

public class AdminLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create Scanner object to read input from user

        // Prompt the user to enter the admin username
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();  // Read username input as a string

        // Prompt the user to enter the admin password
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();  // Read password input as a string

        // Check if the username and password are correct
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login Successful");  // Print success message if credentials match
        } else {
            System.out.println("Invalid login. Please try again.");  // Print error message if credentials don't match
        }

        scanner.close();  // Close the Scanner resource
    }
}

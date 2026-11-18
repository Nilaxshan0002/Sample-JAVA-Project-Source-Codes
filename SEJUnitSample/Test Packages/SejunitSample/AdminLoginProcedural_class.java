import java.util.Scanner; // Scanner class is used to get user input

public class AdminLoginProcedural_class {
    public static void main(String[] args) {
        // Create a Scanner to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Ask for admin username
        System.out.print("Enter admin username: ");
        String user = scanner.nextLine(); // Store the entered username

        // Ask for admin password
        System.out.print("Enter admin password: ");
        String pass = scanner.nextLine(); // Store the entered password

        // Check if username and password match the correct values
        if (user.equals("adminCity01") && pass.equals("City@2025")) {
            System.out.println("Login Successful!"); // Correct credentials
        } else {
            System.out.println("Invalid login."); // Wrong credentials
        }

        // Close the scanner
        scanner.close();
    }
}


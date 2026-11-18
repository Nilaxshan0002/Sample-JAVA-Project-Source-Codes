
import java.util.Scanner;


public class quiz_1 {
    public void validateLogin(String userName, String password){
        String ogUser = "Simar";
        String ogPass = "simar123";
        
        if(ogUser.equals(userName) && ogPass.equals(password)){
            System.out.println("\nValid Login");
        }
        else{
            System.out.println("\nInvalid Login");
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter Your Username: ");
        String userName = scan.nextLine();
        
        System.out.print("\nEnter Your Password: ");
        String password = scan.nextLine();
        
        quiz mk = new quiz();
        mk.validateLogin(userName, password);
    }
}

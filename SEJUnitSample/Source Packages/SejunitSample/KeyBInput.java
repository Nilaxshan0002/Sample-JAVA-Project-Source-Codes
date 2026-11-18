
import java.util.Scanner;


public class KeyBInput {
    public static void main(String[] args) {
        
        //ctrl + shift + I
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number 01: ");
        int n1 = scan.nextInt();
        
        System.out.print("Enter Number 02: ");
        int n2 = scan.nextInt();
        
        int total = n1 + n2;
        
        System.out.println("Total Of Entered Numbers: " + total);
        
    }
}


import java.util.Scanner;


public class SelectionDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int marks = scan.nextInt();
        
        if (marks > 50){
            System.out.println("Pass");
            System.out.println("Congrats");
        }
        else{
            System.out.println("Fail");
            System.out.println("Try Again");
        }
    }
}

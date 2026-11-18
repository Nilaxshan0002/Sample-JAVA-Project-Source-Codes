
import java.util.Scanner;


public class SelectionDemo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Your Marks: ");
        int marks = scan.nextInt();
        
        if(marks >= 80)
            System.out.println("Distiction");
        else if (marks >= 70)
            System.out.println("Merit");
        else if (marks >= 60)
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }
}

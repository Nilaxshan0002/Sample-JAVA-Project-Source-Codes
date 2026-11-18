
import java.util.Scanner;


public class SelectionDemo1 {
       public static void main(String[] args) {
        
           Scanner scan = new Scanner(System.in);
           
           float salesAmt = scan.nextFloat();
           float bonus = 0.0f;
           
           if(salesAmt >= 500000)
               bonus = salesAmt * 0.05f;
           
           System.out.println("Your Bonus Amount: " + bonus);
           
    }
}

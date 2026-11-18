
import java.util.Scanner;

public class SelectionDemo4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter The Hours You Worked: ");
        float hoursWork = scan.nextFloat();
        
        System.out.print("Enter Your Hour Rate      : ");
        float hourRate = scan.nextFloat();
        
        float grossWage = hoursWork * hourRate;
        float texAmount;
            
        if(grossWage > 30000){
            texAmount = grossWage * (12.5f/100);
        }
        else if (grossWage > 20000){
            texAmount = grossWage * (10.3f/100);
        }
        else if (grossWage > 15000){
            texAmount = grossWage * (8.7f/100);
        }
        else{
            texAmount = grossWage * (5.6f/100);
        }
        
        float netWage = grossWage - texAmount;
        System.out.println("\nGross Wage: " + grossWage);
        System.out.println("Tex Amount: " + texAmount);
        System.out.println("Net Wage  : " + netWage);
    }
}

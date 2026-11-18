
import java.util.Scanner;


public class MethodDemo2 {
    //add 3 numbers
    public void addNumbers(float a, float b, float c){
        float total = a + b + c;
        System.out.println("Total: " + total);
    }
    
    //avarage of 3 numbers
    public float avgNumbers(float a, float b, float c){
        float avg = (a + b + c)/3f;
        return avg;
    }
    
    public static void main(String[] args) {
        MethodDemo2 md = new MethodDemo2();
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter 3 Numbers: ");
        float a1 = scan.nextFloat();
        float b1 = scan.nextFloat();
        float c1 = scan.nextFloat();
        
        md.addNumbers(a1, b1, c1);
        float f = md.avgNumbers(a1, b1, c1);
        System.out.println("Avarege of 3 Numbers: " + f);
    }
}

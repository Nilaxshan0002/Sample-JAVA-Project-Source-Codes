import java.util.Scanner;

class F_to_C {
    
    public float fc (float fahrenheit){
        float celsius = (fahrenheit - 32f) * (5f/9f);
        return celsius;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter The Fahrenheit Value: ");
        float fahrenheit = scan.nextFloat();
        
        F_to_C ar = new F_to_C();
        float celsius = ar.fc(fahrenheit);
        
        System.out.println("\nCelsius value of your Fahrenheit value: " + celsius);
    }
}
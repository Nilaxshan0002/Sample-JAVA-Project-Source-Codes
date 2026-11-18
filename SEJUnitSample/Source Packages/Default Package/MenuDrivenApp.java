import java.util.Scanner;

public class MenuDrivenApp {

    Scanner scan = new Scanner(System.in);

    public void showMenu() {
        System.out.println("***************************");
        System.out.println("Welcome to com-Operation");
        System.out.println("MAIN MENU");
        System.out.println("1. Add Numbers");
        System.out.println("2. Find Average");
        System.out.println("3. Area Circle");
        System.out.println("4. Convert F to C");
        System.out.println("5. Exit");

        System.out.print("\nEnter Choice: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                addNumbers();
               
            case 2:
                findAverage();
                
            case 3:
                areaCircle();
                
            case 4:
                convertFtoC();
                
            case 5:
                System.out.println("Thank you ..");
                System.exit(0);
         
            default:
                System.out.println("Invalid Option, try again");
        }

        showMenu();
    }

    public void addNumbers() {
        System.out.println("ADD NUMBERS");
        System.out.println("************");
        System.out.print("Enter first number: ");
        int num1 = scan.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scan.nextInt();
        int tot = num1 + num2;
        System.out.println("Total " + tot);
        showMenu();

    }
    
    public void findAverage() {
        int tot,count,avg;
        System.out.println("FIND AVERAGE");
        System.out.println("*************");
        System.out.print("Enter the total: ");
        tot = scan.nextInt(); 
        System.out.print("Enter the count: ");
        count = scan.nextInt(); 
        avg = tot/count;
        System.out.println(" Average " + avg);
        showMenu();
    }

    public void areaCircle() {
        System.out.println("AREA CIRCLE");
        System.out.println("************");
        System.out.print("Enter Radius: ");
        float radius = scan.nextFloat();
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle " + area);
        showMenu();
    }

    public void convertFtoC() {
        System.out.println("CONVERT F TO C");
        System.out.println("******************");
        System.out.print("Enter temperature in Fahrenheit: ");
        int fahrenheit = scan.nextInt();
        int celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("Temperature in Celsius " + celsius);
        showMenu();
    }

    public static void main(String[] args) {
        MenuDrivenApp md = new MenuDrivenApp();
        md.showMenu();
    }
}

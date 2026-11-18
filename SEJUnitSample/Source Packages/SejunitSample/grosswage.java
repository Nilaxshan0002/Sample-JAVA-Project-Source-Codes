import java.util.Scanner;

public class grosswage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter hours worked: ");
        double hoursWorked = scanner.nextDouble();
        
        System.out.print("Enter hourly rate: ");
        double hourlyRate = scanner.nextDouble();
        
       
        double grossWage = hoursWorked * hourlyRate;
        
       
        System.out.println("Gross Wage: $" + grossWage);
        
        scanner.close();
    }
}

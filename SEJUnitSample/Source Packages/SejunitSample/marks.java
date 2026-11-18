import java.util.Scanner;

public class marks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter marks for Science: ");
        double sci = scanner.nextDouble();
        
        System.out.print("Enter marks for Math: ");
        double mat = scanner.nextDouble();
        
        System.out.print("Enter marks for English: ");
        double eng = scanner.nextDouble();
        
        System.out.print("Enter marks for ICT: ");
        double ict = scanner.nextDouble();
        
        System.out.print("Enter marks for Language: ");
        double lang = scanner.nextDouble();
        
        
        double aggregate = sci + mat + eng + ict + lang;
        double average = aggregate / 5;
        
        
        System.out.println("Total Aggregate Marks: " + aggregate);
        System.out.println("Average Marks: " + average);
        
        scanner.close();
    }
}
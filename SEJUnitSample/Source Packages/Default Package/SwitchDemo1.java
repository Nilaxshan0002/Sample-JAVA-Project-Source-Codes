import java.util.Scanner;

public class SwitchDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number from 1 - 4: ");
        int season = scan.nextInt();

        switch (season) {
            case 1:
                System.out.println("Spring");
                break;
            case 2:
                System.out.println("Summer");
                break;
            case 3:
                System.out.println("Autumn");
                break;
            case 4:
                System.out.println("Winter");
                break;
            default:
                System.out.println("Invalid");
                break;
        }

        scan.close();
    }
}

import java.util.Scanner;

class AreaCircle {
    
    public float area (float radius){
        float area = radius * radius * (22f/7f);
        return area;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter radius of The Circle: ");
        float radius = scan.nextFloat();
        
        AreaCircle ar = new AreaCircle();
        float ara = ar.area(radius);
        
        System.out.println("\nArea Of the Circle: " + ara);
    }
}
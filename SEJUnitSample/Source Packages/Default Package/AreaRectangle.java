import java.util.Scanner;

class AreaRectangle {
    
    public float area (float length, float width){
        float area = length * width;
        return area;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter lenght of The Rectangle: ");
        float len = scan.nextFloat();
        
        System.out.print("\nEnter width of The Rectangle: ");
        float wid = scan.nextFloat();
        
        AreaRectangle ar = new AreaRectangle();
        float ara = ar.area(len, wid);
        System.out.println("\nArea Of the Rectangle: " + ara);
    }
}
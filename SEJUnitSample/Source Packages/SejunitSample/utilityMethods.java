
public class utilityMethods {
    
    public static void areaOfRectangle(double length, double width) {
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }

    public static double areaOfCircle(double radius) {
        return Math.PI * radius * radius;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void totalOfArray(int[] array) {
        int total = 0;
        for (int num : array) {
            total += num;
        }
        System.out.println("Total of array: " + total);
    }

    public static void displayReversedMessage(String message) {
        StringBuilder reversed = new StringBuilder(message).reverse();
        System.out.println("Reversed Message: " + reversed);
    }

    public static void main(String[] args) {
        areaOfRectangle(5, 3); // Rectangle area

        double circleArea = areaOfCircle(4);
        System.out.println("Area of Circle: " + circleArea);

        double celsius = fahrenheitToCelsius(98.6);
        System.out.println("Celsius: " + celsius);

        int[] numbers = {10, 20, 30, 40};
        totalOfArray(numbers); // Array total

        displayReversedMessage("Hello World!");
    }
}

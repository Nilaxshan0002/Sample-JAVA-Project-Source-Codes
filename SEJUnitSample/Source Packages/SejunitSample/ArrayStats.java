public class ArrayStats {
    public static void main(String[] args) {
        int[] numbers = {5, 8, 2, 14, 6, 3};

        int total = 0;
        int max = numbers[0];
        int min = numbers[0];

        for (int number : numbers) {
            total += number;
            if (number > max) max = number;
            if (number < min) min = number;
        }

        System.out.println("Total: " + total);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}

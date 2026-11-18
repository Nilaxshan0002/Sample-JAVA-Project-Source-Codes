public class MultiplicationTable {
    public static void main(String[] args) {
        int size = 6; // table size (1 to 6)

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println();
        }
    }
}


public class LoopTask1 {
    public static void main(String[] args) {
        for(int i = 1; i < 7; i++){
            for(int j = 1; j < 7; j++){
                System.out.print(j*i + " ");
            }
            System.out.print("\n");
        }
        
        System.out.println("\n");
        
        for(int l = 1; l < 7; l++){
            for(int m = 1; m <= l; m++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

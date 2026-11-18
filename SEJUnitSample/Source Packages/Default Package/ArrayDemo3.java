
public class ArrayDemo3 {
    public static void main(String[] args) {
        int[] numbers  = {30,10,50,60,90,20};
        
        int max = numbers[0];
        int min = numbers[0];
        for(int j = 0; j < 6; j++){
            if(max < numbers[j]){
                max = numbers[j];
            }
            if(min > numbers[j]){
                min = numbers[j];
            }
        }
        System.out.println("Max Array: " + max);
        System.out.println("Min Array: " + min);
    }
}

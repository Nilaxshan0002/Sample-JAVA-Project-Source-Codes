
public class ArrayDemo1 {
    public static void main(String[] args) {
        //creating the array
        int[] numbers  = {30,10,50,60,90,20};
        
        //access an item/element
        System.out.println(numbers[2]);//3rd
        System.out.println(numbers[5]);//6th
        
        int add = numbers[0] + numbers[3];
        System.out.println("Sum of element 1st and 3rd: " + add);
        
        int tot = 0;
        for(int i = 0; i < 6; i++){
            tot = tot + numbers[i];
        }
        System.out.println("Total Of Array: " + tot);
    }
}

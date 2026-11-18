import java.util.Scanner;

class printReverse{
    public void reverse(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String txt = scan.nextLine();
        
        for(int i = txt.length() - 1; i >= 0; i--){
            char value = txt.charAt(i);
            System.out.print(value);
        }
    }
    
    public static void main(String[] args) {
        printReverse mn = new printReverse();
        mn.reverse();
    }
}
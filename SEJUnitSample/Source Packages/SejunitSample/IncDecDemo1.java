
public class IncDecDemo1 {
    public static void main(String[] args) {
        
        int x = 10;
        System.out.println("X: " + x);
        
        x++; // x = x + 1
        System.out.println("Now X: " + x);
        
        int a = 11;
        int b = 10;
        
        boolean ans1 = a-- == b; // a-- will work after boolean part. so 'a' will be 11
        boolean ans2 = a == b; // afret first boolean work 'a' will become 10. so here 'a' will be 10 and this boolean wil be 'true'
        System.out.println("Ans: " + ans1);
        System.out.println("Ans: " + ans2);
        
    }
}

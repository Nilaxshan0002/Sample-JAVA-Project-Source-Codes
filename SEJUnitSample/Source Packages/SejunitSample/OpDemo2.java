
public class OpDemo2 {
    public static void main(String[] args) {
      
        int a = 10;
        int b = 20;
        int c = 30;
        
        // >
        boolean greater = a>b;
        System.out.println("Greater Then: " + greater);
        
        // <
        boolean less = a<b;
        System.out.println("Less Then: " + less);
        
        // AND Logic
        boolean and = (a < b) && (b > c);
        System.out.println("AND Logic: " + and);
        
        // OR Logic
        boolean or = (a > b) || (b < c);
        System.out.println("OR Logic: " + or);
        
        // OR NOT
        boolean not1 = (a > b);
        boolean not2= !(a > b);
        System.out.println("NOT Logic With out !: " + not1);
        System.out.println("NOT Logic With !: " + not2);

        
    }
}

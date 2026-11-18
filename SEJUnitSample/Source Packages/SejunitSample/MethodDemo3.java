
public class MethodDemo3 {
    public void methodA(){
        System.out.println("Starting A()");
        methodB();
        System.out.println("Finishing A()");
    }
    
    public void methodB(){
        System.out.println("Starting B()");
        methodC();
        System.out.println("Finishing B()");
    }
    
    public void methodC(){
        System.out.println("Starting C()");
        System.out.println("Finishing C()");
    }
    
    public static void main(String[] args) {
        MethodDemo3 md = new MethodDemo3();
        md.methodA();
    }
}

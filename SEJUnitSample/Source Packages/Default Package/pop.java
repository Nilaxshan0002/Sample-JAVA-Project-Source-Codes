import java.util.ArrayList;

public class pop {
    public static void main(String[] args) {
        ArrayList<String> parts = new ArrayList<>();
        parts.add("Engine");
        parts.add("Gearbox");
        parts.add("Brakes");

        String removed = parts.remove(parts.size() - 1);
        System.out.println("Popped Part: " + removed);
        System.out.println("After popping: " + parts);
    }
}

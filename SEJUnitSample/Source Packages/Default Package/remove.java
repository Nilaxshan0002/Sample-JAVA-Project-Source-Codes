import java.util.ArrayList;

public class remove {
    public static void main(String[] args) {
        ArrayList<String> parts = new ArrayList<>();
        parts.add("Engine");
        parts.add("Gearbox");
        parts.add("Brakes");

        parts.remove("Gearbox");
        System.out.println("After removing Gearbox: " + parts);
    }
}

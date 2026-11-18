import java.util.ArrayList;

public class change {
    public static void main(String[] args) {
        ArrayList<String> parts = new ArrayList<>();
        parts.add("Engine");
        parts.add("Brakes");

        for (int i = 0; i < parts.size(); i++) {
            parts.set(i, "Modified");
        }

        System.out.println("After changing all: " + parts);
    }
}

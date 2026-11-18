import java.util.ArrayList;

public class edit {
    public static void main(String[] args) {
        ArrayList<String> parts = new ArrayList<>();
        parts.add("Engine");
        parts.add("Brakes");

        int index = parts.indexOf("Brakes");
        if (index != -1) {
            parts.set(index, "Disk Brakes");
        }

        System.out.println("After editing: " + parts);
    }
}

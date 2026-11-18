import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> parts = new ArrayList<>();

        parts.add("Engine");
        parts.add("Gearbox");
        parts.add("Brakes");
        parts.add("Suspension");
        System.out.println("After adding parts: " + parts);

        parts.remove("Gearbox");
        System.out.println("After removing 'Gearbox': " + parts);

        String popped = parts.remove(parts.size() - 1);
        System.out.println("After popping last part (" + popped + "): " + parts);

        int index = parts.indexOf("Brakes");
        if (index != -1) {
            parts.set(index, "Disk Brakes");
        }
        System.out.println("After editing 'Brakes' to 'Disk Brakes': " + parts);

        for (int i = 0; i < parts.size(); i++) {
            parts.set(i, "Modified");
        }
        System.out.println("After changing all parts to 'Modified': " + parts);
    }
}

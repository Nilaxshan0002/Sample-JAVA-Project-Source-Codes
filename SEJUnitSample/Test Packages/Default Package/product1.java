// product1.java

// This class represents an electronic product in the City Electronics system.
public class product1 {

    // Static counter to automatically generate unique product IDs
    private static int idCounter = 1000;

    // Instance variables to store product details
    private int id;              // Unique product ID
    private String name;         // Name of the electronic item (e.g., "LG Refrigerator")
    private double price;        // Price in LKR
    private int quantity;        // Number of units in stock

    // Constructor for auto-generated product ID
    public product1(String name, double price, int quantity) {
        this.id = idCounter++;   // Auto-increment ID
        setName(name);           // Validate and set name
        setPrice(price);         // Validate and set price
        setQuantity(quantity);   // Validate and set quantity
    }

    // Overloaded constructor allowing manual ID entry
    public product1(int id, String name, double price, int quantity) {
        this.id = id;            // Manually set ID
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    // Getters and setters with validation
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    // Checks if product is in stock
    public boolean isInStock() {
        return quantity > 0;
    }

    // Display format for product details
    @Override
    public String toString() {
        return String.format("ID: %d | %s | LKR %.2f | Quantity: %d %s",
                id, name, price, quantity, (isInStock() ? "(In Stock)" : "(Out of Stock)"));
    }

    // Sample usage for City Electronics
    public static void main(String[] args) {

        // Creating 5 updated electronic products for City Electronics
        product1 p1 = new product1("LG 260L Double Door Refrigerator", 162000.00, 6);
        product1 p2 = new product1("Dell Inspiron 15 Laptop", 198500.00, 4);
        product1 p3 = new product1("Xiaomi Redmi Note 12 Pro", 88500.00, 15);
        product1 p4 = new product1("Panasonic Microwave Oven", 45999.00, 0);  // Out of stock
        product1 p5 = new product1("Samsung Galaxy Tab A9+", 115999.50, 9);

        // Display the updated product catalog
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
    }
}

// Product.java

// This class represents an electronic product in the City Electronics system.
public class Product {

    // Static counter to automatically generate unique product IDs
    private static int idCounter = 1000;

    // Instance variables to store product details
    private int id;              // Unique product ID
    private String name;         // Name of the electronic item (e.g., "Samsung TV")
    private double price;        // Price in LKR
    private int quantity;        // Number of units in stock

    // Constructor for auto-generated product ID (used by admin)
    public Product(String name, double price, int quantity) {
        this.id = idCounter++;   // Auto-increment ID
        setName(name);           // Validate and set name
        setPrice(price);         // Validate and set price
        setQuantity(quantity);   // Validate and set quantity
    }

    // Overloaded constructor allowing manual ID entry (if needed)
    public Product(int id, String name, double price, int quantity) {
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

    // -------------------------------
    // Example usage for City Electronics
    // -------------------------------
    public static void main(String[] args) {

        // Creating 5 sample electronic products sold at City Electronics
        Product p1 = new Product("Samsung 43\" Smart TV", 145000.00, 10);
        Product p2 = new Product("Apple iPhone 14", 365000.00, 5);
        Product p3 = new Product("HP Pavilion Laptop", 235000.00, 8);
        Product p4 = new Product("Sony Bluetooth Speaker", 22500.00, 0);  // Out of stock
        Product p5 = new Product("Canon PIXMA Printer", 38999.99, 4);

        // Display the products in the system (Admin view or Customer browsing)
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
    }
}

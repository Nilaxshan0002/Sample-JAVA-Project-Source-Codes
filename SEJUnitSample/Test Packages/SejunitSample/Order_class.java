import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Order_Class represents a customer's order at City Electronics in Galle, Sri Lanka.
 * Manages ordered products, calculates totals, and tracks metadata
 * such as a unique order ID and order timestamp.
 */
public class Order_class {

    // List to hold products included in this order
    private ArrayList<Product_class> orderItems;

    // Total cost of all items in the order
    private double total;

    // Unique identifier for each order
    private final String orderId;

    // Timestamp capturing the date and time when the order was created
    private final String orderTimestamp;

    /**
     * Constructor initializes an empty order with:
     * - Unique order ID via UUID
     * - Current timestamp
     */
    public Order_class() {
        this.orderItems = new ArrayList<>();
        this.total = 0;
        this.orderId = UUID.randomUUID().toString();
        this.orderTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * Adds a product to the order with a specified quantity.
     * Updates the total order cost.
     *
     * @param product  The product selected by the customer
     * @param quantity Number of units ordered
     */
    public void addItem(Product_class product, int quantity) {
        if (quantity <= 0) {
            System.out.println(" Invalid quantity. Please enter a positive number.");
            return;
        }

        // Create a new instance representing the quantity ordered
        Product_class orderedItem = new Product_class(product.getName(), product.getPrice(), quantity);

        // Add item to order list
        orderItems.add(orderedItem);

        // Update cumulative total
        total += calculateItemTotal(product.getPrice(), quantity);
    }

    /**
     * Helper method to calculate total for a product line
     *
     * @param price    Unit price
     * @param quantity Number of units
     * @return Total cost for that item
     */
    private double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }

    /**
     * Displays a summary of the order:
     * - Order ID
     * - Timestamp
     * - Product list with quantities and line totals
     * - Total payable amount
     */
    public void displayOrder() {
        System.out.println("===== CITY ELECTRONICS ORDER SUMMARY =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Time: " + orderTimestamp);
        System.out.println("------------------------------------------");

        for (Product_class item : orderItems) {
            double itemTotal = calculateItemTotal(item.getPrice(), item.getQuantity());
            System.out.println(item.getName() + " x" + item.getQuantity()
                    + " = LKR " + String.format("%.2f", itemTotal));
        }

        System.out.println("------------------------------------------");
        System.out.println("Total Amount Payable: LKR " + String.format("%.2f", total));
        System.out.println("==========================================\n");
    }

    // Getters
    public double getTotal() {
        return total;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderTimestamp() {
        return orderTimestamp;
    }
}

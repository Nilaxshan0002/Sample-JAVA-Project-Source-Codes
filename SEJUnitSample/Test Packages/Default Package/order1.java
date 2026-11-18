import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Order class representing a customer's order at City Electronics in Galle, Sri Lanka.
 * This class manages the ordered products, calculates totals, and tracks order metadata
 * such as a unique order ID and the timestamp of when the order was placed.
 */
public class order1 {

    // List to hold all products included in this order
    private ArrayList<product1> orderItems;

    // Total cost of all items in the order
    private double total;

    // Unique identifier assigned to each order for tracking purposes
    private final String orderId;

    // Timestamp capturing the exact date and time when the order was created
    private final String orderTimestamp;

    /**
     * Constructor initializes an empty order with:
     * - A unique order ID generated via UUID
     * - Current date and time as order timestamp
     */
    public order1() {
        this.orderItems = new ArrayList<>();
        this.total = 0;
        this.orderId = UUID.randomUUID().toString();  // Unique order ID generation
        this.orderTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());  // Order time stamp
    }

    /**
     * Adds a product to the customer's order with a specific quantity.
     * Ensures that the quantity is positive before adding.
     * Updates the total order cost accordingly.
     *
     * @param product  The electronic device/product selected by the customer
     * @param quantity The number of units ordered for this product
     */
    public void addItem(product1 product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity. Please enter a positive number.");
            return;  // Reject invalid quantities to maintain order integrity
        }

        // Create a new product1 instance reflecting the quantity ordered
        product1 orderedItem = new product1(product.getName(), product.getPrice(), quantity);

        // Add this item to the order list
        orderItems.add(orderedItem);

        // Update the cumulative total cost of the order
        total += calculateItemTotal(product.getPrice(), quantity);
    }

    /**
     * Helper method to compute total price for a given product line (unit price * quantity).
     *
     * @param price    Unit price of the product
     * @param quantity Number of units ordered
     * @return Total cost for that line item
     */
    private double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }

    /**
     * Displays a comprehensive summary of the order placed by the customer.
     * Includes:
     * - Unique Order ID
     * - Order timestamp
     * - List of products with quantities and line totals
     * - Overall total payment amount
     */
    public void displayOrder() {
        System.out.println("===== CITY ELECTRONICS ORDER SUMMARY =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Time: " + orderTimestamp);
        System.out.println("------------------------------------------");

        for (product1 item : orderItems) {
            double itemTotal = calculateItemTotal(item.getPrice(), item.getQuantity());
            System.out.println(item.getName() + " x" + item.getQuantity()
                    + " = LKR " + String.format("%.2f", itemTotal));
        }

        System.out.println("------------------------------------------");
        System.out.println("Total Amount Payable: LKR " + String.format("%.2f", total));
        System.out.println("==========================================\n");
    }

    /**
     * Getter for the total cost of the order.
     * @return Total amount payable for this order
     */
    public double getTotal() {
        return total;
    }

    /**
     * Getter for the unique order ID.
     * @return The order's unique identifier
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Getter for the order timestamp.
     * @return Date and time when the order was placed
     */
    public String getOrderTimestamp() {
        return orderTimestamp;
    }
}

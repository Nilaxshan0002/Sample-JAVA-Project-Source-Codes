// Import ArrayList class to manage dynamic list of electronics
import java.util.ArrayList;

/**
 * ProductManager class manages the inventory of electronic products
 * for City Electronics in Galle, Sri Lanka.
 */
public class ProductManager {

    // Stores the list of all products available in City Electronics
    private ArrayList<Product> productList = new ArrayList<>();

    /**
     * Adds a new electronic item to City Electronics’ catalog.
     * Ensures price and quantity are valid.
     */
    public void addProduct(Product product) {
        if (product.getPrice() < 0 || product.getQuantity() < 0) {
            System.out.println("️ Error: Product price and quantity must be non-negative.");
            return;
        }
        productList.add(product);
        System.out.println(" Product successfully added to City Electronics: " + product.getName());
    }

    /**
     * Displays all electronic products available in City Electronics' inventory.
     */
    public void viewProducts() {
        if (productList.isEmpty()) {
            System.out.println(" No products available in City Electronics.");
        } else {
            System.out.println(" List of Available Electronic Devices at City Electronics:");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println((i + 1) + ". " + productList.get(i));
            }
        }
    }

    /**
     * Updates the price of a specific product.
     * Useful for price adjustments due to market fluctuations.
     */
    public void updateProductPrice(int index, double newPrice) {
        if (index < 0 || index >= productList.size()) {
            System.out.println(" Error: Invalid product index.");
            return;
        }
        if (newPrice < 0) {
            System.out.println(" Error: Price cannot be negative.");
            return;
        }
        productList.get(index).setPrice(newPrice);
        System.out.println(" Price updated for: " + productList.get(index).getName());
    }

    /**
     * Updates stock quantity when new units arrive or after sales.
     */
    public void updateProductQuantity(int index, int newQuantity) {
        if (index < 0 || index >= productList.size()) {
            System.out.println(" Error: Invalid product index.");
            return;
        }
        if (newQuantity < 0) {
            System.out.println(" Error: Quantity cannot be negative.");
            return;
        }
        productList.get(index).setQuantity(newQuantity);
        System.out.println(" Quantity updated for: " + productList.get(index).getName());
    }

    /**
     * Removes a product from the store's catalog.
     * Useful when a product is discontinued.
     */
    public void deleteProduct(int index) {
        if (index < 0 || index >= productList.size()) {
            System.out.println(" Error: Invalid product index.");
            return;
        }
        String removed = productList.get(index).getName();
        productList.remove(index);
        System.out.println("️ Removed product from City Electronics: " + removed);
    }

    /**
     * Searches for a product in City Electronics by name.
     */
    public void searchProductByName(String name) {
        boolean found = false;
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(" Product found: " + product);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" No product found in City Electronics by the name: " + name);
        }
    }

    /**
     * Calculates the total value of inventory at City Electronics (Galle).
     */
    public void calculateInventoryValue() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println(" Total inventory value for City Electronics (Galle): LKR " + total);
    }

    /**
     * Returns the product list. Can be used by other modules like billing or reporting.
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
}

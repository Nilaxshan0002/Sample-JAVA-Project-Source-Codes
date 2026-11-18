import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class to run the City Electronics Console Management System
 * Located in Galle, Sri Lanka, City Electronics aims to streamline product
 * management and customer ordering through this console-based application.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ProductManager pm = new ProductManager();   // Manages product catalog for City Electronics
        Admin admin = new Admin();                   // Admin user instance for store management
        Customer customer = new Customer();          // Customer user instance for shopping
        
        boolean exit = false;  // Controls the main application loop
        
        // Main program loop offering login choices and exit option
        while (!exit) {
            System.out.println("\n--- Welcome to City Electronics (Galle, Sri Lanka) ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = getIntInput(scanner);  // Safely read menu option as integer
            
            switch (choice) {
                case 1:
                    // Admin login workflow
                    if (admin.login(scanner)) {
                        System.out.println(" Admin Login Successful!");
                        adminMenu(scanner, pm);  // Show admin functions: product management
                    } else {
                        System.out.println(" Access denied. Invalid admin credentials.");
                    }
                    break;
                    
                case 2:
                    // Customer login workflow
                    if (customer.login(scanner)) {
                        System.out.println(" Customer Login Successful!");
                        customerMenu(scanner, pm);  // Show customer functions: browse & order
                    } else {
                        System.out.println(" Access denied. Invalid customer credentials.");
                    }
                    break;
                    
                case 3:
                    // Exit application gracefully
                    exit = true;
                    System.out.println("Thank you for visiting City Electronics!");
                    break;
                    
                default:
                    System.out.println("️ Invalid option. Please try again.");
            }
        }
        
        scanner.close();  // Close scanner resource before program ends
    }
    
    /**
     * Admin menu for managing products in the City Electronics inventory.
     * Allows adding, viewing, updating prices, and deleting products.
     * @param scanner Scanner object for user input
     * @param pm ProductManager instance managing the store's products
     */
    private static void adminMenu(Scanner scanner, ProductManager pm) {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n--- City Electronics Admin Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product Price");
            System.out.println("4. Delete Product");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            
            int choice = getIntInput(scanner);
            
            switch (choice) {
                case 1:
                    // Add a new product to the inventory
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("️ Product name cannot be empty.");
                        break;
                    }
                    
                    System.out.print("Enter product price (LKR): ");
                    double price = getDoubleInput(scanner);
                    if (price < 0) {
                        System.out.println("️ Price cannot be negative.");
                        break;
                    }
                    
                    System.out.print("Enter product quantity: ");
                    int qty = getIntInput(scanner);
                    if (qty < 0) {
                        System.out.println("️ Quantity cannot be negative.");
                        break;
                    }
                    
                    pm.addProduct(new Product(name, price, qty));  // Add product to product manager
                    System.out.println(" Product added successfully.");
                    break;
                    
                case 2:
                    // Display all products in inventory
                    pm.viewProducts();
                    break;
                    
                case 3:
                    // Update price of an existing product
                    if (pm.getProductList().isEmpty()) {
                        System.out.println("️ No products available to update.");
                        break;
                    }
                    pm.viewProducts();
                    
                    System.out.print("Enter product number to update price: ");
                    int idx = getIntInput(scanner) - 1;  // Convert to zero-based index
                    
                    if (!isValidProductIndex(idx, pm)) break;
                    
                    System.out.print("Enter new price (LKR): ");
                    double newPrice = getDoubleInput(scanner);
                    if (newPrice < 0) {
                        System.out.println("️ Price cannot be negative.");
                        break;
                    }
                    
                    pm.updateProductPrice(idx, newPrice);
                    System.out.println(" Product price updated.");
                    break;
                    
                case 4:
                    // Remove a product from the inventory
                    if (pm.getProductList().isEmpty()) {
                        System.out.println("️ No products available to delete.");
                        break;
                    }
                    pm.viewProducts();
                    
                    System.out.print("Enter product number to delete: ");
                    int delIdx = getIntInput(scanner) - 1;
                    
                    if (!isValidProductIndex(delIdx, pm)) break;
                    
                    pm.deleteProduct(delIdx);
                    System.out.println(" Product deleted.");
                    break;
                    
                case 5:
                    // Return to main menu
                    back = true;
                    break;
                    
                default:
                    System.out.println("️ Invalid option. Please try again.");
            }
        }
    }
    
    /**
     * Customer menu to browse products and place orders at City Electronics.
     * Supports viewing products, adding items to an order, viewing the order,
     * and finalizing the order.
     * @param scanner Scanner object for user input
     * @param pm ProductManager instance managing available products
     */
    private static void customerMenu(Scanner scanner, ProductManager pm) {
        boolean back = false;
        Order order = new Order();  // Create new order for this customer session
        
        while (!back) {
            System.out.println("\n--- City Electronics Customer Menu ---");
            System.out.println("1. Browse Products");
            System.out.println("2. Add Product to Order");
            System.out.println("3. View Current Order");
            System.out.println("4. Finalize Order");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            
            int choice = getIntInput(scanner);
            
            switch (choice) {
                case 1:
                    // Display available products for purchase
                    pm.viewProducts();
                    break;
                    
                case 2:
                    // Add a product to the customer's current order
                    if (pm.getProductList().isEmpty()) {
                        System.out.println("️ No products available to order.");
                        break;
                    }
                    pm.viewProducts();
                    
                    System.out.print("Select product number to order: ");
                    int pIdx = getIntInput(scanner) - 1;
                    
                    if (!isValidProductIndex(pIdx, pm)) break;
                    
                    Product selected = pm.getProductList().get(pIdx);
                    
                    System.out.print("Enter quantity to order: ");
                    int qty = getIntInput(scanner);
                    
                    if (qty <= 0) {
                        System.out.println("️ Quantity must be greater than zero.");
                        break;
                    }
                    
                    if (qty > selected.getQuantity()) {
                        System.out.println("️ Insufficient stock. Available quantity: " + selected.getQuantity());
                        break;
                    }
                    
                    // Add item to order and update product stock
                    order.addItem(selected, qty);
                    selected.setQuantity(selected.getQuantity() - qty);
                    
                    System.out.println(" " + qty + " x " + selected.getName() + " added to your order.");
                    break;
                    
                case 3:
                    // Show summary of current order with totals
                    order.displayOrder();
                    break;
                    
                case 4:
                    // Finalize the order if it contains items
                    if (order.getTotal() == 0) {
                        System.out.println("️ Your order is empty. Add items before finalizing.");
                        break;
                    }
                    
                    order.displayOrder();
                    
                    System.out.print("Confirm order? (yes/no): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();
                    
                    if (confirm.equals("yes") || confirm.equals("y")) {
                        System.out.println(" Thank you! Your order has been placed.");
                        order = new Order();  // Reset order for new session
                    } else {
                        System.out.println("️ Order not placed. You can continue modifying your order.");
                    }
                    break;
                    
                case 5:
                    // Return to main menu
                    back = true;
                    break;
                    
                default:
                    System.out.println("️ Invalid option. Please try again.");
            }
        }
    }
    
    /**
     * Utility method to safely read an integer from the user.
     * Prompts repeatedly until a valid integer is entered.
     * @param scanner Scanner object for input
     * @return Validated integer input from user
     */
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();  // Consume leftover newline character
                return input;
            } catch (InputMismatchException e) {
                System.out.print("️ Invalid input. Please enter a valid integer: ");
                scanner.nextLine();  // Clear invalid input buffer
            }
        }
    }
    
    /**
     * Utility method to safely read a double (decimal number) from the user.
     * Prompts repeatedly until a valid number is entered.
     * @param scanner Scanner object for input
     * @return Validated double input from user
     */
    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine();  // Consume leftover newline character
                return input;
            } catch (InputMismatchException e) {
                System.out.print("️ Invalid input. Please enter a valid number: ");
                scanner.nextLine();  // Clear invalid input buffer
            }
        }
    }
    
    /**
     * Validates if the given product index exists within the product list.
     * Prints an error message if invalid.
     * @param index Zero-based index to validate
     * @param pm ProductManager containing the product list
     * @return true if index is valid, false otherwise
     */
    private static boolean isValidProductIndex(int index, ProductManager pm) {
        if (index < 0 || index >= pm.getProductList().size()) {
            System.out.println("️ Invalid product selection. Please try again.");
            return false;
        }
        return true;
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        productmanager1 pm = new productmanager1();  // fixed class name
        admin1 admin = new admin1();                  // as you provided
        customer1 customer = new customer1();         // as you provided

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Welcome to City Electronics (Galle, Sri Lanka) ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    if (admin.login(scanner)) {
                        System.out.println(" Admin Login Successful!");
                        adminMenu(scanner, pm);
                    } else {
                        System.out.println(" Access denied. Invalid admin credentials.");
                    }
                    break;

                case 2:
                    if (customer.login(scanner)) {
                        System.out.println(" Customer Login Successful!");
                        customerMenu(scanner, pm);
                    } else {
                        System.out.println(" Access denied. Invalid customer credentials.");
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("Thank you for visiting City Electronics!");
                    break;

                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void adminMenu(Scanner scanner, productmanager1 pm) {
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
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println(" Product name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter product price (LKR): ");
                    double price = getDoubleInput(scanner);
                    if (price < 0) {
                        System.out.println(" Price cannot be negative.");
                        break;
                    }

                    System.out.print("Enter product quantity: ");
                    int qty = getIntInput(scanner);
                    if (qty < 0) {
                        System.out.println(" Quantity cannot be negative.");
                        break;
                    }

                    pm.addProduct(new product1(name, price, qty));
                    System.out.println(" Product added successfully.");
                    break;

                case 2:
                    pm.viewProducts();
                    break;

                case 3:
                    if (pm.getProductList().isEmpty()) {
                        System.out.println(" No products available to update.");
                        break;
                    }

                    pm.viewProducts();
                    System.out.print("Enter product number to update price: ");
                    int idx = getIntInput(scanner) - 1;

                    if (!isValidProductIndex(idx, pm)) break;

                    System.out.print("Enter new price (LKR): ");
                    double newPrice = getDoubleInput(scanner);
                    if (newPrice < 0) {
                        System.out.println(" Price cannot be negative.");
                        break;
                    }

                    pm.updateProductPrice(idx, newPrice);
                    System.out.println(" Product price updated.");
                    break;

                case 4:
                    if (pm.getProductList().isEmpty()) {
                        System.out.println(" No products available to delete.");
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
                    back = true;
                    break;

                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }

    private static void customerMenu(Scanner scanner, productmanager1 pm) {
        boolean back = false;
        order1 order = new order1();   // fixed class name

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
                    pm.viewProducts();
                    break;

                case 2:
                    if (pm.getProductList().isEmpty()) {
                        System.out.println(" No products available to order.");
                        break;
                    }

                    pm.viewProducts();
                    System.out.print("Select product number to order: ");
                    int pIdx = getIntInput(scanner) - 1;

                    if (!isValidProductIndex(pIdx, pm)) break;

                    product1 selected = pm.getProductList().get(pIdx);

                    System.out.print("Enter quantity to order: ");
                    int qty = getIntInput(scanner);

                    if (qty <= 0) {
                        System.out.println(" Quantity must be greater than zero.");
                        break;
                    }

                    if (qty > selected.getQuantity()) {
                        System.out.println(" Insufficient stock. Available: " + selected.getQuantity());
                        break;
                    }

                    order.addItem(selected, qty);
                    selected.setQuantity(selected.getQuantity() - qty);
                    System.out.println(" " + qty + " x " + selected.getName() + " added to your order.");
                    break;

                case 3:
                    order.displayOrder();
                    break;

                case 4:
                    if (order.getTotal() == 0) {
                        System.out.println(" Your order is empty. Add items first.");
                        break;
                    }

                    order.displayOrder();

                    System.out.print("Confirm order? (yes/no): ");
                    String confirm = scanner.nextLine().trim().toLowerCase();

                    if (confirm.equals("yes") || confirm.equals("y")) {
                        System.out.println(" Thank you! Your order has been placed.");
                        order = new order1(); // Reset order
                    } else {
                        System.out.println(" Order not placed.");
                    }
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // clear newline
                return input;
            } catch (InputMismatchException e) {
                System.out.print(" Invalid input. Enter a valid number: ");
                scanner.nextLine();
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine(); // clear newline
                return input;
            } catch (InputMismatchException e) {
                System.out.print(" Invalid input. Enter a valid price: ");
                scanner.nextLine();
            }
        }
    }

    private static boolean isValidProductIndex(int index, productmanager1 pm) {
        if (index < 0 || index >= pm.getProductList().size()) {
            System.out.println(" Invalid product selection.");
            return false;
        }
        return true;
    }
}

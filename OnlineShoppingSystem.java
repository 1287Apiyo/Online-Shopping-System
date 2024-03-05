import java.util.*;
public class OnlineShoppingSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static List<Item> catalog = new ArrayList<>();

    public static void main(String[] args) {
        // Adding sample items to the catalog
        catalog.add(new Item("Laptop", 1000, "Electronics"));
        catalog.add(new Item("Shoes", 50, "Fashion"));
        catalog.add(new Item("Book", 20, "Books"));

        boolean running = true;
        while (running) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void register() {
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter contact info:");
        String contactInfo = scanner.next();
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        System.out.println("Select user type (1. Customer 2. Premium Customer 3. Administrator):");
        int userTypeChoice = scanner.nextInt();
        switch (userTypeChoice) {
            case 1:
                users.add(new Customer(name, contactInfo, username, password));
                break;
            case 2:
                System.out.println("Enter discount percentage:");
                double discountPercentage = scanner.nextDouble();
                users.add(new PremiumCustomer(name, contactInfo, username, password, discountPercentage));
                break;
            case 3:
                users.add(new Administrator(name, contactInfo, username, password, scanner));
                break;
            default:
                System.out.println("Invalid choice");
        }
        System.out.println("User registered successfully!");
    }

    static void login() {
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        boolean loggedIn = false;
        User user = null;
        for (User u : users) {
            if (u.authenticateUser(username, password)) {
                loggedIn = true;
                user = u;
                break;
            }
        }
        if (!loggedIn) {
            System.out.println("Invalid username or password");
            return;
        }
//polymorhism -user  object is treated polymorphically-depending on its actual type
        if (user instanceof Customer) {
            // Customer actions
            System.out.println("Customer logged in");
            showCatalog();
            performCustomerActions((Customer) user);
        } else if (user instanceof PremiumCustomer) {
            // Premium customer actions
            System.out.println("Premium Customer logged in");
            showCatalog();
            performCustomerActions((PremiumCustomer) user);
        } else if (user instanceof Administrator) {
            // Administrator actions
            System.out.println("Administrator logged in");
            ((Administrator) user).manageItems();
        }
    }

    static void showCatalog() {
        System.out.println("Catalog:");
        for (Item item : catalog) {
            item.displayItemDetails();
        }
    }
//overloading is used in the performCustomerActions method. This method is overloaded to accept both Customer and
// PremiumCustomer objects as parameters.
    static void performCustomerActions(Customer customer) {
        System.out.println("Enter the name of the item you want to purchase:");
        String itemName = scanner.next();
        for (Item item : catalog) {
            if (item.name.equalsIgnoreCase(itemName)) {
                customer.addToCart(item);
                System.out.println("Item added to cart.");
                return;
            }
        }
        System.out.println("Item not found in catalog.");
    }

    static void performCustomerActions(PremiumCustomer premiumCustomer) {
        System.out.println("Enter the name of the item you want to purchase:");
        String itemName = scanner.next();
        for (Item item : catalog) {
            if (item.name.equalsIgnoreCase(itemName)) {
                premiumCustomer.addToCart(item);
                System.out.println("Item added to cart.");
                premiumCustomer.viewExclusiveDeals();
                return;
            }
        }
        System.out.println("Item not found in catalog.");
    }
}
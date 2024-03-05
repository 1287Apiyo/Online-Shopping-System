import java.util.Scanner;

class Administrator extends User {
    Scanner scanner;

    public Administrator(String name, String contactInfo, String username, String password, Scanner scanner) {
        super(name, contactInfo, username, password);
        this.scanner = scanner;
    }

    public void manageItems() {
        boolean running = true;
        while (running) {
            System.out.println("Administrator Actions:");
            System.out.println("1. Add item\n2. Update item\n3. Remove item\n4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    updateItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addItem() {
        System.out.println("Enter item name:");
        String name = scanner.next();
        System.out.println("Enter item price:");
        double price = scanner.nextDouble();
        System.out.println("Enter item category:");
        String category = scanner.next();
        // Add the item to the catalog or database
        System.out.println("Item added: " + name);
    }

    private void updateItem() {
        System.out.println("Enter item name to update:");
        String name = scanner.next();
        // Search for the item in the catalog or database
        // Update the item's details if found
        System.out.println("Item updated: " + name);
    }

    private void removeItem() {
        System.out.println("Enter item name to remove:");
        String name = scanner.next();
        // Search for the item in the catalog or database
        // Remove the item if found
        System.out.println("Item removed: " + name);
    }
}

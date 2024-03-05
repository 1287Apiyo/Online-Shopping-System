


class PremiumCustomer extends Customer {
    double discountPercentage;

    public PremiumCustomer(String name, String contactInfo, String username, String password, double discountPercentage) {
        super(name, contactInfo, username, password);
        this.discountPercentage = discountPercentage;
    }
//in this class the purchase method
// overrides the same method defined in its superclass Customer
    @Override
    public void purchase() {
        // Override purchase method to incorporate discount calculations
        double totalAmount = 0;
        for (Item item : shoppingCart) {
            totalAmount += item.price;
        }
        double discountedAmount = totalAmount * (1 - discountPercentage / 100);
        System.out.println("Purchase Successful! Total Amount: $" + discountedAmount);
    }

    public void applyDiscount() {
        // Logic for applying discounts
    }

    public void viewExclusiveDeals() {
        // Logic to display exclusive deals for premium customers
        System.out.println("Exclusive deals for Premium Customers:");
        // Example:
        System.out.println("1. Special Discount on Electronics");
        System.out.println("2. Buy One Get One Free on Fashion Items");
    }
}

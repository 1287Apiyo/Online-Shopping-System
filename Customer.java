import java.util.ArrayList;
import java.util.List;

class Customer extends User {
    List<Item> shoppingCart;

    public Customer(String name, String contactInfo, String username, String password) {
        super(name, contactInfo, username, password);
        shoppingCart = new ArrayList<>();
    }

    public void addToCart(Item item) {
        shoppingCart.add(item);
    }

    public void viewCart() {
        for (Item item : shoppingCart) {
            item.displayItemDetails();
        }
    }

    public void purchase() {
        // Logic for purchase
        System.out.println("Purchase Successful!");
    }
}
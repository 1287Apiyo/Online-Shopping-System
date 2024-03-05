// Item class representing a generic item available for purchase
class Item {
    //encapsulation-They are encapsulated within the class, and access to these variables is controlled
    String name;
    double price;
    String category;

    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void displayItemDetails() {
        System.out.println("Name: " + name + ", Price: $" + price + ", Category: " + category);
    }
}
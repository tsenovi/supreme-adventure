package restaurant.model;

public class OrderItem {

    private final Item item;
    private final int quantity;
    private final double price;

    public OrderItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.price = calculatePrice(item, quantity);
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    private double calculatePrice(Item item, int quantity) {
        return item.getPrice() * quantity;
    }
}

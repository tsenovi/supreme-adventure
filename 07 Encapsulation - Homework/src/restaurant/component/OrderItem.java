package restaurant.component;

public class OrderItem {

    private Item item;
    private int quantity;
    private double price;

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    private double calculatePrice(Item item, int quantity) {
        return item.getPrice() * quantity;
    }
}

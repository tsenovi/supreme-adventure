package restaurant.model;

public class Item implements Comparable<Item> {

    private final String name;
    private final double price;
    private final ItemType type;

    public Item(String name, double price, ItemType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ItemType getType() {
        return type;
    }

    @Override
    public int compareTo(Item o) {
        return this.getType().compareTo(o.getType());
    }
}

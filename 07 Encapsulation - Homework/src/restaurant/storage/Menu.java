package restaurant.storage;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Item> items;

    public Menu() {
        this.items = new ArrayList<>();
        addInitialMenuItems();
    }

    public StringBuilder getItemsSortedByType() {
        StringBuilder sb = new StringBuilder();
        ItemType comparator = ItemType.DISH;
        sb.append(comparator).append(": ");
        sortItems(sb, comparator);

        comparator = ItemType.DRINK;
        sb.append("\n").append(comparator).append(": ");
        sortItems(sb, comparator);

        return sb;
    }

    private void sortItems(StringBuilder sb, ItemType comparator) {
        for (Item item : items) {
            if (item.getType().equals(comparator)) {
                sb.append(item.getName()).append(", ");
            }
        }
    }

    public boolean createItem(String name, double price, ItemType type) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return false;
            }
        }

        Item item = new Item(name, price, type);
        addItemToMenu(item);
        return true;
    }

    public boolean removeItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                removeItemFromMenu(item);
                return true;
            }
        }

        return false;
    }

    private void addItemToMenu(Item item) {
        this.items.add(item);
    }

    private void removeItemFromMenu(Item item) {
        this.items.remove(item);
    }

    private void addInitialMenuItems() {
        addItemToMenu(new Item("Coffee", 2.50, ItemType.DRINK));
        addItemToMenu(new Item("Water", 1.50, ItemType.DRINK));
        addItemToMenu(new Item("Toast", 3.0, ItemType.DISH));
        addItemToMenu(new Item("Burrito", 4.50, ItemType.DISH));
        addItemToMenu(new Item("Spaghetti", 6.00, ItemType.DISH));
    }
}

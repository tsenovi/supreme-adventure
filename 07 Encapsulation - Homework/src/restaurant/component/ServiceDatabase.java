package restaurant.component;

import java.util.ArrayList;
import java.util.List;

public class ServiceDatabase {

    private final Table[] tables;
    private List<Item> menuItems;
    private List<Order> activeOrders;
    private List<Order> historyOrders;

    public ServiceDatabase() {
        this.menuItems = new ArrayList<>();
        this.activeOrders = new ArrayList<>();
        this.historyOrders = new ArrayList<>();
        this.tables = new Table[5];
        addInitialMenuItems();
        createTables();
    }

    public boolean createNewItem(String name, double price, ItemType type) {
        for (Item item : menuItems) {
            if (item.getName().equals(name)) {
                return false;
            }
        }

        Item item = new Item(name, price, type);
        addItemToMenu(item);
        return true;
    }

    public boolean removeExistedItem(String name) {
        for (Item item : menuItems) {
            if (item.getName().equals(name)) {
                removeItemFromMenu(item);
                return true;
            }
        }

        return false;
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
        for (Item item : menuItems) {
            if (item.getType().equals(comparator)) {
                sb.append(item.getName()).append(", ");
            }
        }
    }

    private void addItemToMenu(Item item) {
        this.menuItems.add(item);
    }

    private void removeItemFromMenu(Item item) {
        this.menuItems.remove(item);
    }

    private void addInitialMenuItems() {
        addItemToMenu(new Item("Coffee", 2.50, ItemType.DRINK));
        addItemToMenu(new Item("Water", 1.50, ItemType.DRINK));
        addItemToMenu(new Item("Toast", 3.0, ItemType.DISH));
        addItemToMenu(new Item("Burrito", 4.50, ItemType.DISH));
        addItemToMenu(new Item("Spaghetti", 6.00, ItemType.DISH));
    }

    private void createTables() {
        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Table(i + 1);
        }
    }

    public String getAvailableTablesNumbers() {
        List<Integer> availableTableNumbers = new ArrayList<>();
        for (Table table : tables) {
            if (table.getOrder() == null) {
                availableTableNumbers.add(table.getTableID());
            }
        }

        return availableTableNumbers.toString();
    }

    public boolean createNewOrder(int tableNumber) {
        for (Table table : tables) {
            if (tableNumber == table.getTableID()
                    && table.getOrder() == null) {
                table.setOrder(new Order(tableNumber));
                activeOrders.add(table.getOrder());
                return true;
            }
        }

        return false;
    }

    public String getAllActiveOrders() {
        return activeOrders.toString();
    }
}

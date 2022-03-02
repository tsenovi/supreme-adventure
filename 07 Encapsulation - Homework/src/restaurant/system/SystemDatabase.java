package restaurant.system;

import restaurant.model.*;

import java.util.ArrayList;
import java.util.List;

public class SystemDatabase {

    private final Table[] tables;
    private final List<Item> menuItems;
    private final List<Order> allOrders;

    public SystemDatabase() {
        this.menuItems = new ArrayList<>();
        this.allOrders = new ArrayList<>();
        this.tables = new Table[5];
        addInitialMenuItems();
        createTables();
    }

    public Table getTable(int index) {
        return tables[index - 1];
    }

    public Item getMenuItem(String name) {
        for (Item menuItem : menuItems) {
            if (menuItem.getName().equalsIgnoreCase(name)) {
                return menuItem;
            }
        }

        return null;
    }


    public boolean createMenuItem(String name, double price, ItemType type) {
        for (Item item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }

        Item item = new Item(name, price, type);
        addItemToMenu(item);
        return true;
    }

    public boolean removeMenuItem(String name) {
        for (Item item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                removeItemFromMenu(item);
                return true;
            }
        }

        return false;
    }

    public String getMenuItemsByType() {
        StringBuilder sb = new StringBuilder();
        sb.append(ItemType.FOOD).append(":\n");
        sortItems(sb, ItemType.FOOD);
        sb.append("\n").append(ItemType.DRINK).append(":\n");
        sortItems(sb, ItemType.DRINK);
        return sb.toString();
    }

    private void sortItems(StringBuilder sb, ItemType comparator) {
        for (Item item : menuItems) {
            if (item.getType().equals(comparator)) {
                sb.append(item.getName()).append(" - Price: ")
                        .append(item.getPrice()).append("\n");
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
        addItemToMenu(new Item("Toast", 3.0, ItemType.FOOD));
        addItemToMenu(new Item("Burrito", 4.50, ItemType.FOOD));
        addItemToMenu(new Item("Spaghetti", 6.00, ItemType.FOOD));
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

    public List<Order> getActiveOrders() {
        List<Order> activeOrders = new ArrayList<>();
        allOrders.forEach(order -> {
            if (!order.getOrderStatus().equals(OrderStatus.PAID)) {
                activeOrders.add(order);
            }
        });

        return activeOrders;
    }

    public boolean createNewOrder(int tableNumber) {
        for (Table table : tables) {
            if (tableNumber == table.getTableID() && table.getOrder() == null) {
                table.setOrder(new Order(tableNumber));
                allOrders.add(table.getOrder());
                return true;
            }
        }

        return false;
    }

    public boolean modifyOrder(Order currentOrder, String itemName, int itemQuantity) {
        Item itemToAdd = getMenuItem(itemName);
        if (itemToAdd == null) {
            return false;
        }

        currentOrder.addItemToOrder(new OrderItem(itemToAdd, itemQuantity));
        return true;
    }
}

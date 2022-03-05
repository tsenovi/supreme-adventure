package restaurant.system;

import restaurant.model.Item;
import restaurant.model.ItemType;
import restaurant.model.Order;
import restaurant.model.Table;

import java.util.List;

public interface SystemDatabase {
    Table getTable(int index);

    boolean createMenuItem(String name, double price, ItemType type);

    boolean removeMenuItem(String name);

    List<Item> getMenuDetails();

    String getAvailableTablesNumbers();

    List<Order> getSortedOrdersByGivenStatus(String status);

    boolean createNewOrder(int tableNumber);

    boolean modifyOrder(Order currentOrder, String itemName, int itemQuantity);

    boolean modifyOrder(Order currentOrder, String itemName);
}

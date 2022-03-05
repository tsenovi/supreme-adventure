package restaurant.ui;

import restaurant.model.Item;
import restaurant.model.Order;

import java.util.List;

public interface ConsoleManager {
    void show(String text);

    void showMenu(List<Item> items);

    void show(List<Order> orders);

    void show(Order order);

    String getTextInput();

    int getDecimalInput();

    double getDoubleNumberInput();
}

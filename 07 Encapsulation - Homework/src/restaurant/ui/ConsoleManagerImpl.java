package restaurant.ui;

import restaurant.model.Item;
import restaurant.model.Order;
import restaurant.model.OrderItem;

import java.util.List;
import java.util.Scanner;

public class ConsoleManagerImpl implements ConsoleManager {

    private final Scanner scanner;

    public ConsoleManagerImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
    public void showMenu(List<Item> items) {
        for (Item item : items) {
            System.out.println(item.getName() + " - Price: " + item.getPrice());
        }
    }

    @Override
    public void show(List<Order> orders) {
        for (Order order : orders) {
            show(showOrderDetails(order));
        }
    }

    @Override
    public void show(Order order) {
        show(showOrderDetails(order));
    }

    private String showOrderDetails(Order order) {
        return "Order: " +
                "Table: " + order.getTableID() +
                "\nDate: " + order.getDate() +
                "\nOrder status: " + order.getOrderStatus() +
                "\nItems:\n" + showOrderItemsDetails(order.getOrderItems()) +
                "\nTotal price: " + order.getTotalPrice() +
                "\n";
    }

    private String showOrderItemsDetails(List<OrderItem> orderItems) {
        StringBuilder sb = new StringBuilder();
        for (OrderItem orderItem : orderItems) {
            sb.append(orderItem.getItem().getName()).append("\t")
                    .append(orderItem.getQuantity()).append(" x ")
                    .append(orderItem.getPrice())
                    .append("\n");
        }

        return sb.toString();
    }

    @Override
    public String getTextInput() {
        return scanner.nextLine();
    }

    @Override
    public int getDecimalInput() {
        return Integer.parseInt(getTextInput());
    }

    @Override
    public double getDoubleNumberInput() {
        return Double.parseDouble(getTextInput());
    }
}

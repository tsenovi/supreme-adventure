package restaurant.ui;

import restaurant.model.Item;
import restaurant.model.Order;
import restaurant.model.OrderItem;

import java.util.List;
import java.util.Scanner;

public class Communicator {

    private final Scanner scanner;

    public Communicator() {
        this.scanner = new Scanner(System.in);
    }

    public void show(String text) {
        System.out.println(text);
    }

    public void showMenu(List<Item> items) {
        for (Item item : items) {
            System.out.println(item.getName() + " - Price: " + item.getPrice());
        }
    }

    public void show(List<Order> orders) {
        for (Order order : orders) {
            show(showOrderDetails(order));
        }
    }

    public void show(Order order) {
        show(showOrderDetails(order));
    }

    private String showOrderDetails(Order order) {
        return "Order:\n" +
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

    public String getTextInput() {
        return scanner.nextLine();
    }

    public int getDecimalInput() {

        return Integer.parseInt(getTextInput());
    }
}

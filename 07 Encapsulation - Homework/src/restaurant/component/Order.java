package restaurant.component;

import java.util.Calendar;
import java.util.Formatter;
import java.util.List;

public class Order {

    private int tableID;
    private String date;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    private double totalPrice;

    public Order(int tableID, List<OrderItem> orderItems, double totalPrice) {
        this.tableID = tableID;
        this.setDate();
        this.orderStatus = OrderStatus.IN_PROGRESS;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
    }

    public int getTableID() {
        return tableID;
    }

    public String getDate() {
        return date;
    }

    private void setDate() {
        Formatter format = new Formatter();
        Calendar calendar = Calendar.getInstance();

        // '%tl' for hours and '%tM' for minutes
        format.format("%tl:%tM", calendar, calendar);
        this.date = String.valueOf(format);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalPrice() {
        totalPrice = 0;
        orderItems.forEach((orderItem) -> {
            totalPrice += orderItem.getPrice();
        });

        return totalPrice;
    }

    public void addItemToOrder(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public void removeItemToOrder(OrderItem orderItem) {
        this.orderItems.remove(orderItem);
    }
}

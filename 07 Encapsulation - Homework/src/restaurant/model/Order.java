package restaurant.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order {

    private final int tableID;
    private String date;
    private OrderStatus orderStatus;
    private final List<OrderItem> orderItems;
    private double totalPrice;

    public Order(int tableID) {
        this.tableID = tableID;
        this.setDate();
        this.orderStatus = OrderStatus.NEW;
        this.orderItems = new ArrayList<>();
        this.totalPrice = 0;
    }

    public int getTableID() {
        return tableID;
    }

    public String getDate() {
        return date;
    }

    private void setDate() {
        Calendar now = Calendar.getInstance();
        this.date = now.get(Calendar.DATE) + "." +
                (now.get(Calendar.MONTH) + 1) + "." +
                now.get(Calendar.YEAR) + " - " +
                now.get(Calendar.HOUR_OF_DAY) + ":" +
                now.get(Calendar.MINUTE);
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
        orderItems.forEach((orderItem) -> totalPrice += orderItem.getPrice());

        return totalPrice;
    }

    public void addItemToOrder(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public void removeItemFromOrder(OrderItem orderItem) {
        this.orderItems.remove(orderItem);
    }
}

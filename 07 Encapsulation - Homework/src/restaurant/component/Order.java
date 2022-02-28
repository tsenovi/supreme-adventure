package restaurant.component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order {

    private int tableID;
    private String date;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
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

    @Override
    public String toString() {
        return "Order{" +
                "tableID=" + tableID +
                ", date='" + date + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderItems=" + orderItems.toString() +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

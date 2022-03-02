package restaurant.model;

public class Table {

    private Order order;
    private final int tableID;

    public Table(int tableID) {
        this.order = null;
        this.tableID = tableID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getTableID() {
        return tableID;
    }
}

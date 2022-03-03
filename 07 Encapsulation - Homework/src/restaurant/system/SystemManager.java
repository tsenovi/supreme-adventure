package restaurant.system;

import restaurant.auth.Authenticator;
import restaurant.auth.LoginStatus;
import restaurant.model.Order;
import restaurant.model.OrderStatus;
import restaurant.model.Table;
import restaurant.ui.Communicator;
import restaurant.model.ItemType;

import java.util.List;

public class SystemManager {

    private final Authenticator authenticator;
    private final Communicator communicator;
    private final SystemDatabase systemDatabase;

    public SystemManager() {
        this.authenticator = new Authenticator();
        this.communicator = new Communicator();
        this.systemDatabase = new SystemDatabase();
    }

    public void start() {
        while (true) {
            communicator.show("Restaurant System");
            if (authenticator.hasLoggedAccount()) {
                processAccountOptions();
            } else {
                startLoginProcess();
            }
        }
    }

    private void startLoginProcess() {
        communicator.show("Please login to continue!");
        String username = getCredentials("Username: ");
        String password = getCredentials("Password: ");

        LoginStatus loginStatus = authenticator.login(username, password);
        if (loginStatus == LoginStatus.LOGIN_FAILED) {
            communicator.show("Login failed!");
        } else {
            communicator.show("Login successful!");
        }
    }

    private String getCredentials(String text) {
        communicator.show(text);
        return communicator.getTextInput();
    }

    private void processAccountOptions() {
        if (authenticator.hasLoggedChef()) {
            runChefOptions();
        } else {
            runWaiterOptions();
        }
    }

    private void runChefOptions() {
        communicator.show(getChefOptions());
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
            case 1 -> authenticator.logout();
            case 2 -> showNewOrdersProcess();
            case 3 -> startChangingOrderStatusProcess();
        }
    }

    private void startChangingOrderStatusProcess() {
        Order currentOrder = getOrder();
        changeOrderStatus(currentOrder);
    }

    private void changeOrderStatus(Order currentOrder) {
        communicator.show(currentOrder);
        if (authenticator.hasLoggedChef()) {
            changeStatusByChef(currentOrder);
        } else {
            changeStatusByWaiter(currentOrder);
        }
    }

    private void changeStatusByChef(Order currentOrder) {
        communicator.show(getChefAvailableOrderStatuses());
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
            case 1 -> currentOrder.setOrderStatus(OrderStatus.PREPARING);
            case 2 -> currentOrder.setOrderStatus(OrderStatus.READY);
            default -> communicator.show("No such status!");
        }
    }

    private void changeStatusByWaiter(Order currentOrder) {
        communicator.show(getWaiterAvailableOrderStatuses());
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
            case 1 -> currentOrder.setOrderStatus(OrderStatus.SERVED);
            case 2 -> finishOrderProcess(currentOrder);
            default -> communicator.show("No such status!");
        }
    }

    private void finishOrderProcess(Order currentOrder) {
        currentOrder.setOrderStatus(OrderStatus.PAID);
        communicator.show(currentOrder);
        systemDatabase.getTable(currentOrder.getTableID()).setOrder(null);
    }

    private void runWaiterOptions() {
        communicator.show(getWaiterOptions());
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
            case 1 -> authenticator.logout();
            case 2 -> startCreatingNewItemProcess();
            case 3 -> startRemovingItemProcess();
            case 4 -> showCurrentMenu();
            case 5 -> showActiveOrdersProcess();
            case 6 -> startCreatingNewOrderProcess();
            case 7 -> startModifyingOrderProcess();
            case 8 -> startChangingOrderStatusProcess();
            case 9 -> showPaidOrdersProcess();
        }
    }

    private void startCreatingNewItemProcess() {
        showCurrentMenu();
        communicator.show("Enter item name: ");
        String itemName = communicator.getTextInput();
        communicator.show("Enter item price: ");
        double itemPrice = communicator.getDecimalInput();
        communicator.show("Enter item type: (ex. Drink/Dish)");
        ItemType itemType = convertAccountChoice(communicator.getTextInput());

        boolean isItemAdded = systemDatabase.createMenuItem(itemName, itemPrice, itemType);
        if (isItemAdded) {
            communicator.show("Item added successfully!");
        } else {
            communicator.show("Item already exists!");
        }
    }

    private ItemType convertAccountChoice(String textInput) {
        if (textInput.equalsIgnoreCase("drink")) return ItemType.DRINK;
        else return ItemType.FOOD;
    }

    private void startRemovingItemProcess() {
        showCurrentMenu();
        communicator.show("Enter item name: ");
        String itemName = communicator.getTextInput();

        boolean isItemRemoved = systemDatabase.removeMenuItem(itemName);
        if (isItemRemoved) {
            communicator.show("Item removed successfully!");
        } else {
            communicator.show("Item does not exists!");
        }
    }

    private void startCreatingNewOrderProcess() {
        communicator.show("Available tables: " + systemDatabase.getAvailableTablesNumbers());
        boolean isOrderCreated = systemDatabase.createNewOrder(getTableNumberInput());
        if (isOrderCreated) {
            communicator.show("Order created successfully!");
        } else {
            communicator.show("Table is not available or does not exists!");
        }
    }

    private void startModifyingOrderProcess() {
        Order currentOrder = getOrder();
        addItemToOrderProcess(currentOrder);
    }

    private Order getOrder() {
        Order currentOrder;
        do {
            Table currentTable = systemDatabase.getTable(getTableNumberInput());
            if (currentTable != null) {
                currentOrder = currentTable.getOrder();
                if (currentOrder != null) {
                    break;
                } else {
                    communicator.show("No such order exists!");
                }
            } else {
                communicator.show("No such table exists!");
            }
        } while (true);
        return currentOrder;
    }

    private int getTableNumberInput() {
        communicator.show("Enter table number: ");
        return communicator.getDecimalInput();
    }

    private void addItemToOrderProcess(Order currentOrder) {
        do {
            showCurrentMenu();
            communicator.show(currentOrder);

            communicator.show("Insert item name or type exit: ");
            String itemName = communicator.getTextInput();
            if (itemName.equalsIgnoreCase("exit")) break;
            communicator.show("Insert quantity: ");
            int itemQuantity = communicator.getDecimalInput();

            boolean isItemAddedToOrder = systemDatabase.modifyOrder(currentOrder, itemName, itemQuantity);
            if (isItemAddedToOrder) {
                communicator.show("Item added successfully to the order!");
            } else {
                communicator.show("No such item exists!");
                break;
            }
        } while (true);
    }

    private void showCurrentMenu() {
        communicator.show("Restaurant Menu");
        communicator.showMenu(systemDatabase.getMenuDetails());
    }

    private void showNewOrdersProcess() {
        getOrdersDetailsByStatus("new", "No new orders!", "List of new orders: ");
    }

    private void showActiveOrdersProcess() {
        getOrdersDetailsByStatus("active", "No active orders!", "List of active orders: ");
    }

    private void showPaidOrdersProcess() {
        getOrdersDetailsByStatus("paid", "No paid orders!", "List of paid orders: ");
    }

    private void getOrdersDetailsByStatus(String paid, String text, String text1) {
        List<Order> ordersByStatus = systemDatabase.getSortedOrdersByGivenStatus(paid);
        if (ordersByStatus.isEmpty()) {
            communicator.show(text);
        } else {
            communicator.show(text1);
            communicator.show(ordersByStatus);
        }
    }

    private String getChefOptions() {
        return """
                1. Logout
                2. See new orders
                3. Change order status""";
    }

    private String getChefAvailableOrderStatuses() {
        return """
                1. Preparing
                2. Ready""";
    }

    //TODO option 7.2 remove OrderItem
    private String getWaiterOptions() {
        return """
                1. Logout
                2. Add item to the menu
                3. Remove item from the menu
                4. See the menu
                5. See active orders
                6. Create new order
                7. Modify order
                8. Change order status
                9. View order history""";
    }

    private String getWaiterAvailableOrderStatuses() {
        return """
                1. Served
                2. Paid""";
    }
}

package restaurant.system;

import restaurant.auth.Authenticator;
import restaurant.auth.LoginStatus;
import restaurant.model.Order;
import restaurant.model.OrderStatus;
import restaurant.model.Table;
import restaurant.ui.ConsoleManager;
import restaurant.model.ItemType;

import java.util.List;

public class SystemManager {

    private final Authenticator authenticator;
    private final ConsoleManager consoleManager;
    private final SystemDatabase systemDatabase;

    public SystemManager(Authenticator authenticator,
                         ConsoleManager consoleManager,
                         SystemDatabase systemDatabase) {
        this.authenticator = authenticator;
        this.consoleManager = consoleManager;
        this.systemDatabase = systemDatabase;
    }

    public void start() {
        while (true) {
            consoleManager.show("Restaurant System");
            if (authenticator.hasLoggedAccount()) {
                processAccountOptions();
            } else {
                startLoginProcess();
            }
        }
    }

    private void startLoginProcess() {
        consoleManager.show("Please login to continue!");
        String username = getCredentials("Username: ");
        String password = getCredentials("Password: ");

        LoginStatus loginStatus = authenticator.login(username, password);
        if (loginStatus == LoginStatus.LOGIN_FAILED) {
            consoleManager.show("Login failed!");
        } else {
            consoleManager.show("Login successful!");
        }
    }

    private String getCredentials(String text) {
        consoleManager.show(text);
        return consoleManager.getTextInput();
    }

    private void processAccountOptions() {
        if (authenticator.hasLoggedChef()) {
            runChefOptions();
        } else {
            runWaiterOptions();
        }
    }

    private void runChefOptions() {
        consoleManager.show(getChefOptions());
        int accountChoice = consoleManager.getDecimalInput();
        switch (accountChoice) {
            case 1 -> authenticator.logout();
            case 2 -> showNewOrdersProcess();
            case 3 -> startChangingOrderStatusProcess();
            default -> consoleManager.show("No such option!");
        }
    }

    private void startChangingOrderStatusProcess() {
        Order currentOrder = getOrder();
        changeOrderStatus(currentOrder);
    }

    private void changeOrderStatus(Order currentOrder) {
        consoleManager.show(currentOrder);
        if (authenticator.hasLoggedChef()) {
            changeStatusByChef(currentOrder);
        } else {
            changeStatusByWaiter(currentOrder);
        }
    }

    private void changeStatusByChef(Order currentOrder) {
        consoleManager.show(getChefAvailableOrderStatuses());
        int accountChoice = consoleManager.getDecimalInput();
        switch (accountChoice) {
            case 1 -> currentOrder.setOrderStatus(OrderStatus.PREPARING);
            case 2 -> currentOrder.setOrderStatus(OrderStatus.READY);
            default -> consoleManager.show("No such status!");
        }
    }

    private void changeStatusByWaiter(Order currentOrder) {
        consoleManager.show(getWaiterAvailableOrderStatuses());
        int accountChoice = consoleManager.getDecimalInput();
        switch (accountChoice) {
            case 1 -> currentOrder.setOrderStatus(OrderStatus.SERVED);
            case 2 -> finishOrderProcess(currentOrder);
            default -> consoleManager.show("No such status!");
        }
    }

    private void finishOrderProcess(Order currentOrder) {
        currentOrder.setOrderStatus(OrderStatus.PAID);
        consoleManager.show(currentOrder);
        systemDatabase.getTable(currentOrder.getTableID()).setOrder(null);
    }

    private void runWaiterOptions() {
        consoleManager.show(getWaiterOptions());
        int accountChoice = consoleManager.getDecimalInput();
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
            default -> consoleManager.show("No such option!");
        }
    }

    private void startCreatingNewItemProcess() {
        showCurrentMenu();
        consoleManager.show("Enter item name: ");
        String itemName = consoleManager.getTextInput();
        consoleManager.show("Enter item price: ");
        double itemPrice = consoleManager.getDoubleNumberInput();
        consoleManager.show("Enter item type: (ex. Drink/Dish)");
        String itemTypeText = consoleManager.getTextInput();
        ItemType itemType = ItemType.getItemTypeByTextInput(itemTypeText);

        boolean isItemAdded = systemDatabase.createMenuItem(itemName, itemPrice, itemType);
        if (isItemAdded) {
            consoleManager.show("Item added successfully!");
        } else {
            consoleManager.show("Item already exists!");
        }
    }

    private void startRemovingItemProcess() {
        showCurrentMenu();
        consoleManager.show("Enter item name: ");
        String itemName = consoleManager.getTextInput();

        boolean isItemRemoved = systemDatabase.removeMenuItem(itemName);
        if (isItemRemoved) {
            consoleManager.show("Item removed successfully!");
        } else {
            consoleManager.show("Item does not exists!");
        }
    }

    private void startCreatingNewOrderProcess() {
        consoleManager.show("Available tables: " + systemDatabase.getAvailableTablesNumbers());
        boolean isOrderCreated = systemDatabase.createNewOrder(getTableNumberInput());
        if (isOrderCreated) {
            consoleManager.show("Order created successfully!");
        } else {
            consoleManager.show("Table is not available or does not exists!");
        }
    }

    private void startModifyingOrderProcess() {
        Order currentOrder = getOrder();
        consoleManager.show(getModifyingOrderOptions());
        int accountChoice = consoleManager.getDecimalInput();
        switch (accountChoice) {
            case 1 -> addItemToOrderProcess(currentOrder);
            case 2 -> removeItemFromOrderProcess(currentOrder);
            default -> consoleManager.show("No such option!");
        }
    }

    private void addItemToOrderProcess(Order currentOrder) {
        do {
            showCurrentMenu();
            consoleManager.show(currentOrder);

            consoleManager.show("Insert item name or type exit: ");
            String itemName = consoleManager.getTextInput();
            if (itemName.equalsIgnoreCase("exit")) break;
            consoleManager.show("Insert quantity: ");
            int itemQuantity = consoleManager.getDecimalInput();

            boolean isItemAddedToOrder = systemDatabase.modifyOrder(currentOrder, itemName, itemQuantity);
            if (isItemAddedToOrder) {
                consoleManager.show("Item added successfully to the order!");
            } else {
                consoleManager.show("No such item exists!");
                break;
            }
        } while (true);
    }

    private void removeItemFromOrderProcess(Order currentOrder) {
        do {
            showCurrentMenu();
            consoleManager.show(currentOrder);

            consoleManager.show("Insert item name or type exit: ");
            String itemName = consoleManager.getTextInput();
            if (itemName.equalsIgnoreCase("exit")) break;

            boolean isItemRemovedFromOrder = systemDatabase.modifyOrder(currentOrder, itemName);
            if (isItemRemovedFromOrder) {
                consoleManager.show("Item removed successfully from the order!");
            } else {
                consoleManager.show("No such item exists!");
                break;
            }
        } while (true);
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
                    consoleManager.show("No such order exists!");
                }
            } else {
                consoleManager.show("No such table exists!");
            }
        } while (true);
        return currentOrder;
    }

    private int getTableNumberInput() {
        consoleManager.show("Enter table number: ");
        return consoleManager.getDecimalInput();
    }

    private void showCurrentMenu() {
        consoleManager.show("Restaurant Menu");
        consoleManager.showMenu(systemDatabase.getMenuDetails());
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
            consoleManager.show(text);
        } else {
            consoleManager.show(text1);
            consoleManager.show(ordersByStatus);
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

    private String getModifyingOrderOptions() {
        return """
                1. Add item to order
                2. Remove item from order""";
    }

    private String getWaiterAvailableOrderStatuses() {
        return """
                1. Served
                2. Paid""";
    }
}

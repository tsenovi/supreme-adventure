package restaurant.sys;

import restaurant.auth.Authenticator;
import restaurant.auth.LoginStatus;
import restaurant.ui.Communicator;
import restaurant.component.ItemType;
import restaurant.component.ServiceDatabase;

public class System {

    private final Authenticator authenticator;
    private final Communicator communicator;
    private final ServiceDatabase serviceDatabase;

    public System() {
        this.authenticator = new Authenticator();
        this.communicator = new Communicator();
        this.serviceDatabase = new ServiceDatabase();
    }

    public void start() {
        while (true) {
            communicator.show("\tRestaurant System");
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
        communicator.show(showChefOptions());
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
            case 1 -> authenticator.logout();
            //TODO
        }
    }

    private void runWaiterOptions() {
        communicator.show(showWaiterOptions());
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
            case 1 -> authenticator.logout();
            case 2 -> startCreatingNewItemProcess();
            case 3 -> startRemovingItemProcess();
            case 4 -> showCurrentMenu();
            case 5 -> showActiveOrders();
            case 6 -> startCreatingNewOrderProcess();
        }
    }

    private void startCreatingNewItemProcess() {
        showCurrentMenu();
        communicator.show("Enter item name: ");
        String itemName = communicator.getTextInput();
        communicator.show("Enter item price: ");
        double itemPrice = communicator.getDecimalInput();
        communicator.show("Enter item type: (ex. Drink/Dish)");
        ItemType itemType = convertUserChoice(communicator.getTextInput());

        boolean isItemAdded = serviceDatabase.createNewItem(itemName, itemPrice, itemType);
        if (isItemAdded) {
            communicator.show("Item added successfully!");
        } else {
            communicator.show("Item already exists!");
        }
    }

    private ItemType convertUserChoice(String textInput) {
        if (textInput.equalsIgnoreCase("drink")) return ItemType.DRINK;
        else return ItemType.DISH;
    }

    private void startRemovingItemProcess() {
        showCurrentMenu();
        communicator.show("Enter item name: ");
        String itemName = communicator.getTextInput();

        boolean isItemRemoved = serviceDatabase.removeExistedItem(itemName);
        if (isItemRemoved) {
            communicator.show("Item removed successfully!");
        } else {
            communicator.show("Item does not exists!");
        }
    }

    private void startCreatingNewOrderProcess() {
        communicator.show("Available tables:\n" + serviceDatabase.getAvailableTablesNumbers());
        communicator.show("Select number of table: ");
        int tableNumber = communicator.getDecimalInput();
        boolean isOrderCreated = serviceDatabase.createNewOrder(tableNumber);
        if (isOrderCreated) {
            communicator.show("Order created successfully!");
        } else {
            communicator.show("Table is not available or does not exists!");
        }
    }

    private void showCurrentMenu() {
        communicator.show("Restaurant Menu\n"
                + serviceDatabase.getItemsSortedByType());
    }

    private void showActiveOrders() {
        communicator.show("Active orders\n"
                + serviceDatabase.getAllActiveOrders());
    }

    private String showChefOptions() {
        return """
                1. Logout
//TODO          2. See new orders
                3. Change order status""";
    }

    private String showWaiterOptions() {
        return """
                1. Logout
                2. Add item to the menu
                3. Remove item from the menu
                4. See the menu
                5. See active orders
                6. Create new order""";
    }
}

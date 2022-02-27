package restaurant.auth;

public class AccountDatabase {

    private final Chef chef;
    private final Waiter waiter;

    public AccountDatabase() {
        this.chef = loadChefCredentials();
        this.waiter = loadWaiterCredentials();
    }

    private Chef loadChefCredentials() {
        return new Chef("Alex", "1203");
    }

    private Waiter loadWaiterCredentials() {
        return new Waiter("Ivan", "0510");
    }

    public Account getAccount(String username) {
        Account account = getChef(username);
        if (account == null) {
            account = getWaiter(username);
        }

        return account;
    }

    private Chef getChef(String userName) {
        if (chef.getUserName().equals(userName)) {
            return chef;
        }

        return null;
    }

    private Waiter getWaiter(String userName) {
        if (waiter.getUserName().equals(userName)) {
            return waiter;
        }

        return null;
    }
}

package restaurant.auth;

public class Authenticator {

    private final AccountDatabase database;
    private Account loggedAccount;

    public Authenticator() {
        this.database = new AccountDatabase();
        this.loggedAccount = null;
    }


    public LoginStatus login(String username, String password) {
        Account account = database.getAccount(username);
        if (account != null && account.getPassword().equals(password)) {
            loggedAccount = account;
            return loggedAccount instanceof Chef ? LoginStatus.LOGIN_CHEF : LoginStatus.LOGIN_WAITER;
        }

        return LoginStatus.LOGIN_FAILED;
    }

    public boolean hasLoggedChef() {
        return loggedAccount instanceof Chef;
    }

    public boolean hasLoggedAccount() {
        return loggedAccount != null;
    }

    public void logout() {
        loggedAccount = null;
    }
}

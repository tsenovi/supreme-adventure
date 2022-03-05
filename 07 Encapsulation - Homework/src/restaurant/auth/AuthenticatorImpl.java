package restaurant.auth;

public class AuthenticatorImpl implements Authenticator {

    private final AccountDatabase database;
    private Account loggedAccount;

    public AuthenticatorImpl() {
        this.database = new AccountDatabase();
        this.loggedAccount = null;
    }


    @Override
    public LoginStatus login(String username, String password) {
        Account account = database.getAccount(username);
        if (account != null && account.getPassword().equals(password)) {
            loggedAccount = account;
            return loggedAccount instanceof Chef ? LoginStatus.LOGIN_CHEF : LoginStatus.LOGIN_WAITER;
        }

        return LoginStatus.LOGIN_FAILED;
    }

    @Override
    public boolean hasLoggedChef() {
        return loggedAccount instanceof Chef;
    }

    @Override
    public boolean hasLoggedAccount() {
        return loggedAccount != null;
    }

    @Override
    public void logout() {
        loggedAccount = null;
    }
}

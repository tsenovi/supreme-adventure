package Task1.auth;

public class Authenticator {

    private ResourceDatabase database;
    private Account loggedAccount;

    public Authenticator() {
        this.database = new ResourceDatabase();
        this.loggedAccount = null;
    }

    public boolean registerUser(String username, String email, int password) {
        if (database.hasUser(email)) {
            return false;
        }

        User user = new User(username, email, password);
        database.addUser(user);
        return true;
    }

    public LoginStatus login(String email, int password) {
        Account account = database.getAccount(email);
        if (account != null && account.getPassword() == password) {
            loggedAccount = account;
            return account instanceof Admin ? LoginStatus.LOGIN_ADMIN : LoginStatus.LOGIN_USER;
        }
        return LoginStatus.LOGIN_FAILED;
    }

    public void logout() {
        this.loggedAccount = null;
    }

    public boolean hasLoggedAccount() {
        return loggedAccount != null;
    }

    public boolean hasLoggedAdmin() {
        return hasLoggedAccount() && loggedAccount instanceof Admin;
    }

    public User[] getAllUsers() {
        return database.getUsers();
    }

    public Movie[] getAllMovies() {
        return database.getMovies();
    }
}

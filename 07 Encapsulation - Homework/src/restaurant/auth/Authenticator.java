package restaurant.auth;

public interface Authenticator {
    LoginStatus login(String username, String password);

    boolean hasLoggedChef();

    boolean hasLoggedAccount();

    void logout();
}

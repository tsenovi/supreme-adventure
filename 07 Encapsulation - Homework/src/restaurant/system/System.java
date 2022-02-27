package restaurant.system;

import restaurant.auth.Authenticator;
import restaurant.auth.LoginStatus;
import restaurant.com.Communicator;

public class System {

    private final Authenticator authenticator;
    private final Communicator communicator;

    public System() {
        this.authenticator = new Authenticator();
        this.communicator = new Communicator();
    }

    public void start() {
        while (true) {
            communicator.show("Welcome to Restaurant Login System");
            startLoginProcess();
        }
    }

    private void startLoginProcess() {
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
}

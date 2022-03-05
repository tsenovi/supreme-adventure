package restaurant;

import restaurant.auth.AuthenticatorImpl;
import restaurant.system.SystemDatabaseImpl;
import restaurant.system.SystemManager;
import restaurant.ui.ConsoleManagerImpl;

public class App {

    public static void main(String[] args) {
        new SystemManager(
                new AuthenticatorImpl(),
                new ConsoleManagerImpl(),
                new SystemDatabaseImpl()
        ).start();
    }
}

package Task1.videostore;


import Task1.auth.Authenticator;
import Task1.auth.LoginStatus;
import Task1.communicator.Communicator;

public class VideoStore {

    private Communicator communicator;
    private Authenticator authenticator;

    public VideoStore() {
        this.communicator = new Communicator();
        this.authenticator = new Authenticator();
    }

    public void runProgram() {
        while (true) {
            if (authenticator.hasLoggedAccount()) {
                runAccountOptions();
            } else {
                runLogin();
            }
        }
    }

    private void runAccountOptions() {
        if (authenticator.hasLoggedAdmin()) {
            communicator.show(getAdminOptions());
            runAdminOptions();
        } else {
            communicator.show(getUserOptions());
            runUserOptions();
        }
    }

    private void runAdminOptions() {
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
            case 1 -> startCreatingUserProcess();
            case 2 -> communicator.show(authenticator.getAllUsers());
            case 3 -> communicator.show(authenticator.getAllMovies());
// TODO     case 4 -> Show all rented movies and who rented them.
            case 5 -> {
                communicator.show("Logout successful!");
                authenticator.logout();
            }
        }
    }

    private void runUserOptions() {
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
// TODO     case 1 -> Show all rented movies by you and return chosen one.
// TODO     case 2 -> Show all available movies and rent chosen one.;
            case 3 -> {
                communicator.show("Logout successful!");
                authenticator.logout();
            }
        }
    }

    private void runLogin() {
        communicator.show("Enter email:");
        String email = communicator.getTextInput();
        communicator.show("Enter password:");
        int password = communicator.getDecimalInput();
        LoginStatus login = authenticator.login(email, password);
        if (login == LoginStatus.LOGIN_FAILED) {
            communicator.show("Incorrect email or password!");
        } else {
            communicator.show("Login successful!");
        }
    }

    private void startCreatingUserProcess() {
        communicator.show("Enter username:");
        String username = communicator.getTextInput();
        communicator.show("Enter email:");
        String email = communicator.getTextInput();
        communicator.show("Enter password:");
        int password = communicator.getDecimalInput();
        communicator.show("Enter password again:");
        int repeatPassword = communicator.getDecimalInput();

        if (password == repeatPassword) {
            boolean registerIsSuccessful = authenticator.registerUser(username, email, password);
            if (registerIsSuccessful) {
                communicator.show("Registration successful");
            } else {
                communicator.show("Such user exists.");
            }
        } else {
            communicator.show("Passwords should match");
        }
    }

    private String getAdminOptions() {
        return "1. Create user account.\n" +
                "2. See all users.\n" +
                "3. See all movies.\n" +
                "4. See all rented movies and who rented them.\n" +
                "5. Logout";
    }

    private String getUserOptions() {
        return "1. See all rented movies by you. Return selected movie.\n" +
                "2. See all available movies. Rent selected movie.\n" +
                "3. Logout";
    }
}

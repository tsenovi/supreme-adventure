package Task1.videostore;

import Task1.auth.Authenticator;
import Task1.auth.LoginStatus;
import Task1.communicator.Communicator;

public class VideoStore {

    private final Communicator communicator;
    private final Authenticator authenticator;

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
            case 2 -> getAllRegisteredUsers();
            case 3 -> getAllMovieResources();
            case 4 -> getAllRentedMovies();
            case 5 -> runLogoutProcess();
        }
    }

    private void runUserOptions() {
        int accountChoice = communicator.getDecimalInput();
        switch (accountChoice) {
            case 1 -> getAllRentedMoviesByUser();
            case 2 -> runReturnMovieProcess();
            case 3 -> getAllAvailableMovies();
            case 4 -> runRentMovieProcess();
            case 5 -> runLogoutProcess();
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

    private void runLogoutProcess() {
        authenticator.logout();
        communicator.show("Logout successful!");
    }

    private void startCreatingUserProcess() {
        communicator.show("Enter username:");
        String username = communicator.getTextInput();
        communicator.show("Enter email:");
        String email;
        while (true) {
            email = communicator.getTextInput();
            if (authenticator.isValidEmail(email)) {
                break;
            } else {
                communicator.show("Invalid email. Enter new one:");
            }
        }

        communicator.show("Enter password:");
        int password = communicator.getDecimalInput();
        communicator.show("Enter password again:");
        int repeatPassword = communicator.getDecimalInput();
        if (password == repeatPassword) {
            boolean registerIsSuccessful = authenticator.registerUser(username, email, password);
            if (registerIsSuccessful) {
                communicator.show("Registration successful.");
            } else {
                communicator.show("Such user exists!");
            }
        } else {
            communicator.show("Passwords should match!");
        }
    }

    private void runRentMovieProcess() {
        communicator.show("Enter the name of the movie:");
        String movieName = communicator.getTextInput();
        boolean rentIsSuccessful = authenticator.rentMovie(movieName);
        if (rentIsSuccessful) {
            communicator.show(movieName + " is successfully rented.");
        } else {
            communicator.show("No such movie to rent!");
        }
    }

    private void runReturnMovieProcess() {
        communicator.show("Enter the name of the movie:");
        String movieName = communicator.getTextInput();
        boolean returnIsSuccessful = authenticator.returnMovie(movieName);
        if (returnIsSuccessful) {
            communicator.show(movieName + " is successfully returned.");
        } else {
            communicator.show("No such movie to return!");
        }
    }

    private void getAllRentedMovies() {
        communicator.show(authenticator.getRentedMovies());
    }

    private void getAllMovieResources() {
        communicator.show(authenticator.getAllMovies());
    }

    private void getAllRegisteredUsers() {
        communicator.show(authenticator.getAllUsers());
    }

    private void getAllRentedMoviesByUser() {
        communicator.show(authenticator.getRentedMoviesByUser());
    }

    private void getAllAvailableMovies() {
        communicator.show(authenticator.getAvailableMovies());
    }

    private String getAdminOptions() {
        return """
                1. Create user account
                2. See all users
                3. See all movies
                4. See all rented movies and who rented them
                5. Logout""";
    }

    private String getUserOptions() {
        return """
                1. See all rented movies by you
                2. Return movie
                3. See all available movies
                4. Rent movie
                5. Logout""";
    }
}

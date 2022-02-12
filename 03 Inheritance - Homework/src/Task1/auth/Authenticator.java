package Task1.auth;

public class Authenticator {

    private ResourceDatabase database;
    private Account loggedAccount;

    public Authenticator() {
        this.database = new ResourceDatabase();
        this.loggedAccount = null;
    }

    public LoginStatus login(String email, int password) {
        Account account = database.getAccount(email);
        if (account != null && account.getPassword() == password) {
            loggedAccount = account;
            return account instanceof Admin ? LoginStatus.LOGIN_ADMIN : LoginStatus.LOGIN_USER;
        }
        return LoginStatus.LOGIN_FAILED;
    }

    public boolean registerUser(String username, String email, int password) {
        if (database.hasUser(email)) {
            return false;
        }

        User user = new User(username, email, password);
        database.addUser(user);
        return true;
    }

    public boolean rentMovie(String movieName) {
        Movie movieToRent = database.getMovie(movieName);
        if (movieToRent != null) {
            movieToRent.rent();
            movieToRent.setRentedBy((User) loggedAccount);
            return true;
        }

        return false;
    }
    public boolean returnMovie(String movieName) {
        Movie movieToReturn = database.getMovie(movieName);
        if (movieToReturn != null) {
            movieToReturn.returnMovie();
            movieToReturn.setRentedBy(null);
            return true;
        }

        return false;
    }

    public User[] getAllUsers() {
        return database.getUsers();
    }

    public Movie[] getAllMovies() {
        return database.getMovies();
    }

    public String getAvailableMovies() {
        StringBuilder sb = new StringBuilder();
        Movie[] movies = getAllMovies();
        for (Movie movie : movies) {
            if (movie != null && movie.getRentedBy() == null) {
                sb.append(movie.getName());
                sb.append("\n");
            }
        }
        return sb.isEmpty() ?
                "There are no available movies": sb.toString();
    }

    public String getRentedMovies() {
        StringBuilder sb = new StringBuilder();
        Movie[] movies = getAllMovies();
        for (Movie movie : movies) {
            if (movie != null && movie.getRentedBy() != null) {
                sb.append(movie.getName());
                sb.append(" - rented by ");
                sb.append(movie.getRentedBy().getUsername());
                sb.append("\n");
            }
        }
        return sb.isEmpty() ?
                "There are no rented movies": sb.toString();
    }

    public String getRentedMoviesByUser() {
        StringBuilder sb = new StringBuilder();
        Movie[] movies = getAllMovies();
        for (Movie movie : movies) {
            if (movie != null && movie.getRentedBy() == loggedAccount) {
                sb.append(movie.getName());
                sb.append("\n");
            }
        }
        return sb.isEmpty() ?
                "There are no rented movies by you!": sb.toString();
    }

    public boolean hasLoggedAccount() {
        return loggedAccount != null;
    }

    public boolean hasLoggedAdmin() {
        return hasLoggedAccount() && loggedAccount instanceof Admin;
    }

    public void logout() {
        this.loggedAccount = null;
    }
}

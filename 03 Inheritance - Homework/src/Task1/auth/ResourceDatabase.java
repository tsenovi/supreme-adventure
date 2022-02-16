package Task1.auth;

public class ResourceDatabase {

    private final Movie[] movies;
    private final User[] users;
    private final Admin admin;
    private int usersNumber;
    private int moviesNumber;

    public ResourceDatabase() {
        this.users = new User[10];
        this.movies = new Movie[100];
        this.admin = new Admin("admin", "admin@mail.bg", 1111);
        this.usersNumber = 0;
        this.moviesNumber = 0;
        storeUsers();
        storeMovies();
    }

    public Movie[] getMovies() {
        return movies;
    }

    public User[] getUsers() {
        return users;
    }

    public Account getAccount(String email) {
        Account currentAccount = getUser(email);
        if (currentAccount == null) {
            currentAccount = getAdmin(email);
        }
        return currentAccount;
    }

    private Account getUser(String email) {
        for (int i = 0; i < usersNumber; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }

    private Account getAdmin(String email) {
        if (admin.getEmail().equals(email)) {
            return admin;
        }
        return null;
    }

    public void addMovie(Movie movie) {
        movies[moviesNumber] = movie;
        moviesNumber++;
    }

    public void addUser(User user) {
        users[usersNumber] = user;
        usersNumber++;
    }

    public Movie getMovie(String movieName) {
        for (int i = 0; i < moviesNumber; i++) {
            if (movies[i].getName().equalsIgnoreCase(movieName)) {
                return movies[i];
            }
        }
        return null;
    }

    public boolean hasUser(String email) {
        return getUser(email) != null;
    }

    private void storeUsers() {
        addUser(new User("Petar", "petar@mail.bg", 5555));
        addUser(new User("Chavdar", "chavdar@mail.bg", 4444));
        addUser(new User("Trayan", "trayan@mail.bg", 3333));
    }

    private void storeMovies() {
        addMovie(new Movie("Greenland"));
        addMovie(new Movie("Gladiator"));
        addMovie(new Movie("Interstellar"));
        addMovie(new Movie("Pompeii"));
    }
}

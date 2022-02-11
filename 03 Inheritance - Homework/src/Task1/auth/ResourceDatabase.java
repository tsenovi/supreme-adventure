package Task1.auth;

public class ResourceDatabase {

    private Movie[] movies;
    private User[] users;
    private Admin admin;
    private int usersNumber;
    private int moviesNumber;

    public ResourceDatabase() {
        this.users = new User[10];
        this.movies = new Movie[100];
        this.admin = new Admin("admin", "admin@mail.bg", 1818);
        this.usersNumber = 0;
        this.moviesNumber = 0;
        storeUsers();
        storeMovies();
    }

    public void addMovie(Movie movie) {
        movies[moviesNumber] = movie;
        moviesNumber++;
    }

    public void addUser(User user) {
        users[usersNumber] = user;
        usersNumber++;
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
            currentAccount = getAdmin();
        }
        return currentAccount;
    }

    public boolean hasUser(String email) {
        return getUser(email) != null;
    }

    private Account getUser(String email) {
        for (int i = 0; i < usersNumber; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }

    private Account getAdmin() {
        return admin;
    }

    private void storeUsers() {
        addUser(new User("Petar Petrov", "petar.petrov@mail.bg", 2020));
        addUser(new User("Kiril Kirillov", "kiril.kirillov@mail.bg", 1919));
    }

    private void storeMovies() {
        addMovie(new Movie("Greenland"));
        addMovie(new Movie("Interstellar"));
    }
}

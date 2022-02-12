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
        this.admin = new Admin("admin", "admin@mail.bg", 1111);
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

    public Movie getMovie(String movieName) {
        for (int i = 0; i < moviesNumber; i++) {
            if(movies[i].getName().equals(movieName)){
                return movies[i];
            }
        }
        return null;
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

    public User[] getUsers() {
        return users;
    }

    private Account getAdmin() {
        return admin;
    }

    private void storeUsers() {
        addUser(new User("Petar", "petar@mail.bg", 2222));
        addUser(new User("Kiril", "kiril@mail.bg", 3333));
    }

    private void storeMovies() {
        addMovie(new Movie("Greenland"));
        addMovie(new Movie("Interstellar"));
    }
}

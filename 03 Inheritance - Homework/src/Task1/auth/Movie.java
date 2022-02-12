package Task1.auth;

public class Movie {

    private final String name;
    private boolean isAvailable;
    private User rentedBy;

    public Movie(String name) {
        this.name = name;
        this.isAvailable = true;
        this.rentedBy = null;
    }

    public String getName() {
        return name;
    }

    public User getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(User rentedBy) {
        this.rentedBy = rentedBy;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnMovie() {
        isAvailable = true;
    }
}

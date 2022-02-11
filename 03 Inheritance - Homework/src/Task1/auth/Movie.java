package Task1.auth;

public class Movie {

    private String name;
    private boolean isAvailable;
    private User rentedBy;

    public Movie(String name) {
        this.name = name;
        this.isAvailable = true;
        this.rentedBy = null;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnMovie() {
        isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public void setRentedBy(User rentedBy) {
        this.rentedBy = rentedBy;
    }
}

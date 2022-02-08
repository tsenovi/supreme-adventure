package Task1;

public class RentedMovie extends Movie {

    private String rentedBy;

    public RentedMovie(String name, String userName) {
        super(name);
        this.rentedBy = userName;
    }
}

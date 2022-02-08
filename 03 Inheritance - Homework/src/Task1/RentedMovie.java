package Task1;

public class RentedMovie extends Movie {

    private String rentedByUser;

    public RentedMovie(String name) {
        super(name);
        isRented = true;
    }
}

package Task1;

public class Movie {

    private String name;
    private boolean isAvailable;

    public Movie(String name) {
        this.name = name;
        this.isAvailable = true;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnMovie() {
        isAvailable = true;
    }
}

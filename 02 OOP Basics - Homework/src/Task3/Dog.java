package Task3;

public class Dog {

    private String name;
    private String color;
    private int egn;
    private String profilePicture;
    private boolean isAdopted;

    public Dog(String name, String color, int egn, String profilePicture) {
        this.name = name;
        this.color = color;
        this.egn = egn;
        this.profilePicture = profilePicture;
        this.isAdopted = false;
    }

    public String getName() {
        return name;
    }

    public void getDetails() {
        System.out.println("Name: " + name + "\n" +
                profilePicture + "\n" +
                "Color: " + color + "\n" +
                "EGN: " + egn + "\n" +
                "Adopted: " + isAdopted + "\n");
    }

    public void adopted() {
        isAdopted = true;
    }
}

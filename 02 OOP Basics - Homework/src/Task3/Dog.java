package Task3;

public class Dog {

    private String name;
    private String color;
    private int egn;
    private String profilePicture;
    private boolean isAdopted;

    public Dog(String name, String color, int egn, String profilePicture) {
        this.setName(name);
        this.setColor(color);
        this.setEgn(egn);
        this.setProfilePicture(profilePicture);
        this.isAdopted = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEgn() {
        return egn;
    }

    public void setEgn(int egn) {
        this.egn = egn;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
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

package Task1;

public class Account {

    private String name;
    private String email;
    private int password;

    public Account(String name, String email, int password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }

    public String getAccountDetails() {
        return name + " " + email;
    }
}

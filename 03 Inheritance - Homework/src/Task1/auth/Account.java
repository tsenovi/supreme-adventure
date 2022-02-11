package Task1.auth;

public class Account {

    private String username;
    private String email;
    private int password;

    public Account(String username, String email, int password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getAccountDetails() {
        return username + " " + email;
    }
}

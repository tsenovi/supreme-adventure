package Task1;

public class Account {

    private String name;
    private String email;
    private String password;
    private boolean isLogged;

    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isLogged = false;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return isLogged;
    }

    public void logOut() {
        isLogged = false;
    }

    public void logIn() {
        isLogged = true;
    }

    public String getAccountDetails() {
        return name + " " + email;
    }
}

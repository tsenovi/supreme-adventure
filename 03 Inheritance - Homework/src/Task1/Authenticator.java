package Task1;

public class Authenticator {

    public static boolean isLegitAccount(VideoStore myVideoStore, String email, String password) {
        for (int index = 0; index < myVideoStore.getUsersNumber(); index++) {
            if (isUser(myVideoStore, email, password, index)) {
                System.out.println("Access Granted! Welcome User!");
                return true;
            }
        }

        if (isAdmin(myVideoStore, email, password)) {
            System.out.println("Access Granted! Welcome Admin!");
            return true;
        }

        System.out.println("Invalid email or password!");
        return false;
    }

    public static Account checkAccountType(VideoStore myVideoStore, String email, String password) {
        for (int index = 0; index < myVideoStore.getUsersNumber(); index++) {
            if (isUser(myVideoStore, email, password, index)) {
                myVideoStore.getUser(index).logIn();
                return myVideoStore.getUser(index);
            }
        }

        if (isAdmin(myVideoStore, email, password)) {
            myVideoStore.getAdmin().logIn();
            return myVideoStore.getAdmin();
        }

        return null;
    }

    private static boolean isUser(VideoStore myVideoStore, String email, String password, int i) {
        return email.equals(myVideoStore.getUser(i).getEmail()) &&
                password.equals(myVideoStore.getUser(i).getPassword());
    }

    private static boolean isAdmin(VideoStore myVideoStore, String email, String password) {
        return email.equals(myVideoStore.getAdmin().getEmail()) &&
                password.equals(myVideoStore.getAdmin().getPassword());
    }
}

package Task1;

public class Authenticator {

    public static boolean isLegitAccount(VideoStore myVideoStore, String email, int password) {
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

    public static String checkAccountType(VideoStore myVideoStore, String email, int password) {
        for (int index = 0; index < myVideoStore.getUsersNumber(); index++) {
            if (isUser(myVideoStore, email, password, index)) {
                return "user";
            }
        }

        if (isAdmin(myVideoStore, email, password)) {
            return "admin";
        }

        return null;
    }

    private static boolean isUser(VideoStore myVideoStore, String email, int password, int i) {
        return email.equals(myVideoStore.getUser(i).getEmail())
                && (password == myVideoStore.getUser(i).getPassword());
    }

    private static boolean isAdmin(VideoStore myVideoStore, String email, int password) {
        return email.equals(myVideoStore.getAdmin().getEmail())
                && (password == myVideoStore.getAdmin().getPassword());
    }
}

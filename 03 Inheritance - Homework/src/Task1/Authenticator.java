package Task1;

public class Authenticator {

    public static boolean isLegitAccount(VideoStore myVideoStore, String email, int password) {
        for (int i = 0; i < myVideoStore.getUsersNumber(); i++) {
            if (email.equals(myVideoStore.getUser(i).getEmail())
                    && password == myVideoStore.getUser(i).getPassword()) {
                System.out.println("Access Granted! Welcome User!");
//                TODO
//                runUserFeatures();
                return true;
            }
        }

        if (email.equals(myVideoStore.getAdmin().getEmail())
                && password == myVideoStore.getAdmin().getPassword()) {
            System.out.println("Access Granted! Welcome Admin!");
            //    TODO
//                runAdminFeatures();
            return true;
        }

        System.out.println("Invalid email or password!");
        return false;
    }
}

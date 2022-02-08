package Task1;

import java.util.Scanner;

public class InputOutput {
    private static Scanner console = new Scanner(System.in);
    private static String inputEmail;
    private static int inputPassword;

    public static void getCredentials(VideoStore myVideoStore) {
        do {
            System.out.println("Enter e-mail: ");
            inputEmail = console.nextLine();
            System.out.println("Enter password: ");
            inputPassword = Integer.parseInt(console.nextLine());
        } while (!Authenticator.isLegitAccount(myVideoStore, inputEmail, inputPassword));
    }

    public static String getAccountType(VideoStore myVideoStore) {
        return Authenticator.checkAccountType(myVideoStore, inputEmail, inputPassword);
    }
}

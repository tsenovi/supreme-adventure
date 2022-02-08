package Task1;

import java.util.Scanner;

public class InputOutput {
    private static Scanner console = new Scanner(System.in);
    private static String inputEmail;
    private static String inputPassword;

    public static void getCredentials(VideoStore myVideoStore) {
        do {
            System.out.println("Enter e-mail: ");
            inputEmail = getInput();
            System.out.println("Enter password: ");
            inputPassword = getInput();
        } while (!Authenticator.isLegitAccount(myVideoStore, inputEmail, inputPassword));
    }

    public static Account getAccountType(VideoStore myVideoStore) {
        return Authenticator.checkAccountType(myVideoStore, inputEmail, inputPassword);
    }

    public static String getInput() {
        return console.nextLine();
    }
}

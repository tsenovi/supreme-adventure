package restaurant.com;

import java.util.Scanner;

public class Communicator {

    private final Scanner scanner;

    public Communicator() {
        this.scanner = new Scanner(System.in);
    }

    public void show(String text) {
        System.out.println(text);
    }

    public void show(StringBuilder sb) {
        System.out.println(sb);
    }

    public String getTextInput() {
        return scanner.nextLine();
    }

    public int getDecimalInput() {
        return Integer.parseInt(getTextInput());
    }
}

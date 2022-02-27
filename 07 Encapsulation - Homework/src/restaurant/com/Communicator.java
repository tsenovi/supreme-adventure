package restaurant.com;

import java.util.Scanner;

public class Communicator {

    private final Scanner scanner;

    public Communicator() {
        this.scanner = new Scanner(System.in);
    }

    public void show(String text){
        System.out.println(text);
    }

    public String getTextInput() {
        return scanner.nextLine();
    }
}

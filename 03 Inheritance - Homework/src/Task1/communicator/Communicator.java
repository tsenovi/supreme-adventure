package Task1.communicator;

import Task1.auth.User;
import Task1.auth.Movie;

import java.util.Scanner;

public class Communicator {

    private final Scanner console;

    public Communicator() {
        this.console = new Scanner(System.in);
    }

    public void show(String text) {
        System.out.println(text);
    }

    public void show(User[] array) {
        for (User user : array) {
            if (user != null) {
                System.out.println(user.getEmail());
            }
        }
    }

    public void show(Movie[] array) {
        for (Movie movie : array) {
            if (movie != null) {
                System.out.println(movie.getName());
            }
        }
    }

    public String getTextInput() {
        return console.nextLine();
    }

    public int getDecimalInput() {
        String textInput = getTextInput();
        while (!textInput.matches("[0-9]+")) {
            show("Invalid input, use numbers only!");
            textInput = getTextInput();
        }
        return Integer.parseInt(textInput);
    }
}

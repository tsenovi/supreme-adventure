package Task1.communicator;

import Task1.auth.User;
import Task1.auth.Movie;

import java.util.Scanner;

public class Communicator {

    private Scanner console;

    public Communicator() {
        this.console = new Scanner(System.in);
    }

    public void show(String text) {
        System.out.println(text);
    }

    public void show(Number number) {
        System.out.println(number);
    }

    public void show(User[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i].getEmail() + " ");
            }
        }
    }

    public void show(Movie[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i].getName() + " ");
            }
        }
    }

    public void show(String[][] array) {
        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array[0].length; cols++) {
                System.out.println(array[rows][cols] + ", ");
            }
        }
    }

    public String getTextInput() {
        return console.nextLine();
    }

    public int getDecimalInput() {
        String textInput = getTextInput();
        while (!textInput.matches("[0-9]+")){
            show("Invalid password!");
            textInput = getTextInput();
        }
        return Integer.parseInt(textInput);
    }
}

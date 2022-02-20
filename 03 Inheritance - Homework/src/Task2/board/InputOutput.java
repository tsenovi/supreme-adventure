package Task2.board;

import Task2.board.Box;

import java.util.Scanner;

public class InputOutput {
    private final Scanner console;

    public InputOutput() {
        this.console = new Scanner(System.in);
    }

    public void show(String text) {
        System.out.println(text);
    }

    public void show(Box[][] array) {
        for (int row = 0; row < array.length; row++) {
            System.out.print("\t|");
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col].getPiece() != null) {
                    System.out.print(array[row][col].getPiece().getShape() + "|");
                } else if ((row + col) % 2 == 0) {
                    System.out.print('\u25AD' + "|");
                } else {
                    System.out.print('\u25AC' + "|");
                }
            }
            System.out.println("\t");
        }
    }

    public String getTextInput() {
        return console.nextLine();
    }

    public int getDecimalInput() {
        String textInput = getTextInput();
        int number = Integer.parseInt(textInput);
        while (true) {
            if (number < 0 || number > 7) {
                show("Invalid index! Enter number between [0-7]: ");
                textInput = getTextInput();
                number = Integer.parseInt(textInput);
            } else {
                break;
            }
        }
        return number;
    }
}

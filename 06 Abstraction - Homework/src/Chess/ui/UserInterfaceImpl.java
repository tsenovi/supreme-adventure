package Chess.ui;

import Chess.board.PlayingPiece;

import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {

    private static final int OFFSET = 8;
    private final Scanner console;

    public UserInterfaceImpl() {
        this.console = new Scanner(System.in);
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
    public void show(PlayingPiece[][] array) {
        System.out.println("\tA\u2001B\u2001C\u2001D\u2001E\u2001F\u2001G\u2001H");
        for (int row = 0; row < array.length; row++) {
            System.out.print(8 - row + "\u2001|");
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] != null) {
                    System.out.print(array[row][col].getShape() + "|");
                } else if ((row + col) % 2 == 0) {
                    System.out.print('\u25AD' + "|");
                } else {
                    System.out.print('\u25AC' + "|");
                }
            }
            System.out.println("\t");
        }
    }

    @Override
    public String getTextInput() {
        return console.nextLine();
    }

    @Override
    public int getRowInput() {
        String textInput = getTextInput();
        int number = Integer.parseInt(textInput);
        while (true) {
            if (number < 1 || number > 8) {
                show("Invalid row! Enter number between [1-8]: ");
                textInput = getTextInput();
                number = Integer.parseInt(textInput);
            } else {
                break;
            }
        }
        return Math.abs(number - OFFSET);
    }

    @Override
    public int getColumnInput() {
        String letter = getTextInput();
        return switch (letter) {
            case "a", "A" -> 0;
            case "b", "B" -> 1;
            case "c", "C" -> 2;
            case "d", "D" -> 3;
            case "e", "E" -> 4;
            case "f", "F" -> 5;
            case "g", "G" -> 6;
            case "h", "H" -> 7;
            default -> getColumnInput();
        };
    }

}

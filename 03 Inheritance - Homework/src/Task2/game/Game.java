package Task2.game;

import Task2.board.Board;
import Task2.board.Color;
import Task2.board.Player;
import Task2.board.InputOutput;

public class Game {
    private Player player;
    private Player currentPlayer;
    private Board board;
    private InputOutput inputOutput;

    public Game() {
        this.player = new Player(Color.WHITE);
        this.currentPlayer = player;
        this.board = new Board();
        this.inputOutput = new InputOutput();
    }

    public void start() {
        while (true) {
            inputOutput.show(board.getBoxes());

            if (currentPlayer.getColor() == Color.WHITE) {
                inputOutput.show("White pieces turn");
            } else {
                inputOutput.show("Black pieces turn");
            }

            boolean isTurnSuccessful;
            do {
                inputOutput.show("Select figure to play");
                inputOutput.show("Enter row from 0 to 7: ");
                int selectedX = inputOutput.getDecimalInput();
                inputOutput.show("Enter col from 0 to 7: ");
                int selectedY = inputOutput.getDecimalInput();

                inputOutput.show("Select new spot for the figure");
                inputOutput.show("Enter row from 0 to 7: ");
                int newX = inputOutput.getDecimalInput();
                inputOutput.show("Enter col from 0 to 7: ");
                int newY = inputOutput.getDecimalInput();

                isTurnSuccessful = board.play(currentPlayer, selectedX, selectedY, newX, newY);
            } while (!isTurnSuccessful);

            if (currentPlayer.getColor() == Color.WHITE) {
                currentPlayer.setColor(Color.BLACK);
            } else {
                currentPlayer.setColor(Color.WHITE);
            }
        }
    }
}

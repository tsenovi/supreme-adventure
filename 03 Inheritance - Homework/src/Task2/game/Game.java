package Task2.game;

import Task2.board.Board;
import Task2.board.Color;
import Task2.board.Player;
import Task2.ui.UserInterface;

public class Game {
    private Player player;
    private Player currentPlayer;
    private Board board;
    private UserInterface userInterface;

    public Game() {
        this.player = new Player(Color.WHITE);
        this.currentPlayer = player;
        this.board = new Board();
        this.userInterface = new UserInterface();
    }

    public void start() {
        while (true) {
            userInterface.show(board.getPieces());
            announceCurrentPlayer();
            initializeMoveProcess();
            switchCurrentPlayer();
        }
    }

    private void initializeMoveProcess() {
        boolean isMoveSuccessful;
        do {
            userInterface.show("Select figure to move");
            userInterface.show("Enter row from 1 to 8: ");
            int selectedX = userInterface.getRowInput();
            userInterface.show("Enter col from A to H: ");
            int selectedY = userInterface.getColumnInput();

            userInterface.show("Select new spot for the figure");
            userInterface.show("Enter row from 1 to 8: ");
            int newX = userInterface.getRowInput();
            userInterface.show("Enter col from A to H: ");
            int newY = userInterface.getColumnInput();

            isMoveSuccessful = board.play(currentPlayer, selectedX, selectedY, newX, newY);
            if(!isMoveSuccessful) {
                userInterface.show("Wrong move!");
                userInterface.show(board.getPieces());
            }
        } while (!isMoveSuccessful);
    }

    private void announceCurrentPlayer() {
        if (currentPlayer.isWhitePlayer()) {
            userInterface.show( currentPlayer.getColor() + " pieces move!");
        } else {
            userInterface.show(currentPlayer.getColor() + " pieces move!");
        }
    }

    private void switchCurrentPlayer() {
        if (currentPlayer.isWhitePlayer()) {
            currentPlayer.setColor(Color.BLACK);
        } else {
            currentPlayer.setColor(Color.WHITE);
        }
    }
}

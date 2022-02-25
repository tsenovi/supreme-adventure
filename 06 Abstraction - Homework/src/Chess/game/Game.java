package Chess.game;

import Chess.board.Board;
import Chess.board.Color;
import Chess.board.Player;
import Chess.ui.UserInterface;

public class Game {
    private final Player currentPlayer;
    private final Board board;
    private final UserInterface userInterface;

    public Game(Board board, Player currentPlayer, UserInterface userInterface) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.userInterface = userInterface;
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
            if (!isMoveSuccessful) {
                userInterface.show("Wrong move!");
                userInterface.show(board.getPieces());
            }
        } while (!isMoveSuccessful);
    }

    private void announceCurrentPlayer() {
        if (currentPlayer.isWhitePlayer()) {
            userInterface.show(currentPlayer.getColor() + " pieces move!");
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

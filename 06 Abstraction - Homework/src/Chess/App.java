package Chess;

import Chess.board.BoardImpl;
import Chess.board.Color;
import Chess.board.PlayerImpl;
import Chess.game.Game;
import Chess.ui.UserInterfaceImpl;

public class App {

    public static void main(String[] args) {
        new Game(
                new BoardImpl(),
                new PlayerImpl(Color.WHITE),
                new UserInterfaceImpl()
        ).start();
    }
}

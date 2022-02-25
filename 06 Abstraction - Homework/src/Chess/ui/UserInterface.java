package Chess.ui;

import Chess.board.PlayingPiece;

public interface UserInterface {
    void show(String text);

    void show(PlayingPiece[][] array);

    String getTextInput();

    int getRowInput();

    int getColumnInput();
}

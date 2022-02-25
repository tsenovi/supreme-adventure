package Chess.board;

public interface Player {
    Color getColor();

    void setColor(Color color);

    boolean isWhitePlayer();
}

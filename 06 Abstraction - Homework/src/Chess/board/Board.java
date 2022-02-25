package Chess.board;

public interface Board {
    PlayingPiece[][] getPieces();

    boolean play(Player player, int selectedX, int selectedY, int newX, int newY);
}

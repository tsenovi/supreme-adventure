package Chess.board;

public class BoardImpl implements Board {
    private final PlayingPiece[][] pieces;

    public BoardImpl() {
        this.pieces = new PlayingPiece[8][8];
        resetBoard();
    }

    @Override
    public PlayingPiece[][] getPieces() {
        return pieces;
    }

    private PlayingPiece getPiece(int x, int y) {
        return pieces[x][y];
    }

    private void addPiece(PlayingPiece piece) {
        pieces[piece.getX()][piece.getY()] = piece;
    }

    private void deletePiece(int x, int y) {
        pieces[x][y] = null;
    }

    private void setNewPosition(int newX, int newY, PlayingPiece movingPiece) {
        movingPiece.setX(newX);
        movingPiece.setY(newY);
    }

    @Override
    public boolean play(Player player, int selectedX, int selectedY, int newX, int newY) {
        PlayingPiece movingPiece = getPiece(selectedX, selectedY);
        if (movingPiece != null && movingPiece.getColor() == player.getColor()) {
            if (movingPiece.isMoveLegal(player, newX, newY)) {
                PlayingPiece existingFigureAt = getPiece(newX, newY);
                if (existingFigureAt == null || existingFigureAt.getColor() != player.getColor()) {
                    setNewPosition(newX, newY, movingPiece);
                    addPiece(movingPiece);
                    deletePiece(selectedX, selectedY);
                    return true;
                }
            }
        }
        return false;
    }

    private void resetBoard() {
        pieces[0][0] = new Rook(0, 0, Color.WHITE);
        pieces[0][1] = new Knight(0, 1, Color.WHITE);
        pieces[0][2] = new Bishop(0, 2, Color.WHITE);
        pieces[0][3] = new King(0, 3, Color.WHITE);
        pieces[0][4] = new Queen(0, 4, Color.WHITE);
        pieces[0][5] = new Bishop(0, 5, Color.WHITE);
        pieces[0][6] = new Knight(0, 6, Color.WHITE);
        pieces[0][7] = new Rook(0, 7, Color.WHITE);
        pieces[1][0] = new Pawn(1, 0, Color.WHITE);
        pieces[1][1] = new Pawn(1, 1, Color.WHITE);
        pieces[1][2] = new Pawn(1, 2, Color.WHITE);
        pieces[1][3] = new Pawn(1, 3, Color.WHITE);
        pieces[1][4] = new Pawn(1, 4, Color.WHITE);
        pieces[1][5] = new Pawn(1, 5, Color.WHITE);
        pieces[1][6] = new Pawn(1, 6, Color.WHITE);
        pieces[1][7] = new Pawn(1, 7, Color.WHITE);

        pieces[7][0] = new Rook(7, 0, Color.BLACK);
        pieces[7][1] = new Knight(7, 1, Color.BLACK);
        pieces[7][2] = new Bishop(7, 2, Color.BLACK);
        pieces[7][3] = new King(7, 3, Color.BLACK);
        pieces[7][4] = new Queen(7, 4, Color.BLACK);
        pieces[7][5] = new Bishop(7, 5, Color.BLACK);
        pieces[7][6] = new Knight(7, 6, Color.BLACK);
        pieces[7][7] = new Rook(7, 7, Color.BLACK);
        pieces[6][0] = new Pawn(6, 0, Color.BLACK);
        pieces[6][1] = new Pawn(6, 1, Color.BLACK);
        pieces[6][2] = new Pawn(6, 2, Color.BLACK);
        pieces[6][3] = new Pawn(6, 3, Color.BLACK);
        pieces[6][4] = new Pawn(6, 4, Color.BLACK);
        pieces[6][5] = new Pawn(6, 5, Color.BLACK);
        pieces[6][6] = new Pawn(6, 6, Color.BLACK);
        pieces[6][7] = new Pawn(6, 7, Color.BLACK);

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }
        }
    }
}

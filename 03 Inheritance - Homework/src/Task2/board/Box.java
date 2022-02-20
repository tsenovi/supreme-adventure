package Task2.board;

public class Box {
    private PlayingPiece piece;
    private int x;
    private int y;

    public Box(int x, int y, PlayingPiece piece) {
        this.setX(x);
        this.setY(y);
        this.setPiece(piece);
    }

    public PlayingPiece getPiece() {
        return this.piece;
    }

    public void setPiece(PlayingPiece piece) {
        this.piece = piece;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

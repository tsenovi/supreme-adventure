package Task2;

public abstract class PlayingPiece {
    private char shape;
    private boolean isWhite;

    protected PlayingPiece() {
    }

    public PlayingPiece(boolean white) {
        this.isWhite = white;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public char getShape() {
        return shape;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public abstract boolean isValidMove();
}

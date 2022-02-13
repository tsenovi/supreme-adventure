package Task2;

public class Rook extends PlayingPiece {
    private char shape;

    public Rook(boolean white) {
        super(white);
        this.shape = setShape();
    }

    public char getShape() {
        return shape;
    }

    private char setShape() {
        if (isWhite()) {
            return shape = '\u2656';
        }
        return shape = '\u265C';
    }

    @Override
    public boolean isValidMove() {
        return false;
    }
}

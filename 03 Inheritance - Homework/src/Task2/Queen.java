package Task2;

public class Queen extends PlayingPiece {
    private char shape;

    public Queen(boolean white) {
        super(white);
        this.shape = setShape();
    }

    public char getShape() {
        return shape;
    }

    private char setShape() {
        if (isWhite()) {
            return shape = '\u2655';
        }
        return shape = '\u265B';
    }

    @Override
    public boolean isValidMove() {
        return false;
    }
}

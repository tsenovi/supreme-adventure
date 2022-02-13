package Task2;

public class King extends PlayingPiece {
    private char shape;

    public King(boolean white) {
        super(white);
        this.shape = setShape();
    }

    public char getShape() {
        return shape;
    }

    private char setShape() {
        if (isWhite()) {
            return shape = '\u2654';
        }
        return shape = '\u265A';
    }

    @Override
    public boolean isValidMove() {
        return false;
    }
}

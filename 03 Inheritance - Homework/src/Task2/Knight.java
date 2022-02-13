package Task2;

public class Knight extends PlayingPiece {
    private char shape;

    public Knight(boolean white) {
        super(white);
        this.shape = setShape();
    }

    public char getShape() {
        return shape;
    }

    private char setShape() {
        if (isWhite()) {
            return shape = '\u2658';
        }
        return shape = '\u265E';
    }

    @Override
    public boolean isValidMove() {
        return false;
    }
}

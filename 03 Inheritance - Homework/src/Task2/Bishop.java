package Task2;

public class Bishop extends PlayingPiece {
    private char shape;

    public Bishop(boolean white) {
        super(white);
        this.shape = setShape();
    }

    public char getShape() {
        return shape;
    }

    private char setShape() {
        if (isWhite()) {
            return shape = '\u2657';
        }
        return shape = '\u265D';
    }

    @Override
    public boolean isValidMove() {
        return false;
    }
}

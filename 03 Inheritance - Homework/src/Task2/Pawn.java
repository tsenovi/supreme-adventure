package Task2;

public class Pawn extends PlayingPiece {
    private char shape;

    public Pawn(boolean white) {
        super(white);
        this.shape = setShape();
    }

    public char getShape() {
        return shape;
    }

    private char setShape() {
        if (isWhite()) {
            return shape = '\u2659';
        }
        return shape = '\u265F';
    }

    @Override
    public boolean isValidMove() {
        return false;
    }
}

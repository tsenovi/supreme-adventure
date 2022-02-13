package Task2;

public class EmptyBox extends PlayingPiece{
    private char shape;

    public EmptyBox() {
        this.shape = setShape();
    }

    public char getShape() {
        return shape;
    }

    private char setShape() {
        return shape = '\u26AA' + ' ';
    }

    @Override
    public boolean isValidMove() {
        return false;
    }
}

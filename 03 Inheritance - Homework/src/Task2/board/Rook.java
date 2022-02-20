package Task2.board;

public class Rook extends PlayingPiece {
    private char shape;

    public Rook(Color color) {
        this.color = color;
        this.setShape();
    }

    @Override
    public boolean isWhite() {
        return color == Color.WHITE;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    public char getShape() {
        return shape;
    }

    @Override
    public void setShape() {
        if (isWhite()) {
            this.shape = '\u2656';
        } else {
            this.shape = '\u265C';
        }
    }

    @Override
    public boolean isMoveLegal(Player player, Box initialBox, Box finalBox) {
        if (initialBox.getX() == finalBox.getX()
                && initialBox.getY() == finalBox.getY()) return false;
        return initialBox.getX() == finalBox.getX() || initialBox.getY() == finalBox.getY();
    }
}
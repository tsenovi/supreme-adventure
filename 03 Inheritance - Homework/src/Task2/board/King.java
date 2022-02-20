package Task2.board;

public class King extends PlayingPiece {

    public King(Color color) {
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
            this.shape = '\u2654';
        } else {
            this.shape = '\u265A';
        }
    }

    @Override
    public boolean isMoveLegal(Player player, Box initialBox, Box finalBox) {
        return false;
    }
}
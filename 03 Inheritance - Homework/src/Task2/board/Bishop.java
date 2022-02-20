package Task2.board;

public class Bishop extends PlayingPiece {
    private char shape;

    public Bishop(Color color) {
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
            this.shape = '\u2657';
        } else {
            this.shape = '\u265D';
        }
    }

    @Override
    public boolean isMoveLegal(Player player, Box initialBox, Box finalBox) {
        if (initialBox.getX() == finalBox.getX()
                && initialBox.getY() == finalBox.getY()) return false;

        int diffX = Math.abs(initialBox.getX() - finalBox.getX());
        int diffY = Math.abs(initialBox.getY() - finalBox.getY());
        return diffX == diffY;
    }
}

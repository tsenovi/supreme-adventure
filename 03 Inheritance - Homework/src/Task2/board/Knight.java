package Task2.board;

public class Knight extends PlayingPiece {
    private char shape;

    public Knight(Color color) {
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
        this.shape = '\u2658';
        } else {
            this.shape = '\u265E';
        }
    }

    @Override
    public boolean isMoveLegal(Player player, Box initialBox, Box finalBox) {
        if (initialBox.getX() == finalBox.getX()
                && initialBox.getY() == finalBox.getY()) return false;

        int diffX = Math.abs(initialBox.getX() - finalBox.getX());
        int diffY = Math.abs(initialBox.getY() - finalBox.getY());

        return (diffX + diffY) == 3 && diffX != 0 && diffY != 0;
    }
}

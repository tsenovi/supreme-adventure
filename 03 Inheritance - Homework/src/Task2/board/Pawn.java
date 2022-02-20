package Task2.board;

public class Pawn extends PlayingPiece {
    private char shape;

    public Pawn(Color color) {
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
            this.shape = '\u2659';
        } else {
            this.shape = '\u265F';
        }
    }

    @Override
    public boolean isMoveLegal(Player player, Box initialBox, Box finalBox) {
        if (initialBox.getX() == finalBox.getX()
                && initialBox.getY() == finalBox.getY()) return false;

        // This is for normal pawn moves.
        if (Math.abs(initialBox.getX() - finalBox.getX()) == 1
                && Math.abs(initialBox.getY() - finalBox.getY()) == 0) {

            // White can only move forward
            if (player.getColor() == Color.WHITE) {
                if (initialBox.getX() < finalBox.getX()) {
                    return true;
                }
            }
            // Black can only move backward in a sense.
            if (player.getColor() == Color.BLACK) {
                if (initialBox.getX() > finalBox.getX()) {
                    return true;
                }
            }
        }

        // This is for first pawn move.
        if (Math.abs(initialBox.getX() - finalBox.getX()) == 2
                && Math.abs(initialBox.getY() - finalBox.getY()) == 0
                && (initialBox.getX() == 1 || initialBox.getX() == 6)) {

            // White can only move forward
            if (player.getColor() == Color.WHITE) {
                if (initialBox.getX() < finalBox.getX()) {
                    return true;
                }
            }
            // Black can only move backward in a sense.
            if (player.getColor() == Color.BLACK) {
                if (initialBox.getX() > finalBox.getX()) {
                    return true;
                }
            }
        }

        return false;
    }
}

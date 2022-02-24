package Task2.board;

public class Pawn extends PlayingPiece {

    public Pawn(int x, int y, Color color) {
        this.x = x;
        this.y = y;
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

    @Override
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
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean isMoveLegal(Player player, int newX, int newY) {
        if (x == newX && y == newY) return false;

        // This is for normal pawn moves
        if (Math.abs(x - newX) == 1
                && Math.abs(y - newY) == 0) {

            // White can only move forward
            if (player.getColor() == Color.WHITE) {
                if (x < newX) {
                    return true;
                }
            }
            // Black can only move backward
            if (player.getColor() == Color.BLACK) {
                if (x > newX) {
                    return true;
                }
            }
        }

        // This is for first pawn move
        if (Math.abs(x - newX) == 2
                && Math.abs(y - newY) == 0
                && (x == 1 || x == 6)) {

            // White can only move forward
            if (player.getColor() == Color.WHITE) {
                if (x < newX) {
                    return true;
                }
            }
            // Black can only move backward
            if (player.getColor() == Color.BLACK) {
                if (x > newX) {
                    return true;
                }
            }
        }

        return false;
    }
}

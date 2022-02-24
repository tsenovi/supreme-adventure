package Task2.board;

public class Bishop extends PlayingPiece {

    public Bishop(int x, int y, Color color) {
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
            this.shape = '\u2657';
        } else {
            this.shape = '\u265D';
        }
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
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

        int diffX = Math.abs(x - newX);
        int diffY = Math.abs(y - newY);
        return diffX == diffY;
    }
}

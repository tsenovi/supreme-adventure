package Task2.board;

public class Rook extends PlayingPiece {

    public Rook(int x, int y, Color color) {
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
            this.shape = '\u2656';
        } else {
            this.shape = '\u265C';
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

        return x == newX || y == newY;
    }
}
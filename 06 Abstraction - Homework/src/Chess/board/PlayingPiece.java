package Chess.board;

public abstract class PlayingPiece {
    protected Color color;
    protected char shape;
    protected int x;
    protected int y;

    public abstract boolean isWhite();

    public abstract void setShape();

    public abstract Color getColor();

    public abstract char getShape();

    public abstract int getX();

    public abstract void setX(int x);

    public abstract int getY();

    public abstract void setY(int y);

    public abstract boolean isMoveLegal(Player player, int newX, int newY);
}

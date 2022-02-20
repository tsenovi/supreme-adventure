package Task2.board;

abstract class PlayingPiece {
    protected Color color;
    protected char shape;

    public abstract boolean isWhite();

    public abstract void setShape();

    public abstract Color getColor();

    public abstract char getShape();

    public abstract boolean isMoveLegal(Player player, Box initialBox, Box finalBox);
}

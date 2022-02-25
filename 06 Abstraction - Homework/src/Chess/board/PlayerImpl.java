package Chess.board;

public class PlayerImpl implements Player {
    private Color color;

    public PlayerImpl(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean isWhitePlayer(){
        return color == Color.WHITE;
    }
}

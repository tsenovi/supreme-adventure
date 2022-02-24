package Task2.board;

import Task2.board.Color;

public class Player {
    private Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isWhitePlayer(){
        return color == Color.WHITE;
    }
}

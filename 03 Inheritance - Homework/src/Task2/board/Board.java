package Task2.board;

import Task2.board.*;

public class Board {
    private final Box[][] boxes;

    public Board() {
        this.boxes = new Box[8][8];
        resetBoard();
    }

    public Box getBox(int x, int y) {
        return boxes[x][y];
    }

    public Box[][] getBoxes() {
        return boxes;
    }

    private void resetBoard() {
        // initialize white pieces
        boxes[0][0] = new Box(0, 0, new Rook(Color.WHITE));
        boxes[0][1] = new Box(0, 1, new Knight(Color.WHITE));
        boxes[0][2] = new Box(0, 2, new Bishop(Color.WHITE));
        boxes[0][3] = new Box(0, 2, new King(Color.WHITE));
        boxes[0][4] = new Box(0, 2, new Queen(Color.WHITE));
        boxes[0][5] = new Box(0, 2, new Bishop(Color.WHITE));
        boxes[0][6] = new Box(0, 2, new Knight(Color.WHITE));
        boxes[0][7] = new Box(0, 2, new Rook(Color.WHITE));
        boxes[1][0] = new Box(1, 0, new Pawn(Color.WHITE));
        boxes[1][1] = new Box(1, 1, new Pawn(Color.WHITE));
        boxes[1][2] = new Box(1, 2, new Pawn(Color.WHITE));
        boxes[1][3] = new Box(1, 3, new Pawn(Color.WHITE));
        boxes[1][4] = new Box(1, 4, new Pawn(Color.WHITE));
        boxes[1][5] = new Box(1, 5, new Pawn(Color.WHITE));
        boxes[1][6] = new Box(1, 6, new Pawn(Color.WHITE));
        boxes[1][7] = new Box(1, 7, new Pawn(Color.WHITE));

        // initialize black pieces
        boxes[7][0] = new Box(7, 0, new Rook(Color.BLACK));
        boxes[7][1] = new Box(7, 1, new Knight(Color.BLACK));
        boxes[7][2] = new Box(7, 2, new Bishop(Color.BLACK));
        boxes[7][3] = new Box(7, 3, new King(Color.BLACK));
        boxes[7][4] = new Box(7, 4, new Queen(Color.BLACK));
        boxes[7][5] = new Box(7, 5, new Bishop(Color.BLACK));
        boxes[7][6] = new Box(7, 6, new Knight(Color.BLACK));
        boxes[7][7] = new Box(7, 7, new Rook(Color.BLACK));
        boxes[6][0] = new Box(6, 0, new Pawn(Color.BLACK));
        boxes[6][1] = new Box(6, 1, new Pawn(Color.BLACK));
        boxes[6][2] = new Box(6, 2, new Pawn(Color.BLACK));
        boxes[6][3] = new Box(6, 3, new Pawn(Color.BLACK));
        boxes[6][4] = new Box(6, 4, new Pawn(Color.BLACK));
        boxes[6][5] = new Box(6, 5, new Pawn(Color.BLACK));
        boxes[6][6] = new Box(6, 6, new Pawn(Color.BLACK));
        boxes[6][7] = new Box(6, 7, new Pawn(Color.BLACK));

        // initialize remaining boxes without piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Box(i, j, null);
            }
        }
    }

    public boolean play(Player player, int selectedX, int selectedY, int newX, int newY) {
        Box initialBox = getBox(selectedX, selectedY);
        Box finalBox = getBox(newX, newY);
        if (initialBox.getPiece() != null) {
            if (initialBox.getPiece().isMoveLegal(player, initialBox, finalBox)) {
                if (finalBox.getPiece() != null && finalBox.getPiece().getColor() != player.getColor()) {
                    finalBox.setPiece(initialBox.getPiece());
                    initialBox.setPiece(null);
                    return true;
                } else {
                    finalBox.setPiece(initialBox.getPiece());
                    initialBox.setPiece(null);
                    return true;
                }
            } else {
                System.out.println("Illegal move!");
                return false;
            }
        } else {
            System.out.println("No figure at selected coordinates");
            return false;
        }
    }
}

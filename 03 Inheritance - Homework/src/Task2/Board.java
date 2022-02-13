package Task2;

public class Board {

    private final static int BOARD_LENGTH = 8;
    private PlayingPiece[][] board;

    public Board() {
        this.board = new PlayingPiece[BOARD_LENGTH][BOARD_LENGTH];
        initBoard();
    }

    private void initBoard() {
        for (int row = 0; row < BOARD_LENGTH; row++) {
            for (int col = 0; col < BOARD_LENGTH; col++) {
                if (row == 0) {
                    if (col == 0 || col == BOARD_LENGTH - 1) {
                        board[row][col] = new Rook(false);
                    } else if (col == 1 || col == BOARD_LENGTH - 2) {
                        board[row][col] = new Knight(false);
                    } else if (col == 2 || col == BOARD_LENGTH - 3) {
                        board[row][col] = new Bishop(false);
                    } else if (col == 3) {
                        board[row][col] = new King(false);
                    } else {
                        board[row][col] = new Queen(false);
                    }
                } else if (row == 1) {
                    board[row][col] = new Pawn(false);
                } else if (row == 6) {
                    board[row][col] = new Pawn(true);
                } else if (row == 7){
                    if (col == 0 || col == BOARD_LENGTH - 1) {
                        board[row][col] = new Rook(true);
                    } else if (col == 1 || col == BOARD_LENGTH - 2) {
                        board[row][col] = new Knight(true);
                    } else if (col == 2 || col == BOARD_LENGTH - 3) {
                        board[row][col] = new Bishop(true);
                    } else if (col == 3) {
                        board[row][col] = new King(true);
                    } else {
                        board[row][col] = new Queen(true);
                    }
                } else {
                    board[row][col] = new EmptyBox();
                }
            }
        }
    }

    public void getBoard() {
        for (int row = 0; row <= BOARD_LENGTH; row++) {
            if (row != BOARD_LENGTH) {
                System.out.print(BOARD_LENGTH - row + " ");
            } else {
                System.out.print("\s");
                for (int i = 1; i <= BOARD_LENGTH; i++) {
                    System.out.print(" " + i + " ");
                }
                break;
            }

            for (int col = 0; col < BOARD_LENGTH; col++) {
                System.out.print("|" + board[row][col].getShape());
            }
            System.out.print("|\n");
        }
    }
}

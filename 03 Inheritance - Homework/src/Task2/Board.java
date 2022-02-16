package Task2;

public class Board {

    private final static int BOARD_LENGTH = 8;
    private PlayingPiece[][] board;

    public Board() {
        this.board = initBoard();
    }

    private PlayingPiece[][] initBoard() {
        return new PlayingPiece[][] {

        };
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

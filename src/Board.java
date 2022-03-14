public class Board {
    private String[][] board;
    public Board() {
        board = new String[10][10];
        final

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length;col++) {
                board[row][col] = "-";
            }
        }
    }

    public void printBoard() {
        System.out.println("  A B C D E F G H I J");
        int idx = 0;
        for(String[] row : board) {
            System.out.print(idx + " ");
            for(String ele : row) {
                System.out.print(ele + " ");
            }
            idx++;
            System.out.println(" ");
        }
    }

    public void fill
}

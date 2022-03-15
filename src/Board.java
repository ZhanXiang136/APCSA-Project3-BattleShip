import java.util.ArrayList;
public class Board {
    private String[][] board;
    final private String[] SHIP_NAME = {"Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
    final private int[] SHIP_SPOT = {5,4,3,3,2};
    private ArrayList<String> shipLocationArr;

    public Board(String userType) {
        board = new String[10][10];
        shipLcoationArr = new ArrayList<>();
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length;col++) {
                board[row][col] = "-";
            }
        }

        fillBoard(userType);
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

    private void fillBoard(String userType) {
        switch (userType) {
            case "None":
                break;
            case "player":
                break;
            case "computer":
                break;
            default:
                System.out.println("Cannot read parameter " + userType);
        }
    }

    private boolean checkIfTaken(String[] arr) {
        for(String spot : arr) {
            if(shipLocationArr.contains(spot)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUserInput(String input) {
        if(input.length() == 2 || "ABCDEFGHIJ".contains(input.substring(0,1)) || "0123456789".contains(input.substring(1))){
            return true;
        }
        return false;
    }
}

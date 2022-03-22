import java.util.ArrayList;
public class Board {
    private String[][] board;
    private Ship[] ships;
    //private ArrayList<Ship> shipLocationArr;

    public Board(String userType) {
        board = new String[10][10];
        ships = {new Ship("Carrier", 4), new Ship("Battleship", 4), new Ship("Cruiser", 3), new Ship("Submarine", 3), new Ship("Destroyer", 2)}
        //shipLocationArr = new ArrayList<>();
        String[] colSymArr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length;col++) {
                board[row][col] = new Space(colSymArr[row]+col);
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
                for(int i = 0; i < 5; i++) {
                    while (true) {
                        printBoard();
                        U.println("Where do you want to put your " + SHIP_NAME[i] + ", which takes up " + SHIP_SPOT[i] + "spaces?");
                        String userInput1 = U.scanStr("Enter your first spot (LetterNumber) e.g. (A1): ");
                        String userInput2 = U.scanStr("Enter your second spot (LetterNumber) e.g. (A1): ");
                        if(checkUserInput(userInput1) || checkUserInput(userInput2)) {

                        }
                        else {
                            System.out.println("Unreadable inputs, please enter in A1 format)");
                        }
                        U.clear();
                    }
            }

                break;
            case "computer":
                break;
            default:
                System.out.println("Cannot read parameter " + userType);
        }
    }

    private boolean checkIfTaken(String[] arr) {
        for(String spot : arr) {
            for(Ship ship : shipLocationArr) {
                if(ship.getSpotArr().asList().contains(spot)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkUserInput(String input) {
        return input.length() == 2 || "ABCDEFGHIJ".contains(input.substring(0, 1)) || "0123456789".contains(input.substring(1));
    }
}

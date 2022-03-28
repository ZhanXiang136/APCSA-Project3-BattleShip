/**
 * This class represents a Board object
 *
 * @author Zhan Xiang Zheng
 */

public class Board {
    /** Symbols for Columns */
    public static final String[] COLUMN_SYMBOLS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    /** 2D Array of BattleShip Board */
    private Space[][] board;

    /** Array of ships */
    private Ship[] ships;

    /**
     * Instantiates a Board object
     *
     * @param userType Type of Board
     */
    public Board(String userType) {
        board = new Space[10][10];
        ships = null;
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length;col++) {
                board[row][col] = new Space(row, col);
            }
        }

        fillBoard(userType);
    }

    /**
     * Fills the board with ships
     *
     * @param userType Type of Board
     */
    private void fillBoard(String userType) {
        if(!userType.equals("computer")) {
            ships = new Ship[]{new Ship("Carrier", 5), new Ship("Battleship", 4), new Ship("Cruiser", 3), new Ship("Submarine", 3), new Ship("Destroyer", 2)};
            for(int i = 0; i < 5; i++) {
                while (true) {
                    printBoard();
                    U.println("Where do you want to put your " + ships[i].getName() + ", which takes up " + ships[i].getNumOfSpots() + " spaces?");
                    String userInput1 = U.scanStr("Enter your first spot (LetterNumber) e.g. (A1): ").toUpperCase();
                    String userInput2 = U.scanStr("Enter your last spot (LetterNumber) e.g. (A1): ").toUpperCase();
                    if (checkUserInput(userInput1) && checkUserInput(userInput2)) {
                        if (!userInput2.equals(userInput1)) {
                            Space[] tempArr = fillSpots(userInput1, userInput2, ships[i].getNumOfSpots());
                            if (tempArr[tempArr.length - 1] != null) {
                                if (!checkIfTaken(tempArr)) {
                                    ships[i].addSpaces(tempArr);
                                    U.println(ships[i].getName() + " successfully added");
                                    break;
                                } else {
                                    U.println("The range you chose is already occupied by another ship");
                                }
                            } else {
                                U.println("Range is not " + ships[i].getNumOfSpots() + " spaces long");
                            }
                        } else {
                            U.println("Starting and ending range is the same");
                        }
                    } else {
                        U.println("Unreadable inputs, please enter in 'A1' format");
                    }
                    U.println("");
                }
                U.println("");
            }
        }
    }

    /**
     * Instantiates a Board object
     *
     * @param input string of user input
     * @return if input is a possible space in the 2D Board
     */
    public static boolean checkUserInput(String input) {
        return input.length() == 2 && "ABCDEFGHIJ".contains(input.substring(0, 1)) && "0123456789".contains(input.substring(1));
    }

    /**
     * Create an array of spaces the new ship will take up
     *
     * @param starting starting coordinate of ship
     * @param ending ending coordinate of ship
     * @param size number of spaces the ship takes up
     * @return new array of spots the ship will take up
     */
    private Space[] fillSpots(String starting, String ending, int size) {
        Space[] tempArr = new Space[size];
        int startingRow = 0;
        int startingCol = 0;

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                if(board[row][col].getCoord().equals(starting)) {
                    startingRow = col;
                    startingCol = row;
                }
            }
        }

        if(starting.substring(0,1).compareTo(ending.substring(0,1)) > 0) {
            for(int i = 0; i < size; i++) {
                tempArr[i] = board[startingRow][startingCol-i];
            }
        }
        else if(starting.substring(0,1).compareTo(ending.substring(0,1)) < 0) {
            for(int i = 0; i < size; i++) {
                tempArr[i] = board[startingRow][startingCol+i];
            }
        }
        else {
            if(starting.substring(1).compareTo(ending.substring(1)) > 0) {
                for(int i = 0; i < size; i++) {
                    tempArr[i] = board[startingRow-i][startingCol];
                }
            }
            else if (starting.substring(1).compareTo(ending.substring(1)) < 0) {
                for(int i = 0; i < size; i++) {
                    tempArr[i] = board[startingRow+i][startingCol];
                }
            }
        }
        return tempArr;
    }

    /**
     * Check if one of the ship's shop is already occupied
     *
     * @param spaceArr Spaces the ship will takes up
     */
    private boolean checkIfTaken(Space[] spaceArr) {
        for(Space spot : spaceArr) {
            for(Ship ship : ships) {
                if(ship.getSpaces()[0] == null) {
                    break;
                }
                for(Space shipSpace : ship.getSpaces()) {
                    if(shipSpace.equals(spot)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Attack a space on the 2D board
     *
     * @param coord coordinate of space that was attacked
     */
    public void attacked(String coord) {
        int col = 0;
        int row = Integer.parseInt(coord.substring(1));

        for(int i = 0; i < COLUMN_SYMBOLS.length; i++) {
            String firstCoord = coord.substring(0,1);
            if(firstCoord.equals(COLUMN_SYMBOLS[i])) {
                col = i;
                break;
            }
        }

        if(board[row][col].getStatus().equals("empty")) {
            board[row][col].setStatus("miss");
            U.println("You hit nothing");
        }
        else if(board[row][col].getStatus().equals("miss") || board[row][col].getStatus().contains("hit")) {
            U.println("You hit the same spot again, git gud");
        }
        else{
            Space tempSpace = board[row][col];
            board[row][col].setStatus(board[row][col].getStatus()+"-hit");
            for(Ship ship : ships) {
                for(Space space :ship.getSpaces()) {
                    if(space.equals(tempSpace)) {
                        U.println("You hit something!");
                        ship.hit(tempSpace.getCoord());
                        break;
                    }
                }
            }
        }
        U.clear();
    }

    /**
     * Check if all ships had sunk
     *
     */
    public boolean gameIsOver() {
        for(Ship ship : ships) {
            if(ship.isFlaot()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Prints out the board from player's Point of View
     *
     */
    public void printBoard() {
        System.out.println("  A B C D E F G H I J");
        int idx = 0;
        for(Space[] row : board) {
            System.out.print(idx + " ");
            for(Space ele : row) {
                System.out.print(ele.getSymbol() + " ");
            }
            idx++;
            System.out.println(" ");
        }
    }

    /**
     * Prints out the board from the other Point of View
     *
     */
    public void printOtherBoard() {
        System.out.println("  A B C D E F G H I J");
        int idx = 0;
        for(Space[] row : board) {
            System.out.print(idx + " ");
            for(Space ele : row) {
                if(ele.getSymbol().equals("-") || ele.getSymbol().equals("X") || ele.getSymbol().equals("O")) {
                    System.out.print(ele.getSymbol() + " ");
                }
                else {
                    System.out.print("- ");
                }
            }
            idx++;
            System.out.println(" ");
        }
    }

}

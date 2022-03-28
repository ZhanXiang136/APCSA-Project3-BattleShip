/**
 * This class represents a Player object
 *
 * @author Zhan Xiang Zheng
 */

public class Player {
    /** Player's name */
    private String name;

    /** Player's board */
    private Board myBoard;

    /** Other Playere */
    private Player otherPlayer;

    /**
     * Instantiates a Player object
     *
     * @param name Player's name
     */
    public Player(String name) {
        this.name = name;
        myBoard = new Board("myBoard");
        otherPlayer = null;
    }

    /**
     * Getter for myBoard
     *
     * @return myBoard
     */
    public Board getMyBoard() { return myBoard; }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() { return name; }

    /**
     * Setter for otherPlayer
     *
     * @param player object to be set to
     */
    public void setOtherPlayer(Player player) { otherPlayer = player; }

    /**
     * Prints player's screen
     *
     */
    public void printBoards() {
        System.out.println(name + "'s Board");
        myBoard.printBoard();
        System.out.println();
        System.out.println();
        System.out.println("Marker Board");
        otherPlayer.getMyBoard().printOtherBoard();

    }
}

/**
 * This class represents a Space object
 *
 * @author Zhan Xiang Zheng
 */

public class Space {
    /** Coordinate of the Space */
    private String coord;

    /** Status of the Space */
    private String status;

    /**
     * Instantiates a Ship object
     *
     * @param row row of the ship
     * @param col col of the ship
     */
    public Space(int row, int col) {
        this.coord = Board.COLUMN_SYMBOLS[row] + col;
        this.status = "empty";
    }

    /**
     * Getter for coord
     *
     * @return coord
     */
    public String getCoord() { return coord; }

    /**
     * Getter for status
     *
     * @return status
     */
    public String getStatus() { return status; }

    /**
     * Setter for status
     *
     * @param newStatus status to be changed to
     */
    public void setStatus(String newStatus) { status = newStatus; }

    /**
     * Determine the symbol for the ship
     *
     * @return the corresponding symbol
     */
    public String getSymbol() {
        return switch (status) {
            case "empty" -> "-";
            case "miss" -> "X";
            case "Carrier" -> "5";
            case "Battleship" -> "4";
            case "Cruiser" -> "3";
            case "Submarine" -> "2";
            case "Destroyer" -> "1";
            default -> "O";
        };
    }
}

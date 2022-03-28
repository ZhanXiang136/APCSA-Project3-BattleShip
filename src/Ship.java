/**
 * This class represents a Ship object
 *
 * @author Zhan Xiang Zheng
 */

public class Ship {
    /** Name of the ship */
    private String name;

    /** Spaces the ship takes up */
    private Space[] spaces;

    /** Number of spots the ship takes up */
    private int numOfSpots;

    /** Whether the ship is still afloat */
    private boolean floating;

    /**
     * Instantiates a Ship object
     *
     * @param name name of the ship
     * @param spaceTaken number of spaces the ship takes up
     */
    public Ship(String name, int spaceTaken) {
        this.name = name;
        numOfSpots = spaceTaken;
        spaces = new Space[spaceTaken];
        floating = true;
    }

    /**
     * Getter method for name
     *
     * @return name
     */
    public String getName() { return name; }

    /**
     * Getter method for spaces
     *
     * @return spaces
     */
    public Space[] getSpaces() { return spaces; }

    /**
     * Getter method for numOfSpots
     *
     * @return numOfSpots
     */
    public int getNumOfSpots() { return numOfSpots; }

    /**
     * Getter method for isFloat
     *
     * @return isFloat
     */
    public boolean isFlaot() { return floating; }

    /**
     * Adds in the spaces for the ship on the Board
     *
     * @param spaces spaces to be added
     */
    public void addSpaces(Space[] spaces) {
        this.spaces = spaces;
        for(Space space : this.spaces) {
            space.setStatus(name);
        }
    }

    /**
     * Change the space's status that got hit on the ship
     *
     */
    public void hit(String coord) {
        for(int i = 0; i < spaces.length; i++) {
            if(spaces[i].getCoord().equals(coord)) {
                spaces[i].setStatus("hit");
                if(!checkIsFloat()){
                    U.println(name + " has sunk");
                    floating = false;
                }
            }
        }
    }

    /**
     * Checks if all spaces on the ship
     *
     * @return condition of the ship
     */
    private boolean checkIsFloat() {
        for(Space space : spaces) {
            if(space.getStatus().equals(name)) {
                return true;
            }
        }
        return false;
    }
}

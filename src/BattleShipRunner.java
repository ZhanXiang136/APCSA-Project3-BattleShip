/**
 * This class represents a BattleShipRunner object
 *
 * @author Zhan Xiang Zheng
 */

public class BattleShipRunner {
    /** Player 1 Object */
    private Player player1;

    /** Player 2 Object */
    private Player player2;

    /**
     * Starts playing the game
     */
    public void play() {
        introduction();
        Player currentPlayer = player1;
        Player otherPlayer = player2;

        boolean run = true;
        while(run) {
            while (true) {
                U.clearScreen();
                U.println(currentPlayer.getName() + "'s turn, Look away " + otherPlayer.getName());
                U.clear();
                U.println(currentPlayer.getName() + ("'s turn"));
                currentPlayer.printBoards();
                String hit = U.scanStr("Where do you want to attack?: ").toUpperCase();
                if (hit.length() > 0 && Board.checkUserInput(hit)) {
                    otherPlayer.getMyBoard().attacked(hit);

                    if(otherPlayer.getMyBoard().gameIsOver()) {
                        currentPlayer.printBoards();
                        U.println("Game Over, " + currentPlayer.getName() + " wins!");
                        run = false;
                        break;
                    }
                    U.println("");
                    currentPlayer.printBoards();
                    break;
                } else {
                    U.println("Invalid Input");
                }
            }

            if(currentPlayer.equals(player1)) {
                currentPlayer = player2;
                otherPlayer = player1;
            }
            else {
                currentPlayer = player1;
                otherPlayer = player2;
            }
        }
    }

    /**
     * Print the introduction of the game and set up the Player objects
     */
    public void introduction() {
        U.println("Welcome to BattleShip");
        U.println("Symbols on the Board: ");
        U.println("1-5 : Ships");
        U.println("- : Empty Space");
        U.println("X : Miss");
        U.println("O : Hit");
        U.println("Open terminal on full screen for best experience");
        U.clear();

        U.println("Player 1 first, Player 2 look away");
        while (true) {
            String name = U.scanStr("What is your name Player 1?: ");
            if(name.length() == 0) {
                U.println("Bad Input");
            }
            else {
                player1 = new Player(name);
                break;
            }
            U.println("");
        }

        U.clearScreen();
        U.println("Player 2's turn, Player 1 look away");
        U.clear();

        while (true) {
            U.println("");
            String name = U.scanStr("What is your name Player 2?: ");
            if(name.length() == 0) {
                U.println("Bad Input");
            }
            else {
                player2 = new Player(name);
                break;
            }
        }
        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        U.clearScreen();
    }
}

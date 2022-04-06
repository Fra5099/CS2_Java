package pokerGame;

import java.util.Scanner;

/**
 * A human player for 2-card poker.
 * It depends on user input to decide whether to stand or fold.
 *
 * @author RIT CS
 * @author Faisal Alzahrany
 */
public class Human extends Player {
	private Scanner in;



    /**
     * Initialize a human player for 2-card poker
	 * @param in the Scanner object to be used to prompt user for stand/fold
     */
    public Human( Scanner in) {
		super();
		this.in=in;
    }

    /**
     * Ask the player if they want to stand.
     * The player is prompted with a suitable message, and then
     * the players response from the Scanner is converted to
     * true (stand) or false (fold).
     *
     * @return true iff the human wants to stand
     */
    public boolean stand() {
		System.out.printf("Do you want to stand for this round?");
		String answer = in.nextLine();
		if (answer.equals("y")){
			return true;
		}
		else {
			return false;
		}
    }

	/**
	 * Get a string representing this human player
	 * @return all the information in {@link Player#toString()}, plus "Human"
	 */
	@Override
	public String toString() {

		return "Human "+ super.toString();
	}
}

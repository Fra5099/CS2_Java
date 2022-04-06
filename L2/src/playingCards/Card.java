package playingCards;

/**
 * A class represent a playing card for the poker
 * @author Faisal Alzahrany
 */

public class Card {
    /**
     * the Rank of the card
     */
    private Rank rank;
    /**
     * the Suit of the card
     */
    private Suit suit;

    /**
     * Create a specific card
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suit suit){
        this.rank=rank;
        this.suit=suit;
    }

    /**
     * A method returns the numerical value of the card
     * @return the numerical value of the card
     */
    public int value(){
        return rank.getValue();
    }

    /**
     * Accessor for the rank
     * @return the rank of the card
     */
    public Rank getRank(){
        return this.rank;
    }

    /**
     * accessor for the suit
     * @return the suit of the card
     */
    public Suit getSuit(){
        return this.suit;
    }

    /**
     * A method returns a long name for the card, ie "THREE of CLUBS"
     * @return the long name of the card
     */
    @Override
    public String toString() {
        return rank+ " of " + suit;
    }

    /**
     * A method returns a short name for the card
     * @return the short name of the card
     */
    public String getShortName(){
        return rank.getShortName()+suit.getShortName();
    }



}

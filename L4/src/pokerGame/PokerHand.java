package pokerGame;

import playingCards.Card;
import playingCards.Rank;
import playingCards.Suit;

/**
 * A class to encapsulate a hand of cards for a 2-card poker game
 *
 * @author RIT CS
 * @author Faisal Alzahrany
 */
public class PokerHand implements Comparable< PokerHand > {

    private Card card_a=null;
    private Card card_b=null;

    /**
     * Initialize a poker hand.
     * @rit.post The hand has no cards
     */
    public PokerHand() {
    }

    /**
     * Add a card to the hand.
     * This method must be called exactly twice because a hand size is 2.
     *
     * @param card the card to add to hand
     * @rit.post cards are in sorted order
     */
    public void addCard( Card card ) {
        if (card_a == null){
            card_a=card;

        }
        else {
            card_b=card;
        }
    }

    /**
     * What kind of hand is this?
     *
     * @return one of the {@link HandType} designations
     * @rit.pre addCard has been called twice
     */
    HandType getType() {
        if (card_a.getRank()==card_b.getRank()){
            return HandType.TWO_OF_KIND;
        }
        if (card_a.getSuit()==card_b.getSuit()){
            return HandType.FLUSH;
        }
        return HandType.REGULAR;
    }

    /**
     * this method sort the cards in the hand from high to low
     */
    public void sortCards(){
        Card high=card_a;
        Card low=card_b;

        if (card_a.compareTo(card_b)==-1){
            card_a=low;
            card_b=high;
        }

    }

    /**
     * Show this hand's contents.
     *
     * @return a string containing all the cards in the hand
     */
    public String toString() {
        return "First Card: "+card_a+", Second Card: "+ card_b + " Hand type: "+getType();
    }

    /**
     * Does this hand beat another hand?<br>
     * Rules
     * <ul>
     *     <li>
     *         Pair beats flush, which beats two arbitrary cards.
     *     </li>
     *     <li>
     *         Otherwise compare higher card ranks.
     *     </li>
     *     <li>
     *         If higher card ranks are the same, compare lower card ranks.
     *     </li>
     *     <li>
     *         If both card ranks are the same, return 0 -- hands are identical.
     *     </li>
     * </ul>
     */
    @Override
    public int compareTo( PokerHand other ) {
        sortCards();
        other.sortCards();
        if (getType()==HandType.TWO_OF_KIND && (other.getType()==HandType.FLUSH || other.getType()==HandType.REGULAR)){
            return 1;
        }
        if (getType()==HandType.FLUSH && other.getType()==HandType.REGULAR){
            return 1;
        }
        if (getType()==other.getType()){
            if (card_a.getRank()==other.card_a.getRank()){
                if (card_b.getRank()==other.card_b.getRank()){
                    return 0;
                }
                if (card_b.compareTo(other.card_b)==1){
                    return 1;
                }
                if (card_b.compareTo(other.card_b)==0){
                    return 0;
                }
            }
            if (card_a.compareTo(other.card_a)==1){
                return 1;
            }
            if (card_a.compareTo(other.card_a)==0){
                return 0;
            }
        }
        return -1;
    }

}

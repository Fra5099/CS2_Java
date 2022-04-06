package miniPoker;

import playingCards.Card;

/**
 * A class represent a computer player for 2-card poker
 * @author Faisal Alzahrany
 */

public class Computer {
    /**
     * This represent the first card
     */
    private Card card_a=null;

    /**
     * This represent the second card
     */
    private Card card_b=null;

    /**
     * A method determines if the computer is going to stand or fold by the chance of winning.
     * if the chance of winning is greater than 50% then the computer is going to stand
     * @return
     */
    public boolean stand(){
        if (card_a.getSuit()==card_b.getSuit()){
            return true;
        }
        else {
            if (card_a.getRank()==card_b.getRank()){
                return true;
            }
            if ((card_a.value()+card_b.value())>=23){
                return true;
            }
            if (card_a.getShortName().equals(" K") && card_b.getShortName().equals(" K")){
                return true;
            }
            if (card_a.getShortName().equals(" A") && card_b.getShortName().equals(" A")){
                return true;
            }
            else {
                return false;
            }
        }

    }

    /**
     * A method adds a card to the player's hand
     * @param c the card that is going to be added
     */
    public void addCard(Card c){
        if (card_a == null){
            card_a=c;

        }
        else {
            card_b=c;
        }
    }

    /**
     * this method print the cards in the player's hand
     */
    public void printHand(){
        System.out.println("Cards in the hand: "+ card_a+", "+ card_b);
    }

    /**
     * this method clear all the cards in the player's hand
     */
    public void newHand(){
        card_a=null;
        card_b=null;
    }

    /**
     * this method calculate the value of the player's hand depending on the cards
     * @return the value of the player hand
     */
    public int value(){
        int High_Value=0;
        int Low_Value=0;
        if (card_a.value()>=card_b.value()){
            High_Value=card_a.value();
            Low_Value=card_b.value();
        }

        if (card_a.value()<card_b.value()){
            High_Value=card_b.value();
            Low_Value=card_a.value();
        }

        if (card_a.value()==card_b.value()){
            return (High_Value*14)+Low_Value+1000;
        }
        if (card_a.getSuit().equals(card_b.getSuit())){
            return (High_Value*14)+Low_Value+500;
        }
        return (High_Value*14)+Low_Value;
    }


}

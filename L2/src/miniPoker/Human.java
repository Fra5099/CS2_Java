package miniPoker;

import playingCards.Card;

import java.util.Scanner;

/**
 * A class represent a human player for 2-card poker
 * @author Faisal Alzahrany
 */

public class Human {
    /**
     * Scanner to initialize a human player
     */
    private Scanner in;

    /**
     * This represent the first card
     */
    private Card card_a=null;

    /**
     * This represent the second card
     */
    private Card card_b=null;


    /**
     * Initialize a human player for 2-card poker
     * @param in Scanner to initialize a human player
     */
    public Human(Scanner in){
        this.in = in;


    }

    /**
     * A method ask if the player want to (y)stand or (n)fold
     * @return
     */
    public boolean stand(){

        if (in.equals("y")){
            return true;
        }
        else {
            return false;
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


    /**
     * this method compare the human's hand with the computer's hand
     * @param computer the player represented by the computer
     * @return An integer which is going to be -1(if the computer's hand value greater than the human)
     * or 1(if the human hand value greater than the computer) or 0(if they have same value).
     */
    public int compareTo(Computer computer){
        if (computer.value()>value()){
            return -1;
        }
        if (computer.value()<value()){
            return 1;
        }
        return 0;
    }



}

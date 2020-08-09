package uno;

/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author Sivagama
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <UnoCards> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
    }



    public GroupOfCards() {

        /*
         * The constructor creates a new cards
         * There are 4 colors: red, blue, green, yellow
         * Each suit has two of the same card except 0 (it only appears once in each suit).
         * For example: green suit has two 1s but only 1 zero
         */


        cards = new ArrayList<UnoCards>();
        String[] colors = {"red","blu","grn","ylw"};
        int[] numbers = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,0}; //regular cards
        int[] specialnumbers = {2,2,4,4}; //special cards +2, +2, +4 and +4


        for(String c:colors) { //adding regular cards to the cards
            for(int i:numbers) {
                cards.add(new UnoCards(i,c)); //adding new cards to our cards
            }
        }


        for(int i:specialnumbers) { //adding special cards to the cards
            cards.add(new UnoCards(i));
        }



    }


    public GroupOfCards(ArrayList<UnoCards> c) { //overloaded constructor
        /*
         * incase the current cards becomes empty, all the thrown cards are collected and it becomes the new cards;
         *
         */
        cards = c;
    }


    public boolean isEmpty() {
        if(cards.size()>0) {
            return false;
        }
        return true;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public UnoCards getTopCard() {
        return cards.remove(cards.size()-1);
    }

    public UnoCards peek() {
        return cards.get(cards.size()-1);
    }


    public String toString() {
        String cards="";
        for(Card c:this.cards) {
            cards = cards +c+ " ";
        }
        return cards;

    }
    
    
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<UnoCards> showCards()
    {
        return cards;
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
}//end class

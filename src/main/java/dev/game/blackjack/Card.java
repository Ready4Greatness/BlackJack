//******************************************************************************
// FILE: Card.java
//
// DESCRIPTION: Class describing the details of the card in the game Black Jack
//
// SOFTWARE HISTORY: //
// 12OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************
package dev.game.blackjack;

/**
 *
 * @author Treshauna Wright
 */
public class Card
{
    public enum Suit
    {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    public enum  Rank
    {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    //**************************************************************************
    // Data Members
    //**************************************************************************

    private final Suit theSuit;

    private final Rank theRank;

    //**************************************************************************
    // Methods
    //**************************************************************************

    /**
     * Creates a card with the specified suit and rank.
     * @param cardSuit the suit to set for this card
     * @param cardRank the rank to set for this card
     */
    public Card(Suit cardSuit, Rank cardRank)
    {
        theSuit = cardSuit;
        theRank = cardRank;
    }

    /**
     * Gets the suit of this card.
     * @return card suit
     */
    public Suit getSuit()
    {
        return theSuit;
    }

    /**
     * Gets the rank of this card.
     * @return card rank
     */
    public Rank getRank()
    {
        return theRank;
    }
    
    /* Return the card's rank as an integer.
     * @return the value of the card 
     */
     public int getRankValue()
     {

         switch (theRank)
         {
            case ACE:        return 1;
            case TWO:        return 2;
            case THREE:      return 3;
            case FOUR:       return 4;
            case FIVE:       return 5;
            case SIX:        return 6;
            case SEVEN:      return 7;
            case EIGHT:      return 8;
            case NINE:       return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:      // fall through intentional
            {
                return 10;
            }
            default:         return 0;
         }
     }

    /* Return a String representing the card's suit.
    * @return the string representing the card's suit
    */
    private String getSuitString()
    {
        switch (theSuit)
        {
            case CLUBS:          return "Clubs";
            case DIAMONDS:       return "Diamonds";
            case HEARTS:         return "Hearts";
            case SPADES:         return "Spades";
            default:             return "";
        }
    }

    /* Return a String representing the card's rank.
    * @return the string representing the card's rank
    */
    private String getRankString()
    {

        switch (theRank)
        {
           case ACE:        return "Ace";
           case TWO:        return "2";
           case THREE:      return "3";
           case FOUR:       return "4";
           case FIVE:       return "5";
           case SIX:        return "6";
           case SEVEN:      return "7";
           case EIGHT:      return "8";
           case NINE:       return "9";
           case TEN:        return "10";
           case JACK:       return "Jack";
           case QUEEN:      return "Queen";
           case KING:       return "King";
           default:         return "";
        }
    }
   
    /* Return a String representing the card.
    * @return the string representing the card's suit and rank
    */
    @Override
    public String toString()
    {
        return getRankString() + " of " + getSuitString();
    }
    
    /* Return true if the rank and suit are equal to the current card.
     * @return true if true, false otherwise
     */
    public boolean equals(Card card)
    {
        return (( (theRank == card.getRank()) && (theSuit == card.getSuit()) ));
    }
}

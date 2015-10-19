//******************************************************************************
// FILE: DeckOfCards.java
//
// DESCRIPTION: Class describing the details of the card in the game Black Jack
//
// SOFTWARE HISTORY: //
// 12OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************
package dev.game.blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Treshauna Wright
 */
public class DeckOfCards
{
    //**************************************************************************
    // Data Members
    //**************************************************************************

    /// Maximum number of cards the deck can have
    public final int MAX_NUMBER_CARDS = 52;

    /// The deck of cards for the current game
    private static ArrayList<Card> theDeck;
    
    /// index of first card in deck
    private static final int FIRST_CARD_INDEX = 0;

    //**************************************************************************
    // Methods
    //**************************************************************************

    /**
     * Constructor
     */
    public DeckOfCards()
    {
        // Build the deck of cards
        theDeck = new ArrayList<Card>();

        int cardCount = 0;     // How many cards have been created so far.
        for (Card.Suit suit : Card.Suit.values())
        {
            for (Card.Rank rank : Card.Rank.values())
            {
                theDeck.add(new Card(suit, rank));
                cardCount++;
            }
        }

        if (cardCount != MAX_NUMBER_CARDS)
        {
            throw new RuntimeException("The number of cards in the deck " +
                                       "should equal " + MAX_NUMBER_CARDS + ".");
        }
    }

    /**
     * Puts all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffleDeck()
    {
        // shuffle deck
        Collections.shuffle(theDeck);
    }

    /**
     * Gets the number of remaining cards in the deck
     * @return the number of remaining cards in the deck
     */
    public int getCardsRemaining()
    {
        return theDeck.size();
    }

    /**
     * Removes a card a deck and deals to either the player or dealer
     * @return the card which is removed from the deck.
     * @throws RuntimeException if there are no cards left in the deck
     */
    public static Card dealCard()
    {
        if (theDeck.isEmpty())
        {
            throw new RuntimeException("No cards are left in the deck.");
        }

        // removes first card in deck
        Card cardToDeal = theDeck.remove(FIRST_CARD_INDEX);

        return cardToDeal;
    }

    /**
     * Prints the deck of cards
     * @return String representation of cards in deck
     * */
    @Override
    public String toString()
    {
    
     StringBuilder retVal = new StringBuilder("");
    
        for (Card card : theDeck)
        {
            retVal.append(card.toString()).append("\n");
        }
        
        return retVal.toString();
    }

}

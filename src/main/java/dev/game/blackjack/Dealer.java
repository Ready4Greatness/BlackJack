//******************************************************************************
// FILE: Dealer.java
//
// DESCRIPTION: Class to describe the dealer
//
// SOFTWARE HISTORY: //
// 13OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************

package dev.game.blackjack;

import java.util.ArrayList;

/**
*
* @author Treshauna Wright
*/
public class Dealer
{
    //**************************************************************************
    // Data Members
    //**************************************************************************
    /// Black Jack win value 
    private static final int DEALER_MIN_STAY_VALUE = 17;
    
    /// name of the dealer
    private final String theDealerName;

    /// list of the dealers cards
    private final ArrayList<Card> theDealerHand;

    //**************************************************************************
    // Methods
    //**************************************************************************
    /*
     * Constructor
     * 
     */
    public Dealer(String name)
    {
        theDealerName = name;
        theDealerHand = new ArrayList<Card>();
    }
    
    /**
     * See PlayerInterface::addCardToHand()
     * @param card the card to add to the dealer's hand
     */
    public void addCardToHand(Card card)
    {
        theDealerHand.add(card);
    }
    
    /**
     * See PlayerInterface::turn()
     */
    public void turn()
    {
        System.out.println("\nIt's the dealer's turn.");
        
        System.out.println("Dealer's hand consists of:\n");
        displayCards();
        
        while (!isOverTwentyOne() && !shouldStay())
        {
            hit();
        }
    }

    /**
     * See PlayerInterface::hit()
     */
    private void hit()
    {
        System.out.println("\nDealer takes a card.");
        theDealerHand.add(DeckOfCards.dealCard());
        Card receivedCard = theDealerHand.get(theDealerHand.size() - 1);
        System.out.println("Dealer drew a " + receivedCard.toString() + ".");
    }

    /**
     * See PlayerInterface::shouldStay()
     */
    private boolean shouldStay()
    {
        boolean shouldStay = true;
        
        // determine if new total is greater than 21
        
        if (getTotal() < DEALER_MIN_STAY_VALUE)
        {
            shouldStay = false;
        }
        
        return shouldStay;
    }
    
    /**
     * See PlayerInterface::isOverTwentyOne()
     */
    private boolean isOverTwentyOne()
    {
        boolean retVal = false;
        
        if (getTotal() > BlackJackGame.BLACKJACK_WIN_VALUE)
        {
            System.out.println("Dealer's total is greater than " + BlackJackGame.BLACKJACK_WIN_VALUE +
                               ". Dealer's turn is over.");
            retVal = true;
        }
        
        return retVal; 
    }
    
    /**
     * PlayerInterface::getTotal()
     * @return the total of the card's in the dealer's hand
     */
    public int getTotal()
    {
        int totalValue = 0;
        boolean containsAce = false;

        for (Card card : theDealerHand)
        {
            if (card.getRank() == Card.Rank.ACE)
            {
                containsAce = true;
            }
            int cardValue = card.getRankValue();
            totalValue = totalValue + cardValue;
        }
        
        if (containsAce && 
            ((totalValue + PlayerInterface.ACE_FACE_VALUE_DIFFERENCE) <= BlackJackGame.BLACKJACK_WIN_VALUE))
        {
            totalValue += PlayerInterface.ACE_FACE_VALUE_DIFFERENCE;
        }

        return totalValue;
    }    
    
    /**
     * PlayerInterface::getName()
     * @return the dealer's name
     */
    public String getName()
    {
        return theDealerName;
    }
    
    /**
     * PlayerInterface::clearHand()
     */
    public void clearHand()
    {
        theDealerHand.clear();
    }
    
    /**
     * PlayerInterface::getNumberCards()
     * @return the number of cards in the dealer's hand
     */
    public int getNumberCards()
    {
        return theDealerHand.size();
    }
    
    /**
     * PlayerInterface::displayCards()
     */
    public void displayCards()
    {
        for (Card card : theDealerHand)
        {
            System.out.println(card.toString());
        }
    }
}

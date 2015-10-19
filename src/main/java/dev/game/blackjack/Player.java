//******************************************************************************
// FILE: Player.java
//
// DESCRIPTION: Class describing the details of the player
//
// SOFTWARE HISTORY: //
// 13OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************
package dev.game.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Treshauna Wright
 */
public class Player
{
    //**************************************************************************
    // Data Members
    //**************************************************************************
    /// name of the player
    private final String thePlayerName;

    /// list of the player's cards
    private final ArrayList<Card> thePlayerHand;
    
    /// Scanner for user input
    private final Scanner theScanner;

    //**************************************************************************
    // Methods
    //**************************************************************************
    /*
     * Constructor
     * 
     */
    public Player(String name, Scanner scanner)
    {
        thePlayerName = name;
        thePlayerHand = new ArrayList<Card>();
        theScanner    = scanner;
    }
    
    /**
     * See PlayerInterface::addCardToHand()
     * @param card the card to add to the player's hand
     */
    public void addCardToHand(Card card)
    {
        thePlayerHand.add(card);
    }
    
    /**
     * See PlayerInterface::turn()
     */
    public void turn()
    {
        System.out.println("\n" + thePlayerName + ", your hand consists of:\n");
        displayCards();
        
        while (!isOverTwentyOne() && !shouldStay())
        {
            hit();
        }
    }

    /**
     * See PlayerInterface::hit()
     */
    public void hit()
    {
        thePlayerHand.add(DeckOfCards.dealCard());
        Card receivedCard = thePlayerHand.get(thePlayerHand.size() - 1);
        System.out.println("You drew a " + receivedCard.toString() + ".");
    }

    /**
     * See PlayerInterface::shouldStay()
     */
    private boolean shouldStay()
    {
        boolean wantToStay = false;
        boolean validInput = false;

        //Scanner userInput = new Scanner(System.in);
        String shouldStayString = "\nWould you like to \"hit\"? (yes/no) ";
        do
        {
            System.out.println(shouldStayString);
            String userAnswer = theScanner.nextLine().toLowerCase();
            
            if (userAnswer.equals("yes"))
            {
                wantToStay = false;
                validInput = true;
            }
            else if (userAnswer.equals("no"))
            {
                wantToStay = true;
                validInput = true;
            }
            else
            {
                // Input is not valid...ask player again
                shouldStayString = "\nYou have entered an invalid answer.  " +
                                   "Please enter a valid response.  Would you " +
                                   " like to \"hit\"? (yes/no) ";
            }
        } while(!validInput);

        return wantToStay;
    }
    
    /**
     * See PlayerInterface::isOverTwentyOne()
     * @return true if player's hand total is over 21, false otherwise
     */
    public boolean isOverTwentyOne()
    {
        boolean retVal = false;
        
        if (getTotal() > BlackJackGame.BLACKJACK_WIN_VALUE)
        {
            System.out.println("Your total is greater than " + BlackJackGame.BLACKJACK_WIN_VALUE +
                               ". Your turn is over.");
            retVal = true;
        }
        
        return retVal; 
    }
    
    /**
     * PlayerInterface::getTotal()
     * @return the total of the player's hand
     */
    public int getTotal()
    {
        int totalValue = 0;
        boolean containsAce = false;

        for (Card card : thePlayerHand)
        {
            if (card.getRank() == Card.Rank.ACE)
            {
                containsAce = true;
            }
            int cardValue = card.getRankValue();
            totalValue += cardValue;
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
     * @return player's name
     */
    public String getName()
    {
        return thePlayerName;
    }
    
    /**
     * PlayerInterface::clearHand()
     */
    public void clearHand()
    {
        thePlayerHand.clear();
    }
    
    /**
     * PlayerInterface::getNumberCards()
     * @return number of cards in player's hand
     */
    public int getNumberCards()
    {
        return thePlayerHand.size();
    }
    
    /**
     * PlayerInterface::displayCards()
     */
    public void displayCards()
    {
        for (Card card : thePlayerHand)
        {
            System.out.println(card.toString());
        }
    }
}

//******************************************************************************
// FILE: DealerTest.java
//
// DESCRIPTION: JUnit test class for Dealer class
//
// SOFTWARE HISTORY: //
// 13OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************
package dev.game.blackjack;

import static org.junit.Assert.*;
import org.junit.Test;

/**
*
* @author Treshauna Wright
*/
public class DealerTest
{
    @Test
    public void testGetName()
    {
        System.out.println("***** Running Get Dealer's Name Test *****\n");
        
        String dealerName = "Treshauna";
        
        Dealer dealer = new Dealer(dealerName);
        assertNotNull(dealer);
        
        // Print dealer's name
        System.out.println("The dealer's name is " + dealer.getName() + ".\n");        
        assertEquals(dealerName, dealer.getName());
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testClearHand()
    {
        System.out.println("***** Running Clear Dealer's Hand Test *****\n");
        
        String dealerName = "Robert";
        
        Dealer dealer = new Dealer(dealerName);
        assertNotNull(dealer);
        
        DeckOfCards deckOfCards = new DeckOfCards();
        assertNotNull(deckOfCards);
        
        // shuffle deck
        deckOfCards.shuffleDeck();
        
        // deal 2 cards
        Card card1 = DeckOfCards.dealCard();
        Card card2 = DeckOfCards.dealCard();
        
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card2);
        
        // Display cards
        System.out.println("Displaying card(s) dealt:");
        System.out.println(card1.toString());
        System.out.println(card2.toString() + "\n");
        
        // Dealer should have 2 cards in his hand
        assertEquals(2, dealer.getNumberCards());
        
        // Clear dealers hand
        dealer.clearHand();
        
        // Dealer should have 0 cards in his hand
        assertEquals(0, dealer.getNumberCards());
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testDealerTurn()
    {
        System.out.println("***** Running Dealer's Turn Test *****\n");
        
        String dealerName = "Benny";
        
        Dealer dealer = new Dealer(dealerName);
        assertNotNull(dealer);
        
        DeckOfCards deckOfCards = new DeckOfCards();
        assertNotNull(deckOfCards);
        
        // shuffle deck
        deckOfCards.shuffleDeck();
        
        // deal 2 cards
        Card card1 = DeckOfCards.dealCard();
        Card card2 = DeckOfCards.dealCard();
        
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card2);
        
        // Display cards
        System.out.println("Displaying card(s) dealt:");
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        
        // Dealer should have 2 cards in his hand
        assertEquals(2, dealer.getNumberCards());
        
        // Clear dealers hand
        dealer.turn();
        
        System.out.println("\nDealer's turn is over.\n");
        
        System.out.println("Test passed.\n\n");
    }
}

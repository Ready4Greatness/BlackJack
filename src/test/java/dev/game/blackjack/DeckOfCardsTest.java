//******************************************************************************
// FILE: DeckOfCardsTest.java
//
// DESCRIPTION: JUnit test class for DeckofCards class
//
// SOFTWARE HISTORY: //
// 13OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************
package dev.game.blackjack;

import static org.junit.Assert.*;
import org.junit.Test;

import dev.game.blackjack.Card.Suit;
import dev.game.blackjack.Card.Rank;

/**
*
* @author Treshauna Wright
*/
public class DeckOfCardsTest
{
    @Test
    public void testShuffleDeck()
    {
        System.out.println("***** Running Shuffle Deck Test *****\n");
        
        DeckOfCards deckOfCards = new DeckOfCards();
        assertNotNull(deckOfCards);
        
        // Print deck before shuffling
        System.out.println("***** Printing Deck Before Shuffle *****");
        String deckBeforeShuffle = deckOfCards.toString();
        System.out.println(deckBeforeShuffle);
        
        // Now shuffle deck
        deckOfCards.shuffleDeck();
        System.out.println("***** Printing Deck After Shuffle *****");
        String deckAfterShuffle = deckOfCards.toString();
        System.out.println(deckAfterShuffle);
        
        assertTrue(!deckBeforeShuffle.equals(deckAfterShuffle));
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testDealCardAndGetCardsRemaining()
    {
        System.out.println("***** Running Deal Card Test *****\n");
        
        DeckOfCards deckOfCards = new DeckOfCards();
        assertNotNull(deckOfCards);
        
        // deal 2 cards
        Card firstCard = DeckOfCards.dealCard();		
        Card secondCard = DeckOfCards.dealCard();
        
        // Display cards
        System.out.println("Displaying card(s) dealt:");
        System.out.println(firstCard.toString());
        System.out.println(secondCard.toString() + "\n");
        
        // Two cards from the deck have been removed so the deck should now
        // have 50 cards
        assertEquals(50, deckOfCards.getCardsRemaining());
        
        Card testCard1 = new Card(Suit.CLUBS, Rank.ACE);
        Card testCard2 = new Card(Suit.CLUBS, Rank.TWO);
        assertTrue(firstCard.equals(testCard1));
        assertTrue(secondCard.equals(testCard2));
        
        System.out.println("Test passed.\n\n");
    }
}

//******************************************************************************
// FILE: CardTest.java
//
// DESCRIPTION: JUnit test class for Card class
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
public class CardTest
{
    @Test
    public void testCardEquals()
    {
        System.out.println("***** Running Card Equals Test *****\n");
        
        Card card1 = new Card(Suit.DIAMONDS, Rank.ACE);
        Card card2 = new Card(Suit.DIAMONDS, Rank.ACE);
        
        assertNotNull(card1);
        assertNotNull(card2);
        
        System.out.println("Displaying card(s):");
        System.out.println(card1.toString());
        System.out.println(card2.toString() + "\n");
        
        assertTrue(card1.equals(card2));
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testCardNotEquals()
    {
        System.out.println("***** Running Card Not Equals Test *****\n");
        
        Card card1 = new Card(Suit.CLUBS, Rank.EIGHT);
        Card card2 = new Card(Suit.HEARTS, Rank.QUEEN);
        
        System.out.println("Displaying card(s):");
        System.out.println(card1.toString());
        System.out.println(card2.toString() + "\n");
        
        assertTrue(!card1.equals(card2));
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testGetSuit()
    {
        System.out.println("***** Running Get Card Suit Test *****\n");
        
        Card card = new Card(Suit.SPADES, Rank.KING);
        assertNotNull(card);
        
        System.out.println("Displaying card(s):");
        System.out.println(card.toString() + "\n");
        
        assertEquals(Suit.SPADES, card.getSuit());
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testGetRank()
    {
        System.out.println("***** Running Get Card Rank Test *****\n");
        
        Card card = new Card(Suit.DIAMONDS, Rank.SEVEN);
        assertNotNull(card);
        
        System.out.println("Displaying card(s):");
        System.out.println(card.toString());
        
        assertEquals(Rank.SEVEN, card.getRank());
        
        System.out.println("\nDisplay card's value: " + card.getRankValue() + "\n");
        
        System.out.println("Test passed.\n\n");
    }
}

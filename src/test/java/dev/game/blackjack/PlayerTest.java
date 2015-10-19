//******************************************************************************
// FILE: PlayerTest.java
//
// DESCRIPTION: JUnit test class for Player class
//
// SOFTWARE HISTORY: //
// 13OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************
package dev.game.blackjack;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

/**
*
* @author Treshauna Wright
*/
public class PlayerTest
{
    @Test
    public void testGetName()
    {
        System.out.println("***** Running Get Player's Name Test *****\n");
        
        String playerName = "Samuel";
        Scanner scanner = new Scanner(System.in);
        
        Player player = new Player(playerName, scanner);
        assertNotNull(player);
        
        // Print player's name
        System.out.println("The player's name is " + player.getName() + ".\n");
        assertEquals(playerName, player.getName());
        
        scanner.close();
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testClearHand()
    {
        System.out.println("***** Running Clear Player's Hand Test *****\n");
        
        String playerName = "Tina";
        Scanner scanner = new Scanner(System.in);
        
        Player player = new Player(playerName, scanner);
        assertNotNull(player);
        
        DeckOfCards deckOfCards = new DeckOfCards();
        assertNotNull(deckOfCards);
        
        // shuffle deck
        deckOfCards.shuffleDeck();
        
        // deal 2 cards
        Card card1 = DeckOfCards.dealCard();
        Card card2 = DeckOfCards.dealCard();
        
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        
        // Display cards
        System.out.println("Displaying card(s) dealt:");
        System.out.println(card1.toString());
        System.out.println(card2.toString() + "\n");
        
        // Player should have 2 cards in his hand
        assertEquals(2, player.getNumberCards());
        
        // Clear player's hand
        player.clearHand();
        
        scanner.close();
        
        // Player should have 0 cards in his hand
        assertEquals(0, player.getNumberCards());
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testPlayersTakesHit()
    {
        System.out.println("***** Running Player Takes Hit Test *****\n");
        
        String playerName = "Denise";
        Scanner scanner = new Scanner(System.in);
        
        Player player = new Player(playerName, scanner);
        assertNotNull(player);
        
        DeckOfCards deckOfCards = new DeckOfCards();
        assertNotNull(deckOfCards);
        
        // shuffle deck
        deckOfCards.shuffleDeck();
        
        // deal 2 cards
        Card card1 = DeckOfCards.dealCard();
        Card card2 = DeckOfCards.dealCard();
        
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        
        // Display cards
        System.out.println("Displaying card(s) dealt:");
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        
        // Player should have 2 cards in his hand
        assertEquals(2, player.getNumberCards());
        
        // Player takes another card
        player.hit();
        
        // Player should have 3 cards now
        assertEquals(3, player.getNumberCards());

        scanner.close();
        
        System.out.println("\nPlayer's turn is over.\n");
        
        System.out.println("Test passed.\n\n");
    }
    
    @Test
    public void testIsOverTwentyOne()
    {
        System.out.println("***** Running Is Player's Hand Over 21 Test *****\n");
        
        String playerName = "Isabel";
        Scanner scanner = new Scanner(System.in);
        
        Player player = new Player(playerName, scanner);
        assertNotNull(player);
        
        DeckOfCards deckOfCards = new DeckOfCards();
        assertNotNull(deckOfCards);
        
        // shuffle deck
        deckOfCards.shuffleDeck();
        
        // deal 2 cards
        Card card1 = DeckOfCards.dealCard();
        Card card2 = DeckOfCards.dealCard();
        
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        
        // Display cards
        System.out.println("Displaying card(s) dealt:");
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        
        // Player should have 2 cards in his hand
        assertEquals(2, player.getNumberCards());
        
        // Clear dealers hand
        while (!player.isOverTwentyOne())
        {
            System.out.println("\nCard's total: " + player.getTotal() + "\n");
            
            // give player another card to try to get hand over 21
            player.hit();
        }
        
        // Player's total should be over 21
        assertTrue(player.getTotal() > BlackJackGame.BLACKJACK_WIN_VALUE);
        
        System.out.println("\nFinal total: " + player.getTotal() + "\n");

        scanner.close();
        
        System.out.println("Test passed.\n\n");
    }
}

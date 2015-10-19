//******************************************************************************
// FILE: BlackJackGameTest.java
//
// DESCRIPTION: JUnit test class for BlackJackGame class
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
public class BlackJackGameTest
{
    public class TestPlayer extends Player
    {
        /// the total of the player's card
        protected int theTotal;
        
        public TestPlayer(String name, Scanner scanner)
        {
            super(name, scanner);
            // TODO Auto-generated constructor stub
        }
        
        private void setTotal(int total)
        {
            theTotal = total;
        }
        
        @Override
        public int getTotal()
        {
            return theTotal;
        }
    }
        
    public class TestDealer extends Dealer
    {
        /// the total of the dealer's card
        protected int theTotal;
        
        public TestDealer(String name)
        {
            super(name);
            // TODO Auto-generated constructor stub
        }
        
        private void setTotal(int total)
        {
            this.theTotal = total;
        }
        
        @Override
        public int getTotal()
        {
            return theTotal;
        }
    }
    
    @Test
    public void testDetermineWinner()
    {
        System.out.println("***** Running Determine Winner Test *****\n");
        
        String dealerName = "Frieda";
        String playerName = "Wilson";
        
        Scanner scanner = new Scanner(System.in);
        Dealer dealer = new Dealer(dealerName);
        Player player = new Player(playerName, scanner);
        
        assertNotNull(dealer);
        assertNotNull(player);
        
        BlackJackGame game = new BlackJackGame(player, dealer);
        
        int round = 0;
        
        // play ten rounds
        while (round < 10)
        {
            DeckOfCards deck = new DeckOfCards();
            deck.shuffleDeck();
            
            // clear players hands
            player.clearHand();
            dealer.clearHand();
            
            // Deal cards to players
            player.addCardToHand(DeckOfCards.dealCard());
            dealer.addCardToHand(DeckOfCards.dealCard());
            player.addCardToHand(DeckOfCards.dealCard());
            dealer.addCardToHand(DeckOfCards.dealCard());
            
            System.out.println("\nPlayer's hand: ");
            player.displayCards();
            
            dealer.turn();

            // Determine winner based on player's first 2 cards (without hits)
            // and dealer's hit/stand rules
            game.determineWinner();
            
            round++;
        }
        
        System.out.println("\nTest passed.\n\n");
    }
    
    @Test
    public void testSetTotal()
    {
        System.out.println("***** Running Set Total Test *****\n");
        
        String dealerName = "Sharon";
        String playerName = "Henry";
        
        Scanner scanner = new Scanner(System.in);
        TestDealer dealer = new TestDealer(dealerName);
        TestPlayer player = new TestPlayer(playerName, scanner);
        
        assertNotNull(dealer);
        assertNotNull(player);
        
        BlackJackGame game = new BlackJackGame(player, dealer);
        
        // both players over 21...winner is dealer
        System.out.println("\nGame 1:");
        dealer.setTotal(22);
        player.setTotal(23);
        game.determineWinner();
        
        // both players over 21...winner is dealer
        System.out.println("\nGame 2:");
        dealer.setTotal(23);
        player.setTotal(23);
        game.determineWinner();
        
        // dealer has blackjack...winner is dealer
        System.out.println("\nGame 3:");
        dealer.setTotal(21);
        player.setTotal(23);
        game.determineWinner();
        
        // player has blackjack...player is dealer
        System.out.println("\nGame 4:");
        dealer.setTotal(16);
        player.setTotal(21);
        game.determineWinner();
        
        // both players have blackjack...game is tie
        System.out.println("\nGame 5:");
        dealer.setTotal(21);
        player.setTotal(21);
        game.determineWinner();
        
        // both players have same score...game is tie
        System.out.println("\nGame 6:");
        dealer.setTotal(17);
        player.setTotal(17);
        game.determineWinner();
        
        // player's score is higher...player is winner
        System.out.println("\nGame 7:");
        dealer.setTotal(17);
        player.setTotal(18);
        game.determineWinner();
        
        // dealer's score is higher...dealer is winner
        System.out.println("\nGame 8:");
        dealer.setTotal(20);
        player.setTotal(19);
        game.determineWinner();
        
        System.out.println("\nTest passed.\n\n");
    }
   
}

//******************************************************************************
// FILE: BlackJackGame.java
//
// DESCRIPTION: Black Jack Game Main Class
//
// SOFTWARE HISTORY: //
// 12OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************
package dev.game.blackjack;

import java.util.Scanner;

/**
 *
 * @author Treshauna Wright
 */

/**
* Main class for Next Century Coding Assessment BlackJack Game
*/
public class BlackJackGame
{
    /// Static variable to hold dealer's name
    private static final String DEALER_NAME = "Chance";
    
    /// Black Jack win value 
    public static final int BLACKJACK_WIN_VALUE = 21;
    
    /// One of the two game players: Player
    private static Player thePlayer;
    
    /// One of the two game players: Dealer
    private static Dealer theDealer;
    
    private DeckOfCards theCardDeck;
    
    /**
     * Creates a Black Jack game with two players.
     * @param player the player for this game
     * @param dealer the dealer for this game
     */
    public BlackJackGame(Player player, Dealer dealer)
    {
        thePlayer = player;
        theDealer = dealer;
    }

    public static void main(String[] args)
    {
        // Main class for Next Century Coding Assessment BlackJack Game
        System.out.println("**** Welcome to the game of BlackJack *****\n");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, my name is " + DEALER_NAME + ".  " +
                           "I will be your dealer today." +
                           "\n\nWhat is your name? ");

        String playerName = scanner.nextLine();

        System.out.println("Hello " + playerName + "! Let's play Black Jack!\n");
        
        // ********************** NOTE ***************************************
        // The scanner object is passed to the Player constructor and
        // playAgain() function because having multiple scanners and closing
        // one closes the input stream on all other scanners
        // *******************************************************************
        BlackJackGame game = new BlackJackGame(new Player(playerName, scanner),
                                               new Dealer(DEALER_NAME));

        do
        {
            game.play();
        } while( game.playAgain(scanner) );
        
        System.out.println("\n" + playerName + ", thank you for playing!");
        
        scanner.close();
    }

    private void play()
    {
        System.out.println("Dealer shuffles deck.");
        
        try
        {
            theCardDeck = new DeckOfCards();
            theCardDeck.shuffleDeck();
            
            // clear players hands
            thePlayer.clearHand();
            theDealer.clearHand();
            
            System.out.println("Dealer deals cards to players.");
            
            // Deal cards to players
            thePlayer.addCardToHand(DeckOfCards.dealCard());
            theDealer.addCardToHand(DeckOfCards.dealCard());
            thePlayer.addCardToHand(DeckOfCards.dealCard());
            theDealer.addCardToHand(DeckOfCards.dealCard());
            
            // It's the player's turn 
            thePlayer.turn();
            // Now it's the dealer's turn
            theDealer.turn();
            
            // determine if there is a winner
            determineWinner();
        }
        catch (RuntimeException e)
        {
            System.out.println(e.toString());
        }
    }
    
    private boolean isTie()
    {
        boolean retVal = false;
        
        int playerTotal = thePlayer.getTotal();
        int dealerTotal = theDealer.getTotal();
        
        if (playerTotal == dealerTotal)
        {
            retVal = true;
            if ( (playerTotal == BLACKJACK_WIN_VALUE) && (dealerTotal == BLACKJACK_WIN_VALUE) )
            {
                System.out.println("Both player's have Black Jack.  The game is a tie.");
            }
            else if ( (playerTotal > BLACKJACK_WIN_VALUE) && (dealerTotal > BLACKJACK_WIN_VALUE) )
            {
                System.out.println("Both player's have over 21.  The dealer wins.");
            }
            else
            {
                System.out.println("Both player's have the same score.  The game is a tie.");
            }
        }

        return retVal;
    }
    
    public void determineWinner()
    {
        int playerTotal = thePlayer.getTotal();
        int dealerTotal = theDealer.getTotal();
        
        if (!isTie())
        {
            if (playerTotal == BLACKJACK_WIN_VALUE)
            {
                System.out.println("\nCONGRATULATIONS!!!  You have Black Jack! " + 
                                   "You win!");
            }
            else if (dealerTotal == BLACKJACK_WIN_VALUE)
            {
                System.out.println("\nThe dealer has Black Jack!  You lose!");
            }
            else if ( (playerTotal > BLACKJACK_WIN_VALUE) && (dealerTotal > BLACKJACK_WIN_VALUE) )
            {
                System.out.println("\nBoth players have over " + BLACKJACK_WIN_VALUE + 
                                   ". The dealer wins!");
            }
            else if ( (playerTotal > dealerTotal) && 
                    (playerTotal < BLACKJACK_WIN_VALUE) && (dealerTotal < BLACKJACK_WIN_VALUE))
            {
                System.out.println("\nYour total (" + playerTotal + ") is greater " +
                                   "than the dealer's total (" + dealerTotal + ").  " +
                                   "\nYou win!");
            }
            else if ( (dealerTotal > playerTotal) && 
                    (playerTotal < BLACKJACK_WIN_VALUE) && (dealerTotal < BLACKJACK_WIN_VALUE))
            {
                System.out.println("\nThe dealer's total (" + dealerTotal + ") is greater " +
                                   "than your total (" + playerTotal + ").  " +
                                   "\nYou lose!");
            }
            else if (dealerTotal > BLACKJACK_WIN_VALUE)
            {
                System.out.println("\nThe dealer has over " + BLACKJACK_WIN_VALUE + ". " +
                "You are the winner!");
            }
            else if (playerTotal > BLACKJACK_WIN_VALUE)
            {
                System.out.println("\nYou have over " + BLACKJACK_WIN_VALUE + ". " +
                "The dealer is the winner!");
            }
        }
    }

    private boolean playAgain(Scanner scanner)
    {
        boolean retVal = false;
        boolean validInput = false;
        String endOfGameString = "\nThe game is over.  Would you like to " +
                                 "play again? (yes/no) ";

        do
        {
            System.out.println(endOfGameString);

            String userAnswer = scanner.nextLine().toLowerCase();
            
            if (userAnswer.equals("yes"))
            {
                retVal = true;
                validInput = true;
            }
            else if (userAnswer.equals("no"))
            {
                retVal = false;
                validInput = true;
            }
            else
            {
                // Input is not valid...ask player again
                endOfGameString = "\n\nYou have entered an invalid answer.  " +
                                  "Please enter a valid response.  Would you " +
                                  "like to play again? (yes/no) ";
            }

        } while(!validInput);

        return retVal;
    }
}

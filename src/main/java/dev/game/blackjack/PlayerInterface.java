//******************************************************************************
// FILE: PlayerInterface.java
//
// DESCRIPTION: Interface defining players of Black Jack game
//
// SOFTWARE HISTORY: //
// 13OCT15 T. Wright
// Initial Coding.
//
//******************************************************************************
package dev.game.blackjack;

/**
 *
 * @author Treshauna Wright
 */
interface PlayerInterface
{
    /// The difference in value between for an Ace card
    static final int ACE_FACE_VALUE_DIFFERENCE = 10;
    
    /**
     * Add card to player's hand
     * Called at the beginning of game when dealing cards to each player
     */
    void addCardToHand(Card card);
    
    /**
     * Its a player's turn to play
     */
    void turn();

    /**
     * Pull a card from the deck and add it to the player's hand.
     */
    void hit();

    /**
     * Determines if player wants to stay or hit or makes decision if player is dealer
     * @return answer user provided on whether to stay or hit
     */
    boolean shouldStay();

    /**
     * Gets the total of the player's hand.
     * @return the combined total of the cards in the player's hand
     */
    int getTotal();
    
    /**
     * Gets the name of the player.
     * @return the name of player
     */
    String getName();
    
    /**
     * Removes all cards from player's hand.
     */
    void clearHand();
    
    /**
     * Determines if player's total is over 21.
     */
    void isOverTwentyOne();

    /**
     * Get number of cards in player's hand.
     */
    int getNumberCards();
    
    /**
     * Display cards in player's hand.
     */
    void displayCards();

}

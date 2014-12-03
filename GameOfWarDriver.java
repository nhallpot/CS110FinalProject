// Noah Hall-Potvin
// CS 110
// Game of War

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
	This class will be the driver for a game of war.
	There will be two users who play the game of war.
	A GUI will accompany this program.
*/
public class GameOfWarDriver
{

	private static final int CARDS_FOR_WAR = 3;

	public static void main(String [] args)
	{
		// Create a deck for both users
		Deck firstPlayerDeck = new Deck();
		Deck secondPlayerDeck = new Deck();
      

		// Shuffle each deck
		firstPlayerDeck.shuffle();
		secondPlayerDeck.shuffle();

	//************** This will be repeated until one of the decks is empty ***********/

		// Check to make sure each play has cards in their deck
		while((!(firstPlayerDeck.isEmpty()))&& (!(secondPlayerDeck.isEmpty())))
		{
			// Have each user lay down the top card off of their deck
			Card firstPlayerCard = firstPlayerDeck.dealCard();
			Card secondPlayerCard = secondPlayerDeck.dealCard();
         System.out.println(firstPlayerCard);
         System.out.println(secondPlayerCard);
         System.out.println(secondPlayerDeck.cardsRemaining());
         System.out.println(firstPlayerDeck.cardsRemaining());

			// Compare each card
			// Higher card takes the other card and adds it to their deck (make sure other deck is subtracted)
			if (firstPlayerCard.getRank() > secondPlayerCard.getRank())
			{
				firstPlayerDeck.add(secondPlayerCard);
       		firstPlayerDeck.add(secondPlayerCard);
            secondPlayerDeck.cardsRemaining();
            firstPlayerDeck.cardsRemaining();

			}
			else if (firstPlayerCard.getRank() < secondPlayerCard.getRank())
			{
				secondPlayerDeck.add(firstPlayerCard);
            secondPlayerDeck.add(secondPlayerCard);
			}

			/// If they are equal, game of war

			/// Check to make sure each player has cards in their deck
			else
			{
				// Create an array list to store the face down cards
				ArrayList<Card> warWinnings = new ArrayList<Card>(2*CARDS_FOR_WAR);

				// Make sure the decks have enough cards for a war
				if(firstPlayerDeck.cardsRemaining()>CARDS_FOR_WAR+1 && secondPlayerDeck.cardsRemaining()>CARDS_FOR_WAR+1)
				{
					/// Each player lays down 3 cards face down, and then lays down a fourth card face up
					for(int i=0;i<CARDS_FOR_WAR;i++)
					{
						Card firstPlayerWar = firstPlayerDeck.dealCard();
						Card secondPlayerWar = secondPlayerDeck.dealCard();
						warWinnings.add(firstPlayerWar);
						warWinnings.add(secondPlayerWar);
					}
					System.out.println(warWinnings.size());
					/// Comapre the cards
					///Higher card takes the other card and adds all of the cards (show all of the cards in the game of war)
				   firstPlayerCard = firstPlayerDeck.dealCard();
				   secondPlayerCard = secondPlayerDeck.dealCard();

					// Compare each card
					// Higher card takes the other card and adds it to their deck (make sure other deck is subtracted)
					if (firstPlayerCard.getRank() > secondPlayerCard.getRank())
					{
						firstPlayerDeck.add(secondPlayerCard);
					}
					else if (firstPlayerCard.getRank() < secondPlayerCard.getRank())
					{
						secondPlayerDeck.add(firstPlayerCard);
					}
				}
				else /// If the decks don't have enough cards, the one that has less cards will lose first (run out of cards first)
				{
					if(firstPlayerDeck.cardsRemaining()<secondPlayerDeck.cardsRemaining())
					{
						System.out.println("Computer Wins");
					}
					else
					{
						System.out.println("You Win!");
					}
				}	
			}


		}// ends while loop encompassing entire program
      	System.out.println(firstPlayerDeck.cardsRemaining());
      	System.out.println(secondPlayerDeck.cardsRemaining());

	}// ends main method

}// ends class
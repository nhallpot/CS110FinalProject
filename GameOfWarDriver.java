// Noah Hall-Potvin
// CS 110
// Game of War

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;


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
		Deck deck = new Deck();
      
		deck.freshDeck();
      
		// Shuffle the deck
		deck.shuffle();

		// Add the cards from the hand to each player
		for(int i=0;i<26;i++)
		{
			Card tempCard = deck.dealCard();
			firstPlayerDeck.add(tempCard);
		}
      for(int i=0;i<26;i++)
      {
         Card tempCard = deck.dealCard();
         secondPlayerDeck.add(tempCard);
      }
      Scanner keyboard = new Scanner(System.in);

	//************** This will be repeated until one of the decks is empty ***********/
      System.out.print("Battle the computer?: (y/n) ");
      String yayOrNay = keyboard.nextLine();
      if(yayOrNay.equals("y"))
      {
   		// Check to make sure each play has cards in their deck
   		while((!(firstPlayerDeck.isEmpty()))&& (!(secondPlayerDeck.isEmpty())))
   		{
   
            
      			// Have each user lay down the top card off of their deck
      			Card firstPlayerCardNonWar = firstPlayerDeck.dealCard();
      			Card secondPlayerCardNonWar = secondPlayerDeck.dealCard();
               System.out.println(secondPlayerDeck.cardsRemaining());
               System.out.println(firstPlayerDeck.cardsRemaining());
      
      			// Compare each card
      			// Higher card takes the other card and adds it to their deck (make sure other deck is subtracted)
      			if (firstPlayerCardNonWar.getRank() > secondPlayerCardNonWar.getRank())
      			{
      				firstPlayerDeck.add(secondPlayerCardNonWar);
      				firstPlayerDeck.add(firstPlayerCardNonWar);
                  System.out.println(secondPlayerDeck.cardsRemaining());
                  System.out.println(firstPlayerDeck.cardsRemaining());
      
      			}
      			else if (firstPlayerCardNonWar.getRank() < secondPlayerCardNonWar.getRank())
      			{
      				secondPlayerDeck.add(firstPlayerCardNonWar);
                  secondPlayerDeck.add(secondPlayerCardNonWar);
                  System.out.println(secondPlayerDeck.cardsRemaining());
                  System.out.println(firstPlayerDeck.cardsRemaining());
      			}
      
      			/// If they are equal, game of war
      
      			/// Check to make sure each player has cards in their deck
      			else
      			{
      				// Create an array list to store the face down cards
      				ArrayList<Card> warWinnings = new ArrayList<Card>();
      
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
      				    Card firstPlayerCard = firstPlayerDeck.dealCard();
      				    Card secondPlayerCard = secondPlayerDeck.dealCard();
      
      					// Compare each card
      					// Higher card takes the other card and adds it to their deck (make sure other deck is subtracted)
      					if (firstPlayerCard.getRank() > secondPlayerCard.getRank())
      					{
      						firstPlayerDeck.add(secondPlayerCard);
                        firstPlayerDeck.add(firstPlayerCard);
                        firstPlayerDeck.add(secondPlayerCardNonWar);
                        firstPlayerDeck.add(firstPlayerCardNonWar);
                        System.out.println(secondPlayerDeck.cardsRemaining());
                        System.out.println(firstPlayerDeck.cardsRemaining());
                        for(int i=0;i<6;i++)
                        {
                           firstPlayerDeck.add(warWinnings.get(i));
                           System.out.println(secondPlayerDeck.cardsRemaining());
                           System.out.println(firstPlayerDeck.cardsRemaining());
                        }
                        System.out.println(secondPlayerDeck.cardsRemaining());
                        System.out.println(firstPlayerDeck.cardsRemaining());
                        System.out.println(warWinnings.size());
                     
      					}
      					else
      					{
                        secondPlayerDeck.add(secondPlayerCard);
      						secondPlayerDeck.add(firstPlayerCard);
                        secondPlayerDeck.add(secondPlayerCardNonWar);
                        secondPlayerDeck.add(firstPlayerCardNonWar);;
                        System.out.println(secondPlayerDeck.cardsRemaining());
                        System.out.println(firstPlayerDeck.cardsRemaining());
                        for(int i=0;i<6;i++)
                        {
                           secondPlayerDeck.add(warWinnings.get(i));
                           System.out.println(secondPlayerDeck.cardsRemaining());
                           System.out.println(firstPlayerDeck.cardsRemaining());
                        }
                        System.out.println(secondPlayerDeck.cardsRemaining());
                        System.out.println(firstPlayerDeck.cardsRemaining());
                        System.out.println(warWinnings.size());
      
      					}
      				}
      
      			}
            
   
   		}// ends while loop encompassing entire program
      }
      else
      {
   		// Determine who won the game
   		if(firstPlayerDeck.cardsRemaining()<secondPlayerDeck.cardsRemaining())
   		{
   			System.out.println("Computer Wins");
   		}
   		else
   		{
   			System.out.println("You Win!");
   		}
   		
         	System.out.println(firstPlayerDeck.cardsRemaining());
         	System.out.println(secondPlayerDeck.cardsRemaining());
      }
	}// ends main method

}// ends class
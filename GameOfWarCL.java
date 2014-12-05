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
	There will be a user and a computer pitted against each other in a vicous game of war, where a full deck of cards is the prize!
*/
public class GameOfWarCL
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
         while(((!(firstPlayerDeck.isEmpty()))&& (!(secondPlayerDeck.isEmpty())))&&yayOrNay.equals("y"))    // Check to make sure each play has cards in their deck
         {
            // Have each user lay down the top card off of their deck
            Card firstPlayerCardNonWar = firstPlayerDeck.dealCard();
            Card secondPlayerCardNonWar = secondPlayerDeck.dealCard();
            // Compare each card
            // Higher card takes the other card and adds it to their deck (make sure other deck is subtracted)
            if (firstPlayerCardNonWar.getRank() > secondPlayerCardNonWar.getRank())
            {
               firstPlayerDeck.add(secondPlayerCardNonWar);
               firstPlayerDeck.add(firstPlayerCardNonWar);
            }
            else if (firstPlayerCardNonWar.getRank() < secondPlayerCardNonWar.getRank())
            {
               secondPlayerDeck.add(firstPlayerCardNonWar);
               secondPlayerDeck.add(secondPlayerCardNonWar);
            }

            /// If they are equal, game of war

            /// Check to make sure each player has cards in their deck
            else
            {
               System.out.println("War occuring between your: "+firstPlayerCardNonWar.toString() + " and the computer's: "+secondPlayerCardNonWar.toString());
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
                  /// Comapre the cards
                  ///Higher card takes the other card and adds all of the cards (show all of the cards in the game of war)
                  Card firstPlayerCard = firstPlayerDeck.dealCard();
                  Card secondPlayerCard = secondPlayerDeck.dealCard();

                  // Compare each card
                  // Higher card takes the other card and adds it to their deck (make sure other deck is subtracted)
                  if (firstPlayerCard.getRank() > secondPlayerCard.getRank())
                  {
                     System.out.println("Your "+firstPlayerCard.toString()+" beats the computer's "+secondPlayerCard.toString());
                     firstPlayerDeck.add(secondPlayerCard);
                     firstPlayerDeck.add(firstPlayerCard);
                     firstPlayerDeck.add(secondPlayerCardNonWar);
                     firstPlayerDeck.add(firstPlayerCardNonWar);
                     for(int i=0;i<6;i++)
                     {
                        firstPlayerDeck.add(warWinnings.get(i));
                     }
                  }
                  else
                  {
                     System.out.println("Your "+firstPlayerCard.toString()+" loses to the computer's "+secondPlayerCard.toString());
                     secondPlayerDeck.add(secondPlayerCard);
                     secondPlayerDeck.add(firstPlayerCard);
                     secondPlayerDeck.add(secondPlayerCardNonWar);
                     secondPlayerDeck.add(firstPlayerCardNonWar);;

                     for(int i=0;i<6;i++)
                     {
                        secondPlayerDeck.add(warWinnings.get(i));
                     }

                  }

               } // Ends war Game

            } // Ends war else
            System.out.println("Your cards remaining: "+firstPlayerDeck.cardsRemaining());
            System.out.println("Computer cards remaining: "+secondPlayerDeck.cardsRemaining());

            System.out.print("Battle the computer?: (y/n) ");
            yayOrNay = keyboard.nextLine();

         } // Yay or nay if statement

      }
      else if(yayOrNay.equals("n"))
      {
         // Determine who won the game
         if(firstPlayerDeck.cardsRemaining()<secondPlayerDeck.cardsRemaining())
         {
         System.out.println("Computer Wins");
         }
         else if(firstPlayerDeck.cardsRemaining()>secondPlayerDeck.cardsRemaining())
         {
         System.out.println("You Win!");
         }
         else
         {
         System.out.println("It's a Tie!");
         }

      }
      else
      {
      System.out.println("Please enter either a y or n");
      }

	}// ends main method

}// ends class
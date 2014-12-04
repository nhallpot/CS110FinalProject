// Noah Hall-Potvin
// CS 110
// Final Project

/*
   The Card class represents a single 
   playing card from a standard 52 card deck.
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Card
{   
   //initialize constants
   public final static int SPADES = 1;
   public final static int CLUBS = 2;
   public final static int HEARTS = 3;
   public final static int DIAMONDS = 4;
   public final static int JACK = 11;
   public final static int QUEEN = 12;
   public final static int KING = 13;
   public final static int ACE = 1;
   private int rank; //rank of card
   private int suit; //suit of card
 
   /**
      This constructor initializes the 
      suit and rank of the card.
      @param s The suit of the card.
      @param r The rank of the card.
   */
   
   public Card(int r, int s)
   {
      rank = r;
      suit = s;
   }
   
   /**
      The getSuit method returns the suit of the card.
      @return The suit of the card.
   */
   
   public int getSuit()
   {
      return suit;
   }
   
   /**
      The getRank method returns the rank of the card.
      @return The rank of the card.
   */
   
   public int getRank()
   {
      return rank;
   }
   
   /**
      The stringSuit method returns the suit as a string.
      @return The suit as a String.
   */
   
   public String stringSuit()
   {
      if (suit == 1)
         return "Spades";
      
      else if (suit == 2)
         return "Clubs";
         
      else if (suit == 3)
         return "Hearts";
         
      else if (suit == 4)
         return "Diamonds";
      else
         return "invalid suit";
   } 
   
   /**
      The stringRank method returns the rank as a String.
      @return The rank as a String.
   */
   
   public String stringRank()
   {
      if (rank == 1)
         return "Ace";
         
      else if (rank == 11)
         return "Jack";
         
      else if (rank == 12)
         return "Queen";
         
      else if (rank == 13)
         return "King";
      
      else
         return "invalid rank";
   }
      
   /**
      toString mehtod
      @return A string indicating 
              the object's suit and rank.
   */
   
   public String toString()
   {
      String s;
      if ((rank == ACE) || (rank >= JACK))
      {
         s = stringRank() + " of " + stringSuit();
         return s;
      }
      else
      {
         s = getRank() + " of " + stringSuit();
         return s;
      }
   }
   
   /**
      The equals method compares two Month objects.
      They are equal if they contain the same rank.
      @param other The other month that you are comparing to.
      @return True or False.
   */
   
   public boolean equals(Card otherCard)
   {
      if (rank == (otherCard.rank))
         return true;
      return false;
   }

   /**
      This method will return a label that represents a card
      @param rank The rank of the card
      @param suit The suit of the card
      @return pic The picture of the card
   */
   public ImageIcon getCardImage(int rank, int suit)
   {
       ImageIcon front = new ImageIcon();

      if(suit==SPADES)
      {
         if(rank == ACE)
         {
            front = new ImageIcon("images/aces.jpg");
         }
         else if(rank==2)
         {
            front = new ImageIcon("images/2s.jpg");
         }
         else if(rank==3)
         {
            front = new ImageIcon("images/3s.jpg");
         }
         else if(rank==4)
         {
            front = new ImageIcon("images/4s.jpg");
         }

         else if(rank==5)
         {
            front = new ImageIcon("images/5s.jpg");
         }

         else if(rank==6)
         {
            front = new ImageIcon("images/6s.jpg");
         }

         else if(rank==7)
         {
            front = new ImageIcon("images/7s.jpg");
         }

         else if(rank==8)
         {
            front = new ImageIcon("images/8s.jpg");
         }

         else if(rank==9)
         {
            front = new ImageIcon("images/9s.jpg");
         }

         else if(rank==10)
         {
            front = new ImageIcon("images/10s.jpg");
         }

         else if(rank==JACK)
         {
            front = new ImageIcon("images/jacks.jpg");
         }

         else if(rank==QUEEN)
         {
            front = new ImageIcon("images/queens.jpg");
         }

         else
         {
            front = new ImageIcon("images/kings.jpg");
         }

      }
      else if(suit == CLUBS)
      {
         if(rank == ACE)
         {
            front = new ImageIcon("images/acec.jpg");
         }
         else if(rank==2)
         {
            front = new ImageIcon("images/2c.jpg");
         }
         else if(rank==3)
         {
            front = new ImageIcon("images/3c.jpg");
         }
         else if(rank==4)
         {
            front = new ImageIcon("images/4c.jpg");
         }

         else if(rank==5)
         {
            front = new ImageIcon("images/5c.jpg");
         }

         else if(rank==6)
         {
            front = new ImageIcon("images/6c.jpg");
         }

         else if(rank==7)
         {
            front = new ImageIcon("images/7c.jpg");
         }

         else if(rank==8)
         {
            front = new ImageIcon("images/8c.jpg");
         }

         else if(rank==9)
         {
            front = new ImageIcon("images/9c.jpg");
         }

         else if(rank==10)
         {
            front = new ImageIcon("images/10c.jpg");
         }

         else if(rank==JACK)
         {
            front = new ImageIcon("images/jackc.jpg");
         }

         else if(rank==QUEEN)
         {
            front = new ImageIcon("images/queenc.jpg");
         }

         else
         {
            front = new ImageIcon("images/kingc.jpg");
         }
      }
      else if(suit == HEARTS) // Hearts
      {
         if(rank == ACE)
         {
            front = new ImageIcon("images/aceh.jpg");
         }
         else if(rank==2)
         {
            front = new ImageIcon("images/2h.jpg");
         }
         else if(rank==3)
         {
            front = new ImageIcon("images/3h.jpg");
         }
         else if(rank==4)
         {
            front = new ImageIcon("images/4h.jpg");
         }

         else if(rank==5)
         {
            front = new ImageIcon("images/5h.jpg");
         }

         else if(rank==6)
         {
            front = new ImageIcon("images/6h.jpg");
         }

         else if(rank==7)
         {
            front = new ImageIcon("images/7h.jpg");
         }

         else if(rank==8)
         {
            front = new ImageIcon("images/8h.jpg");
         }

         else if(rank==9)
         {
            front = new ImageIcon("images/9h.jpg");
         }

         else if(rank==10)
         {
            front = new ImageIcon("images/10h.jpg");
         }

         else if(rank==JACK)
         {
            front = new ImageIcon("images/jackh.jpg");
         }

         else if(rank==QUEEN)
         {
            front = new ImageIcon("images/queenh.jpg");
         }

         else
         {
            front = new ImageIcon("images/kingh.jpg");
         }
      }
      else
      {
         if(rank == ACE)
         {
            front = new ImageIcon("images/aced.jpg");
         }
         else if(rank==2)
         {
            front = new ImageIcon("images/2d.jpg");
         }
         else if(rank==3)
         {
            front = new ImageIcon("images/3d.jpg");
         }
         else if(rank==4)
         {
            front = new ImageIcon("images/4d.jpg");
         }

         else if(rank==5)
         {
            front = new ImageIcon("images/5d.jpg");
         }

         else if(rank==6)
         {
            front = new ImageIcon("images/6d.jpg");
         }

         else if(rank==7)
         {
            front = new ImageIcon("images/7d.jpg");
         }

         else if(rank==8)
         {
            front = new ImageIcon("images/8d.jpg");
         }

         else if(rank==9)
         {
            front = new ImageIcon("images/9d.jpg");
         }

         else if(rank==10)
         {
            front = new ImageIcon("images/10d.jpg");
         }

         else if(rank==JACK)
         {
            front = new ImageIcon("images/jackd.jpg");
         }

         else if(rank==QUEEN)
         {
            front = new ImageIcon("images/queend.jpg");
         }

         else
         {
            front = new ImageIcon("images/kingd.jpg");
         }
      }
      

   return front;   
   }
   
}
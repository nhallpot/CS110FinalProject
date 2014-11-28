// Noah Hall-Potvin
// CS 110
// Final Project

/*
   The Card class represents a single 
   playing card from a standard 52 card deck.
*/ 

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
   
}
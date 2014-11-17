public class Card
{
	private int rank;
	private int suit; 
	public final int SPADES=0;
	public final int CLUBS=1;
	public final int HEARTS=2;
	public final int DIAMONDS=3;
	public final int ACE=13;
	public final int JACK=10;
	public final int QUEEN=11;
	public final int KING=12;

	/**
		This default constructor sets the class suit and rank from user input
		@param suit The suit of the card
		@param rank The value of the card
	*/
	public Card(int suit, int rank)
	{
		this.rank = rank;
      	this.suit = suit;
	}
	/**
		This method returns the value of the suit
		@return suit The type of card
	*/
	public int getSuit ()
	{
		return suit;
	}
	/**
		This method returns the value of the card
		@return rank The value of the card
	*/
	public int getRank()
	{
		return rank;
	}
	/**
		This method converts the state of the card to a string
		@return nameofCard The rank and suit of the card
	*/
	public String toString()
	{
		String suitCheck;
		String rankCheck;

		switch(rank)
		{
			case ACE: rankCheck = "Ace";
			break;
			case KING: rankCheck = "King";
			break;
			case QUEEN: rankCheck = "Queen";
			break;
			case JACK: rankCheck = "Jack";
			break;
			default: rankCheck = ""+rank;
			break;

		}

		switch(suit)
		{
			case SPADES: suitCheck = "Spades";
			break;
			case CLUBS: suitCheck = "Clubs";
			break;
			case HEARTS: suitCheck = "Hearts";
			break;
			case DIAMONDS: suitCheck = "Diamonds";
			break;
			default: suitCheck = ""+rank;
		}

		String nameOfCard = (rankCheck+" of "+suitCheck);
		return nameOfCard;
	}
	/**
		This method determines whether or not the two cards are equal
		@param otherCard The other card created by the user
		@return bool Whether or not the two cards are equal
	*/
	public Boolean equals(Card otherCard)
	{
		boolean bool;
		if (rank == otherCard.getRank())
		{
			bool = true;
		}
		else
		{	
			bool = false;
		}
		return bool;
	}

}
// Noah Hall-Potvin  
// CS 110
// Game of War GUI


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOfWarGUI extends JFrame
{
   private JButton dealButton;
   private JLabel pic,pic2;
   private ImageIcon front,back;

   /**
   		The default constructor creates a gui for the game of war
   		@param s The title of the frame. 
   */
   public GameOfWarGUI(String s)
   {


      super(s);
      setLayout(new BorderLayout());

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
 


      // Create the panels for the border layout
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      JPanel panel3 = new JPanel();
      JPanel panel4 = new JPanel();
      JPanel panel5 = new JPanel();


      //add the buttons to the panels
      dealButton = new JButton("Deal Cards!");
      dealButton.addActionListener(new ButtonListener());
      panel2.add(dealButton);


      // Put the panels in their place
      add(panel1, BorderLayout.NORTH);
      add(panel2, BorderLayout.SOUTH);
      add(panel3, BorderLayout.EAST);
      add(panel4, BorderLayout.WEST);
      add(panel5, BorderLayout.CENTER);



      front = new ImageIcon("images/back.jpg");
      back = new ImageIcon("images/back.jpg");
      pic = new JLabel(back);     
      pic2 = new JLabel(back);
      panel4.add(pic);
      panel3.add(pic2);
      
   	  pack();
   	  setVisible(true);
   
   }
/**
	Button Listener sets what happens when the button is clicked
*/
//class to handle button press
class ButtonListener implements ActionListener
{

  public void actionPerformed(ActionEvent e)
  {
     if (pic.getIcon() == back)
        pic.setIcon(front);
     else
        pic.setIcon(back);
  	
	// Put code from CL here
	while((!(firstPlayerDeck.isEmpty()))&& (!(secondPlayerDeck.isEmpty())))    // Check to make sure each play has cards in their deck
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
	} // Ends while loop  	

  }
}

   /**
		The main method creates and runs the Game of War GUI
   */
   public static void main(String [] args)
   {
  
      JFrame frame = new GameOfWarGUI("LET'S PLAY WAR!");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   
   }	


}
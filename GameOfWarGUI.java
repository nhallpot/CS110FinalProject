// Noah Hall-Potvin  
// CS 110
// Game of War GUI


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameOfWarGUI extends JFrame
{
   private JButton dealButton;
   private JLabel warWinngings,warLabel,pic,pic2,firstPlayerCardsRemaining,secondPlayerCardsRemaining;
   private JLabel pic3,secondPlayerWarCardLabel,firstPlayerCardLabel,secondPlayerCardLabel,warTextLabel,firstPlayerWarCardLabel;
   private JLabel outcome;
   private ImageIcon front,back;
   private Deck deck,firstPlayerDeck,secondPlayerDeck;
   private JPanel panel1,panel2,panel3,panel4,panel5, panel11,panel22,panel33,panel44,panel55,panel551,panel552,panel553;

   public final int CARDS_FOR_WAR = 3;

   /**
   		The default constructor creates a gui for the game of war
   		@param s The title of the frame. 
   */
   public GameOfWarGUI(String s)
   {


      super(s);
      setLayout(new BorderLayout());
      // Create a deck for both users
      firstPlayerDeck = new Deck();
      secondPlayerDeck = new Deck();
      deck = new Deck();

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
       panel1 = new JPanel();
       panel2 = new JPanel();
       panel3 = new JPanel();
       panel4 = new JPanel();
       panel5 = new JPanel();

       panel11 = new JPanel();
       panel22= new JPanel();
       panel33 = new JPanel();
       panel44 = new JPanel();
       panel55 = new JPanel();
       
       panel551 = new JPanel();
       panel552 = new JPanel();
       panel553 = new JPanel();
       
      panel5.setLayout(new BorderLayout());
      panel55.setLayout(new BorderLayout());


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

      panel5.add(panel11, BorderLayout.NORTH);
      panel5.add(panel22, BorderLayout.SOUTH);
      panel5.add(panel33, BorderLayout.EAST);
      panel5.add(panel44, BorderLayout.WEST);
      panel5.add(panel55, BorderLayout.CENTER);
      
      panel55.add(panel551, BorderLayout.WEST);
      panel55.add(panel552, BorderLayout.EAST);
      panel55.add(panel553, BorderLayout.SOUTH);

      // Create labels for the gui

      firstPlayerCardLabel = new JLabel();
      secondPlayerCardLabel = new JLabel();

      firstPlayerWarCardLabel = new JLabel();
      secondPlayerWarCardLabel = new JLabel();

      firstPlayerCardsRemaining = new JLabel();
      secondPlayerCardsRemaining = new JLabel();

      warLabel = new JLabel();
      warTextLabel = new JLabel();
      

      // Create the war lable
      warLabel.setText("It's time for a War!!!");
      warLabel.setVisible(false);
      panel11.add(warLabel);

      outcome = new JLabel();
      outcome.setVisible(false);

      panel553.add(outcome);

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
  	if((!(firstPlayerDeck.isEmpty()))&& (!(secondPlayerDeck.isEmpty())))    // Check to make sure each play has cards in their deck
  	{
      warLabel.setVisible(false);
      warTextLabel.setVisible(false);


      // Show the user how many cards each deck has remaining
      firstPlayerCardsRemaining.setText("Your cards remaining"+String.valueOf(firstPlayerDeck.cardsRemaining()));
      secondPlayerCardsRemaining.setText("Computer cards remaining"+String.valueOf(secondPlayerDeck.cardsRemaining()));  
      panel1.add(firstPlayerCardsRemaining);
      panel1.add(secondPlayerCardsRemaining);

  		// Have each user lay down the top card off of their deck
  		Card firstPlayerCardNonWar = firstPlayerDeck.dealCard();
  		Card secondPlayerCardNonWar = secondPlayerDeck.dealCard();

      // Create the labels for the cards

      firstPlayerCardLabel.setIcon(firstPlayerCardNonWar.getCardImage(firstPlayerCardNonWar.getRank(),firstPlayerCardNonWar.getSuit()));
      secondPlayerCardLabel.setIcon(secondPlayerCardNonWar.getCardImage(secondPlayerCardNonWar.getRank(),secondPlayerCardNonWar.getSuit()));

      // Add them to the center frame
      panel44.add(firstPlayerCardLabel);
      panel33.add(secondPlayerCardLabel);

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

        warLabel.setVisible(true);
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
            warTextLabel.setVisible(true);
            pic3.setVisible(true);
  				/// Comapre the cards
  				///Higher card takes the other card and adds all of the cards (show all of the cards in the game of war)
  				Card firstPlayerCard = firstPlayerDeck.dealCard();
  				Card secondPlayerCard = secondPlayerDeck.dealCard();
   
            firstPlayerWarCardLabel.setIcon(firstPlayerCardNonWar.getCardImage(firstPlayerCardNonWar.getRank(),firstPlayerCardNonWar.getSuit()));
            secondPlayerWarCardLabel.setIcon(secondPlayerCardNonWar.getCardImage(secondPlayerCardNonWar.getRank(),secondPlayerCardNonWar.getSuit()));

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
  	} // Ends if statement
    else 
    {
      // Put code from CL here
      // Determine who won the game
      if(firstPlayerDeck.cardsRemaining()<secondPlayerDeck.cardsRemaining())
      {
        outcome.setText("The computer wins");
        outcome.setVisible(true);
      }
      else if(firstPlayerDeck.cardsRemaining()>secondPlayerDeck.cardsRemaining())
      {
        outcome.setText("You win!");
        outcome.setVisible(true);
      }
      else
      {
        outcome.setText("It's a tie");
        outcome.setVisible(true);
      }


    }  	

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
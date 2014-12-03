import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest{
	public static void main (String[] args) {
		// xet up frame container
		ButtonTestFrame frame = new ButtonTestFrame("Jackie's Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}

class ButtonTestFrame extends JFrame 
{
   private JPanel panel;
   private JButton button;
   private Color c;
   
   public ButtonTestFrame(String s)
   {  
      super(s);

      // set up a new panel in the frame
      panel = new JPanel();
      button = new JButton("Red");
      //button2 = new JButton("Blue");
     // panel2 = new JPanel();
      panel.add(button);
     // panel2.add(button2);
      button.addActionListener(new ButtonListener());
    //  button2.addActionListener(new ButtonListener());
      
      c = Color.BLUE;
      panel.setBackground(c);
      add(panel);
   }
   // private inner class
   class ButtonListener implements ActionListener{
      public void actionPerformed (ActionEvent e) 
      {
         if (c.equals(Color.BLUE))
         {
            c = Color.RED;

         }
         else{
            c = Color.BLUE;
            button = new JButton("Blue");
         }
         panel.add(button);
            
         panel.setBackground(c);
      }
}


}
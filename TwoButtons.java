import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TwoButtons extends JFrame 
{
   private JPanel panel;
   private JButton buttonRed,buttonBlue;
   
   public TwoButtons(String s)
   {  
      super(s);

      // set up a new panel in the frame
      panel = new JPanel();
      buttonRed = new JButton("Red");
     panel.add(buttonRed);
      buttonRed.addActionListener(new ButtonListener());

      buttonBlue = new JButton("Blue");
      panel.add(buttonBlue);
      buttonBlue.addActionListener(new ButtonListener());
   
      add(panel);
   }
   // private inner class
   class ButtonListener implements ActionListener{
      public void actionPerformed (ActionEvent e) {
         JButton b = (JButton)(e.getSource());
   
         if (b.getText().compareTo("Red") == 0)
           panel.setBackground(Color.red);
         else
            panel.setBackground(Color.blue);

         // OR
         /*
         if (e.getSource() == buttonRed)
            panel.setBackground(Color.red);
         else
            panel.setBackground(Color.blue);
         */
      }
   }
   public static void main(String [] args)
   {
      JFrame frame = new TwoButtons("Jackie's frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
  
   }
}
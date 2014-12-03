import javax.swing.*;
import java.awt.*; // for layout
public class Tester 
{
  public static void main(String [] args) 
   {
      JFrame frame = new MyFrame("New Frame ...");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

   }
}

class MyFrame extends JFrame 
{
   private JLabel label1,label2,label3,label4;
   public MyFrame(String s) 
   {
      super (s);
      label1 = new JLabel("one");
      add(label1);
      label2 = new JLabel("two");
      add(label2);
      label3 = new JLabel("three");
      add(label3);
      label4 = new JLabel("four");
      add(label4);
      
      
   }

}
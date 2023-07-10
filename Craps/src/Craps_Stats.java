// @author Forrest Wang
// October 21, 2021
//
// Craps_Stats

// Import(s):
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Craps_Stats extends JFrame
    implements ActionListener {
  private Craps_Game game;
  private JTextField numberIn, statsOut;

  // Constructor(s):
  public Craps_Stats() {
    super("Craps: Stats");

    Container c = getContentPane();
    c.setLayout(new FlowLayout());

    c.add(new JLabel("Number of games to run:"));

    numberIn = new JTextField(5);
    numberIn.addActionListener(this);
    c.add(numberIn);

    statsOut = new JTextField(18);
    statsOut.setEditable(false);
    c.add(statsOut);

    game = new Craps_Game();
  }

  // Called when a number is entered in the numberIn text field
  public void actionPerformed(ActionEvent e) {
    String s = numberIn.getText();
    int nGames = Integer.parseInt(s);
    int result, gameCount = 0, winCount = 0;
    Die die1 = new Die();
    Die die2 = new Die();

    while (gameCount < nGames) {
      die1.roll();
      die2.roll();
      int total = die1.getNumDots() + die2.getNumDots();
      result = game.processRoll(total);
      if (result != 0) {gameCount++;}

      if (result > 0) {winCount++;}
    }

    numberIn.setText("");
    statsOut.setText(" Games: " + gameCount + " Wins: " + winCount);
  }

  public static void main(String args[]) {
    Craps_Stats window = new Craps_Stats();
    window.setBounds(100, 100, 300, 100);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}


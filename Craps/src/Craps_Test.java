// @author Forrest Wang
// October 21, 2021
//
// Craps_Test

// Import(s):
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Craps_Test extends JFrame
    implements ActionListener {
  private Craps_Game game;
  private JTextField input;
  private JTextArea display;

  // Constructor(s):
  public Craps_Test() {
    super("Craps: Test 1");

    Container c = getContentPane();
    c.setLayout(new FlowLayout());

    c.add(new JLabel("Next roll:"));
    input = new JTextField(5);
    input.setBackground(Color.YELLOW);
    input.addActionListener(this);
    c.add(input);

    display = new JTextArea(10, 20);
    display.setEditable(false);
    display.setBackground(Color.WHITE);
    c.add(new JScrollPane(display,
              ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

    game = new Craps_Game();
  }

  // Called when a number is entered into the JTextField input:
  public void actionPerformed(ActionEvent e) {
    String s = input.getText().trim();
    int total = Integer.parseInt(s);
    int result = game.processRoll(total);
    int point = game.getPoint();
    input.setText("");
    display.append(total + ":  Result = " + result + " Point = " + point + "\n");
  }

  public static void main(String[] args) {
    Craps_Test window = new Craps_Test();
    window.setBounds(100, 100, 300, 240);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}


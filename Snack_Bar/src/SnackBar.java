// @author Forrest Wang
// November 20, 2021
//
// SnackBar
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class SnackBar extends JFrame implements ActionListener {
  private static final String MY_PASSWORD = "jinx";
  private VendingMachine machine1;
  private VendingMachine machine2;
  private VendingMachine machine3;

  public SnackBar() {
    super("Snack Bar");
    Color var1 = new Color(130, 30, 10);
    Color var2 = new Color(255, 180, 0);
    Color var3 = new Color(90, 180, 0);
    ImageIcon var4 = new ImageIcon("coin.gif");
    this.machine1 = new VendingMachine("Java", var1, 45, var4);
    this.machine2 = new VendingMachine("JApple", var2, 50, var4);
    this.machine3 = new VendingMachine("Jinx", var3, 35, var4);
    Box var5 = Box.createHorizontalBox();
    var5.add(Box.createHorizontalStrut(5));
    var5.add(this.machine1);
    var5.add(Box.createHorizontalStrut(5));
    var5.add(this.machine2);
    var5.add(Box.createHorizontalStrut(5));
    var5.add(this.machine3);
    var5.add(Box.createHorizontalStrut(5));
    JPanel var6 = new JPanel();
    var6.add(new JLabel(" Service login: "));
    JPasswordField var7 = new JPasswordField("", 5);
    var7.addActionListener(this);
    var6.add(var7);
    Container var8 = this.getContentPane();
    var8.setBackground(Color.GRAY);
    var8.add(var5, "Center");
    var8.add(var6, "South");
  }

  public void actionPerformed(ActionEvent var1) {
    JPasswordField var2 = (JPasswordField)var1.getSource();
    String var3 = new String(var2.getPassword());
    var2.setText("");
    if ("jinx".equals(var3)) {
      this.machine1.reload();
      this.machine2.reload();
      this.machine3.reload();
      JOptionPane.showMessageDialog((Component)null, "Machines reloaded", "Service", 1);
    }

    else {JOptionPane.showMessageDialog((Component)null, "Login failed", "Service", 0);}

  }

  public static void main(String[] var0) {
    SnackBar var1 = new SnackBar();
    var1.setBounds(50, 50, 520, 310);
    var1.setDefaultCloseOperation(3);
    var1.setResizable(false);
    var1.setVisible(true);
  }
}

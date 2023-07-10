// @author Forrest Wang
// November 20, 2021
//
// VendingMachine
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VendingMachine extends JPanel implements ActionListener {
  private static final int FULL_STOCK = 5;
  private JButton deposit25c;
  private JButton deposit10c;
  private JButton deposit5c;
  private JButton go;
  private JTextField display;
  private Vendor vendor;
  boolean trayFull;
  Color brandColor;
  String brandName;

  public VendingMachine(String var1, Color var2, int var3, ImageIcon var4) {
    this.setBackground(Color.WHITE);
    this.brandColor = var2;
    this.brandName = var1;
    JTextField var5 = new JTextField("  " + this.brandName + "  " + var3 + "c  ");
    var5.setEditable(false);
    var5.setFont(new Font("Serif", 1, 14));
    var5.setHorizontalAlignment(0);
    this.deposit25c = new JButton(" 25 ", var4);
    this.deposit25c.addActionListener(this);
    this.deposit10c = new JButton(" 10 ", var4);
    this.deposit10c.addActionListener(this);
    this.deposit5c = new JButton("  5 ", var4);
    this.deposit5c.addActionListener(this);
    this.go = new JButton("   ");
    this.go.setBackground(Color.RED);
    this.go.addActionListener(this);
    JPanel var6 = new JPanel(new GridLayout(3, 1, 5, 0));
    var6.setBackground(Color.BLUE);
    var6.add(this.deposit25c);
    var6.add(this.deposit10c);
    var6.add(this.deposit5c);
    this.display = new JTextField("0  ");
    this.display.setFont(new Font("Monospaced", 1, 16));
    this.display.setBackground(Color.YELLOW);
    this.display.setEditable(false);
    this.display.setHorizontalAlignment(4);
    Box var7 = Box.createVerticalBox();
    var7.add(var5);
    var7.add(Box.createVerticalStrut(5));
    var7.add(this.display);
    var7.add(Box.createVerticalStrut(12));
    Box var8 = Box.createHorizontalBox();
    var8.add(Box.createHorizontalStrut(60));
    Box var9 = Box.createVerticalBox();
    var9.add(this.go);
    var9.add(Box.createVerticalStrut(8));
    var9.add(var6);
    var8.add(var9);
    var7.add(var8);
    var7.add(Box.createVerticalStrut(5));
    this.add(var7);
    this.vendor = new Vendor(var3, 5);
  }

  public void reload() {
    this.vendor.setStock(5);
    this.display.setText(" " + this.vendor.getDeposit() + "  ");
    this.repaint();
  }

  public void actionPerformed(ActionEvent var1) {
    JButton var2 = (JButton)var1.getSource();
    if (var2 == this.deposit25c) {this.vendor.addMoney(25);}

    else if (var2 == this.deposit10c) {this.vendor.addMoney(10);}

    else if (var2 == this.deposit5c) {this.vendor.addMoney(5);}

    else if (var2 == this.go) {
      this.trayFull = this.vendor.makeSale();
      int var3 = this.vendor.getChange();

      if (this.trayFull) {
        this.repaint();
        JOptionPane.showMessageDialog((Component)null, "Enjoy your " + this.brandName + "\n" + " Change " + var3 + "c", "Enjoy " + this.brandName, -1);
        this.trayFull = false;
      }

      else if (var3 > 0) {JOptionPane.showMessageDialog((Component)null, "Take " + var3 + "c back", "Money back", 0);}
    }

    if (this.vendor.getStock() > 0) {this.display.setText(" " + this.vendor.getDeposit() + "  ");}

    else {this.display.setText("Call service ");}

    this.repaint();
  }

  public void paintComponent(Graphics var1) {
    super.paintComponent(var1);
    int var2 = this.getWidth() / 12;
    int var3 = this.getHeight() / 2;
    var1.setColor(Color.BLACK);
    var1.drawRect(var2, var3, 28, 74);
    int var5 = var3 + 4;
    int var6 = var2 + 4;
    int var7 = this.vendor.getStock();

    for(int var8 = 5; var8 > 0; --var8) {
      if (var8 <= var7) {this.drawCan(var1, var6, var5);}

      var5 += 14;
    }

    var1.setColor(Color.BLUE);
    var5 += 14;
    var1.drawRect(var2, var5 - 4, 28, 18);

    if (this.trayFull) {this.drawCan(var1, var6, var5);}

  }

  private void drawCan(Graphics var1, int var2, int var3) {
    var1.setColor(this.brandColor);
    var1.fillRoundRect(var2, var3, 20, 10, 4, 4);
    var1.setColor(Color.WHITE);
    var1.drawLine(var2 + 2, var3 + 4, var2 + 14, var3 + 4);
    var1.drawLine(var2 + 2, var3 + 6, var2 + 14, var3 + 6);
  }
}

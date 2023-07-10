// @author Forrest Wang
// November 29, 2021
//
// VendingMachine

public class Vendor {
  // Field(s):
  private int deposit, price, stock, change;
  private static double totalSales = 0;

  //  Constructor:
  public Vendor(int price, int number) {
    this.price = price;
    stock = number;
  }

  /**
   * Pre-condition: Requires the number of items to place in stock.
   * Post-condition: Should set the quantity of items in stock.
   */
  public void setStock(int number) {stock = number;}

  /**
   * Pre-condition: Nothing.
   * Post-condition: Should return the number of items currently in stock.
   */
  public int getStock() {return stock;}

  /**
   * Pre-condition: Requires the number of cents to add to the deposit.
   * Post-condition: Should add a specified amount in cents to the deposited amount.
   */
  public void addMoney(int cents) {deposit += cents;}

  /**
   * Pre-condition: Nothing.
   * Post-condition: Should return the number of cents in the current deposit.
   */
  public int getDeposit() {return deposit;}

  /**
   * Pre-condition: Nothing.
   * Post-condition: Should return true of the sale is successful, and false if it is unsuccessful.
   */
  public boolean makeSale() {
    change = 0;

    if (stock > 0 && deposit >= price) {
      stock--;
      change = deposit - price;
      deposit = 0;
      totalSales += price / 100.0;
      return true;
    }

    else {
      change = deposit;
      return false;
    }
  }

  /**
   * Pre-condition: Nothing.
   * Post-condition: Should return the number of cents in the current change.
   */
  public int getChange() {return change;}

  /**
   * Pre-condition: Nothing.
   * Post-condition: Should return the the variable totalSales.
   */
  public static double getTotalSales() {
    double totalSales2 = totalSales;
    totalSales = 0;
    return totalSales2;
  }
}

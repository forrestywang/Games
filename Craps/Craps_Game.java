// @author Forrest Wang
// October 21, 2021
//
// Craps_Game

public class Craps_Game {
  private int point = 0;

  /**
   * Pre-condition: Nothing.
   * Post-condition: Should calculate the result of the roll.
   */
  public int processRoll(int total) {
	  int result;

	  // If this is the first roll:
	  if (point == 0) {
	  	// Winning numbers:
	  	if (total == 7 || total == 11) {result = 1;}

	  	// Losing numbers:
	  	else if (total == 2 || total == 3 || total == 12) {result = -1;}

	  	// Keep rolling:
	  	else {
		  point = total;
		  result = 0;
	  	}
	  }
    
	  else {
	  	// Losing number:
	  	if (total == 7) {
	  		result = -1;
	  		point = 0;
	  	}

	  	// Winning number:
	  	else if (total == point) {
    		result = 1;
    		point = 0;
	  	}

	  	// Keep rolling:
    	else {result = 0;}
    }
    
    return result;
  }

  /**
   * Pre-condition: Nothing.
   * Post-condition: Should return the saved point.
   */
  public int getPoint() {
	  return point;
  }
}

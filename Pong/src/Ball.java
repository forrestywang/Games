// @author Forrest Wang
// December 28, 2021
//
// Ball
//
// Import(s):
import java.awt.*;
import java.util.*;

public class Ball extends GameObject{
    // Field(s):
    private int velocityX = 1, velocityY = 1;

    // Constructor(s):
    public Ball() {
        // Constructor(s):
        Random rng = new Random();

        this.setSize(10, 10);
        this.setColor(Color.RED);

        // Start the ball with a random velocity:
        if (rng.nextInt(2) + 1 == 1) {
            velocityX = -1;
        }

        if (rng.nextInt(2) + 1 == 1) {
            velocityY = -1;
        }
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should return the value of the field velocityX.
     */
    public int getVelocityX() {
        return velocityX;
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should return the value of the field velocityY.
     */
    public int getVelocityY() {
        return velocityY;
    }

    /**
     * Pre-condition: Requires the value of the variable velocityX.
     * Post-condition: Should set the field velocityX to the parameter.
     */
    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * Pre-condition: Requires the value of the variable velocityY.
     * Post-condition: Should set the field velocityY to the parameter.
     */
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should move the ball depending on the velocity.
     */
    public void act() {
        this.setLocation((int) (this.getX() + this.velocityX * 4), (int) (this.getY() + this.velocityY));
    }
}
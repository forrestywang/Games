// @author Forrest Wang
// December 28, 2021
//
// Paddle

public class Paddle extends GameObject{
    // Field(s):
    private int velocity;

    // Constructor(s):
    public Paddle() {
        this.setSize(10, 50);
    }

    /**
     * Pre-condition: Needs the value of variable velocity.
     * Post-condition: Should set the value of the field velocity to the parameter.
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should move the paddle depending on the velocity.
     */
    public void act() {
        this.setY(this.getY() + this.velocity * 2);
    }
}
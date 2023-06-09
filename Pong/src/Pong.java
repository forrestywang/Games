// @author Forrest Wang
// December 14, 2021
//
// Pong
//
// Import(s):
import java.awt.*;
import javax.swing.*;

public class Pong extends Game {
    // Field(s):
    private Ball ball;
    private Paddle paddle1, paddle2;
    private JLabel player1ScoreLabel, player2ScoreLabel;
    private int player1Score = 0, player2Score = 0;

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should move both paddles depending on which keys the user is pressing. 'Z' and 'X' move the left
     * paddle up and down respectively, and 'N' and 'M' move the right paddle up and down respectively.
     */
    public void userInput() {
        if (ZKeyPressed() && paddle1.getY() >= 0) {
            paddle1.setVelocity(-1);
        }
        else if (XKeyPressed() && paddle1.getY() + 50 <= getFieldHeight()) {
            paddle1.setVelocity(1);
        }
        else {
            paddle1.setVelocity(0);
        }
        if (NKeyPressed() && paddle2.getY() >= 0) {
            paddle2.setVelocity(-1);
        }
        else if (MKeyPressed() && paddle2.getY() + 50 <= getFieldHeight()) {
            paddle2.setVelocity(1);
        }
        else {
            paddle2.setVelocity(0);
        }
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should check if the ball collided with anything.
     */
    public void collisionCheck() {
        // If the ball collides with a paddle
        if (ball.collides(paddle1) || ball.collides(paddle2)) {
            ball.setVelocityX(- ball.getVelocityX());
        }
        // If the ball collides with the ceiling or floor:
        else if (ball.getY() <= 0 || ball.getY() >= getFieldHeight()) {
            ball.setVelocityY(- ball.getVelocityY());
        }
        // If the ball collides with the left side of the room:
        else if (ball.getX() <= 0) {
            // Increase score:
            player2Score++;

            // Check if Player 2 won:
            if (player2Score == 10) {
                p2Wins();
                player1Score = 0;
                player2Score = 0;
            }

            // Reset the playing field:
            remove(ball);
            remove(paddle1);
            remove(paddle2);
            remove(player1ScoreLabel);
            remove(player2ScoreLabel);
            setup();
            repaint();
        }

        // If the ball collides with the right side of the room:
        else if (ball.getX() >= getFieldWidth() - 10) {
            // Increase score:
            player1Score++;

            // Check if Player 1 won:
            if (player1Score == 10) {
                p1Wins();
                player1Score = 0;
                player2Score = 0;
            }

            // Reset the playing field:
            remove(ball);
            remove(paddle1);
            remove(paddle2);
            remove(player1ScoreLabel);
            remove(player2ScoreLabel);
            setup();
            repaint();
        }
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should implement Pong's game logic.
     */
    public void act() {
        // Check if there is a collision:
        collisionCheck();

        // Check if there is user input:
        userInput();
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should setup the Pong game.
     */
    public void setup() {
        setDelay(1);

        // Setup the ball:
        ball = new Ball();
        ball.setLocation(getFieldWidth() / 2 - 5, getFieldHeight() / 2 - 5);
        add(ball);

        // Setup the left paddle:
        paddle1 = new Paddle();
        paddle1.setColor(Color.WHITE);
        paddle1.setLocation(0, getFieldHeight() / 2 - 25);
        add(paddle1);

        // Setup the right paddle:
        paddle2 = new Paddle();
        paddle2.setColor(Color.WHITE);
        paddle2.setLocation(getFieldWidth() - 10, getFieldHeight() / 2 - 25);
        add(paddle2);

        // Setup Player 1's Score JLabel:
        player1ScoreLabel = new JLabel();
        player1ScoreLabel.setForeground(Color.WHITE);
        player1ScoreLabel.setBounds(10, 0, 50, 20);
        player1ScoreLabel.setText("P1: " + player1Score);
        add(player1ScoreLabel);

        // Setup Player 2's Score JLabel:
        player2ScoreLabel = new JLabel();
        player2ScoreLabel.setForeground(Color.WHITE);
        player2ScoreLabel.setBounds(getFieldWidth() - 40, 0, 50, 20);
        player2ScoreLabel.setText("P2: " + player2Score);
        add(player2ScoreLabel);
    }
}
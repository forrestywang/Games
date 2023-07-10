package G11_Final_Project;

// @author Forrest Wang
// June 5, 2021
//
// Tic_Tac_Toe
// Tic Tac Toe application with a GUI.
//
// Tutorial(s) used:
// Part 1: https://www.youtube.com/watch?v=YMeVSoNumAg
// Part 2: https://www.youtube.com/watch?v=xJ72uh4zLGk
// Part 3: https://www.youtube.com/watch?v=tSV-xfpQ3GU
// Part 4: https://www.youtube.com/watch?v=J4yVqw41Q6E
// Part 5: https://www.youtube.com/watch?v=VgnYZ72bcZg
// Writing and reading to a text file in Java: https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java

// Imports:
import java.awt.*;
import javax.swing.*;

public class Tic_Tac_Toe_GUI extends JFrame{

    // Initializing field(s):
    private Container pane;

    // Initializing variable(s):
    private String currentPlayer;
    private boolean hasFinished;

    // Initializing array(s):
    private JButton [][] board;

    /**
     * Pre-condition: Requires the pane, and board to be initialized.
     * Post-condition: Should initialize the Pane, Board, Menu Bar, and start the game.
     */
    public Tic_Tac_Toe_GUI() {
        super();

        // Initializing the Pane:
        pane = getContentPane();
        pane.setLayout(new GridLayout(3, 3));
        setTitle("Tic Tac Toe");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        // Initializing the Board and Menu Bar:
        currentPlayer = "X";
        board = new JButton[3][3];
        hasFinished = false;
        initializeBoard();
        initializeMenuBar();
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should initialize the Menu Bar, allowing the user to start a new game, quit, save a game, or load a game.
     */
    private void initializeMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Settings:");

        // Initialize "New Game" Button:
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(e -> resetBoard()); // IntelliJ suggested this notation.

        // Initialize "Quit Game" Button:
        JMenuItem quitGame = new JMenuItem("Quit Game");
        quitGame.addActionListener(e -> System.exit(0)); // IntelliJ suggested this notation.

//        // Initialize "Save Game" Button:
//        JMenuItem saveGame = new JMenuItem("Save Game");
//        saveGame.addActionListener(e -> {
//            try {saveGame();}
//            catch (IOException ioException) {ioException.printStackTrace();}
//        }); // IntelliJ suggested this notation.

//        // Initialize "Load Game" Button:
//        JMenuItem loadGame = new JMenuItem("Load Game");
//        loadGame.addActionListener(e -> {
//            try {loadGame();}
//            catch (IOException ioException) {ioException.printStackTrace();}
//        }); // IntelliJ suggested this notation.

        // Adding JMenuItems into the JMenu:
        menu.add(newGame);
//        menu.add(saveGame);
//        menu.add(loadGame);
        menu.add(quitGame);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    /**
     * Pre-condition: Nothing.
     * Post-condition: Should save the current state of the game, which includes the current turn, and the previous moves.
     */
//    private void saveGame() throws IOException {
//        // Writing to a text file:
//        try {
//            FileWriter writer = new FileWriter("Tic Tac Toe Game Save.txt");
//            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//
//            // Writing the current turn:
//            bufferedWriter.write(currentPlayer);
//            bufferedWriter.newLine();
//
//            // Writing the values for the board array:
//            for (byte x = 0; x < 3; x++) {
//                for (byte y = 0; y < 3; y++) {
//                    bufferedWriter.write(board[x][y].getText());
//                    bufferedWriter.newLine();
//                }
//            }
//
//            writer.close();
//            bufferedWriter.close();
//        }
//        catch (IOException e) {e.printStackTrace();} // IntelliJ suggested this notation.
//    }

    /**
     * Pre-condition: Requires a text file with the game save.
     * Post-condition: Should load a previous game state, which includes the current turn, and the previous moves.
     */
//    private void loadGame() throws IOException {
//        // Reading a text file:
//        try {
//            FileReader reader = new FileReader("Tic Tac Toe Game Save.txt");
//            BufferedReader bufferedReader = new BufferedReader(reader);
//
//            // Load the current turn:
//            currentPlayer = bufferedReader.readLine();
//
//            // Load the text for the previous moves:
//            for (byte x = 0; x < 3; x++) {
//                for (byte y = 0; y < 3; y++) {
//                    // Load the previous moves:
//                    board[x][y].setText(bufferedReader.readLine());
//                    board[x][y].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100)); // Set the font type to SANS_SERIF, bold, and size 100.
//
//                    // Set the font colour based on the player:
//                    if (board[x][y].getText().equals("X")) {board[x][y].setForeground(Color.red);}
//                    else {board[x][y].setForeground(Color.blue);}
//                }
//            }
//
//            reader.close();
//            bufferedReader.close();
//        }
//        catch (IOException e) {e.printStackTrace();}
//
//        // Display current turn:
//        JOptionPane.showMessageDialog(null, "It is player " + currentPlayer + "'s turn.");
//    }

    /**
     * Pre-condition: Requires the board to be initialized.
     * Post-condition: Should reset the board when the method is called.
     */
    private void resetBoard() {
        // Resetting the Game:
        currentPlayer = "X";
        hasFinished = false;

        // Resetting the Buttons:
        for (byte a = 0; a < 3; a++) {
            for (byte b = 0; b < 3; b++) {board[a][b].setText("");}
        }
    }

    /**
     * Pre-condition: Requires the board to be initialized, the hasFinished() and togglePlayer() methods working.
     * Post-condition: Should go through each button in the 2D-array, make it "clickable", and add it to the content pane.
     */
    private void initializeBoard() {
        // Go through each button in the 2D-array:
        for (byte a = 0; a < 3; a++) {
            for (byte b = 0; b < 3; b++) {
                // Initialize the button:
                JButton button = new JButton();
                board[a][b] = button;

                // Make the button perform an action:
                button.addActionListener(e -> {
                    // Check if the move is legal:
                    if (((JButton)e.getSource()).getText().equals("") && !hasFinished) {
                        // Overwrite the text for the button to the current player:
                        button.setText(currentPlayer);
                        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100)); // Set the font type to SANS_SERIF, bold, and size 100.

                        // Set the font colour based on the player:
                        if (currentPlayer.equals("X")) {button.setForeground(Color.red);}
                        else {button.setForeground(Color.blue);}

                        // Check if there is a winner or a draw:
                        hasFinished();
                    }
                });

                // Add the button to the content pane:
                pane.add(button);
            }
        }
    }

    /**
     * Pre-condition: Requires currentPlayer to be initialized.
     * Post-condition: Should change players when the method is called.
     */
    private void togglePlayer() {
        // Based on the current player, toggle it:
        if (currentPlayer.equals("X")) {currentPlayer = "O";}

        else {currentPlayer = "X";}
    }

    /**
     * Pre-condition: Requires hasFinished to be initialized.
     * Post-condition: Should check if there is a winner.
     */
    private void hasFinished() {
        // Check if there is a winner:
        for (byte x = 0; x < 3; x++) {
            if(board[x][0].getText().equals(currentPlayer) && board[x][1].getText().equals(currentPlayer) && board[x][2].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
                hasFinished = true;
                resetBoard();
                return;
            }
        }

        for (byte y = 0; y < 3; y++) {
            if(board[0][y].getText().equals(currentPlayer) && board[1][y].getText().equals(currentPlayer) && board[2][y].getText().equals(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
                hasFinished = true;
                resetBoard();
                return;
            }
        }

        if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            hasFinished = true;
            resetBoard();
            return;
        }
        else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            hasFinished = true;
            resetBoard();
            return;
        }

        // Check if there is a draw:
        // Variables:
        byte a = 0;

        // Check if all moves have been made:
        for (byte b = 0; b < 3; b++) {
            for (byte c = 0; c < 3; c++) {
                if (board[b][c].getText().equals("X") || board[b][c].getText().equals("O")) {a++;}
            }
        }

        // Check if there is a draw:
        if (a == 9 && !hasFinished) {
            JOptionPane.showMessageDialog(null, "Draw!");
            hasFinished = true;
            resetBoard();
            return;
        }

        // Toggle player:
        if (!hasFinished) {togglePlayer();}
    }

    /**
     * Pre-condition: Requires the Tic_Tac_Toe_GUI method to work.
     * Post-condition: Should load the Menu Bar, and run the GUI.
     */
    public static void main(String[] args) {
        // Run the GUI and load the Menu Bar:
        SwingUtilities.invokeLater(Tic_Tac_Toe_GUI::new);
    }
}
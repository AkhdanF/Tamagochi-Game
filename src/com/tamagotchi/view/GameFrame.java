// File: src/main/java/com/tamagotchi/view/GameFrame.java
package com.tamagotchi.view;

import com.tamagotchi.controller.GameController;
import com.tamagotchi.util.ImageManager;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private final GameScreen gameScreen; // The game screen that displays the game's visuals
    private final GameController gameController; // The controller that manages the game logic

    // Constructor to set up the game frame
    public GameFrame() {
        setTitle("Tamagotchi"); // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation to exit the application
        setResizable(false); // Prevent resizing the window

        // Initialize the ImageManager to manage all the game's images
        ImageManager imageManager = new ImageManager();
        
        // Initialize the GameScreen to display the game graphics
        gameScreen = new GameScreen(imageManager);
        
        // Initialize the GameController to manage the game logic
        gameController = new GameController(gameScreen);

        // Set up the key listener to handle keyboard input
        setupKeyListener();
        
        // Set up the mouse listener to handle mouse clicks
        setupMouseListener();

        // Add the game screen to the frame
        add(gameScreen);
        
        // Automatically adjust the frame size based on the components
        pack();
        
        // Center the window on the screen
        setLocationRelativeTo(null);
        
        // Allow the window to receive key events (important for key listeners)
        setFocusable(true);
    }

    // Set up the key listener to detect when the space key is pressed
    private void setupKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // When the space key is pressed, handle the event through the game controller
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gameController.handleSpaceKey();
                }
            }
        });
    }

    // Set up the mouse listener to detect mouse clicks on the game screen
    private void setupMouseListener() {
        gameScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // When the mouse is clicked, handle the click event by passing the coordinates to the game controller
                gameController.handleMouseClick(e.getX(), e.getY());
            }
        });
    }
}
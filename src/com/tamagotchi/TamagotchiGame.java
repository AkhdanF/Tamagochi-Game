// File: src/main/java/com/tamagotchi/TamagotchiGame.java
package com.tamagotchi;

import com.tamagotchi.view.GameFrame;
import javax.swing.*;

public class TamagotchiGame {
    public static void main(String[] args) {
        // This runs the main game setup and launches the game window in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            try {
                // Set the look and feel of the UI to the system's default style (native look)
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace(); // If an exception occurs, print the stack trace
            }
            // Create an instance of the GameFrame (main game window)
            GameFrame game = new GameFrame();
            // Make the game window visible
            game.setVisible(true);
        });
    }
}

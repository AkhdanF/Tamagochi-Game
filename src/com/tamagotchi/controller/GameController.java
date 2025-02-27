// File: src/main/java/com/tamagotchi/controller/GameController.java
package com.tamagotchi.controller;

import com.tamagotchi.model.Pet;
import com.tamagotchi.util.Constants;
import com.tamagotchi.view.GameScreen;
import javax.swing.*;

public class GameController {
    private final GameScreen gameScreen; // Object to control the game screen
    private Pet currentPet; // Object to store the current pet that is being played with
    private final Timer gameStateTimer; // Timer to update the pet's state at regular intervals
    private final Timer animationTimer; // Timer to update the pet's animation at regular intervals
    private int animationFrame = 0; // Current animation frame

    // Constructor for GameController
    public GameController(GameScreen gameScreen) {
        this.gameScreen = gameScreen; // Store the reference to the game screen

        // Timer to update the pet's state every 2 seconds (2000 ms)
        gameStateTimer = new Timer(2000, e -> {
            if (currentPet != null) { // Update the pet's state only if there is a pet
                currentPet.updateState(); // Update the pet's status (e.g., health, happiness)
            }
        });

        // Timer to update the pet's animation every 0.5 seconds (500 ms)
        animationTimer = new Timer(500, e -> {
            if (currentPet != null) { // Update the animation only if there is a pet
                animationFrame++; // Increase the animation frame
                if (animationFrame > 10) { // After 10 frames, reset the animation and set the eating and playing statuses to false
                    gameScreen.setEating(false);
                    gameScreen.setPlaying(false);
                }
                gameScreen.setAnimationFrame(animationFrame); // Set the new animation frame
            }
            gameScreen.repaint(); // Update the game screen whenever the animation changes
        });

        startTimers(); // Start the timers that have been defined
    }

    // Method to start all the timers
    public void startTimers() {
        gameStateTimer.start(); // Start the pet's status timer
        animationTimer.start(); // Start the pet's animation timer
    }

    // Method to stop all the timers
    public void stopTimers() {
        gameStateTimer.stop(); // Stop the pet's status timer
        animationTimer.stop(); // Stop the pet's animation timer
    }

    // Method to handle input when the space key is pressed
    public void handleSpaceKey() {
        if (currentPet == null) { // If there is no pet, create a new pet
            createNewPet();
        }
    }

    // Method to handle mouse click input at position (x, y)
    public void handleMouseClick(int x, int y) {
        if (currentPet != null) { // If there is a pet, check if the click happened on buttons or settings
            checkButtonClicks(x, y);
            checkSettingsClick(x, y);
        }
    }

    // Method to create a new pet by choosing a pet type and giving it a name
    private void createNewPet() {
        String[] options = {"Cat", "Dog", "Bunny"}; // Options for pet types
        String type = (String) JOptionPane.showInputDialog(
            null,
            "Choose your pet:", // Dialog title
            "New Pet", // Dialog message
            JOptionPane.QUESTION_MESSAGE,
            null,
            options, // Pet type options
            options[0]); // Default choice is Cat
        
        if (type != null) {
            String name = JOptionPane.showInputDialog("Name your pet:"); // Ask user to name the pet
            if (name != null && !name.trim().isEmpty()) { // If the name is valid (not empty)
                currentPet = new Pet(name, type); // Create a new pet object with the chosen name and type
                gameScreen.setCurrentPet(currentPet); // Send the new pet to the game screen
                gameScreen.repaint(); // Update the game screen
            }
        }
    }

    // Method to check if the click happened on certain buttons on the screen
    private void checkButtonClicks(int x, int y) {
        if (y > Constants.SCREEN_HEIGHT-80 && y < Constants.SCREEN_HEIGHT-50) {
            // If the click is within the area of the bottom buttons
            if (x > 50 && x < 110) { // Feed button
                currentPet.feed(); // Call the feed method on the pet
                gameScreen.setEating(true); // Set the eating status to true
                resetAnimation(); // Reset the animation
            } else if (x > 170 && x < 230) { // Play button
                showStatus(); // Show the pet's status
            } else if (x > 290 && x < 350) { // Status button
                currentPet.play(); // Call the play method on the pet
                gameScreen.setPlaying(true); // Set the playing status to true
                resetAnimation(); // Reset the animation
            }
        }
    }

    // Method to check if the click happened on the settings button in the corner
    private void checkSettingsClick(int x, int y) {
        int settingX = Constants.SCREEN_WIDTH - 40 - 40; // Position of the settings button
        int settingY = 35;
        if (x > settingX && x < settingX + 40 && 
            y > settingY && y < settingY + 40) { // If the click is within the settings button
            showSettingsMenu(); // Show the settings menu
        }
    }

    // Method to reset the animation to the first frame
    private void resetAnimation() {
        animationFrame = 0; // Reset the animation frame
        gameScreen.setAnimationFrame(animationFrame); // Set the animation frame to 0
    }

    // Method to show the current status of the pet
    private void showStatus() {
        if (currentPet != null) {
            String status = String.format("""
                %s the %s
                Age: %d
                Health: %d%%
                Happiness: %d%%
                Hunger: %d%%
                %s""",
                currentPet.getName(), currentPet.getType(), currentPet.getAge(),
                currentPet.getHealth(), currentPet.getHappiness(), currentPet.getHunger(),
                currentPet.isStressed() ? "Status: Stressed" : "Status: Normal"
            );
            JOptionPane.showMessageDialog(null, status, "Pet Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method to show the settings menu with options to change the pet's name, restart the game, or exit
    private void showSettingsMenu() {
        String[] options = {"Change Name", "Restart Game", "Exit Game"};
        int choice = JOptionPane.showOptionDialog(null, 
            "Settings", 
            "Choose an option", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            options, 
            options[0]);

        switch (choice) {
            case 0: // Change Name
                if (currentPet != null) {
                    String newName = JOptionPane.showInputDialog("Enter new name for your pet:");
                    if (newName != null && !newName.trim().isEmpty()) {
                        currentPet.setName(newName); // Change the pet's name
                        gameScreen.repaint(); // Update the game screen
                    }
                }
                break;
            case 1: // Restart Game
                currentPet = null; // Set the current pet to null
                gameScreen.setCurrentPet(null); // Update the game screen with no pet
                gameScreen.repaint(); // Update the game screen
                break;
            case 2: // Exit Game
                System.exit(0); // Exit the game
                break;
        }
    }
}
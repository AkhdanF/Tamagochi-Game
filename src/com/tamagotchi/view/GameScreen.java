// File: src/main/java/com/tamagotchi/view/GameScreen.java
package com.tamagotchi.view;

import com.tamagotchi.model.Pet;
import com.tamagotchi.util.Constants;
import com.tamagotchi.util.ImageManager;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GameScreen extends JPanel {
    private final BufferedImage screenBuffer; // Buffer to store the current screen image
    private final Graphics2D g2d; // Graphics object for drawing on the screen buffer
    private final ImageManager imageManager; // ImageManager instance to manage the game's images
    private Pet currentPet; // The pet currently being displayed
    private int animationFrame = 0; // The current frame of animation for the pet
    private boolean isEating = false; // Flag to track if the pet is eating
    private boolean isPlaying = false; // Flag to track if the pet is playing

    // Constructor to initialize the game screen and set up the image manager
    public GameScreen(ImageManager imageManager) {
        this.imageManager = imageManager; // Set the image manager to load images
        setPreferredSize(new Dimension(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)); // Set screen size
        screenBuffer = new BufferedImage(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB); // Create a screen buffer
        g2d = screenBuffer.createGraphics(); // Create a Graphics2D object to draw on the screen buffer
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); // Disable anti-aliasing for performance
    }

    // Set the current pet displayed on the screen
    public void setCurrentPet(Pet pet) {
        this.currentPet = pet;
    }

    // Set the current animation frame for the pet
    public void setAnimationFrame(int frame) {
        this.animationFrame = frame;
    }

    // Set whether the pet is eating
    public void setEating(boolean eating) {
        this.isEating = eating;
    }

    // Set whether the pet is playing
    public void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    // Overridden method to paint the components on the screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass paintComponent method
        drawDevice(); // Draw the device frame and LCD screen
        
        if (currentPet != null) {
            drawPet(); // Draw the current pet
            drawStatus(); // Draw the pet's status bars
            drawButtons(); // Draw the buttons (Feed, Play, Stats)
        } else {
            drawWelcomeScreen(); // If no pet is created, draw the welcome screen
        }

        g.drawImage(screenBuffer, 0, 0, null); // Draw the screen buffer onto the panel
    }

    // Draw the device frame and LCD screen area
    private void drawDevice() {
        g2d.setColor(Constants.LCD_OUTER); // Set color for the outer frame
        g2d.fillRoundRect(10, 10, Constants.SCREEN_WIDTH-20, Constants.SCREEN_HEIGHT-20, 20, 20); // Draw rounded rectangle for the device frame
        
        g2d.setColor(Constants.LCD_INNER); // Set color for the inner LCD area
        g2d.fillRect(40, 60, Constants.SCREEN_WIDTH-80, Constants.SCREEN_HEIGHT-200); // Draw the LCD screen
        
        g2d.setColor(Constants.LCD_OUTLINE_COLOR); // Set color for the LCD outline
        g2d.setStroke(new BasicStroke(3)); // Set the stroke for drawing the outline
        g2d.drawRect(40, 60, Constants.SCREEN_WIDTH-80, Constants.SCREEN_HEIGHT-200); // Draw the outline rectangle
        g2d.setStroke(new BasicStroke(1)); // Reset stroke

        // Draw settings icon in the top-right corner
        int settingX = Constants.SCREEN_WIDTH - imageManager.getSettingButtonImage().getWidth() / 4 - 40;
        int settingY = 35;
        g2d.drawImage(imageManager.getSettingButtonImage(), settingX, settingY, 
            imageManager.getSettingButtonImage().getWidth() / 4, 
            imageManager.getSettingButtonImage().getHeight() / 4, null);

        // Draw pet's name in the top-left corner
        // Inside the drawDevice() method, replace the pet name drawing code with:
            if (currentPet != null) {
                g2d.setColor(Constants.STATUS_TEXT_COLOR);
                g2d.setFont(new Font("Courier New", Font.BOLD, 16));
                g2d.drawString(currentPet.getName(), 50, 45); // Adjusted Y position to be visible
            }
    }

    // Draw the current pet based on its type
    private void drawPet() {
        int centerX = Constants.SCREEN_WIDTH / 2;
        int centerY = Constants.SCREEN_HEIGHT / 2 - 50;

        switch (currentPet.getType()) {
            case "Cat" -> drawCat(centerX, centerY); // Draw cat if the pet type is "Cat"
            case "Dog" -> drawDog(centerX, centerY); // Draw dog if the pet type is "Dog"
            case "Bunny" -> drawBunny(centerX, centerY); // Draw bunny if the pet type is "Bunny"
        }
    }

    // Draw the cat on the screen
    private void drawCat(int x, int y) {
        BufferedImage catImage;
        if (isEating) {
            catImage = (animationFrame % 2 == 0) ? imageManager.getCatEat1() : imageManager.getCatEat2();
        } else if (isPlaying) {
            catImage = (animationFrame % 2 == 0) ? imageManager.getCatPlay1() : imageManager.getCatPlay2();
        } else {
            catImage = (animationFrame % 2 == 0) ? imageManager.getCatIdle1() : imageManager.getCatIdle2();
        }
        drawScaledImage(catImage, x, y, 5); // Draw the cat with appropriate image
    }

    // Draw the dog on the screen
    private void drawDog(int x, int y) {
        BufferedImage dogImage;
        if (isEating) {
            dogImage = (animationFrame % 2 == 0) ? imageManager.getDogEat1() : imageManager.getDogEat2();
        } else if (isPlaying) {
            dogImage = (animationFrame % 2 == 0) ? imageManager.getDogPlay1() : imageManager.getDogPlay2();
        } else {
            dogImage = (animationFrame % 2 == 0) ? imageManager.getDogIdle1() : imageManager.getDogIdle2();
        }
        drawScaledImage(dogImage, x, y, 4); // Draw the dog with appropriate image
    }

    // Draw the bunny on the screen
    private void drawBunny(int x, int y) {
        BufferedImage bunnyImage;
        if (isEating) {
            bunnyImage = (animationFrame % 2 == 0) ? imageManager.getBunnyEat1() : imageManager.getBunnyEat2();
        } else if (isPlaying) {
            bunnyImage = (animationFrame % 2 == 0) ? imageManager.getBunnyPlay1() : imageManager.getBunnyPlay2();
        } else {
            bunnyImage = (animationFrame % 2 == 0) ? imageManager.getBunnyIdle1() : imageManager.getBunnyIdle2();
        }
        drawScaledImage(bunnyImage, x, y, 4); // Draw the bunny with appropriate image
    }

    // Helper method to draw a scaled image of a pet
    private void drawScaledImage(BufferedImage image, int x, int y, int scale) {
        int scaledWidth = image.getWidth() / scale;
        int scaledHeight = image.getHeight() / scale;
        int imageX = x - scaledWidth / 2;
        int imageY = y - scaledHeight / 2;
        g2d.drawImage(image, imageX, imageY, scaledWidth, scaledHeight, null); // Draw the scaled image
    }

    // Draw the pet's status bars (Health, Happiness, Hunger)
    private void drawStatus() {
        g2d.setColor(Constants.LCD_OUTER);
        g2d.setFont(new Font("Courier New", Font.BOLD, 12)); // Set font for status bars

        drawStatusBar("Health", currentPet.getHealth(), 50, Constants.SCREEN_HEIGHT - 190);
        drawStatusBar("Happy", currentPet.getHappiness(), 50, Constants.SCREEN_HEIGHT - 170);
        drawStatusBar("Hunger", currentPet.getHunger(), 50, Constants.SCREEN_HEIGHT - 150);
    }

    // Draw individual status bar
    private void drawStatusBar(String label, int value, int x, int y) {
        g2d.setColor(Constants.STATUS_TEXT_COLOR);
        g2d.drawString(label, x, y); // Draw the label of the status bar
        g2d.setColor(Constants.LCD_OUTER);
        g2d.drawRect(x+60, y-10, 100, 10); // Draw the border of the status bar
        g2d.setColor(Constants.STATUS_BAR_COLOR);
        g2d.fillRect(x+60, y-10, value, 10); // Fill the status bar with the current value
    }

    // Draw the buttons (Feed, Stats, Play) at the bottom of the screen
    private void drawButtons() {
        int buttonY = Constants.SCREEN_HEIGHT - 80;
        int buttonWidth = imageManager.getFeedButtonImage().getWidth() / 4;
        int buttonHeight = imageManager.getFeedButtonImage().getHeight() / 4;

        g2d.drawImage(imageManager.getFeedButtonImage(), 50, buttonY, buttonWidth, buttonHeight, null);
        g2d.drawImage(imageManager.getStatsButtonImage(), 150, buttonY, buttonWidth + 35, buttonHeight, null);
        g2d.drawImage(imageManager.getPlayButtonImage(), 280, buttonY, buttonWidth, buttonHeight, null);
    }

    // Draw the welcome screen if no pet is created
    private void drawWelcomeScreen() {
        int lcdWidth = Constants.SCREEN_WIDTH - 80;
        int lcdHeight = Constants.SCREEN_HEIGHT - 200;
        g2d.drawImage(imageManager.getMenuImage(), 40, 60, lcdWidth, lcdHeight, null); // Draw the menu image
    }
}
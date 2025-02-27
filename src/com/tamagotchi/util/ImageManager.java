// File: src/main/java/com/tamagotchi/util/ImageManager.java
package com.tamagotchi.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageManager {
    // BufferedImage fields to store the images for different pet states and buttons
    private BufferedImage catIdle1, catIdle2, catPlay1, catPlay2, catEat1, catEat2;
    private BufferedImage dogIdle1, dogIdle2, dogEat1, dogEat2, dogPlay1, dogPlay2;
    private BufferedImage bunnyIdle1, bunnyIdle2, bunnyPlay1, bunnyPlay2, bunnyEat1, bunnyEat2;
    private BufferedImage feedButtonImage, playButtonImage, statsButtonImage;
    private BufferedImage menuImage, settingButtonImage;

    // Constructor for ImageManager, which calls the loadImages method to load all images
    public ImageManager() {
        loadImages();
    }

    // Method to load all the images needed for the game
    private void loadImages() {
        try {
            // Load pet images for different states (idle, play, eat) for each pet type
            catIdle1 = loadImage("/assets/Car_idle1.png");
            catIdle2 = loadImage("/assets/Car_idle2.png");
            catPlay1 = loadImage("/assets/Car_play1.png");
            catPlay2 = loadImage("/assets/Car_play2.png");
            catEat1 = loadImage("/assets/Car_eat1.png");
            catEat2 = loadImage("/assets/Car_eat2.png");

            dogIdle1 = loadImage("/assets/Dog_idle1.png");
            dogIdle2 = loadImage("/assets/Dog_idle2.png");
            dogEat1 = loadImage("/assets/Dog_eat1.png");
            dogEat2 = loadImage("/assets/Dog_eat2.png");
            dogPlay1 = loadImage("/assets/Dog_play1.png");
            dogPlay2 = loadImage("/assets/Dog_play2.png");

            bunnyIdle1 = loadImage("/assets/Bnuy_idle1.png");
            bunnyIdle2 = loadImage("/assets/Bnuy_idle2.png");
            bunnyPlay1 = loadImage("/assets/Bnuy_play1.png");
            bunnyPlay2 = loadImage("/assets/Bnuy_play2.png");
            bunnyEat1 = loadImage("/assets/Bnuy_eat1.png");
            bunnyEat2 = loadImage("/assets/Bnuy_eat2.png");

            // Load button and menu images
            feedButtonImage = loadImage("/assets/Feed_button.png");
            playButtonImage = loadImage("/assets/Play_button.png");
            statsButtonImage = loadImage("/assets/Stats_button.png");
            menuImage = loadImage("/assets/menu.png");
            settingButtonImage = loadImage("/assets/Setting_button.png");
        } catch (IOException e) {
            // Handle any errors that occur while loading images
            e.printStackTrace();
        }
    }

    // Helper method to load an image from a given file path
    private BufferedImage loadImage(String path) throws IOException {
        // Load the image using the class' resource path
        return ImageIO.read(getClass().getResource(path));
    }

    // Getter methods for accessing each image
    public BufferedImage getCatIdle1() { return catIdle1; }
    public BufferedImage getCatIdle2() { return catIdle2; }
    public BufferedImage getCatPlay1() { return catPlay1; }
    public BufferedImage getCatPlay2() { return catPlay2; }
    public BufferedImage getCatEat1() { return catEat1; }
    public BufferedImage getCatEat2() { return catEat2; }
    public BufferedImage getDogIdle1() { return dogIdle1; }
    public BufferedImage getDogIdle2() { return dogIdle2; }
    public BufferedImage getDogEat1() { return dogEat1; }
    public BufferedImage getDogEat2() { return dogEat2; }
    public BufferedImage getDogPlay1() { return dogPlay1; }
    public BufferedImage getDogPlay2() { return dogPlay2; }
    public BufferedImage getBunnyIdle1() { return bunnyIdle1; }
    public BufferedImage getBunnyIdle2() { return bunnyIdle2; }
    public BufferedImage getBunnyPlay1() { return bunnyPlay1; }
    public BufferedImage getBunnyPlay2() { return bunnyPlay2; }
    public BufferedImage getBunnyEat1() { return bunnyEat1; }
    public BufferedImage getBunnyEat2() { return bunnyEat2; }
    public BufferedImage getFeedButtonImage() { return feedButtonImage; }
    public BufferedImage getPlayButtonImage() { return playButtonImage; }
    public BufferedImage getStatsButtonImage() { return statsButtonImage; }
    public BufferedImage getMenuImage() { return menuImage; }
    public BufferedImage getSettingButtonImage() { return settingButtonImage; }
}
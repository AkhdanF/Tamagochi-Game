# Java Tamagotchi Game

A nostalgic virtual pet simulation game built in Java, inspired by the classic Tamagotchi toys from the 90s.

## Overview

This Java Tamagotchi Game allows you to adopt and care for a virtual pet. Your pet has various needs that must be maintained, including hunger, happiness, and energy. If you neglect your pet for too long, its health will deteriorate. Take good care of your pet to help it grow and thrive!

## Features

- **Pet Creation**: Name your pet and choose its type/appearance
- **Basic Needs System**: Manage your pet's hunger, happiness, and energy
- **Health Monitoring**: Keep an eye on your pet's overall health status
- **Activities**: Feed and play with your pet
- **Time-Based Gameplay**: Pet stats naturally change over time
- **Simple GUI**: User-friendly interface with visual feedback

## How to Play

1. Run the game and create a new pet or load an existing one
2. Monitor your pet's stats in the main interface
3. Click on the different action buttons to care for your pet:
   - 🍔 Feed your pet when it's hungry
   - 🎮 Play with your pet to increase happiness
4. Check the stats area for your pet's status

## Technical Details

### Installation

1. Clone this repository:
   ```
   git clone https://github.com/yourusername/tamagochi-game.git
   ```
2. Navigate to the project directory:
   ```
   cd tamagochi-game
   ```
3. Compile the source code:
   ```
   javac -d bin src/*.java
   ```
4. Run the game:
   ```
   java -cp bin Main
   ```

### Project Structure

```
java-tamagotchi/
├── src/
│   ├── Main.java             # Entry point
│   ├── Pet.java              # Pet class with attributes and methods
│   ├── GameManager.java      # Manages game state and logic
│   ├── ui/                   # UI components
│   │   ├── GameWindow.java   # Main game window
│   │   └── ...
│   ├── util/                 # Utility classes
│   │   ├── SaveManager.java  # Handles saving/loading
│   │   └── ...
├── resources/                # Images and sounds
├── saves/                    # Directory for saved games
└── README.md                 # This file
```

## Future Enhancements

- More pet types with unique characteristics
- Additional activities and mini-games
- Pet evolution based on care patterns
- Accessories and customization options
- Multiplayer features to interact with friends' pets
- Save and load game features that allows you to save your current progress



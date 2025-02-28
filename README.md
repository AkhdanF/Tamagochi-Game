# Java Tamagotchi Game

A nostalgic virtual pet simulation game built in Java, inspired by the classic Tamagotchi toys from the 90s.

## Overview

This Java Tamagotchi Game allows you to adopt and care for a virtual pet. Your pet has various needs that must be maintained, including hunger, happiness, energy, and cleanliness. If you neglect your pet for too long, its health will deteriorate. Take good care of your pet to help it grow and thrive!

## Features

- **Pet Creation**: Name your pet and choose its type/appearance
- **Basic Needs System**: Manage your pet's hunger, happiness, energy, and cleanliness
- **Health Monitoring**: Keep an eye on your pet's overall health status
- **Activities**: Feed, play with, let your pet sleep, and clean your pet
- **Time-Based Gameplay**: Pet stats naturally change over time
- **Growth System**: Watch your pet grow through different life stages
- **Simple GUI**: User-friendly interface with visual feedback
- **Save/Load System**: Save your pet's status and continue later

## How to Play

1. Run the game and create a new pet or load an existing one
2. Monitor your pet's stats in the main interface
3. Click on the different action buttons to care for your pet:
   - 🍔 Feed your pet when it's hungry
   - 🎮 Play with your pet to increase happiness
   - 💤 Let your pet sleep when it's tired
   - 🚿 Clean your pet when it's dirty
4. Check the message area for feedback on your pet's status
5. Save your game before exiting

## Technical Details

### Requirements

- Java 8 or higher
- No additional libraries required for basic functionality

### Installation

1. Clone this repository:
   ```
   git clone https://github.com/yourusername/java-tamagotchi.git
   ```
2. Navigate to the project directory:
   ```
   cd java-tamagotchi
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

## Contributing

Contributions are welcome! Feel free to fork this repository and submit pull requests.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Inspired by the classic Tamagotchi toys created by Bandai
- Thanks to everyone who contributed to this project
- Special thanks to the Java community for resources and support

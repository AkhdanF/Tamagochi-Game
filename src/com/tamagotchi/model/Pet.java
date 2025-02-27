package com.tamagotchi.model;

public class Pet {
    private String name; // Name of the pet
    private String type; // Type of the pet (e.g., Cat, Dog, Bunny)
    private int health; // Health level of the pet, ranging from 0 to 100
    private int happiness; // Happiness level of the pet, ranging from 0 to 100
    private int hunger; // Hunger level of the pet, ranging from 0 to 100
    private boolean stressed; // Whether the pet is stressed (true if happiness < 20)
    private int age; // Age of the pet, in years

    // Constructor to initialize the pet with a given name and type
    public Pet(String name, String type) {
        this.name = name; // Set the pet's name
        this.type = type; // Set the pet's type
        this.health = 100; // Set the initial health to 100
        this.happiness = 50; // Set the initial happiness to 50
        this.hunger = 50; // Set the initial hunger to 50
        this.stressed = false; // Initially, the pet is not stressed
        this.age = 0; // The pet starts at age 0
    }

    // Getters to access the pet's attributes
    public String getName() { return name; }
    public String getType() { return type; }
    public int getHealth() { return health; }
    public int getHappiness() { return happiness; }
    public int getHunger() { return hunger; }
    public boolean isStressed() { return stressed; }
    public int getAge() { return age; }

    // Setter to modify the pet's name
    public void setName(String name) { this.name = name; }

    // Method to update the pet's state based on hunger and happiness
    public void updateState() {
        hunger = Math.min(hunger + 1, 100); // Increase hunger by 1, but not more than 100
        if (hunger > 80) {
            health = Math.max(health - 2, 0); // If hunger is too high, reduce health by 2 (minimum 0)
        } else if (hunger < 20) {
            health = Math.min(health + 1, 100); // If hunger is low, increase health by 1 (maximum 100)
        }
        happiness = Math.max(happiness - 1, 0); // Decrease happiness by 1, but not below 0
        stressed = happiness < 20; // If happiness is below 20, the pet is stressed
    }

    // Method to feed the pet, which reduces hunger and increases health
    public void feed() {
        hunger = Math.max(hunger - 20, 0); // Decrease hunger by 20, but not below 0
        health = Math.min(health + 5, 100); // Increase health by 5, but not above 100
    }

    // Method to play with the pet, which increases happiness
    public void play() {
        happiness = Math.min(happiness + 20, 100); // Increase happiness by 20, but not above 100
    }
}
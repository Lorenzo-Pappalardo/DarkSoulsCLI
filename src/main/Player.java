package main;

import enemies.Enemy;

import java.util.Scanner;

/**
 * Singleton
 */
public class Player {
    private static Player instance;
    final private String name;
    private Float health;
    private Integer souls;
    final private Float damage;

    private Player(String name) {
        this.name = name;
        health = 100f;
        souls = 0;
        damage = 20f;
    }

    private static String getName() {
        System.out.println("Enter a name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Player getInstance() {
        if (instance == null)
            instance = new Player(getName());
        return instance;
    }

    public void printInfo() {
        System.out.println();
        System.out.println("[Player]");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Souls: " + souls);
    }

    public Float getHealth() {
        return health;
    }

    public void decreaseHealth(Integer value) {
        health -= value;
    }

    public void setHealth(Float health) {
        this.health = health;
    }

    public void updateSouls(Integer value) {
        souls += value;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " performs a basic attack and inflicts " + damage + " points of damage!");
        enemy.decreaseHealth(damage);
    }
}
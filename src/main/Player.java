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

    private Player() {
        name = setName();
        health = 100f;
        souls = 0;
        damage = 30f;
    }

    public static Player getInstance() {
        if (instance == null)
            instance = new Player();
        return instance;
    }

    public String setName() {
        System.out.println("Enter a name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getName() {
        return name;
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

    public void attack(Enemy enemy, Float critMultiplier) {
        Float damage = this.damage * critMultiplier;
        System.out.println(name + " performs a roll and attacks the enemy from behind! It inflicts " + damage + " points of damage!");
        enemy.decreaseHealth(damage);
    }

    public void attack(Enemy enemy, Float critMultiplier, Boolean isParry) {
        Float damage = this.damage * critMultiplier;
        System.out.println(name + " performs a parry and attacks the enemy while it's stunned! It inflicts " + damage + " points of damage!");
        enemy.decreaseHealth(damage);
    }
}
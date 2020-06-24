package main;

import enemies.Enemy;

import java.util.Scanner;

public class Player {
    final private String name;
    private Float maxHealth;
    private Float health;
    private Float damage;
    private Integer totalAcquiredSouls;
    private Integer souls;

    public Player() {
        name = inputName();
        maxHealth = 100f;
        health = maxHealth;
        damage = 30f;
        totalAcquiredSouls = 0;
        souls = totalAcquiredSouls;
    }

    public String inputName() {
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
        System.out.println();
    }

    public Float getHealth() {
        return health;
    }

    public void decreaseHealth(Float value) {
        health -= value;
    }

    public Boolean isDead() {
        return (health <= 0);
    }

    public Integer getTotalAcquiredSouls() {
        return totalAcquiredSouls;
    }

    public Boolean hasEnoughSouls(Integer cost) {
        return (souls >= cost);
    }

    public void addSouls(Integer defeatedEnemies) {
        Integer acquiredSouls = 10 * defeatedEnemies;
        System.out.println(name + " gets " + acquiredSouls + " souls! ");
        this.totalAcquiredSouls += acquiredSouls;
        this.souls += acquiredSouls;
    }

    public void decreaseSouls(Integer cost) {
        this.souls -= cost;
    }

    public void attack(Enemy enemy) {
        System.out.println("It inflicts " + damage + " points of damage!");
        enemy.decreaseHealth(damage);
    }

    public void attack(Enemy enemy, Float damageMultiplier) {
        Float damage = this.damage * damageMultiplier;
        System.out.println("It inflicts " + damage + " points of damage!");
        enemy.decreaseHealth(damage);
    }

    public void upgradeHealth(Integer defeatedEnemies) {
        this.maxHealth += 5 * defeatedEnemies;
        health = maxHealth;
    }

    public void upgradeDamageOutput(Integer defeatedEnemies) {
        this.damage += 3 * defeatedEnemies;
    }
}
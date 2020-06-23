package main;

import decorator.Component;
import enemies.Enemy;

import java.util.Scanner;

public class Player implements Component {
    final private String name;
    private Float health;
    private Integer souls;
    private Float damage;

    public Player() {
        name = setName();
        health = 100f;
        souls = 0;
        damage = 30f;
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

    public void decreaseHealth(Float value) {
        health -= value;
    }

    public void setHealth(Float health) {
        this.health = health;
    }

    public Boolean isDead() {
        return (health <= 0);
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

    @Override
    public void upgradeHealth(Integer defeatedEnemies) {
        this.health += 5 * defeatedEnemies;
    }

    @Override
    public void upgradeDamageOutput(Integer defeatedEnemies) {
        this.damage += 3 * defeatedEnemies;
    }

    @Override
    public void upgradeSouls(Integer defeatedEnemies) {
        this.souls += 10 * defeatedEnemies;
    }
}
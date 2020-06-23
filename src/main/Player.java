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
        name = inputName();
        health = 100f;
        souls = 0;
        damage = 30f;
    }

    @Override
    public String inputName() {
        System.out.println("Enter a name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("[Player]");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Souls: " + souls);
    }

    @Override
    public Float getHealth() {
        return health;
    }

    @Override
    public void decreaseHealth(Float value) {
        health -= value;
    }

    @Override
    public Boolean isDead() {
        return (health <= 0);
    }

    @Override
    public void attack(Enemy enemy, Float damage) {
        System.out.println(name + " performs a basic attack and inflicts " + damage + " points of damage!");
        enemy.decreaseHealth(damage);
    }

    /*public void attack(Enemy enemy, Float critMultiplier) {
        Float damage = this.damage * critMultiplier;
        System.out.println(name + " performs a roll and attacks the enemy from behind! It inflicts " + damage + " points of damage!");
        enemy.decreaseHealth(damage);
    }

    public void attack(Enemy enemy, Float critMultiplier, Boolean isParry) {
        Float damage = this.damage * critMultiplier;
        System.out.println(name + " performs a parry and attacks the enemy while it's stunned! It inflicts " + damage + " points of damage!");
        enemy.decreaseHealth(damage);
    }*/

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
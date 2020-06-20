package main;

import java.util.Scanner;

/**
 * Singleton
 */
public class Player {
    private static Player instance;
    private final String name;
    private Integer health;
    private Integer souls;
    // private Inventory inventory;

    private Player(String name) {
        this.name = name;
        health = 100;
        souls = 0;
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
        System.out.println("[Player]");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Souls: " + souls);
    }

    public void updateHealth(Integer value) {
        health += value;
    }

    public void updateSouls(Integer value) {
        souls += value;
    }
}
package main;

import java.util.Scanner;

public class Player {
    private static Player instance;
    private String name;
    private Integer health;
    private Integer souls;
    // private Inventory inventory;

    private Player(String name) {
        this.name = name;
        health = 100;
        souls = 0;
    }

    private static String getName() {
        System.out.println("Enter name: ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        input.close();
        return name;
    }

    public static Player getInstance() {
        if (instance == null)
            instance = new Player(getName());
        return instance;
    }

    public void updateHealth(Integer value) {
        health += value;
    }

    public void updateSouls(Integer value) {
        souls += value;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Souls: " + souls);
    }
}
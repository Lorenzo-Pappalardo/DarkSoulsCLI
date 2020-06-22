package main;

import enemies.Enemy;

import java.util.Random;
import java.util.Scanner;

public class Game implements ActiveScreen {
    private Boolean rollCritMultiplier;

    private Boolean parryCritMultiplier;

    public Game() {
        rollCritMultiplier = false;
        parryCritMultiplier = false;
    }

    private void printContents() {
        System.out.println("Game");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private void fightingPhase() {
        Player player = Player.getInstance();
        Integer enemiesDefeated = 0;
        while (player.getHealth() > 0) {
            Enemy enemy = Creator.getEnemy(enemiesDefeated);
            while (enemy.getHealth() > 0) {
                player.printInfo();
                enemy.printInfo();
                playerActions(enemy);
            }
            enemiesDefeated++;
        }
    }

    private void playerActions(Enemy enemy) {
        System.out.println("(1) Basic Attack");
        System.out.println("(2) Roll");
        System.out.println("(3) Parry");
        Integer choice = getChoice();
        if (choice == 1)
            execBasicAttack(enemy);
        else if (choice == 2)
            execRoll(enemy);
        else
            execParry(enemy);
    }

    private Integer getChoice() {
        System.out.print("\nYour choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= 3)
            return choice;
        else {
            System.err.println("Wrong choice, try again!");
            return getChoice();
        }
    }

    private void execBasicAttack(Enemy enemy) {
        if (rollCritMultiplier) {
            Player.getInstance().attack(enemy, 1.2f);
        } else if (parryCritMultiplier) {
            Player.getInstance().attack(enemy, 2f, true);
        } else Player.getInstance().attack(enemy);
    }

    private void execRoll(Enemy enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(2) == 0) {
            rollCritMultiplier = true;
            execBasicAttack(enemy);
            rollCritMultiplier = false;
        } else
            System.out.println(Player.getInstance().getName() + " failed to roll away...");
    }

    private void execParry(Enemy enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(6) == 0) {
            parryCritMultiplier = true;
            execBasicAttack(enemy);
            parryCritMultiplier = false;
        } else
            System.out.println(Player.getInstance().getName() + " failed to parry the attack...");
    }

    @Override
    public void init() {
        printContents();
        fightingPhase();
    }
}
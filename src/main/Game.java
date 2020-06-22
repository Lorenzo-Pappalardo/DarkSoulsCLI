package main;

import enemies.Enemy;

import java.util.Scanner;

public class Game implements ActiveScreen {
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
        }
    }

    private void playerActions(Enemy enemy) {
        System.out.println("(1) Basic Attack");
        System.out.println("(2) Roll");
        System.out.println("(3) Parry");
        Integer choice = getChoice();
        if (choice == 1)
            execBasicAttack(enemy);
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
        Player.getInstance().attack(enemy);
    }

    @Override
    public void init() {
        printContents();
        fightingPhase();
    }
}
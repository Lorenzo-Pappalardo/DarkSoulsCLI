package main;

import enemies.Enemy;

import java.util.Random;
import java.util.Scanner;

public class Game implements ActiveScreen {
    private Boolean rolled;

    private Boolean parried;

    public Game() {
        rolled = false;
        parried = false;
    }

    private void printContents() {
        System.out.println("Game");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private void fightingPhase() {
        Player player = new Player();
        Integer defeatedEnemies = 0;
        while (!player.isDead()) {
            Enemy enemy = Creator.getEnemy(defeatedEnemies);
            while (!enemy.isDead()) {
                player.printInfo();
                enemy.printInfo();
                playerActions(player, enemy);
                enemyActions(player, enemy);
                if (player.isDead()) break;
            }
            if (enemy.isBoss())
                defeatedEnemies = 0;
            else defeatedEnemies++;
        }
        died();
    }

    private void playerActions(Player player, Enemy enemy) {
        System.out.println("(1) Basic Attack");
        System.out.println("(2) Roll");
        System.out.println("(3) Parry");
        System.out.println("(4) Level Up");
        Integer choice = getChoice();
        if (choice == 1)
            execBasicAttack(player, enemy);
        else if (choice == 2)
            execRoll(player, enemy);
        else if (choice == 3)
            execParry(player, enemy);
    }

    private void enemyActions(Player player, Enemy enemy) {
        if (!enemy.isDead() && !rolled && !parried) {
            Float enemyDamage = enemy.attack();
            player.decreaseHealth(enemyDamage);
        }
    }

    private Integer getChoice() {
        System.out.print("\nYour choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= 4)
            return choice;
        else {
            System.err.println("Wrong choice, try again!");
            return getChoice();
        }
    }

    private void execBasicAttack(Player player, Enemy enemy) {
        player.attack(enemy);
    }

    private void execRoll(Player player, Enemy enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(2) == 0) {
            player.attack(enemy, 1.2f);
            rolled = true;
        } else
            System.out.println(player.getName() + " failed to roll away...");
    }

    private void execParry(Player player, Enemy enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(6) == 0) {
            player.attack(enemy, 2f, true);
            parried = true;
        } else
            System.out.println(player.getName() + " failed to parry the attack...");
    }

    private void postFight() {
    }

    private void died() {
        System.out.println();
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
        System.out.println("YOU DIED");
        for (int i = 0; i < 30; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    @Override
    public void init() {
        printContents();
        fightingPhase();
    }
}
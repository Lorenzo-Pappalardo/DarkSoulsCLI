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
        Player player = Player.getInstance();
        Integer enemiesDefeated = 0;
        while (player.getHealth() > 0) {
            Enemy enemy = Creator.getEnemy(enemiesDefeated);
            while (!enemy.isDead()) {
                player.printInfo();
                enemy.printInfo();
                playerActions(enemy);
                enemyActions(enemy);
            }
            if (enemy.isBoss())
                enemiesDefeated = 0;
            else enemiesDefeated++;
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

    private void enemyActions(Enemy enemy) {
        if (!enemy.isDead() && !rolled && !parried) {
            Float enemyDamage = enemy.attack();
            Player.getInstance().decreaseHealth(enemyDamage);
        }
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

    private void execRoll(Enemy enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(2) == 0) {
            Player.getInstance().attack(enemy, 1.2f);
            rolled = true;
        } else
            System.out.println(Player.getInstance().getName() + " failed to roll away...");
    }

    private void execParry(Enemy enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(6) == 0) {
            Player.getInstance().attack(enemy, 2f, true);
            parried = true;
        } else
            System.out.println(Player.getInstance().getName() + " failed to parry the attack...");
    }

    @Override
    public void init() {
        printContents();
        fightingPhase();
    }
}
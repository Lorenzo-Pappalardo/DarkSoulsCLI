package screens;

import enemies.Creator;
import enemies.Enemy;
import main.Player;
import storage.Storage;

import java.util.Random;
import java.util.Scanner;

public class Game implements ActiveScreen {
    private Boolean rolled;

    private Boolean parried;

    private Boolean levelUp;

    private Integer nextUpgradeCost;

    private Integer totalDefeatedEnemies;

    private Integer defeatedEnemies;

    public Game() {
        rolled = false;
        parried = false;
        levelUp = false;
        nextUpgradeCost = 20;
        totalDefeatedEnemies = 0;
        defeatedEnemies = totalDefeatedEnemies;
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
        while (!player.isDead()) {
            Enemy enemy = Creator.getEnemy(defeatedEnemies);
            while (!enemy.isDead()) {
                player.printInfo();
                enemy.printInfo();
                rolled = false;
                parried = false;
                levelUp = false;
                playerActions(player, enemy);
                if (enemy.isDead()) {
                    totalDefeatedEnemies++;
                    defeatedEnemies++;
                    enemyDies(player);
                } else enemyActions(player, enemy);
                if (player.isDead()) break;
            }
            if (enemy.isBoss())
                defeatedEnemies = 0;
        }
        playerDies(player);
    }

    private void playerActions(Player player, Enemy enemy) {
        System.out.println();
        System.out.println("(1) Basic Attack");
        System.out.println("(2) Roll");
        System.out.println("(3) Parry");
        System.out.println("(4) Level Up");
        Integer choice = getChoice();
        System.out.println();
        if (choice == 1)
            execBasicAttack(player, enemy);
        else if (choice == 2)
            execRoll(player, enemy);
        else if (choice == 3)
            execParry(player, enemy);
        else {
            upgrade(player);
            if (!levelUp)
                playerActions(player, enemy);
        }
    }

    private Integer getChoice() {
        System.out.println();
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= 4)
            return choice;
        System.err.println("Wrong choice, try again!");
        return getChoice();
    }

    private void enemyActions(Player player, Enemy enemy) {
        if (!levelUp && !rolled && !parried) {
            Float enemyDamage = enemy.attack();
            player.decreaseHealth(enemyDamage);
            System.out.println("Enemy inflicts " + enemyDamage + " points of damage");
        }
    }

    private void execBasicAttack(Player player, Enemy enemy) {
        System.out.println(player.getName() + " performs a basic attack");
        player.attack(enemy);
    }

    private void execRoll(Player player, Enemy enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(2) == 0) {
            System.out.println(player.getName() + " rolls behind the enemy and performs a backstab!");
            player.attack(enemy, 1.2f);
            rolled = true;
        } else
            System.out.println(player.getName() + " failed to roll away...");
    }

    private void execParry(Player player, Enemy enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(6) == 0) {
            System.out.println(player.getName() + " performs a parry!");
            player.attack(enemy, 2f);
            parried = true;
        } else
            System.out.println(player.getName() + " failed to parry the attack...");
    }

    private void upgrade(Player player) {
        if (player.hasEnoughSouls(nextUpgradeCost)) {
            player.upgradeHealth(defeatedEnemies);
            player.upgradeDamageOutput(defeatedEnemies);
            player.decreaseSouls(nextUpgradeCost);
            nextUpgradeCost *= 3;
            levelUp = true;
            System.out.println(player.getName() + " leveled up!");
        } else System.out.println("Not enough souls!");
    }

    private void enemyDies(Player player) {
        System.out.println("Enemy dies");
        player.addSouls(defeatedEnemies);
    }

    private void playerDies(Player player) {
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
        Storage.getInstance().append(player, totalDefeatedEnemies);
    }

    @Override
    public void init() {
        printContents();
        fightingPhase();
    }
}
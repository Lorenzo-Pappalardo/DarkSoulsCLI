package main;

import enemies.Enemy;
import weapons.Weapon;

/**
 * Creator and Concrete Creator for design pattern Factory Method
 */
public class Creator {
    /**
     * Factory Method responsible of creating instances of Enemy and returning them to the caller
     */
    public static Enemy getEnemy() {
    }

    /**
     * Factory Method responsible of creating instances of Weapon and returning them to the caller
     */
    private Weapon getWeapon() {
    }
}

package main;

import enemies.*;
import weapons.*;

import java.util.Random;

/**
 * Creator and Concrete Creator for design pattern Factory Method
 */
public class Creator {
    /**
     * Factory Method responsible of creating instances of Enemy and returning them to the caller
     */
    public static Enemy getEnemy(Integer enemiesDefeated) {
        Random random = new Random(System.currentTimeMillis());
        int randomChoice = random.nextInt() % (3 + enemiesDefeated);
        if (randomChoice == 0)          //Ghost
            return new Ghost(getWeapon(randomChoice));
        else if (randomChoice == 1)     //Skeleton
            return new Skeleton(getWeapon(randomChoice));
        else if (randomChoice == 2)     //Undead Assassin
            return new UndeadAssassin(getWeapon(randomChoice));
        else if (randomChoice == 3)     //Undead Soldier
            return new UndeadSoldier(getWeapon(randomChoice));
        else if (randomChoice == 4)     //Infested Barbarian
            return new InfestedBarbarian(getWeapon(randomChoice));
        else if (randomChoice == 5)     //Pinwheel
            return new Pinwheel(getWeapon(randomChoice));
        else if (randomChoice == 6)     //Capra Demon;
            return new CapraDemon(getWeapon(randomChoice));
        else if (randomChoice == 7)     //Bell Gargoyle
            return new BellGargoyle(getWeapon(randomChoice));
        else if (randomChoice == 8)     //Ornstein and Smough
            return new OrnsteinSmoug(getWeapon(randomChoice));
        return new GwynLordOfCinder(getWeapon(randomChoice));   //Gwyn Lord of Cinder
    }

    /**
     * Factory Method responsible of creating instances of Weapon and returning them to the caller
     */
    private static Weapon getWeapon(Integer enemy) {
        Random random = new Random(System.currentTimeMillis());
        if (enemy == 0) {               //Ghost
            Integer randomChoice = random.nextInt() % 3;
            if (randomChoice == 0) return new Knife();
            else if (randomChoice == 1) return new Axe();
            return new Sword();
        } else if (enemy == 1) {        //Skeleton
            Integer randomChoice = random.nextInt() % 5;
            if (randomChoice == 0) return new Knife();
            else if (randomChoice == 1) return new Axe();
            else if (randomChoice == 2) return new Club();
            else if (randomChoice == 3) return new Spear();
            return new Sword();
        } else if (enemy == 2) {        //Undead Assassin
            return new Knife();
        } else if (enemy == 3) {        //Undead Soldier
            Integer randomChoice = random.nextInt() % 5;
            if (randomChoice == 0) return new Knife();
            else if (randomChoice == 1) return new Axe();
            else if (randomChoice == 2) return new Club();
            else if (randomChoice == 3) return new Spear();
            return new Sword();
        } else if (enemy == 4) {        //Infested Barbarian
            Integer randomChoice = random.nextInt() % 2;
            if (randomChoice == 0) return new Club();
            return new GreatHammer();
        } else if (enemy == 5) {        //Pinwheel
            return new Magic();
        } else if (enemy == 6) {        //Capra Demon
            Integer randomChoice = random.nextInt() % 2;
            if (randomChoice == 0) return new Spear();
            return new Sword();
        } else if (enemy == 7) {        //Bell Gargoyle
            return new Halberd();
        } else if (enemy == 8) {        //Ornstein and Smough
            return new Spear();
        }
        return new Sword();             //Gwyn Lord of Cinder
    }
}

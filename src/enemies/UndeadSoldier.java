package enemies;

import weapons.Weapon;

import java.util.Random;

/**
 * Concrete Product for Factory Method design pattern
 */
public class UndeadSoldier implements Enemy {
    final private String name;
    final private Weapon weapon;
    private Float health;

    public UndeadSoldier(Weapon weapon) {
        name = "Undead Soldier";
        health = 100f;
        this.weapon = weapon;
    }

    @Override
    public Boolean isBoss() {
        return false;
    }

    @Override
    public Float getHealth() {
        return health;
    }

    @Override
    public void decreaseHealth(Float damage) {
        health -= damage;
    }

    @Override
    public Boolean isDead() {
        return (health <= 0);
    }

    @Override
    public Float attack() {
        Random random = new Random(System.currentTimeMillis());
        if (random.nextInt(10) == 0) {
            System.out.println("Enemy crits!");
            return weapon.getCritMultiplier() * weapon.getDamage();
        }
        return weapon.getDamage().floatValue();
    }

    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("[Enemy]");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Weapon: " + weapon.getName());
        System.out.println();
    }
}

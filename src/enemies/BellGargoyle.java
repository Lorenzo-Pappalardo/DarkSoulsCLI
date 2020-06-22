package enemies;

import weapons.Weapon;

import java.util.Random;

public class BellGargoyle implements Enemy {
    final private String name;
    final private Weapon weapon;
    private Float health;

    public BellGargoyle(Weapon weapon) {
        name = "Bell Gargoyle";
        health = 190f;
        this.weapon = weapon;
    }

    @Override
    public Boolean isBoss() {
        return true;
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
    public Integer attack() {
        return weapon.getDamage();
    }

    @Override
    public Boolean block() {
        Random random = new Random(System.currentTimeMillis());
        return (random.nextInt(2) == 0);
    }

    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("[Enemy]");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Weapon: " + weapon.getName());
    }
}

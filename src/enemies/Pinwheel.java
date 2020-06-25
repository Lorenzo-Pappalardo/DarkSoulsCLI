package enemies;

import weapons.Weapon;

public class Pinwheel implements Enemy {
    final private String name;
    final private Weapon weapon;
    private Float health;

    public Pinwheel(Weapon weapon) {
        name = "Pinwheel";
        health = 140f;
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
    public Float attack() {
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

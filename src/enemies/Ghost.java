package enemies;

import weapons.Weapon;

public class Ghost implements Enemy {
    final private String name;
    final private Weapon weapon;
    private Float health;

    public Ghost(Weapon weapon) {
        name = "Ghost";
        health = 70f;
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
    public Integer attack() {
        return weapon.getDamage();
    }

    @Override
    public Boolean block() {
        return true;
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

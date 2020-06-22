package enemies;

import weapons.Weapon;

public class InfestedBarbarian implements Enemy {
    final private String name;
    final private Weapon weapon;
    private Float health;

    public InfestedBarbarian(Weapon weapon) {
        name = "Infested Barbarian";
        health = 130f;
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
        return false;
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

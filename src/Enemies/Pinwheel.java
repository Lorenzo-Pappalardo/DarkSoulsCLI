package enemies;

import weapons.Weapon;

public class Pinwheel implements Enemy {
    final private String name;
    final private Weapon weapon;
    private Float health;

    Pinwheel(Weapon weapon) {
        name = "Pinwheel";
        health = 160f;
        this.weapon = weapon;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Float getHealth() {
        return health;
    }

    @Override
    public void updateHealth(Float damage) {
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
}

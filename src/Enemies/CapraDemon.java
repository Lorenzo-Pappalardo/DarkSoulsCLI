package enemies;

import weapons.Weapon;

import java.util.Random;

public class CapraDemon implements Enemy {
    final private String name;
    final private Weapon weapon;
    private Float health;

    CapraDemon(Weapon weapon) {
        name = "Capra Demon";
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
        Random random = new Random(System.currentTimeMillis());
        return ((random.nextInt() % 2) == 0);
    }
}

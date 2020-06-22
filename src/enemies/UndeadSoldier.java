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
    public String getName() {
        return name;
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
        return ((random.nextInt() % 5) == 3);
    }
}

package enemies;

import weapons.Weapon;

public class Ghost implements Enemy {
    final private String name;
    final private Weapon weapon;
    private Float health;

    Ghost(Weapon weapon) {
        name = "Ghost";
        health = 70f;
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

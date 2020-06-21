package weapons;

/**
 * Concrete Product for Factory Method design pattern
 */
public class Spear implements Weapon {
    final private String name;
    final private Integer damage;
    final private Float critMultiplier;

    public Spear() {
        name = "Spear";
        damage = 23;
        critMultiplier = 1.4f;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getDamage() {
        return damage;
    }

    @Override
    public Float getCritMultiplier() {
        return critMultiplier;
    }
}
